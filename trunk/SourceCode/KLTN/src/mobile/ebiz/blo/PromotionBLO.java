package mobile.ebiz.blo;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.blo.food.FoodBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
/**
 * @author nthanhphong
 */
public class PromotionBLO {
    /**
     * [Give the description for method].
     * @return JSONObject
     * @throws JSONException JSONException
     */
    public static JSONObject getFoodPromotion() throws JSONException {
        JSONObject json = new JSONObject();
        JSONArray foodList = new JSONArray();
        List<FoodForm> formList = new ArrayList<FoodForm>();
        formList = FoodBLO.getFoodListByStatus(30, "1");
        FoodDAO dao = new FoodDAO();
        for (FoodForm food : formList) {
            JSONObject obj = new JSONObject();
            obj.put("id", food.getId());
            obj.put("name", food.getName());
            foodList.put(obj);
        }
        // json.put("info", CommonConstant.CODEFOOD_1);
        // json.put("name", "Food Promotion");
        json.put("data", foodList);
        return json;
    }
    // public static JSONArray getFoodPromotionList() throws JSONException{
    // JSONArray foodList = new JSONArray();
    // List<FoodPromotion> foods = new ArrayList<FoodPromotion>();
    // FoodDAO dao = new FoodDAO();
    // //foods = dao.getListFoodPromotion();
    // for (FoodPromotion food : foods) {
    // JSONObject obj = new JSONObject();
    // obj.put("id", food.getProductId());
    // obj.put("name", food.getProductName());
    // foodList.put(obj);
    // }
    // return foodList;
    // }
    /**
     * [Give the description for method].
     * @return JSONObject
     * @throws JSONException JSONException
     */
    public static JSONObject createFoodPromotion() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("data", getFoodListAll());
        return json;
    }
    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    public static List<JSONObject> getFoodListAll() throws JSONException {

        List<JSONObject> objList = new ArrayList<JSONObject>();
        // add data
        // call function to get all data
        List<Food> foodList = new ArrayList<Food>();
        foodList = FoodBLO.getFoodListAll();
        if (!foodList.isEmpty()) {
            int temp = 5;
            if (foodList.size() < temp) {
                temp = foodList.size();
            }

            for (int i = 0; i < temp; i++) {
                JSONObject json = new JSONObject();
                json.put("id", foodList.get(i).getFoodId());
                json.put("name", foodList.get(i).getFoodName());
                json.put("promotionprice", foodList.get(i).getPricePromotion());
                objList.add(json);
            }
        }
        return objList;
    }

}
