package kltn.android.server;

import kltn.client.android_server.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * @author NThanhPhong
 */
public class AndroidServerActivity extends Activity {
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
    }
}