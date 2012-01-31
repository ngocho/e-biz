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
import ebiz.util.CommonUtil;

/**
 * @author ThuyNT
 */
public class UploadProduct extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// after check validate
		FoodForm foodForm = (FoodForm) form;
		HttpSession se = request.getSession();
		String url, urlKey;
		//get url
//        url = (String) se.getAttribute("urlImage");
		 urlKey = (String) se.getAttribute("urlImageKey");
        if((urlKey != null)){
//        urlKey = (String) se.getAttribute("urlImageKey");
//        foodForm.setUrl(url);
        foodForm.setUrlKey(urlKey);
        
        System.out.println("FOOD ID"+ foodForm.getId());
		// upload product
		if (CommonUtil.isBlankOrZero(foodForm.getId())) {
			ProviderForm provider;
			provider = (ProviderForm) se.getAttribute("provider");

			// set atrr into form
			foodForm.setIdProvider(provider.getLoginId());
			System.out.println("UPLOAD" + foodForm.getUrlKey());

			Food food = foodForm.getFood();
			System.out.println("ID pro" + food.getFoodTypeId());
			System.out.println("ID pro" + food.getUrlKey());
//			food.setIsDisplay(1); // display ( must edit : 0)
//			food.setNumberOrder(0);
//			food.setFoodPriceLevelId(FoodBLO.getFoodIdPrice(food.getPrice()));
			// food.setIsDisplay(0);
			boolean flagUpload = FoodBLO.uploadFood(food);
			System.out.println("UPLOAD" + flagUpload);
			if (flagUpload) {
				//remove attr
				se.removeAttribute("foodForm");
				se.removeAttribute("urlImage");
				se.removeAttribute("urlImageKey");
				request.setAttribute("fUpload", "1");
			}
			return mapping.findForward(SUCCESS);
		}
		// updated product
		else {
			Food food = foodForm.getFood();
			food.setFoodId(foodForm.getId());
			boolean flag;
	        flag = FoodBLO.updateFood(food);
			if (flag) {
			    //remove attr 
				se.removeAttribute("urlImage");
				se.removeAttribute("urlImageKey");
				se.removeAttribute("foodForm");
				request.setAttribute("fUpload", "1");
				return mapping.findForward(SUCCESS1);
			}

		}
        }
		return mapping.findForward(FAILURE);
	}
        
}
