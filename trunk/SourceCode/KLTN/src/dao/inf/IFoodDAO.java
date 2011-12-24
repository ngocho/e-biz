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
package ebiz.dao.inf;

import java.util.HashMap;
import java.util.List;

import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodPromotion;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;
import ebiz.form.Paging;

/**
 * @author ThuyNT
 *
 */
public interface IFoodDAO {
    
    public List<Food> getListFoodById(String col, String id);
    public boolean insertFood(Food food);
    public boolean save(Food food);
    public boolean insertFoodAttribute(FoodAttribute food);
    public boolean insertFoodStatus(FoodStatus food);
    public boolean insertFoodType(FoodType food);
    public boolean insertFoodPriceLevel(FoodPriceLevel food);
    public boolean insertFoodPromotion(FoodPromotion food);
    public boolean deleteFood(String key);
    public Food getFoodById(String id);
    public Food getFoodById(Long id);
    public List<Food> getFoodList();
    public List<Food> diplayFirstPage(String col, HashMap<Integer, String> paging, String order, int record,int  page);
    public List<FoodPromotion> getListFoodPromotion();
    public List<String> getAttributeList(String col);
    public List<FoodPriceLevel> getPriceList(); 
//    public FoodPromotion getFoodPromotionById(String col,Long key);
    public FoodPromotion getFoodPromotionById(Long key);
//    public boolean updateNumber(Long id ,String col, Integer value);
    

}
