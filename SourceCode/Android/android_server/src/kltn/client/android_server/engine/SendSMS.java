package kltn.client.android_server.engine;

import android.telephony.SmsManager;

/**
 * @author nthanhphong
 */
public class SendSMS {
    /**
     * [Give the description for method].
     * @param phoneNumber String
     * @param message String
     */
    public void sendMessage(String phoneNumber, String message) {
        SmsManager sm = SmsManager.getDefault();
        String number = phoneNumber;
        sm.sendTextMessage(number, null, message, null, null);
    }
}
