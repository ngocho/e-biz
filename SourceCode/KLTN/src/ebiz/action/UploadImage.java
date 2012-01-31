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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

/**
 * @author ThuyNT
 */
public class UploadImage extends BaseAction {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(request);
//      blobstoreService.createUploadUrl(")
        BlobKey blobKey = blobs.get("myFile");
        HttpSession se = request.getSession();
        if(blobKey != null){
        String urlKey =  blobKey.getKeyString();
//      BlobKey blobKey1 = new BlobKey(blobKey)
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
       String urlImage =  imagesService.getServingUrl(blobKey);
      
       System.out.println("URLIMAGE : " + urlImage);
        if (blobKey != null) {
//        	//url for mobile
//            se.setAttribute("urlImage", urlImage);
            //display Image(use BlobStore)
            se.setAttribute("urlImageKey", urlKey);
        }
        }
        return mapping.findForward(SUCCESS);
    }


}
