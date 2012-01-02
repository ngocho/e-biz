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
package ebiz.blo.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ebiz.blo.food.FoodBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodPromotion;
import ebiz.dto.food.FoodPromotionType;
import ebiz.dto.food.FoodStatus;
import ebiz.util.CommonConstant;

/**
 * initialze for web site
 * @author ThuyNT
 *
 */
public class Initialize {
    private static IFoodDAO foodDao = new FoodDAO();
    
    public static List<Food> initializeFood() {
        List<Food> foodList = new ArrayList<Food>();
        for ( int i =0;i<10; i++){
            Food food = new Food();
            food.setFoodName(String.valueOf(i));
            food.setFoodTypeId(CommonConstant.TYPE_1);
            food.setFoodPriceLevelId("0");
            food.setPrice(new Long(i));
            food.setCalo("123");
            food.setDetail("canh ga");
            food.setExpDate(new Date());
            food.setNumber(12);
            food.setPrice(new Long(i*2));
            
            food.setProductAttributeId("1");
            food.setProviderID("NCC1");
            food.setReviewer(123);
            food.setStartDate(new Date());
//            DateFormat df = DateFormat.getDateInstance();
            food.setExpDate(new Date());
            food.setUrl("Images/Foods/"+ String.valueOf(i+1)+".jpg");
          
            foodList.add(food);
            if(i%2==0){
            food.setFoodStatusId("2");
            food.setPricePromotion(new Long(i));
            }
            else{
                food.setFoodStatusId("1");
            }
            foodDao.saveFood(food);
        }
        return foodList;
    }
    
    public static void initializeFoodAttribute() {
        
        FoodAttribute attr0 = new FoodAttribute();
        attr0.setProductAttributeId("0");
        attr0.setProductAttributeName("xao");
        System.out.println("ATTR: "+ foodDao.insertFoodAttribute(attr0));
        
        FoodAttribute attr1 = new FoodAttribute();
        attr1.setProductAttributeId("1");
        attr1.setProductAttributeName("kho");
        foodDao.insertFoodAttribute(attr1);
        
        FoodAttribute attr2 = new FoodAttribute();
        attr2.setProductAttributeId("2");
        attr2.setProductAttributeName("canh");
        foodDao.insertFoodAttribute(attr2);
     
    }
    
    public static void initializeFoodStatus() {
        FoodStatus sta0 = new FoodStatus();
        sta0.setFoodStatusId("0");
        sta0.setFoodStatusName("Het hang");
        foodDao.insertFoodStatus(sta0);

        FoodStatus sta1 = new FoodStatus();
        sta1.setFoodStatusId("1");
        sta1.setFoodStatusName("Dang ban");
        foodDao.insertFoodStatus(sta1);

        FoodStatus sta2 = new FoodStatus();
        sta2.setFoodStatusId("2");
        sta2.setFoodStatusName("Khuyen mai");
        foodDao.insertFoodStatus(sta2);

    }
    public static void initializeFoodPriceLevel() {
        FoodPriceLevel level0 = new FoodPriceLevel();
        level0.setFoodPriceLevelId("0");
        level0.setStartPrice(new Long("1000"));
        level0.setEndPrice(new Long("2000"));
        foodDao.insertFoodPriceLevel(level0);
       
        FoodPriceLevel level1 = new FoodPriceLevel();
        level1.setFoodPriceLevelId("1");
        level1.setStartPrice(new Long("1000"));
        level1.setEndPrice(new Long("2000"));
        foodDao.insertFoodPriceLevel(level1);
    }
//    public static void initializeFoodPromotion() {
//        List<Food> foodList = new ArrayList<Food>();
//        foodList = initializeFood();
//        FoodPromotionType f = new FoodPromotionType();
//        System.out.println("%%%%%%%%%%%%");
//        for(Food food: foodList){
//            System.out.println("1");
//            FoodBLO.updateFoodPromotion(food);
////           foodDao.insertFoodPromotion(food)
//        }
//    }
    
    

}
