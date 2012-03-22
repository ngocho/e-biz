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

    /**
     * [get List Food filter by property(column in database) ].
     * @param col
     * @param id
     * @return List<Food>
     * @see ebiz.dao.inf.IFoodDAO#getListFoodByValue(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getListFoodByValue(String col, String value) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.getObjectListByValue(Food.class, col, value);
        return foodList;
    }

//    /**
//     * [get an obj Food by ID(String)].
//     * @param key
//     * @return Food
//     * @see ebiz.dao.inf.IFoodDAO#getFoodById(java.lang.String)
//     */
//    @Override
//    public Food getFoodById(String key) {
//        Food food = null;
//        food = (Food) PMF.getObjectById(Food.class, key);
//        return food;
//    }

    /**
     * [get an obj Food by ID].
     * @param key
     * @return Food
     * @see ebiz.dao.inf.IFoodDAO#getFoodById(java.lang.Long)
     */
    @Override
    public Food getFoodById(Long key) {
        Food food = null;
        food = (Food) PMF.getObjectById(Food.class, key);
        return food;
    }

    /**
     * [increase number of Food ].
     *
     * @param id of Food
     * @param number will be increased
     * @return true if success and else
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
     * [decrease number of Food].
     * @param id of Food
     * @param number will be decreased
     * @return true if success and else
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

    /**
     * [get all Food in database (Food table)].
     * @return List<Food>
     * @see ebiz.dao.inf.IFoodDAO#getFoodListAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getFoodListAll() {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.getObjectList(Food.class);
        return foodList;
    }

    /**
     * [paging Food].
     * @param col
     * @param numberPageList
     * @param order
     * @param record
     * @param page
     * @param sql
     * @return List<Food>
     * @see ebiz.dao.inf.IFoodDAO#diplayPageFood(java.lang.String, java.util.List, java.lang.String, int, int, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> diplayPageFood(String col, List<String> numberPageList, String order, int record, int page,
            String sql) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.displayPageFood(Food.class, col, numberPageList, order, record, page, sql);
        return foodList;
    }

    /**
     * [display initialize List Food ].
     * @param col
     * @param numberPageList
     * @param order
     * @param record
     * @param page
     * @param sql
     * @return List<Food>
     * @see ebiz.dao.inf.IFoodDAO#diplayFoodCategoryAll(java.lang.String, java.util.List, java.lang.String, int, int, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> diplayFoodCategoryAll(String col, List<String> numberPageList, String order, int record,
            int page, String sql) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.displayPageFoodAll(Food.class, col, numberPageList, order, record, page, sql);
        return foodList;
    }

    /**
     * [save Food].
     * @param food
     * @return boolean
     * @see ebiz.dao.inf.IFoodDAO#saveFood(ebiz.dto.food.Food)
     */
    @Override
    public boolean saveFood(Food food) {

        return PMF.insertObject(food);

    }

    /**
     * [insertFoodAttribute].
     * @param food
     * @return boolean
     * @see ebiz.dao.inf.IFoodDAO#insertFoodAttribute(ebiz.dto.food.FoodAttribute)
     */
    @Override
    public boolean insertFoodAttribute(FoodAttribute food) {

        return PMF.insertObject(food);

    }

    /**
     * [insertFoodStatus].
     * @param food
     * @return boolean
     * @see ebiz.dao.inf.IFoodDAO#insertFoodStatus(ebiz.dto.food.FoodStatus)
     */
    @Override
    public boolean insertFoodStatus(FoodStatus food) {

        return PMF.insertObject(food);

    }

    /**
     * [insertFoodType].
     * @param food
     * @return
     * @see ebiz.dao.inf.IFoodDAO#insertFoodType(ebiz.dto.food.FoodType)
     */
    @Override
    public boolean insertFoodType(FoodType food) {

        return PMF.insertObject(food);

    }

    /**
     * [insertFoodPriceLevel].
     * @param food
     * @return
     * @see ebiz.dao.inf.IFoodDAO#insertFoodPriceLevel(ebiz.dto.food.FoodPriceLevel)
     */
    @Override
    public boolean insertFoodPriceLevel(FoodPriceLevel food) {

        return PMF.insertObject(food);

    }

    /**
     * [deleteFood].
     * @param food  Food
     * @return boolean
     * @see ebiz.dao.inf.IFoodDAO#deleteFood(ebiz.dto.food.Food)
     */
    @Override
    public boolean deleteFood(Food food) {
        return PMF.delete(food);

    }


    /**
     * [getPriceList].
     * @return List<FoodPriceLevel>
     * @see ebiz.dao.inf.IFoodDAO#getPriceList()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<FoodPriceLevel> getPriceList() {

        List<FoodPriceLevel> foodProList = new ArrayList<FoodPriceLevel>();
        foodProList = (List<FoodPriceLevel>) PMF.getObjectList(FoodPriceLevel.class);
        return foodProList;

    }

    /**
     * [test a food is exist].
     * @param id
     * @return boolean
     * @see ebiz.dao.inf.IFoodDAO#isFood(java.lang.Long)
     */
    @Override
    public boolean isFood(Long id) {
        if (id != null) {
            return PMF.isObject(Food.class, String.valueOf(id));
        }
        return false;
    }

    /**
     * [getFoodListByProviderStatus].
     *
     * @param idProvider String
     * @param statusFood String
     * @return @SuppressWarnings("unchecked")
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

    /**
     * [getStatusNameByID].
     * @param id
     * @return nameStatus
     * @see ebiz.dao.inf.IFoodDAO#getStatusNameByID(java.lang.String)
     */
    @Override
    public String getStatusNameByID(String id) {
        FoodStatus status = (FoodStatus) PMF.getObjectById(FoodStatus.class, id);
        if (status != null) {
            return status.getFoodStatusName();
        }
        return null;
    }

    /**
     * [getNameTypeById].
     * @param id
     * @return nameType
     * @see ebiz.dao.inf.IFoodDAO#getNameTypeById(java.lang.String)
     */
    @Override
    public String getNameTypeById(String id) {
        FoodType type = (FoodType) PMF.getObjectById(FoodType.class, id);

        if (type != null) {
            return type.getProductTypeName();
        }
        return null;
    }

    /**
     * [getNameAttrById].
     * @param id
     * @return String
     * @see ebiz.dao.inf.IFoodDAO#getNameAttrById(java.lang.String)
     */
    @Override
    public String getNameAttrById(String id) {
        FoodAttribute type = (FoodAttribute) PMF.getObjectById(FoodAttribute.class, id);
        if (type != null) {
            return type.getProductAttributeName();
        }
        return null;
    }

    /**
     * [getAttributeList].
     * @return List<FoodAttribute>
     * @see ebiz.dao.inf.IFoodDAO#getAttributeList()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<FoodAttribute> getAttributeList() {
        List<FoodAttribute> list = new ArrayList<FoodAttribute>();
        list = (List<FoodAttribute>) PMF.getObjectList(FoodAttribute.class);
        return list;
    }
    /**
     * [searchFoodByName].
     * @param searchText
     * @param type
     * @param attr
     * @param price
     * @param status
     * @param provider
     * @return
     * @see ebiz.dao.inf.IFoodDAO#searchFoodByName(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> searchFoodByName(String searchText, String type, String attr, String price, String status,
            String provider) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) PMF.searchListFoodByName(Food.class, searchText, type, attr, price, status, provider);
        return foodList;
    }

}
