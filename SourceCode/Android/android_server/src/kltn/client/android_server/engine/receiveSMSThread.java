/**
 * 
 */
package kltn.client.android_server.engine;

import java.util.TimerTask;

import kltn.client.android_server.activity.GPSActivity;

import android.sax.StartElementListener;
import android.telephony.SmsManager;

/**
 * @author nthanhphong
 *
 */
public class receiveSMSThread extends TimerTask{

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//SmsReceiver receiver=new SmsReceiver();
		
		System.out.println("Running the scheduled task by Timer");
		System.gc();
	}
	
}
