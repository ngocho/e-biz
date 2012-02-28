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
 * @author nthanhphong
 */
public class SendActiveCodeThread extends TimerTask {

    @SuppressWarnings("static-access")
    @Override
    public void run() {
        if (parseJSONCode(queryURL(queryURLactivecode))) {
            for (int i = 0; i < dataActiveCode.size(); i++) {
                final int pos = i;
                Thread send = new Thread() {

                    @Override
                    public void run() {
                        SendSMS sendsms = new SendSMS();
                        ActivecodeObject item = dataActiveCode.get(pos);
                        sendsms.sendMessage("+841655011503", "Ma chung thuc cua ban la: "+item.getCode());
                        System.out.println("send sms active code to " + item.getPhone());
                        System.gc();
                    }
                };
                send.start();
                try {
                    send.sleep(10000);
                    send.stop();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * [Give the description for method].
     * @param json String
     * @return boolean
     */
    private boolean parseJSONCode(String json) {
        boolean jResult = false;
        try {
            JSONArray jsonArrayPhone = new JSONArray(json);
            int i;
            dataActiveCode = new Vector<ActivecodeObject>();
            for (i = 0; i < jsonArrayPhone.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayPhone.get(i);
                ActivecodeObject node = new ActivecodeObject(item.getString("phone"), item.getString("code"));
                dataActiveCode.add(node);
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
    /** . */
    private Vector<ActivecodeObject> dataActiveCode;
    /** . */
    private String queryURLactivecode = "http://16.test-kltn1.appspot.com/getCodeActive.vn";
}
