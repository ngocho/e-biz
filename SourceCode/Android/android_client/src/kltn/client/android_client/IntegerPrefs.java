package kltn.client.android_client;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author NThanhPhong
 *
 */
public class IntegerPrefs extends PrefsItem {
    /**
     * @param context Context
     * @param name String
     * @param defValue int
     */
    public IntegerPrefs(Context context, String name, int defValue) {
        super(context, name);
        this.defValue = defValue;
    }

    @Override
    public void setPrefValue(Object value) {
        Integer v = (Integer) value;
        SharedPreferences settings = context.getSharedPreferences(prefsname, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(getName(), v.intValue());
        editor.commit();
    }

    @Override
    public Object getPrefValue() {
        // TODO Auto-generated method stub
        SharedPreferences settings = context.getSharedPreferences(prefsname, Context.MODE_PRIVATE);
        int v = settings.getInt(getName(), defValue);
        return v;
    }

    /**
     * [Give the description for method].
     * @return int
     */
    public int getValue() {
        Integer i = (Integer) getPrefValue();
        return i;
    }

    /**
     * [Give the description for method].
     * @param value int
     */
    public void setValue(int value) {
        setPrefValue(value);
    }

    /**  . */
    private int defValue;
}
