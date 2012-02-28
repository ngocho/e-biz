/**
 * Licensed to Open-Ones Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Open-Ones Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package kltn.client.android_server.engine;

import java.util.Random;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author nthanhphong
 */
public class SendPromotionThread extends TimerTask {
    /** . */
    private String[] phones;
    /** . */
    private String[] message;
    /** . */
    private Engine mEngine;
    /** . */
    private String url = "http://16.test-kltn1.appspot.com/getFoodPromotion.vn";
    /**
     * [Give the description for method].
     * @param json String
     * @return String
     */
    private boolean parseJSONPromotion(String json) {
        boolean jResult = false;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonphones = jsonObject.getJSONObject("phone");
            JSONArray jsonArrayphone = jsonphones.getJSONArray("data");
            phones = new String[jsonArrayphone.length()];
            int i;
            for (i = 0; i < phones.length; i++) {
                phones[i] = jsonArrayphone.getString(i);
            }
            JSONObject jsonmesage = jsonObject.getJSONObject("promotion");
            JSONArray jsonArraymesage = jsonmesage.getJSONArray("data");
            message = new String[jsonArraymesage.length()];
            for (i = 0; i < message.length; i++) {
                JSONObject item = (JSONObject) jsonArraymesage.get(i);
                message[i] = "Khuyen mai lon: " + item.getString("id") + "-" + item.getString("name")
                        + ", gia chi con " + item.getString("promotionprice") + "vnđ. Foodshop.com";
            }
            jResult = true;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jResult;
    }

    /**
     * [Explain the description for this method here].
     * @see java.util.TimerTask#run()
     */
    @SuppressWarnings("static-access")
    @Override
    public void run() {
        mEngine = new Engine();
        final SendSMS sendsms = new SendSMS();
        if (parseJSONPromotion(mEngine.queryURL(url))) {
            for (int i = 0; i < phones.length; i++) {
                final int pos = i;
                Thread send = new Thread() {

                    @Override
                    public void run() {
                        Random random = new Random();
                        int intmessage = random.nextInt(message.length);
                        try {
                            sendsms.sendMessage("+841655011503", message[intmessage]);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("send" + message[intmessage]);
                    }
                };
                send.start();
                try {
                    send.sleep(10000);
                    send.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
