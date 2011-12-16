package kltn.client.android_server;

import java.util.Timer;

import kltn.client.android_server.activity.GPSActivity;
import kltn.client.android_server.activity.PromotionActivity;
import kltn.client.android_server.engine.happybirthday_thread;
import kltn.client.android_server.engine.receiveSMSThread;
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
        timer=new Timer();
        //receiveSMSThread task=new receiveSMSThread();
        happybirthday_thread taskHappybirthday=new happybirthday_thread();
        //timer.schedule(task,3000,5000);
       //timer.schedule(taskHappybirthday, 5000,3600000);
    }
    public Timer timer;
}