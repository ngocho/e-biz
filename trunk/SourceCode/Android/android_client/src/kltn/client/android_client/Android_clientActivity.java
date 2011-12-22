package kltn.client.android_client;

import kltn.android.client.R;
import android.app.Activity;
import android.os.Bundle;

public class Android_clientActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}