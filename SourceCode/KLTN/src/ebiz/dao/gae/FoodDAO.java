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
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.TaskOptions;

import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodPromotion;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;
import ebiz.form.ShoppingCart;

/**
 * @author ThuyNT
 */
public class FoodDAO implements IFoodDAO {
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getListFoodById(String col, String id) {
        List<Food> foodList = new ArrayList<Food>();
        foodList =  (List<Food>) PMF.getObjectListByValue(Food.class, col, id);
        return foodList;
    }
    
  
    @Override
    public Food getFoodById(String key) {
        Food food = null;
        food =  (Food)PMF.getObjectById(Food.class, key);
        return food;
    }
    @Override
    public Food getFoodById(Long key) {
        Food food = null;
        food =  (Food)PMF.getObjectById(Food.class, key);
        return food;
    }

    public static boolean upNumberFood(Long id, Integer number){
        Food food = null;
        food = (Food)PMF.getObjectById(Food.class, id);
        if(food !=null){
            food.setNumber(food.getNumber()+number);
            return true;
        }
        return false;
    }
    public static boolean downNumberFood(Long id, Integer number){
        Food food = null;
        food = (Food)PMF.getObjectById(Food.class, id);
        if(food !=null){
            food.setNumber(food.getNumber() - number);
            return true;
        }
        return false;
    }
    /**
     * 
     * update Number of product
     * @param col
     * @param value
     * @return
     * @see ebiz.dao.inf.IFoodDAO#updateNumber(java.lang.String, java.lang.Integer)
     */
//    public boolean updateNumber(Long id ,String col, Integer value){
//        System.out.println("updateNumber");
//        return PMF.update(Food.class,"foodId",id, col, value);
//    }
//    @SuppressWarnings("unchecked")
//    @Override
//    public FoodPromotion getFoodPromotionById(String col,Long key) {
//        FoodPromotion food = null;
//        List<FoodPromotion> results = new ArrayList<FoodPromotion>();
//        String id = String.valueOf(key);
//        results =  (List<FoodPromotion>) PMF.getObjectListById(FoodPromotion.class,col, id);
//        if(!results.isEmpty()){
//            food = results.get(0);
//        }
//        
//        return food;
//    }
    @Override
    public FoodPromotion getFoodPromotionById(Long key) {
        FoodPromotion food = null;
        food =  (FoodPromotion)PMF.getObjectById(FoodPromotion.class, key);
        return food;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getFoodList() {
        List<Food> foodList = new ArrayList<Food>();
        foodList =  (List<Food>) PMF.getObjectList(Food.class);
        return foodList;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Food>  diplayFirstPage(String col, HashMap<Integer, String> paging,String order , int record, int page){
        List<Food> foodList = new ArrayList<Food>();
        foodList =  (List<Food>) PMF.diplayFirstPage(Food.class, col, paging, order, record, page);
        return foodList;
    }
    @Override
    public boolean insertFood(Food food){
        
        return PMF.insertObject(food);
        
    }
    @Override
    public boolean save(Food food){
        
        return PMF.insertObject(food);
        
    }
    @Override
    public boolean insertFoodAttribute(FoodAttribute food){
        
        return PMF.insertObject(food);
        
    }
    @Override
    public boolean insertFoodStatus(FoodStatus food){
        
        return PMF.insertObject(food);
        
    }
    @Override
    public boolean insertFoodType(FoodType food){
        
        return PMF.insertObject(food);
        
    }
    @Override
    public boolean insertFoodPriceLevel(FoodPriceLevel food){
        
        return PMF.insertObject(food);
        
    }
    @Override
    public boolean insertFoodPromotion(FoodPromotion food){
        
        return PMF.insertObject(food);
        
    }
    
    
    
    @Override
    public boolean deleteFood(String key){
        return false;
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FoodPromotion> getListFoodPromotion(){
        
       List<FoodPromotion> foodProList = new ArrayList<FoodPromotion>();
       foodProList = (List<FoodPromotion>) PMF.getObjectList(FoodPromotion.class);
       return foodProList;
        
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getAttributeList( String col){
       System.out.println("get attr list");
       List<String> foodProList = new ArrayList<String>();
       foodProList = (List<String>) PMF.getColList(FoodAttribute.class, col);
       return foodProList;
        
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<FoodPriceLevel> getPriceList(){
        
        
        List<FoodPriceLevel> foodProList = new ArrayList<FoodPriceLevel>();
        foodProList = (List<FoodPriceLevel>) PMF.getObjectList(FoodPriceLevel.class);
        return foodProList;
        
    }


//    /**
//     * create bill using transaction : put task into taks queue
//     * @param key
//     * @return
//     * @see ebiz.dao.inf.IFoodDAO#billing(ebiz.form.ShoppingCart)
//     */
//    @Override
//    public boolean billing(ShoppingCart key) {
//        
//        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
//        Queue queue = QueueFactory.getDefaultQueue();
//        Transaction txn = ds.beginTransaction();
//        try {
//           
//
//            // ...
//
//            queue.add(TaskOptions.Builder.withUrl("/path/to/my/worker"));
//
//            // ...
//            txn.commit();
//        } catch (DatastoreFailureException e) {
//           txn.rollback(); 
//        }
//        
//        return false;
//    }


}
