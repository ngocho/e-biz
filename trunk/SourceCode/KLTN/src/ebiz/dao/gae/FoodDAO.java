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
package ebiz.dao.gae;

import java.util.ArrayList;
import java.util.List;

import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;

/**
 * @author ThuyNT
 */
public class FoodDAO implements IFoodDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getListFoodByValue(String col, String id) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.getObjectListByValue(Food.class, col, id);
        return foodList;
    }

    @Override
    public Food getFoodById(String key) {
        Food food = null;
        food = (Food) PMF.getObjectById(Food.class, key);
        return food;
    }

    @Override
    public Food getFoodById(Long key) {
        Food food = null;
        food = (Food) PMF.getObjectById(Food.class, key);
        return food;
    }

    /**
     * [upNumberFood].
     * @param id Long
     * @param number int
     * @return boolean
     */
    public static boolean upNumberFood(Long id, int number) {
        Food food = null;
        food = (Food) PMF.getObjectById(Food.class, id);
        if (food != null) {
            food.setNumber(food.getNumber() + number);
            return true;
        }
        return false;
    }

    /**
     * [downNumberFood].
     * @param id    Long
     * @param number   int
     * @return   boolean
     */
    public static boolean downNumberFood(Long id, int number) {
        Food food = null;
        food = (Food) PMF.getObjectById(Food.class, id);
        if (food != null) {
            food.setNumber(food.getNumber() - number);
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getFoodListAll() {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.getObjectList(Food.class);
        return foodList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Food> diplayPageFood(String col, List<String> numberPageList, String order, int record, int page,
            String sql) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.displayPageFood(Food.class, col, numberPageList, order, record, page, sql);
        return foodList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Food> diplayFoodCategoryAll(String col, List<String> numberPageList, String order, int record,
            int page, String sql) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.displayPageFoodAll(Food.class, col, numberPageList, order, record, page, sql);
        return foodList;
    }

    @Override
    public boolean saveFood(Food food) {

        return PMF.insertObject(food);

    }

    @Override
    public boolean insertFoodAttribute(FoodAttribute food) {

        return PMF.insertObject(food);

    }

    @Override
    public boolean insertFoodStatus(FoodStatus food) {

        return PMF.insertObject(food);

    }

    @Override
    public boolean insertFoodType(FoodType food) {

        return PMF.insertObject(food);

    }

    @Override
    public boolean insertFoodPriceLevel(FoodPriceLevel food) {

        return PMF.insertObject(food);

    }

    @Override
    public boolean deleteFood(Food food) {
        return PMF.delete(food);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getAttributeList(String col) {
        List<String> foodProList = new ArrayList<String>();
        foodProList = (List<String>) PMF.getColList(FoodAttribute.class, col);
        return foodProList;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FoodPriceLevel> getPriceList() {

        List<FoodPriceLevel> foodProList = new ArrayList<FoodPriceLevel>();
        foodProList = (List<FoodPriceLevel>) PMF.getObjectList(FoodPriceLevel.class);
        return foodProList;

    }

    @Override
    public boolean isFood(Long id) {
        if (id != null) {
            return PMF.isObject(Food.class, String.valueOf(id));
        }
        return false;
    }

    /**
     * [getFoodListByProviderStatus].
     * @param idProvider String
     * @param statusFood String
     * @return  @SuppressWarnings("unchecked")
     * @see ebiz.dao.inf.IFoodDAO#getFoodListByProviderStatus()
     * @SuppressWarnings
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getFoodListByProviderStatus(String idProvider, String statusFood) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.getObjectListByTwoValues(Food.class, "providerID", idProvider, "foodStatusId",
                statusFood);
        return foodList;
    }

    @Override
    public String getStatusNameByID(String id) {
        FoodStatus status = (FoodStatus) PMF.getObjectById(FoodStatus.class, id);
        if (status != null) {
            return status.getFoodStatusName();
        }
        return null;
    }
    
    @Override
    public String getNameTypeById(String id) {
        FoodType type = (FoodType) PMF.getObjectById(FoodType.class, id);
        System.out.println("FOODTYPE" + type);
        if (type != null) {
            return type.getProductTypeName();
        }
        return null;
    }
    
    @Override
    public String getNameAttrById(String id) {
        FoodAttribute type = (FoodAttribute) PMF.getObjectById(FoodAttribute.class, id);
        if (type != null) {
            return type.getProductAttributeName();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FoodAttribute> getAttributeList() {
        List<FoodAttribute> list = new ArrayList<FoodAttribute>();
        list = (List<FoodAttribute>) PMF.getObjectList(FoodAttribute.class);
        return list;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> searchFoodByName(String searchText, String type, String attr, String price, String status) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.searchListFoodByName(Food.class, searchText, type, attr, price, status);
        return foodList;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteFoodAll(Class<?> className) {
        List<Object> list = new ArrayList<Object>();
        list = ( List<Object>)PMF.getObjectList(className);
;       return PMF.deleteAll(list);
    }
}
