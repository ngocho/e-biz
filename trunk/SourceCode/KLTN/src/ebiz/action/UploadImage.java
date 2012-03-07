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

import java.util.List;
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

/**
 * @author ThuyNT
 */
public class UploadImage extends BaseAction {
    /** . declare BlobstoreService */
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    /**
     * [UploadImage Action].
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see ActionForward Struts1 Framework
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
        List<BlobKey> blobList = blobs.get("myFile");
        BlobKey blobKey = null;
        String type = request.getParameter("type");
        HttpSession se = request.getSession();
        if (blobList != null && !blobList.isEmpty()) {
            blobKey = blobList.get(0);
            if (blobKey != null) {
                // get Key
                String urlKey = blobKey.getKeyString();
                if (urlKey != null) {
                    se.setAttribute("notCropped", "1");
                }
                if (type != null && type.equals("1")) {
                    // register Provider
                    se.setAttribute("urlImageKeyP", urlKey);
                } else {
                    // save in session
                    se.setAttribute("urlImageKey", urlKey);
                }
            }
        }
        if (type != null && type.equals("1")) {
            return mapping.findForward(SUCCESS1);
        } else {
            return mapping.findForward(SUCCESS);
        }
    }

}
