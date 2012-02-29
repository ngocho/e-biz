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
        Intent i = new Intent(this, GPSActivity.class);
        startActivity(i);
        timer1 = new Timer();
        timer2 = new Timer();
        timer3 = new Timer();
        timer4 = new Timer();
        SendPromotionThread promotionTask = new SendPromotionThread();
        timer4.schedule(promotionTask, 5000, 360000);
        SendActiveCodeThread activecodeTask = new SendActiveCodeThread();
        timer1.schedule(activecodeTask, 5000, 360000);
        SendStnThread stnTask = new SendStnThread();
        timer2.schedule(stnTask, 5000, 360000);
        HappyBirthdayThread taskHappybirthday = new HappyBirthdayThread();
        timer3.schedule(taskHappybirthday, 3000, 500000);
    }
    /** . */
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    private Timer timer4;
}