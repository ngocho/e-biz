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
package ebiz.blo.provider;

import java.util.ArrayList;
import java.util.List;

import ebiz.dao.gae.FoodDAO;
import ebiz.dao.gae.ProviderDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dao.inf.IProviderDAO;
import ebiz.dto.account.provider.Provider;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;

/**
 * @author Administrator
 */
public class ProviderBLO {

    private static IProviderDAO proDao = new ProviderDAO();
    private static IFoodDAO foodDao = new FoodDAO();

    public static boolean registerProvider(Provider provider) {

        boolean flag = proDao.isProvider(provider.getProviderId());
        if (!flag) {
            return proDao.saveProvider(provider);
        }
        return false;
    }
    public static String getNameProviderByID(String id){
        Provider provider = proDao.getProviderById(id);
        if(provider !=null){
           return  provider.getProviderName();
        }
        return null;
    }
    
    public static int isLoginID(String id, String pass) {
        Provider provider = proDao.getProviderById(id);
        
        if (provider != null) {
        	if(!provider.isActive()){
            	return 2; //not yet authentication
            }
            // get password
            String passCust = provider.getProviderPassword();
            if (pass.equals(passCust)) {
                return 1; // success
            } else {
                return 0; // didn't match
            }
        } else {
            return -1; // didn't exist this user
        }
        

    }
 public static List<FoodForm> getFoodFormList(String idProvider,String statusFood){
        
        List<Food> foodList = new ArrayList<Food>();
        List<FoodForm> formList = new ArrayList<FoodForm>();
        //get all
        if(statusFood.equals("0")){
            System.out.println("ALL");
            foodList = foodDao.getListFoodByValue("providerID", idProvider);
        }
        //get by status
        else{
            foodList = foodDao.getFoodListByProviderStatus(idProvider, statusFood);
        }
        for(Food food :foodList ){
            FoodForm form = new FoodForm();
            form.editForm(food);
            formList.add(form);
        }
        return formList;
    }

}
