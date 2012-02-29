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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author NThanhPhong
 */
public class AndroidServerActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    /**
     * [Explain the description for this method here].
     * @param savedInstanceState Bundle
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        Intent i = new Intent(this, GPSActivity.class);
        startActivity(i);
        timer1 = new Timer();
        timer2 = new Timer();
        timer3 = new Timer();
        timer4 = new Timer();
        SendPromotionThread promotionTask = new SendPromotionThread();
        timer4.schedule(promotionTask, START, RELOAD);
        SendActiveCodeThread activecodeTask = new SendActiveCodeThread();
        timer1.schedule(activecodeTask, START, RELOAD);
        SendStnThread stnTask = new SendStnThread();
        timer2.schedule(stnTask, START, RELOAD);
        HappyBirthdayThread taskHappybirthday = new HappyBirthdayThread();
        timer3.schedule(taskHappybirthday, START, RELOAD);
        mUpdate = (Button) findViewById(R.id.setting_update);
        mStart = (Button) findViewById(R.id.setting_start);
        mStop = (Button) findViewById(R.id.setting_stop);
        mAds = (EditText) findViewById(R.id.setting_ads);
        mActivecode = (EditText) findViewById(R.id.setting_activecode);
        mStp = (EditText) findViewById(R.id.setting_napxu);
    }
    /** . */
    private Timer timer1;
    /** . */
    private Timer timer2;
    /** . */
    private Timer timer3;
    /** . */
    private Timer timer4;
    /** . */
    private Button mUpdate, mStart, mStop;
    /** . */
    private EditText mAds, mActivecode, mStp;
    /** . */
    private static final long START = 5000;
    /** . */
    private static final long RELOAD = 3600000;
    /**
     * [Explain the description for this method here].
     * @param v
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        
    }
}