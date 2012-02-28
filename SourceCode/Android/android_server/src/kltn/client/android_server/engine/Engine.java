package kltn.client.android_server.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
     * @param produckey String
     * @param username String
     * @return boolean
     */
    private boolean parseJSONxu(String produckey, String username) {
        boolean jResult = false;
        try {
            JSONArray jsonArrayphone = new JSONArray(queryURL(urlXU));
            JSONObject item = jsonArrayphone.getJSONObject(0);
            if (item.getString("flag").equals("true")) {
                jResult = true;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jResult;
    }
    /**
     * [Give the description for method].
     * @param q String
     * @return String
     */
    public String queryURL(String q) {
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return qResult;
    }
    /** . */
    private String urlXU = "http://5.07520349-1.appspot.com/getActiveXU.vn";
}
