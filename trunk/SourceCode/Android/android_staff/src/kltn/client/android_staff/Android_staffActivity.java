package kltn.client.android_staff;

import kltn.client.android_staff.activity.chatActivity;
import kltn.client.android_staff.activity.delivery_Activity;
import kltn.client.android_staff.activity.loginActivity;
import kltn.client.android_staff.activity.mapActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Android_staffActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        finish();
        Intent i=new Intent(this,delivery_Activity.class);
        startActivity(i);
    }
}