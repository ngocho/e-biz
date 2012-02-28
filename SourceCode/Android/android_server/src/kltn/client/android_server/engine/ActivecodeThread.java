package kltn.client.android_server.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.TimerTask;
import java.util.Vector;

import kltn.client.android_server.object.ActivecodeObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author NThanhPhong
 */
public class ActivecodeThread extends TimerTask {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        parseJSONActivecode(queryURL(queryURLActivecode));
        for (int i = 0; i < dataActivecode.size(); i++) {
            final int pos = i;
            Thread send = new Thread() {

                @Override
                public void run() {
                    SendSMS sendsms = new SendSMS();
                    ActivecodeObject item = dataActivecode.get(pos);
                    // sendsms.sendMessage("+841265204953", item.message);
                    System.out.println("send sms activecode " + item.getCode() + " to " + item.getPhone());
                    System.gc();
                }
            };
            send.start();
            try {
                send.sleep(20000);
                send.stop();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    /**
     * [Give the description for method].
     * @param json String
     * @return boolean
     */
    private boolean parseJSONActivecode(String json) {
        boolean jResult = false;
        try {
            JSONArray jsonArrayphone = new JSONArray(json);
            int i;
            dataActivecode = new Vector<ActivecodeObject>();
            for (i = 0; i < jsonArrayphone.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayphone.get(i);
                ActivecodeObject node = new ActivecodeObject(item.getString("phone"), item.getString("code"));
                dataActivecode.add(node);
            }
            jResult = true;

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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return qResult;
    }
    /**  . */
    private Vector<ActivecodeObject> dataActivecode;
    /**  . */
    private String queryURLActivecode = "http://5.07520349-1.appspot.com/getHappyBirthday.vn";
}
