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
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
import ebiz.form.ProviderForm;

/**
 * @author ThuyNT
 */
public class UploadProduct extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //after check validate 
        System.out.println("UPLOAD" );
        String url, urlKey;
        ProviderForm provider;
        HttpSession se = request.getSession();
        url= (String)se.getAttribute("urlImage");
        urlKey= (String)se.getAttribute("urlImageKey");
        System.out.println("URL KEY"+ urlKey);
        provider = (ProviderForm)se.getAttribute("provider");
        if(provider ==  null){
            return mapping.findForward(INPUT);
        }
        FoodForm foodForm = (FoodForm)form;
        //set atrr into form
        foodForm.setUrl(url);
        foodForm.setUrlKey(urlKey);
        
        foodForm.setIdProvider(provider.getLoginId());
        System.out.println("UPLOAD STATUS" +foodForm.getStatus() );
        
        Food food = foodForm.getFood();
        System.out.println("ID pro"+food.getProviderID());
        System.out.println("ID pro"+food.getFoodStatusId());
        
        food.setIsDisplay(1); //updated ( must edit : 0)
        food.setNumberOrder(0);
        food.setFoodPriceLevelId(FoodBLO.getFoodStatus(food.getPrice()));
        
        boolean flagUpload = FoodBLO.uploadFood(food);
        if(flagUpload){
           se.removeAttribute("urlImage");
           se.removeAttribute("urlImageKey");
           foodForm.clear();
           return mapping.findForward(SUCCESS);
        }
        return mapping.findForward(FAILURE);
        
    }

}
