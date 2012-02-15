/**
 * 
 */
package kltn.client.android_client;

import android.app.Application;

/**
 * @author nthanhphong
 * 
 */
public class App extends Application {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application#onCreate()
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	private final StringPrefs Username = new StringPrefs(this, "username", "");
	private final StringPrefs Password = new StringPrefs(this, "password", "");
	private final StringPrefs Linkserver = new StringPrefs(this, "linkserver",
			"");
}
