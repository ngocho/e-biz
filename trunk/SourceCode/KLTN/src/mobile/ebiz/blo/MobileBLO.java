package mobile.ebiz.blo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import mobile.ebiz.dao.gae.IdxuDAO;
import mobile.ebiz.dao.inf.IIdxuDAO;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.dao.gae.CustomerDAO;
import ebiz.dao.gae.PMF;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.food.Food;
import ebiz.util.CommonConstant;

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
				//urlImage = url(chương trình) + /serveImage.vn?urlKey=getUrlKey
				json.put("url", foodList.get(i).getUrlKey());
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
	//
	//	KÍNH CHÚC QUÝ KHÁCH SINH NHẬT TRÀN NGẬP HẠNH PHÚC VÀ MAY MẮN!
	public static JSONObject createListHappyBirth() throws JSONException{
		JSONObject obj=new JSONObject();
		List<Customer> listphone=new ArrayList<Customer>();
		listphone=(List<Customer>)PMF.getObjectList(Customer.class);
		obj.put("data", listphone);
		return obj;
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
