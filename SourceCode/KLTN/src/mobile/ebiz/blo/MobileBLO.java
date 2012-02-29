package mobile.ebiz.blo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.blo.food.FoodBLO;
import ebiz.dao.gae.PMF;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.account.provider.Provider;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
import ebiz.util.CommonUtil;

/**
 * @author NThanhPhong
 */
public class MobileBLO {
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
            int temp = 50;
            if (foodList.size() < temp) {
                temp = foodList.size();
            }

            for (int i = 0; i < temp; i++) {
                JSONObject json = new JSONObject();
                // urlImage = url(chÆ°Æ¡ng trĂ¬nh) +
                // /serveImage.vn?urlKey=getUrlKey
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

    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    public static List<JSONObject> getDealsListAll() throws JSONException {

        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<FoodForm> foodList = FoodBLO.getFoodListRecent(10);
        for (int i = 0; i < foodList.size(); i++) {
            JSONObject json = new JSONObject();
            // urlImage = url(chÆ°Æ¡ng trĂ¬nh) + /serveImage.vn?urlKey=getUrlKey
            json.put("url", foodList.get(i).getUrlKey());
            json.put("id", foodList.get(i).getId());
            json.put("name", foodList.get(i).getName());
            json.put("price", foodList.get(i).getPrice());
            json.put("promotionPrice", foodList.get(i).getPromoPrice());
            json.put("dateUpload", foodList.get(i).getUploadDate());
            json.put("number", foodList.get(i).getSale());
            json.put("detail", foodList.get(i).getDetail());
            objList.add(json);
        }
        return objList;
    }
    /**
     * [Give the description for method].
     * @param idprovider String
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    public static List<JSONObject> getFoodListByProvider(String idprovider) throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<FoodForm> foodList = FoodBLO.getFoodListByProvider(idprovider);
        for (int i = 0; i < foodList.size(); i++) {
            JSONObject json = new JSONObject();
            json.put("url", foodList.get(i).getUrlKey());
            json.put("id", foodList.get(i).getId());
            json.put("name", foodList.get(i).getName());
            json.put("price", foodList.get(i).getPrice());
            json.put("promotionPrice", foodList.get(i).getPromoPrice());
            json.put("dateUpload", foodList.get(i).getUploadDate());
            json.put("number", foodList.get(i).getSale());
            json.put("detail", foodList.get(i).getDetail());
            objList.add(json);
        }
        return objList;
    }

    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    public static List<JSONObject> getBrowserListAll() throws JSONException {

        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<Food> foodList = FoodBLO.getFoodListAll();
        if (!foodList.isEmpty()) {
            int temp = 50;
            if (foodList.size() < temp) {
                temp = foodList.size();
            }
            for (int i = 0; i < temp; i++) {
                JSONObject json = new JSONObject();
                json.put("url", foodList.get(i).getUrlKey());
                json.put("id", foodList.get(i).getFoodId());
                json.put("name", foodList.get(i).getFoodName());
                json.put("price", foodList.get(i).getPrice());
                json.put("promotionPrice", foodList.get(i).getPricePromotion());
                json.put("dateUpload", CommonUtil.convertDateToString(foodList.get(i).getUploadDate()));
                json.put("sale", foodList.get(i).getSaleProduct());
                json.put("detail", foodList.get(i).getDetail());
                json.put("type", foodList.get(i).getFoodTypeId());
                json.put("provider", foodList.get(i).getProviderID());
                objList.add(json);
            }
        }
        return objList;
    }

    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    public static List<JSONObject> getBestListAll() throws JSONException {

        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<FoodForm> foodList = FoodBLO.getFoodListPromotionBest(10);
        for (int i = 0; i < foodList.size(); i++) {
            JSONObject json = new JSONObject();
            // urlImage = url(chÆ°Æ¡ng trĂ¬nh) + /serveImage.vn?urlKey=getUrlKey
            json.put("url", foodList.get(i).getUrlKey());
            json.put("id", foodList.get(i).getId());
            json.put("name", foodList.get(i).getName());
            json.put("price", foodList.get(i).getPrice());
            json.put("promotionPrice", foodList.get(i).getPromoPrice());
            json.put("dateUpload", foodList.get(i).getUploadDate());
            json.put("sale", foodList.get(i).getSale());
            json.put("detail", foodList.get(i).getDetail());
            objList.add(json);
        }
        return objList;
    }

    /**
     * [Give the description for method].
     * @return JSONObject
     * @throws JSONException JSONException
     */
    @SuppressWarnings("unchecked")
    public static JSONObject createCustomerPhone() throws JSONException {
        JSONObject obj = new JSONObject();
        List<Customer> listphone = new ArrayList<Customer>();
        listphone = (List<Customer>) PMF.getObjectList(Customer.class);
        List<String> phones = new ArrayList<String>();
        for (int i = 0; i < listphone.size(); i++) {
            if (!listphone.get(i).getCustomerPhone().equals("")) {
                phones.add(listphone.get(i).getCustomerPhone());
            }
        }
        obj.put("data", phones);
        return obj;
    }

    //
    // KĂ�NH CHĂ�C QUĂ� KHĂ�CH SINH NHáº¬T TRĂ€N NGáº¬P Háº NH PHĂ�C VĂ€ MAY
    // Máº®N!
    /**
     * [Give the description for method].
     * @return JSONObject
     * @throws JSONException JSONException
     */
    @SuppressWarnings("uncheXcked")
    public static JSONObject createListHappyBirth() throws JSONException {
        JSONObject obj = new JSONObject();
        List<Customer> listphone = new ArrayList<Customer>();
        listphone = (List<Customer>) PMF.getObjectList(Customer.class);
        List<String> phones = new ArrayList<String>();
        for (int i = 0; i < listphone.size(); i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String today = formatter.format(Calendar.getInstance().getTime());
            String birthday = formatter.format(listphone.get(i).getCustomerBirth());
            if (!listphone.get(i).getCustomerPhone().equals("") && today.equals(birthday)) {
                phones.add(listphone.get(i).getCustomerPhone());
            }
        }
        obj.put("data", phones);
        return obj;
    }
    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    @SuppressWarnings("unchecked")
    public static List<JSONObject> getActiveCode() throws JSONException {

        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<Provider> listcustomer = (List<Provider>) PMF.getObjectList(Provider.class);
        for (int i = 0; i < listcustomer.size(); i++) {
            if (!listcustomer.get(i).getProviderPhone().equals("") && !listcustomer.get(i).isActive()) {
                JSONObject json = new JSONObject();
                json.put("phone", listcustomer.get(i).getProviderPhone());
                json.put("code", listcustomer.get(i).getActiveCode());
                objList.add(json);
            }
        }
        return objList;
    }

    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    public static List<JSONObject> createEmployeeInfo() throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();

        JSONObject json = new JSONObject();
        JSONObject json1 = new JSONObject();
        // add data
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
