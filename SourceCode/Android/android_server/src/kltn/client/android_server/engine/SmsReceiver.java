/**
 * 
 */
package kltn.client.android_server.engine;

import kltn.client.android_server.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * @author nthanhphong
 *
 */
public class SmsReceiver extends BroadcastReceiver{

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String str = "";            
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
                str += "SMS from " + msgs[i].getOriginatingAddress();                     
                str += " :";
                str += msgs[i].getMessageBody().toString();
                str += "\n";        
            }
            
            //---display the new SMS message---
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            paserSMS(msgs);
        }
	}
	public void paserSMS(SmsMessage[] sms){
		sendSMS sendsms=new sendSMS();
		for(int i=0;i<sms.length;i++){
			if(typeSMS(sms[i].getMessageBody())==1){
				sendsms.sendMessage(sms[i].getDisplayOriginatingAddress(), xu_true);
			}
		}
	}
	public int typeSMS(String bodySMS){
		int result=0;
		//0 - tin nhan sai cu phap; 1 - Active xu;
		int pos;
		for(pos=0;pos<bodySMS.length();pos++)
			if(bodySMS.charAt(pos)==' ')
				break;
		String item=bodySMS.substring(0, pos);
		if(item.equals("xu")||item.equals("XU")||item.equals("Xu")||item.equals("xU"))
			result=1;
		return result;
	}
	private String xu_true="Tài khoản của bạn được nạp 50XU !";
	private String xu_false="Mã nạp XU này không có thực, xin nhập lại!";
}
