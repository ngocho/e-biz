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
	public static List<JSONObject> createHappyBirth() throws JSONException {
		List<JSONObject> objList = new ArrayList<JSONObject>();
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		//add data
		json.put("phone", "0978349998");
		json.put("name", " ChÃºc má»«ng sinh nháº­t Mr A! Tháº­t nhiá»�u may máº¯n vÃ  thÃ nh cÃ´ng");
		objList.add(json);
		json1.put("phone", "0978349999");
		json1.put("name", "ChÃºc má»«ng sinh nháº­t Mrs B!  Tháº­t nhiá»�u may máº¯n vÃ  thÃ nh cÃ´ng");
		objList.add(json1);
		return objList;
	}
	public static JSONObject createCustomerPhone() throws JSONException {
		JSONObject json = new JSONObject();
		List<String> phones = new ArrayList<String>();
		//add data
		phones.add("0978354952");
		phones.add("0978354950");
		phones.add("0978354951");
		json.put("data", phones);
		return json;
	}
	public static List<JSONObject> createEmployeeInfo() throws JSONException {
		List<JSONObject> objList = new ArrayList<JSONObject>();

		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		//add data
		json.put("id", "123");
		json.put("name", "Mr A");
		json.put("x", "1");
		json.put("y", "2");
		objList.add(json);
		json1.put("id", "123");
		json1.put("name", "Mr B");
		json1.put("x", "1");
		json1.put("y", "2");
		objList.add(json1);
		return objList;
	}
}
