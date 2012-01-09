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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.provider.ProviderBLO;
import ebiz.form.FoodForm;
import ebiz.form.ProviderForm;

/**
 * @author ThuyNT
 */
public class DisplayProduct extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String value = request.getParameter("value");
        HttpSession se =request.getSession();
        ProviderForm login;
        List<FoodForm> formList = new ArrayList<FoodForm>();
        login = (ProviderForm)se.getAttribute("provider");
        System.out.println("USER PRO ID"+value);
        //required Login
        if(login == null){
            return mapping.findForward(FAILURE);
        }
       
        if(value ==null){
           
            value="0";
        }
        //get FoodFormList to display
        formList = ProviderBLO.getFoodFormList(login.getLoginId(), value);
        se.setAttribute("providerProduct", formList);
        return mapping.findForward(SUCCESS);
    }

}
