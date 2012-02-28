package kltn.client.android_server;

import java.util.Timer;

import kltn.client.android_server.activity.GPSActivity;
import kltn.client.android_server.engine.HappybirthdayThread;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author NThanhPhong
 *
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
        Intent i = new Intent(this, GPSActivity.class);
        startActivity(i);
        timer = new Timer();
        // receiveSMSThread task=new receiveSMSThread();
        HappybirthdayThread taskHappybirthday = new HappybirthdayThread();
        // timer.schedule(task,3000,5000);
        // timer.schedule(taskHappybirthday, 5000,3600000);
    }
    /**  . */
    public Timer timer;
}