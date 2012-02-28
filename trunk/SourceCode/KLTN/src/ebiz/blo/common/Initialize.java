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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ebiz.blo.customer.CustomerBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.account.customer.Assessment;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
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
            food.setNumberOrder(0);
            food.setIsDisplay(1);
            food.setProductAttributeId("1");
            food.setProviderID("NCC1");
            food.setStartDate(new Date());
//            DateFormat df = DateFormat.getDateInstance();
            food.setExpDate(new Date());
//            food.setUrl("Images/Foods/"+ String.valueOf(i+1)+".jpg");
          
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
        attr0.setProductAttributeId("1");
        attr0.setProductAttributeName("Kho");
                                                  
        
        FoodAttribute attr1 = new FoodAttribute();
        attr1.setProductAttributeId("2");
        attr1.setProductAttributeName("Canh");
        foodDao.insertFoodAttribute(attr1);
        
        FoodAttribute attr2 = new FoodAttribute();
        attr2.setProductAttributeId("3");
        attr2.setProductAttributeName("Xao");
        foodDao.insertFoodAttribute(attr2);
        
        attr2.setProductAttributeId("4");
        attr2.setProductAttributeName("Lẩu");
        foodDao.insertFoodAttribute(attr2);
        attr2.setProductAttributeId("5");
        attr2.setProductAttributeName("Khác");
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
    	
    	foodDao.deleteFoodAll(FoodPriceLevel.class);
    	
        FoodPriceLevel level0 = new FoodPriceLevel();
        level0.setFoodPriceLevelId("1");
        level0.setStartPrice(0);
        level0.setEndPrice(30000);
        foodDao.insertFoodPriceLevel(level0);
        
        level0.setFoodPriceLevelId("2");
        level0.setStartPrice(30000);
        level0.setEndPrice(100000);
        foodDao.insertFoodPriceLevel(level0);
        
        level0.setFoodPriceLevelId("3");
        level0.setStartPrice(100000);
        level0.setEndPrice(200000);
        foodDao.insertFoodPriceLevel(level0);
        
        level0.setFoodPriceLevelId("4");
        level0.setStartPrice(200000);
        foodDao.insertFoodPriceLevel(level0);
        
        
    }
    public static void createAss(){
    	Assessment a1= new Assessment();
    	a1.setId("1");
    	a1.setName("Món ăn đa dạng");
    	a1.setNumber(12);
    	CustomerBLO.saveAss(a1);
    	
    	Assessment a2= new Assessment();
    	a2.setId("2");
    	a2.setName("Giá cả phải chăng");
    	a2.setNumber(12);
    	CustomerBLO.saveAss(a2);
    	
    	Assessment a3= new Assessment();
    	a3.setId("3");
    	a3.setName("Giao diện dễ sử dụng");
    	a3.setNumber(12);
    	CustomerBLO.saveAss(a3);
    	Assessment a4= new Assessment();
    	a4.setId("4");
    	a4.setName("Thanh toán đảm bảo");
    	a4.setNumber(12);
    	CustomerBLO.saveAss(a4);
    	Assessment a5= new Assessment();
    	a5.setId("5");
    	a5.setName("Giao hàng tận tình");
    	a5.setNumber(12);
    	CustomerBLO.saveAss(a5);
    	
    }
    
    

}
