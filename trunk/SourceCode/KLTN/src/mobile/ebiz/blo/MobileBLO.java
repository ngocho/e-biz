package mobile.ebiz.blo;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.blo.food.FoodBLO;
import ebiz.dto.food.Food;

public class MobileBLO {
	 public static List<JSONObject> getFoodListAll() throws JSONException {
	        
	        List<JSONObject> objList = new ArrayList<JSONObject>();
	        //add data
	        //call function to get all data
	        List<Food> foodList = new ArrayList<Food>();
	        foodList = FoodBLO.getFoodListAll();
	        if(!foodList.isEmpty()){
	            int temp = 50;
	            if(foodList.size() <temp){
	                temp = foodList.size();
	            }
	        
	        for(int i =0; i< temp; i++){
	            JSONObject json = new JSONObject();
	            json.put("url", foodList.get(i).getUrl());
	            json.put("id", foodList.get(i).getFoodId());
	            json.put("name", foodList.get(i).getFoodName());
	            json.put("price", foodList.get(i).getPrice());
	            json.put("promotionPrice", foodList.get(i).getPricePromotion());
	            json.put("dateUpload", foodList.get(i).getUploadDate());
	            json.put("number", foodList.get(i).getNumber());
	            objList.add(json);
	        }
	    }
	        return objList;
	    }
}
