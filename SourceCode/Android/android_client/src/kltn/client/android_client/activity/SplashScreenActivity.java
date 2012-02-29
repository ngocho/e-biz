package kltn.client.android_client.activity;

import java.lang.Thread.UncaughtExceptionHandler;

import kltn.client.android_client.App;
import kltn.client.android_client.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;

/**
 * @author NThanhPhong
 */
public class SplashScreenActivity extends Activity {
    /** . */
    public static final int HANDLER_MSG_WAIT = 1;
    // time in mili, which is how long we display splash screen
    /** . */
    public static final int SPLASH_SCREEN_DELAYED = 1000;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // error dealer
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                // TODO Auto-generated method stub

            }
        });
        setContentView(R.layout.load_activity);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        mHandler.sendEmptyMessageDelayed(HANDLER_MSG_WAIT, SPLASH_SCREEN_DELAYED);

    }
    /**
     * [Give the description for method].
     * @return App
     */
    public App getApp() {
        return (App) getApplication();
    }
    /** . */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            // start main activity
            startActivity(intent);
            // call finish so that we can't go back splash screen
            finish();
        }
    };
}
