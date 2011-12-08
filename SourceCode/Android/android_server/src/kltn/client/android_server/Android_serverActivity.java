package kltn.client.android_server;

import kltn.client.android_server.activity.GPSActivity;
import kltn.client.android_server.activity.PromotionActivity;
import kltn.client.android_server.object.promotion;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Android_serverActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent i=new Intent(this,GPSActivity.class);
        startActivity(i);
    }
}