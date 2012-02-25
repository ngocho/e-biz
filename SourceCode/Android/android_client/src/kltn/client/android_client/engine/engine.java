package kltn.client.android_client.engine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import kltn.client.android_client.PrefUtil;
import kltn.client.android_client.model.Browser_food_item;
import kltn.client.android_client.model.best_food_item;
import kltn.client.android_client.model.date_food_item;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

/**
 * @author NThanhPhong
 */
public class Engine {
    /** . */
    private String mURLLogin = "http://16.test-kltn1.appspot.com/getUserFuntion.vn";
    /** . */
    private String mURLCUSTOMERFUNTION = "http://16.test-kltn1.appspot.com/getUserFuntion.vn";
    /** . */
    private String mURLGetDateFood;
    /** . */
    private String mURLGetBestFood = "http://16.test-kltn1.appspot.com/getBestList.vn";
    /** . */
    public String mURLImage = "http://16.test-kltn1.appspot.com/serveImage.vn?urlKey=";

    // getBrowserList

    /**
     * [Give the description for method].
     * @param mContext Context
     * @return Vector<Browser_food_item>
     */
    public Vector<Browser_food_item> getBrowserFood(Context mContext) {
        Vector<Browser_food_item> result = new Vector<Browser_food_item>();
        try {
            JSONArray jsonArrayBrowser = new JSONArray(mQueryURL(PrefUtil.GetStringPref(mContext, "linkserver")
                    + "getBrowserList.vn"));
            int i;
            for (i = 0; i < jsonArrayBrowser.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayBrowser.get(i);
                Browser_food_item node = new Browser_food_item(item.getString("id"), item.getString("name"),
                        item.getString("detail"), item.getString("price"), item.getString("promotionPrice"),
                        item.getString("url"), item.getString("dateUpload"), item.getString("dateUpload"),
                        item.getInt("sale"), item.getInt("sale"), item.getInt("sale"), item.getInt("sale"),
                        item.getString("type"), item.getString("provider"));
                result.add(node);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    // lay danh sách sản phẩm theo khoảng cách gần nhất
    // lấy danh sách sản phẩm theo bestfood
    /**
     * [Give the description for method].
     * @return Vector<best_food_item>
     */
    public Vector<best_food_item> getBestFood() {
        Vector<best_food_item> result = new Vector<best_food_item>();
        try {
            JSONArray jsonArrayphone = new JSONArray(mQueryURL(mURLGetBestFood));
            int i;
            for (i = 0; i < jsonArrayphone.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayphone.get(i);
                best_food_item node = new best_food_item(item.getString("id"), item.getString("name"),
                        item.getString("detail"), item.getString("price"), item.getString("promotionPrice"),
                        item.getString("url"), item.getString("dateUpload"), item.getString("dateUpload"),
                        item.getInt("sale"), item.getInt("sale"), item.getInt("sale"), item.getInt("sale"));
                result.add(node);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    // lấy danh sách sản phẩm theo th�?i gian
    /**
     * [get_date_food].
     * @return Vector<date_food_item>
     */
    public Vector<date_food_item> getDateFood() {
        Vector<date_food_item> result = new Vector<date_food_item>();
        try {
            JSONArray jsonArrayPhone = new JSONArray(mQueryURL(mURLGetDateFood));
            int i;
            for (i = 0; i < jsonArrayPhone.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayPhone.get(i);
                date_food_item node = new date_food_item(item.getString("id"), item.getString("name"),
                        item.getString("price"), item.getString("buyprice"), item.getString("imageurl"),
                        item.getString("startdate"), item.getString("enddate"), item.getInt("buycount"),
                        item.getInt("countmin"), item.getInt("countmax"));
                result.add(node);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * [GetXu].
     * @param username String
     * @param password String
     * @return String
     */
    public String mGetXu(String username, String password) {
        String result = "0";
        try {
            JSONObject item = new JSONObject(
                    mQueryURL("http://16.test-kltn1.appspot.com/getUserFuntion.vn?flag=GetXu&content=" + username + "@"
                            + password));
            return item.getString("flag");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * [GetInfo].
     * @param username String
     * @param password String
     * @return JSONObject
     */
    public JSONObject mGetInfo(String username, String password) {
        try {
            JSONObject item = new JSONObject(
                    mQueryURL("http://16.test-kltn1.appspot.com/getUserFuntion.vn?flag=Info&content=" + username + "@"
                            + password));
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * [GetFood].
     * @param idfood String
     * @return JSONObject
     */
    public JSONObject mGetFood(String idfood) {
        try {
            JSONObject item = new JSONObject(
                    mQueryURL("http://16.test-kltn1.appspot.com/getFoodId.vn?idfood=" + idfood));
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // đăng ký tài khoản ngư�?i dùng
    /**
     * [register].
     * @param username String
     * @param password String
     * @param fullname String
     * @param sex String
     * @param email String
     * @param phone String
     * @param address String
     * @param birthday String
     * @return boolean
     */
    public boolean mRegister(String username, String password, String fullname, String sex, String email, String phone,
            String address, String birthday) {
        boolean result = false;
        try {
            JSONObject item = new JSONObject(mQueryURL(mURLCUSTOMERFUNTION + "?flag=register&content=" + username + "@"
                    + password + "@" + fullname + "@" + phone + "@" + email + "@" + birthday + "@" + sex + "@"
                    + address));
            if (item.getInt("flag") == 1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // login vào hệ thống
    /**
     * [login].
     * @param username String
     * @param password String
     * @return boolean
     */
    public boolean login(String username, String password) {
        return mParseJSONLogin(username, password);
    }
    /**
     * [ChangePass].
     * @param username String
     * @param oldpassword String
     * @param newpassword String
     * @return boolean
     */
    public boolean mChangePass(String username, String oldpassword, String newpassword) {
        boolean jResult = false;
        try {
            JSONObject item = new JSONObject(mQueryURL(mURLCUSTOMERFUNTION + "?flag=changepass&content=" + username
                    + "@" + oldpassword + "@" + newpassword));
            if (item.getString("flag").equals("1")) {
                jResult = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jResult;
    }

    /**
     * [ParseJSON_login].
     * @param username String
     * @param password String
     * @return boolean
     */
    private boolean mParseJSONLogin(String username, String password) {
        boolean jResult = false;
        try {
            JSONObject item = new JSONObject(mQueryURL(mURLLogin + "?flag=login&content=" + username + "@" + password));
            if (item.getString("flag").equals("1")) {
                jResult = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jResult;
    }

    // query 1 url từ server
    /**
     * [Give the description for method].
     * @param q String
     * @return String
     */
    public String mQueryURL(String q) {
        String qResult = null;
        String qString = q;
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(qString);
        try {
            HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();
            if (httpEntity != null) {
                InputStream inputStream = httpEntity.getContent();
                Reader in = new InputStreamReader(inputStream);
                BufferedReader bufferedreader = new BufferedReader(in);
                StringBuilder stringBuilder = new StringBuilder();
                String stringReadLine = null;
                while ((stringReadLine = bufferedreader.readLine()) != null) {
                    stringBuilder.append(stringReadLine + "\n");
                }
                qResult = stringBuilder.toString();
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return qResult;
    }
    /**
     * [Give the description for method].
     * @param in String
     * @param count int
     * @return String
     */
    public String fillString(String in, int count) {
        String result = "";
        if (in.length() > count) {
            result = in.substring(0, count);
            result += "...";
        } else {
            result = in;
        }
        return result;
    }

}
