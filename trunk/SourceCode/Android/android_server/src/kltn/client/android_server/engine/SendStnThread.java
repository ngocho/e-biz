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
import java.util.Vector;

import kltn.client.android_server.object.HappybirthdayObject;
import kltn.client.android_server.until.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author nthanhphong
 */
public class SendStnThread extends TimerTask {

    /**
     * [Explain the description for this method here].
     * @see java.util.TimerTask#run()
     */
    @SuppressWarnings("static-access")
    @Override
    public void run() {
        Engine mEngine = new Engine();
        parseJSONStn(mEngine.queryURL(url));
        for (int i = 0; i < phones.length; i++) {
            final int pos = i;
            Thread send = new Thread() {

                @Override
                public void run() {
                    SendSMS sendsms = new SendSMS();
                    Random random = new Random();
                    int len = random.nextInt(Util.CODE1.length);
                    try {
                        sendsms.sendMessage("+841655011503", Util.CODE1[len]);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("send sms stn to " + phones[pos]);
                    System.gc();
                }
            };
            send.start();
            try {
                send.sleep(Util.SLEEP);
                send.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * [Give the description for method].
     * @param json String
     * @return boolean
     */
    private boolean parseJSONStn(String json) {
        boolean jResult = false;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonphones = jsonObject.getJSONObject("phone");
            JSONArray jsonArrayphone = jsonphones.getJSONArray("data");
            phones = new String[jsonArrayphone.length()];
            for (int i = 0; i < phones.length; i++) {
                phones[i] = jsonArrayphone.getString(i);
            }
            jResult = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jResult;
    }
    /** . */
    private String[] phones;
    /** . */
    private String url = "http://16.test-kltn1.appspot.com/getFoodPromotion.vn";
}
