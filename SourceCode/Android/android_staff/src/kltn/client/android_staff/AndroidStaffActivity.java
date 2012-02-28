package kltn.client.android_staff;

import kltn.client.android_staff.activity.delivery_Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author NThanhPhong
 *
 */
public class AndroidStaffActivity extends Activity {
    /** Called when the activity is first created. */
    /**
     * [Explain the description for this method here].
     * @param savedInstanceState Bundle
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        finish();
        Intent i = new Intent(this, delivery_Activity.class);
        startActivity(i);
    }
}