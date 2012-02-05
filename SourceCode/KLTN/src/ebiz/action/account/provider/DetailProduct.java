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

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.form.FoodForm;

/**
 * @author ThuyNT
 */
public class DetailProduct extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
        HttpServletResponse response) throws Exception {
    	//get id of product
    	HttpSession se = request.getSession();
        String id =(String) request.getParameter("id");
        System.out.println("Updated");
        FoodForm foodForm = FoodBLO.getFoodFormDetail(id);
        if (foodForm != null) {
        //set Form to display
        System.out.println("foodform"+foodForm.getId());
        //set form to display
        se.setAttribute("foodForm", foodForm);
        //display
//        se.setAttribute("urlImage", "");
        se.setAttribute("urlImageKey", foodForm.getUrlKey());
        se.setAttribute("flagUpload", 1);
        return mapping.findForward(SUCCESS);
        }
        return mapping.findForward(FAILURE);
    }

}
