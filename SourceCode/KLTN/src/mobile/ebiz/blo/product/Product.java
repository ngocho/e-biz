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
package mobile.ebiz.blo.product;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.dao.gae.FoodDAO;
import ebiz.dto.food.FoodPromotion;
import ebiz.util.CommonConstant;
/**
 * @author ThuyNT
 *
 */
public class Product {
    public static JSONObject getFoodPromotion() throws JSONException{
        JSONObject json = new JSONObject();
        JSONArray foodList = new JSONArray();
        List<FoodPromotion> foods = new ArrayList<FoodPromotion>();
        FoodDAO dao = new FoodDAO();
        //foods = dao.getListFoodPromotion();
        for (FoodPromotion food : foods) {
            JSONObject obj = new JSONObject();
            obj.put("id", food.getProductId());
            obj.put("name", food.getProductName());
            foodList.put(obj);
        }
//        json.put("info", CommonConstant.CODEFOOD_1);
//        json.put("name", "Food Promotion");
        json.put("data", foodList);
        return json;
    }
    public static JSONArray getFoodPromotionList() throws JSONException{
        JSONArray foodList = new JSONArray();
        List<FoodPromotion> foods = new ArrayList<FoodPromotion>();
        FoodDAO dao = new FoodDAO();
        //foods = dao.getListFoodPromotion();
        for (FoodPromotion food : foods) {
            JSONObject obj = new JSONObject();
            obj.put("id", food.getProductId());
            obj.put("name", food.getProductName());
            foodList.put(obj);
        }
        return foodList;
    }
    public static JSONObject createFoodPromotion() throws JSONException{
        JSONObject json = new JSONObject();
        JSONArray foodList = new JSONArray();

        for (int i = 0; i < 5; i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", String.valueOf(i));
            obj.put("name", "abc" + String.valueOf(i));
            foodList.put(obj);
        }
        json.put("data", foodList);
        return json;
    }

}
