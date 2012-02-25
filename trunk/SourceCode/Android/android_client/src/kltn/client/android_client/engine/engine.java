/**
 * 
 */
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
    private String URL_Login = "http://16.test-kltn1.appspot.com/getUserFuntion.vn";
    private String URL_CUSTOMER_FUNTION = "http://16.test-kltn1.appspot.com/getUserFuntion.vn";
    private String URL_Get_Date_Food;
    private String URL_get_Best_Food = "http://16.test-kltn1.appspot.com/getBestList.vn";
    public String URL_Image = "http://16.test-kltn1.appspot.com/serveImage.vn?urlKey=";

    // getBrowserList

    public Vector<Browser_food_item> GetBrowserFood(Context mContext) {
        Vector<Browser_food_item> result = new Vector<Browser_food_item>();
        try {
            JSONArray JsonArray_Browser = new JSONArray(Query_URL(PrefUtil.GetStringPref(mContext, "linkserver")
                    + "getBrowserList.vn"));
            int i;
            for (i = 0; i < JsonArray_Browser.length(); i++) {
                JSONObject item = (JSONObject) JsonArray_Browser.get(i);
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
    public Vector<best_food_item> get_best_food() {
        Vector<best_food_item> result = new Vector<best_food_item>();
        try {
            JSONArray JsonArray_phone = new JSONArray(Query_URL(URL_get_Best_Food));
            int i;
            for (i = 0; i < JsonArray_phone.length(); i++) {
                JSONObject item = (JSONObject) JsonArray_phone.get(i);
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
    public Vector<date_food_item> get_date_food() {
        Vector<date_food_item> result = new Vector<date_food_item>();
        try {
            JSONArray JsonArray_phone = new JSONArray(Query_URL(URL_Get_Date_Food));
            int i;
            for (i = 0; i < JsonArray_phone.length(); i++) {
                JSONObject item = (JSONObject) JsonArray_phone.get(i);
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

    public String GetXu(String username, String password) {
        String result = "0";
        try {
            JSONObject item = new JSONObject(
                    Query_URL("http://16.test-kltn1.appspot.com/getUserFuntion.vn?flag=GetXu&content=" + username + "@"
                            + password));
            return item.getString("flag");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public JSONObject GetInfo(String username, String password) {
        try {
            JSONObject item = new JSONObject(
                    Query_URL("http://16.test-kltn1.appspot.com/getUserFuntion.vn?flag=Info&content=" + username + "@"
                            + password));
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public JSONObject GetFood(String idfood) {
        try {
            JSONObject item = new JSONObject(
                    Query_URL("http://16.test-kltn1.appspot.com/getFoodId.vn?idfood=" + idfood));
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // đăng ký tài khoản ngư�?i dùng
    public boolean register(String username, String password, String fullname, String sex, String email, String phone,
            String address, String birthday) {
        boolean result = false;
        try {
            JSONObject item = new JSONObject(Query_URL(URL_CUSTOMER_FUNTION + "?flag=register&content=" + username
                    + "@" + password + "@" + fullname + "@" + phone + "@" + email + "@" + birthday + "@" + sex + "@"
                    + address));
            if (item.getInt("flag") == 1)
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // login vào hệ thống
    public boolean login(String username, String password) {
        return ParseJSON_login(username, password);
    }
    public boolean ChangePass(String username, String oldpassword, String newpassword) {
        boolean jResult = false;
        try {
            JSONObject item = new JSONObject(Query_URL(URL_CUSTOMER_FUNTION + "?flag=changepass&content=" + username
                    + "@" + oldpassword + "@" + newpassword));
            if (item.getString("flag").equals("1"))
                jResult = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jResult;
    }

    private boolean ParseJSON_login(String username, String password) {
        boolean jResult = false;
        try {
            JSONObject item = new JSONObject(Query_URL(URL_Login + "?flag=login&content=" + username + "@" + password));
            if (item.getString("flag").equals("1"))
                jResult = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jResult;
    }

    // query 1 url từ server
    public String Query_URL(String q) {
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
