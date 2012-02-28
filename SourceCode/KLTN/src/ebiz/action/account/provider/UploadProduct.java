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
package ebiz.action.account.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
import ebiz.util.CommonUtil;

/**
 * @author ThuyNT
 */
public class UploadProduct extends BaseAction {
    /**
     * [UploadProduct ].
     * 
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
        // after check validate
        FoodForm foodForm = (FoodForm) form;
        HttpSession se = request.getSession();
        String urlKey = (String) se.getAttribute("urlImageKey");
        // have image
        if ((urlKey != null)) {
            // start check validate numeric
            ActionMessages messages = new ActionMessages();
            boolean ftemp = false;
            if (CommonUtil.isBlankOrZero(foodForm.getPrice()) || foodForm.getNumber() == 0) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("text.invFormat"));
                ftemp = true;

                saveMessages(request, messages);
                return mapping.findForward(FAILURE);
            }
            if (foodForm.getStatus().equals("1")) {
                if (CommonUtil.isBlankOrZero(foodForm.getPromoPrice())) {
                    if (!ftemp) {
                        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("text.invFormat"));
                        saveMessages(request, messages);
                    }
                    return mapping.findForward(FAILURE);
                }
            }
            // end check validate numeric
            foodForm.setUrlKey(urlKey);

            // upload product
            if (CommonUtil.isBlankOrZero(foodForm.getId())) {
                // get idProvider
                String idProvider = (String) se.getAttribute("idProvider");
                // put idProvider into FoodForm
                foodForm.setIdProvider(idProvider);
                // get Food from FoodForm
                Food food = foodForm.getFood();
                // upload Food
                boolean flagUpload = FoodBLO.uploadFood(food);
                // success
                if (flagUpload) {
                    // clear Form
                    foodForm.clear();
                    // remove attr from session
                    se.removeAttribute("foodForm");
                    se.removeAttribute("urlImageKey");
                    // set flag to display in next screen
                    request.setAttribute("fUpload", "1");
                }
                return mapping.findForward(SUCCESS);
            } else {
                // updated product
                Food food = foodForm.getFood();
                food.setFoodId(foodForm.getId());
                                                          
                boolean flag = FoodBLO.updateFood(food);
                if (flag) {
                    // remove attr
                    se.removeAttribute("urlImageKey");
                    se.removeAttribute("foodForm");
                    se.removeAttribute("flagUpload");
                    return mapping.findForward(SUCCESS1);
                }

            }
        }
        return mapping.findForward(FAILURE);
    }

}
