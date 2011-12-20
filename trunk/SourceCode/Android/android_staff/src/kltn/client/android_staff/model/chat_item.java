/**
 * 
 */
package kltn.client.android_staff.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 *
 */
public class chat_item implements BaseColumns{
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_staff/chat");

	public static final String DEFAULT_SORT_ORDER = "date, _id DESC";

	public static final String MESSAGE = "message";

	public static final String STATE = "state";
	
	public static final String DATE = "date";
	
	public chat_item(String message,String date,int state){
		setDate(date);
		setMessage(message);
		setState(state);
	}
	public String getMessage(){
		return mMessage;
	}
	public int getState(){
		return mState;
	}
	public String getDate(){
		return mDate;
	}
	
	public void setMessage(String message){
		mMessage=message;
	}
	public void setState(int state){
		mState=state;
	}
	public void setDate(String date){
		mDate=date;
	}
	private String mMessage,mDate;
	private int mState;
}
