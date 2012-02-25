/**
 * 
 */
package kltn.client.android_client;

import android.app.Application;

/**
 * @author nthanhphong
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
        Username.setValue("wind");
        Password.setValue("1234567890");
        Xu.setValue("0");
        Linkserver.setValue("http://16.test-kltn1.appspot.com/");
    }

    private final StringPrefs Username = new StringPrefs(this, "username", "admin");
    private final StringPrefs Password = new StringPrefs(this, "password", "");
    private final StringPrefs Linkserver = new StringPrefs(this, "linkserver", "");
    private final StringPrefs Xu = new StringPrefs(this, "xu", "0");
}
