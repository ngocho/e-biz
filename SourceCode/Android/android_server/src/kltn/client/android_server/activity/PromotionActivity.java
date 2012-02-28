package kltn.client.android_server.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import kltn.client.android_server.R;
import kltn.client.android_server.object.HappybirthdayObject;
import kltn.client.android_server.object.Promotion;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author nthanhphong
 */
public class PromotionActivity extends Activity {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_promotion);
        tvwPromotionContent = (TextView) findViewById(R.id.promotion_content);
        btnpromotionrestart = (Button) findViewById(R.id.promotion_restart);
        btnpromotionstart = (Button) findViewById(R.id.promotion_start);
        btnpromotionstart.setOnClickListener(startaction);
    }
    /**
     * [Give the description for method].
     * @param phoneNumber String
     * @param message String
     */
    private void sendSMS(String phoneNumber, String message) {
        String sent = "SMS_SENT";
        String delivered = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(sent), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(delivered), 0);

        // ---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver() {

            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK :
                        Toast.makeText(getBaseContext(), getString(R.string.sms_send), Toast.LENGTH_SHORT).show();
                        // findViewById(R.id.b_send_sms).setEnabled(true);
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE :
                        Toast.makeText(getBaseContext(), getString(R.string.generic_failure), Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE :
                        Toast.makeText(getBaseContext(), getString(R.string.no_service), Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU :
                        Toast.makeText(getBaseContext(), getString(R.string.null_pdu), Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF :
                        Toast.makeText(getBaseContext(), getString(R.string.radio_off), Toast.LENGTH_SHORT).show();
                        break;
                    default :
                        break;
                }
            }
        }, new IntentFilter(sent));

        // ---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK :
                        Toast.makeText(getBaseContext(), getString(R.string.sms_delivered), Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED :
                        Toast.makeText(getBaseContext(), getString(R.string.sms_not_delivered), Toast.LENGTH_SHORT)
                                .show();
                        break;
                    default :
                        break;
                }
            }
        }, new IntentFilter(delivered));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }
    /** . */
    private OnClickListener startaction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub;
            tvwPromotionContent.setText(parseJSONPromotion(queryURL(queryURL)));
            parseJSONbirthday(queryURL(queryURLHappybirthday));
            // ImageView de=(ImageView)findViewById(R.id.image_promotion);
            // de.setImageBitmap(ghepImages(((BitmapDrawable)de.getDrawable()).getBitmap(),5,4));
        }
    };
    /**
     * [Give the description for method].
     * @param c Bitmap
     * @param m int
     * @param n int
     * @return Bitmap
     */
    private Bitmap ghepImages(Bitmap c, int m, int n) { // can add a 3rd parameter 'String loc' if you want to save the
                                                        // new image - left some code to do that at the bottom
        Bitmap cs = null;
        int size = 72;
        int width, height = 0;
        width = m * size;
        height = n * size;
        cs = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas comboImage = new Canvas(cs);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                comboImage.drawBitmap(c, size * i, size * j, null);
            }
        }
        return cs;
    }
    /**
     * [Give the description for method].
     * @param c Bitmap
     * @param s Bitmap
     * @return Bitmap
     */
    private Bitmap combineImages(Bitmap c, Bitmap s) { // can add a 3rd parameter 'String loc' if you want to save the
                                                       // new image - left some code to do that at the bottom
        Bitmap cs = null;

        int width, height = 0;

        if (c.getWidth() > s.getWidth()) {
            width = c.getWidth();
            height = c.getHeight() + s.getHeight();
        } else {
            width = s.getWidth();
            height = c.getHeight() + s.getHeight();
        }

        cs = Bitmap.createBitmap(width + width, height, Bitmap.Config.ARGB_8888);

        Canvas comboImage = new Canvas(cs);

        comboImage.drawBitmap(c, 0f, 0f, null);
        comboImage.drawBitmap(s, c.getWidth(), c.getHeight() - 20, null);

        // this is an extra bit I added, just incase you want to save the new image somewhere and then return the
        // location
        /*
         * String tmpImg = String.valueOf(System.currentTimeMillis()) + ".png"; OutputStream os = null; try { os = new
         * FileOutputStream(loc + tmpImg); cs.compress(CompressFormat.PNG, 100, os); } catch(IOException e) {
         * Log.e("combineImages", "problem combining images", e); }
         */

        return cs;
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

    /**
     * [Give the description for method].
     * @param json String
     * @return String
     */
    /**
     * [Give the description for method].
     * @param json String
     * @return String
     */
    private String parseJSONPromotion(String json) {
        String jResult = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonphones = jsonObject.getJSONObject("phone");
            JSONArray jsonArrayphone = jsonphones.getJSONArray("data");
            String[] phones = new String[jsonArrayphone.length()];
            int i;
            for (i = 0; i < phones.length; i++) {
                phones[i] = jsonArrayphone.getString(i);
            }
            JSONObject jsonmesage = jsonObject.getJSONObject("promotion");
            JSONArray jsonArraymesage = jsonmesage.getJSONArray("data");
            String[] message = new String[jsonArraymesage.length()];
            for (i = 0; i < message.length; i++) {
                JSONObject item = (JSONObject) jsonArraymesage.get(i);
                message[i] = item.getString("id") + item.getString("name");
            }
            jResult = jsonArrayphone.getString(0);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jResult;
    }
    /**
     * [Give the description for method].
     * @param json String
     * @return String
     */
    private String parseJSONbirthday(String json) {
        String jResult = null;
        try {
            JSONArray jsonArrayphone = new JSONArray(json);
            int i;
            dataBirthday = new Vector<HappybirthdayObject>();
            for (i = 0; i < jsonArrayphone.length(); i++) {
                JSONObject item = (JSONObject) jsonArrayphone.get(i);
                HappybirthdayObject node = new HappybirthdayObject(item.getString("phone"), item.getString("name"));
                dataBirthday.add(node);
            }
            jResult = jsonArrayphone.getString(0);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jResult;
    }
    /**  . */
    private Promotion dataPromotion;
    /**  . */
    private Vector<HappybirthdayObject> dataBirthday;
    /**  . */
    private String queryURL = "http://5.07520349-1.appspot.com/getPromotion.vn";
    /**  . */
    private String queryURLHappybirthday = "http://5.07520349-1.appspot.com/getHappyBirthday.vn";
    /**  . */
    private TextView tvwPromotionContent;
    /**  . */
    private Button btnpromotionstart;
    /**  . */
    private Button btnpromotionrestart;
}
