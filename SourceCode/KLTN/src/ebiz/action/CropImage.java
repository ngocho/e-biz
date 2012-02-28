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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.api.blobstore.BlobKey;
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
            if ((leftX != rightX) && (topY != bottomY)) {
                String urlKey = request.getSession().getAttribute("urlKey").toString();
                Image image = ImagesServiceFactory.makeImageFromBlob(new BlobKey(urlKey));
                Transform crop = ImagesServiceFactory.makeCrop(leftX, topY, rightX, bottomY);
                ImagesService services = ImagesServiceFactory.getImagesService();
                services.applyTransform(crop, image);
                request.getSession().removeAttribute("urlImageKey");
                request.getSession().removeAttribute("notCropped");
                response.getWriter().print("success");
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException re) {
            response.getWriter().print("fail");
        }
        return null;
    }
}
