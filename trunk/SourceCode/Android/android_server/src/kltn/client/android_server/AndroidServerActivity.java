package kltn.client.android_server;

import java.util.Timer;

import kltn.client.android_server.activity.GPSActivity;
import kltn.client.android_server.engine.HappyBirthdayThread;
import kltn.client.android_server.engine.SendActiveCodeThread;
import kltn.client.android_server.engine.SendPromotionThread;
import kltn.client.android_server.engine.SendStnThread;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TimingLogger;

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
        timer = new Timer();
//        SendPromotionThread promotionTask = new SendPromotionThread();
//        timer.schedule(promotionTask, 5000, 3600000);
//        SendActiveCodeThread activecodeTask=new SendActiveCodeThread();
//        timer.schedule(activecodeTask, 5000,3000000);
        SendStnThread stnTask=new SendStnThread();
        timer.schedule(stnTask, 5000,3000000);
        Intent i = new Intent(this, GPSActivity.class);
        startActivity(i);
        // receiveSMSThread task=new receiveSMSThread();
//         HappyBirthdayThread taskHappybirthday = new HappyBirthdayThread();
//         timer.schedule(taskHappybirthday,3000,5000000);
         //timer.schedule(taskHappybirthday, 5000,3600000);
    }
    /** . */
    private Timer timer;
}