package kltn.client.android_server.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * @author nthanhphong
 */
public class SmsReceiver extends BroadcastReceiver {

    /*
     * (non-Javadoc)
     * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        if (bundle != null) {
            // ---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                str += "SMS from " + msgs[i].getOriginatingAddress();
                str += " :";
                str += msgs[i].getMessageBody().toString();
                str += "\n";
            }

            // ---display the new SMS message---
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            paserSMS(msgs);
        }
    }
    /**
     * [Give the description for method].
     * @param sms SmsMessage[]
     */
    public void paserSMS(SmsMessage[] sms) {
        for (int i = 0; i < sms.length; i++) {
            if (typeSMS(sms[i].getMessageBody()) == 1) {
                funtionXu(sms[i].getOriginatingAddress(), sms[i].getMessageBody());
            } else if (typeSMS(sms[i].getMessageBody()) == 2) {
                funtionNap(sms[i].getOriginatingAddress(), sms[i].getMessageBody());
            } else if (typeSMS(sms[i].getMessageBody()) == 3) {
                funtionBuyByPhone(sms[i].getOriginatingAddress(), sms[i].getMessageBody());
            } else if (typeSMS(sms[i].getMessageBody()) == 4) {
                funtionBuyByUsername(sms[i].getOriginatingAddress(), sms[i].getMessageBody());
            } else if (typeSMS(sms[i].getMessageBody()) == 5) {
                funtionNapByPhone(sms[i].getOriginatingAddress(), sms[i].getMessageBody());
            }
        }
    }
    // nạp tiền vào số điện thoại(số điện thoại là username)
    // cú pháp là <scn menhgia>
    /**
     * [Give the description for method].
     * @param phone String
     * @param bodymessage String
     * @return boolean
     */
    public boolean funtionNapByPhone(String phone, String bodymessage) {
        boolean result = false;
        SendSMS sendsms = new SendSMS();
        String menhgia = "";
        String[] splitResult = bodymessage.split(" ");
        menhgia = splitResult[1];
        ArrayList<String> listmenhgia = new ArrayList<String>();
        listmenhgia.add("10");
        listmenhgia.add("20");
        listmenhgia.add("50");
        listmenhgia.add("100");
        if (listmenhgia.contains(menhgia)) {
            sendsms.sendMessage(phone, "So dien thoai " + phone + " duoc nap " + menhgia
                    + ".000đ! Soan <sta mahang> gui 0122 de mua hang.");
        } else {
            // sendsms.sendMessage(phone, xu_false);
        }
        return result;
    }

    // mua hàng qua user người dùng
    // cú pháp nhắn tin là <stb mahang username password>
    /**
     * [Give the description for method].
     * @param phone String
     * @param bodymessage String
     * @return boolean
     */
    public boolean funtionBuyByUsername(String phone, String bodymessage) {
        boolean result = false;
        SendSMS sendsms = new SendSMS();
        String mahang = "", username = "", password = "";
        String[] splitResult = bodymessage.split(" ");
        mahang = splitResult[1];
        username = splitResult[2];
        password = splitResult[3];
        // if(true){
        sendsms.sendMessage(phone, "Voucher cua ban la: " + mahang + username + password);
        // }else{
        // sendsms.sendMessage(phone, xu_false);
        // }
        return result;
    }
    // mua hàng thông qua số điện thoại di động(số điện thoại là username)
    // cú pháp nhắn tin là <scb mahang>
    /**
     * [Give the description for method].
     * @param phone String
     * @param bodymessage String
     * @return boolean
     */
    public boolean funtionBuyByPhone(String phone, String bodymessage) {
        boolean result = false;
        SendSMS sendsms = new SendSMS();
        String[] splitResult = bodymessage.split(" ");
        String mahang = "";
        mahang = splitResult[1];
        // if(){
        sendsms.sendMessage(phone, "Voucher cua ban la " + mahang);
        // }else{
        // sendsms.sendMessage(phone, xu_false);
        // }
        return result;
    }
    // nạp xu qua tổng đài, sẽ bị trừ tiền
    // cú pháp <sca username menhgia>(menhgia 10,20,50)
    /**
     * [Give the description for method].
     * @param phone String
     * @param bodymessage String
     * @return boolean
     */
    public boolean funtionNap(String phone, String bodymessage) {
        boolean result = false;
        SendSMS sendsms = new SendSMS();
        String menhgia = "";
        String username = "";
        String[] splitResult = bodymessage.split(" ");
        menhgia = splitResult[2];
        username = splitResult[1];
        ArrayList<String> listmenhgia = new ArrayList<String>();
        listmenhgia.add("10");
        listmenhgia.add("20");
        listmenhgia.add("50");
        listmenhgia.add("100");
        if (listmenhgia.contains(menhgia)) {
            sendsms.sendMessage(phone, "Tai khoan " + username + " cua ban duoc nap " + menhgia + ".000đ!");
            queryURL(server + "getActiveXU.vn?flag=sca&content=" + username + "@" + menhgia);
        } else {
            // sendsms.sendMessage(phone, xu_false);
        }
        return result;
    }
    // nạp xu qua productkey
    // cú pháp tin nhắn <stp username productkey >
    /**
     * [Give the description for method].
     * @param phone String
     * @param bodymessage String
     * @return boolean
     */
    public boolean funtionXu(String phone, String bodymessage) {
        boolean result = false;
        SendSMS sendsms = new SendSMS();
        String productKey = "";
        String username = "";
        String[] splitResult = bodymessage.split(" ");
        productKey = splitResult[2];
        username = splitResult[1];
        if (productKey.length() == 15) {
            // sendsms.sendMessage(phone, "Tai khoan " + username+" cua ban duoc nap 50.000VND!");
            try {
                JSONObject item = new JSONObject(queryURL(server + "getActiveXU.vn?flag=stp&content=" + username + "@"
                        + productKey));
                if (item.getString("flag").equals("false")) {
                    sendsms.sendMessage(phone, "The nap da duoc su dung. Vui long nhap the nap khac!");
                } else {
                    sendsms.sendMessage(phone, "Nap Xu thanh cong! Tai khoan cua ban la " + item.getString("flag")
                            + " Xu");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            sendsms.sendMessage(phone, xuFalse);
        }
        return result;
    }
    /**
     * [Give the description for method].
     * @param bodySMS String
     * @return int
     */
    public int typeSMS(String bodySMS) {
        int result = 0;
        // 0 - tin nhan sai cu phap;
        // 1 - nạp xu qua productkey với username tương ứng
        // 2 - nạp xu bằng cách nhắn tin đến tổng đài với username tương ứng
        // 3 - nạp
        int pos;
        for (pos = 0; pos < bodySMS.length(); pos++) {
            if (bodySMS.charAt(pos) == ' ') {
                break;
            }
        }
        String item = bodySMS.substring(0, pos);
        if (item.toLowerCase().equals("stp")) {
            result = 1;
        } else if (item.toLowerCase().equals("sca")) {
            result = 2;
        } else if (item.toLowerCase().equals("scb")) {
            result = 3;
        } else if (item.toLowerCase().equals("stb")) {
            result = 4;
        } else if (item.toLowerCase().equals("scn")) {
            result = 5;
        }
        return result;
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

    // product ke XU gom 15 chu so
    // private String xu_true="Tài khoản của bạn được nạp 50XU !";
    /**  . */
    private String xuFalse = "Mã nạp XU này không có thực, xin nhập lại!";
    /**  . */
    private String server = "http://16.test-kltn1.appspot.com/";
}
