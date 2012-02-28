package kltn.client.android_staff.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 */
public class ChatItem implements BaseColumns {
    /** . */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_staff/chat");

    /** . */
    public static final String DEFAULT_SORT_ORDER = "date, _id DESC";

    /** . */
    public static final String MESSAGE = "message";

    /** . */
    public static final String STATE = "state";

    /** . */
    public static final String DATE = "date";

    /**
     * @param message String
     * @param date String
     * @param state int
     */
    public ChatItem(String message, String date, int state) {
        setDate(date);
        setMessage(message);
        setState(state);
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getMessage() {
        return mMessage;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getState() {
        return mState;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getDate() {
        return mDate;
    }

    /**
     * [Give the description for method].
     * @param message String
     */
    public void setMessage(String message) {
        mMessage = message;
    }
    /**
     * [Give the description for method].
     * @param state int
     */
    public void setState(int state) {
        mState = state;
    }
    /**
     * [Give the description for method].
     * @param date String
     */
    public void setDate(String date) {
        mDate = date;
    }
    /**  . */
    private String mMessage, mDate;
    /**  . */
    private int mState;
}
