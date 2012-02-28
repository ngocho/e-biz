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
import ebiz.form.ProviderForm;

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
    public static boolean updateProvider(Provider provider) {
        return proDao.saveProvider(provider);
    }
    public static Provider getProviderById(String id) {
        return proDao.getProviderById(id);
    }
    public static String getNameProviderByID(String id) {
        Provider provider = proDao.getProviderById(id);
        if (provider != null) {
            return provider.getProviderName();
        }
        return null;
    }
    public static List<ProviderForm> searchProvider(String value) {
        List<Provider> providerList = proDao.getProviderByName(value);
        return transferForm(providerList);
    }

    public static int isLoginID(String id, String pass) {
        Provider provider = proDao.getProviderById(id);

        if (provider != null) {
            if (!provider.isActive()) {
                return 2; // not yet authentication
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
    public static List<FoodForm> getFoodFormList(String idProvider, String statusFood) {

        List<Food> foodList = new ArrayList<Food>();
        List<FoodForm> formList = new ArrayList<FoodForm>();
        // get all
        if (statusFood.equals("0")) {
                                                      
            foodList = foodDao.getListFoodByValue("providerID", idProvider);
        }
        // get by status
        else {
            foodList = foodDao.getFoodListByProviderStatus(idProvider, statusFood);
        }
        for (Food food : foodList) {
            FoodForm form = new FoodForm();
            form.editForm(food);
            formList.add(form);
        }
        return formList;
    }
    public static List<ProviderForm> getProviderFormAll() {
        List<Provider> providerList = proDao.getProviderAll();
        return transferForm(providerList);
    }
    public static List<ProviderForm> searchProviderByName(String value) {
        List<Provider> providerList = proDao.getProviderByName(value);
        return transferForm(providerList);
    }
    public static List<ProviderForm> transferForm(List<Provider> providerList) {
        List<ProviderForm> resultList = new ArrayList<ProviderForm>();
        if (!providerList.isEmpty()) {
            for (Provider provider : providerList) {
                                                          
                ProviderForm form = new ProviderForm();
                form.editForm(provider);
                if (form != null) {
                                                              
                    resultList.add(form);
                }
            }
        }
        return resultList;
    }

    public static List<String> searchProviderByDis(String value) {
        List<String> list = new ArrayList<String>();
        List<Provider> providerList = proDao.getProviderAll();
        for (Provider provider : providerList) {
            String add = provider.getProviderAddress();
            if (add.indexOf(value) != -1) { // have result
                list.add(provider.getProviderId());
            }
        }
        return list;
    }
    public static boolean testProviderByDis(List<String> idProviderList, String idProvider) {
        for (String id : idProviderList) {
            if (id.equals(idProvider)) {
                return true;
            }
        }
        return false;
    }
}
