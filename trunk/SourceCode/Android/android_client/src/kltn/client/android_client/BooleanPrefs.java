package kltn.client.android_client;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author NThanhPhong
 */
public class BooleanPrefs extends PrefsItem {
    /**
     * @param context
     * @param name
     * @param defValue
     */
    public BooleanPrefs(Context context, String name, boolean defValue) {
        super(context, name);
        this.defValue = defValue;
    }

    /**
     * [Explain the description for this method here].
     * @param value
     * @see kltn.client.android_client.PrefsItem#setPrefValue(java.lang.Object)
     */
    @Override
    public void setPrefValue(Object value) {
        Boolean v = (Boolean) value;
        SharedPreferences settings = context.getSharedPreferences(PrefsName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(getName(), v.booleanValue());
        editor.commit();
    }

    @Override
    public Object getPrefValue() {
        // TODO Auto-generated method stub
        SharedPreferences settings = context.getSharedPreferences(PrefsName, Context.MODE_PRIVATE);
        boolean v = settings.getBoolean(getName(), defValue);
        return v;
    }

    /**
     * [Give the description for method].
     * @return boolean
     */
    public boolean getValue() {
        Boolean b = (Boolean) getPrefValue();
        return b.booleanValue();
    }

    /**
     * [Give the description for method].
     * @param value
     */
    public void setValue(boolean value) {
        setPrefValue(value);
    }

    /**  . */
    private boolean defValue;
}
