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
package kltn.client.android_client.activity;

import kltn.client.android_client.PrefUtil;
import kltn.client.android_client.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author NThanhPhong
 */
public class SettingAppActivity extends Activity implements OnClickListener{

    /**
     * [Explain the description for this method here].
     * @param savedInstanceState
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingactivity);
        mServer = (EditText) findViewById(R.id.setting_link);
        mOk = (Button) findViewById(R.id.setting_ok);
        mBack = (Button) findViewById(R.id.setting_back);
        mOk.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mServer.setText(PrefUtil.getStringPref(this, "linkserver"));
    }
    private EditText mServer;
    private Button mOk, mBack;
    /**
     * [Explain the description for this method here].
     * @param v
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_ok :
                PrefUtil.setPref(SettingAppActivity.this, "linkserver", mServer.getText().toString());
                finish();
                break;
            case R.id.setting_back:
                finish();
                break;
            default :
                break;
        }
    }
}
