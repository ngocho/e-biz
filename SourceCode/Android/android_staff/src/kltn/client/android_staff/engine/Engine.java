package kltn.client.android_staff.engine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import kltn.client.android_staff.object.Delivery;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author nthanhphong
 */
public class Engine {

    /**
     * [Give the description for method].
     * @param username String
     * @param password String
     * @return Vector<delivery>
     */
    public Vector<Delivery> getDelivery(String username, String password) {
        Vector<Delivery> result = parseJSONGetDelivery(queryURL(urlLogin));
        return result;
    }

    /**
     * [Give the description for method].
     * @param id String
     * @param message String
     * @return String
     */
    public String sendMessageChat(String id, String message) {
        // id bằng username của staff + @ + staff
        String result = "";
        try {
            JSONArray jsonArrayChat = new JSONArray(queryURL(urlChat));
            JSONObject item = jsonArrayChat.getJSONObject(0);
            result = item.getString("chat");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * [Give the description for method].
     * @param json String
     * @return Vector<delivery>
     */
    private Vector<Delivery> parseJSONGetDelivery(String json) {
        Vector<Delivery> dataDelivery = null;
        try {
            JSONArray jsonArrayPhone = new JSONArray(json);
            int i;
            dataDelivery = new Vector<Delivery>();
            for (i = 0; i < jsonArrayPhone.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayPhone.get(i);
                // delivery node=new delivery(item.getString("phone"), item.getString("code"));
                // data_activecode.add(node);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataDelivery;
    }

    /**
     * [Give the description for method].
     * @param username String
     * @param password String
     * @return boolean
     */
    public boolean login(String username, String password) {
        return parseJSONLogin(username, password);
    }

    // login vào hệ thống
    /**
     * [Give the description for method].
     * @param username String
     * @param password String
     * @return boolean
     */
    private boolean parseJSONLogin(String username, String password) {
        boolean jResult = false;
        try {
            JSONArray jsonArraypPhone = new JSONArray(queryURL(urlLogin));
            JSONObject item = jsonArraypPhone.getJSONObject(0);
            if (item.getString("flag").equals("true")) {
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
    private String queryURL(String q) {
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
    /** . */
    private String urlLogin = "http://5.07520349-1.appspot.com/getLogin.vn";
    /** . */
    private String urlChat = "http://5.07520349-1.appspot.com/getLogin.vn";
}
