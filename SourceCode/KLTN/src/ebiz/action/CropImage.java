/**
 * Licensed to Open-Ones Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Open-Ones Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ebiz.action;

import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
/**
 * Action Class for crop an image.
 * @author CongDanh
 *
 */
public class CropImage extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            int leftX = Integer.parseInt(request.getParameter("leftX"));
            int topY = Integer.parseInt(request.getParameter("topY"));
            int rightX = Integer.parseInt(request.getParameter("rightX"));
            int bottomY = Integer.parseInt(request.getParameter("bottomY"));
            double height = 1.0 * Integer.parseInt(request.getParameter("height"));
            double width = 1.0 * Integer.parseInt(request.getParameter("width"));
            if ((leftX != rightX) && (topY != bottomY)) {
                String urlKey = request.getSession().getAttribute("urlImageKey").toString();
                // get image
                Image image = ImagesServiceFactory.makeImageFromBlob(new BlobKey(urlKey));
                // crop image
                Transform crop = ImagesServiceFactory.makeCrop(leftX/width, topY/height, rightX/width, bottomY/height);
                ImagesService services = ImagesServiceFactory.getImagesService();
                Image newImage = services.applyTransform(crop, image);
                
                // Delete old file.
                BlobstoreServiceFactory.getBlobstoreService().delete(new BlobKey(urlKey));
                // save to File
                FileService fileService = FileServiceFactory.getFileService();
                AppEngineFile file = fileService.createNewBlobFile("image/png");
                FileWriteChannel writeChannel = fileService.openWriteChannel(file, true);
                ByteBuffer buffer = ByteBuffer.wrap(newImage.getImageData());
                writeChannel.write(buffer);
                writeChannel.closeFinally();
                
                // Get new blob key and write to session.
                BlobKey blob = fileService.getBlobKey(file);
                request.getSession().setAttribute("urlImageKey", blob.getKeyString());
                request.getSession().removeAttribute("notCropped");
                response.getWriter().print(blob.getKeyString());
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException re) {
            response.getWriter().print("fail");
        }
        return null;
    }
}
