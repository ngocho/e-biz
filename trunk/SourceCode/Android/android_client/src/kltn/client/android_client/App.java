package kltn.client.android_client;

import android.app.Application;

/**
 * @author NThanhPhong
 */
public class App extends Application {

    /*
     * (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        userName.setValue("wind");
        password.setValue("1234567890");
        xu.setValue("0");
        if(PrefUtil.getStringPref(this, "linkserver")==null)
            linkserver.setValue("http://16.test-kltn1.appspot.com/");
    }

    /**  . */
    private final StringPrefs userName = new StringPrefs(this, "username", "admin");
    /**  . */
    private final StringPrefs password = new StringPrefs(this, "password", "");
    /**  . */
    private final StringPrefs linkserver = new StringPrefs(this, "linkserver", "");
    /**  . */
    private final StringPrefs xu = new StringPrefs(this, "xu", "0");
}
