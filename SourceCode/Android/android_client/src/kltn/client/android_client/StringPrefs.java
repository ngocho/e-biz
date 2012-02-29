package kltn.client.android_client;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author NThanhPhong
 */
public class StringPrefs extends PrefsItem {
    /**
     * @param context Context
     * @param name String
     * @param defValue String
     */
    public StringPrefs(Context context, String name, String defValue) {
        super(context, name);
        this.defValue = defValue;
    }

    @Override
    public void setPrefValue(Object value) {
        String v = (String) value;
        SharedPreferences settings = context.getSharedPreferences(PREFSNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(getName(), v);
        editor.commit();
    }

    @Override
    public Object getPrefValue() {
        // TODO Auto-generated method stub
        SharedPreferences settings = context.getSharedPreferences(PREFSNAME, Context.MODE_PRIVATE);
        String v = settings.getString(getName(), defValue);
        return v;
    }

    /**
     * [Give the description for method].
     * @return String
     */
    public String getValue() {
        String s = (String) getPrefValue();
        return s;
    }

    /**
     * [Give the description for method].
     * @param value String
     */
    public void setValue(String value) {
        setPrefValue(value);
    }

    /** . */
    private String defValue;
}
