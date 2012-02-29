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

import kltn.client.android_client.App;
import android.R;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * @author NThanhPhong
 */
public class SettingActivity extends PreferenceActivity {

    /**
     * [Explain the description for this method here].
     * @param savedInstanceState
     * @see android.preference.PreferenceActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //addPreferencesFromResource(R.xml.preferences);
    }
    private Preference mVolume;
    private Preference mVolumeReminder;
    private Preference mReminder;
    private Preference mLinkServer;
    private Preference mFavorite;
    private Preference mSave;
    public App getApp() {
        return (App) getApplication();
    }
}
