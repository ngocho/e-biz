/**
 * 
 */
package kltn.client.android_server.engine;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * @author nthanhphong
 *
 */
public class sendSMS{
	public void sendMessage(String phoneNumber, String message)
	{        
		SmsManager sm = SmsManager.getDefault();
		String number = phoneNumber;
		sm.sendTextMessage(number, null, message, null, null);      
	}
}
