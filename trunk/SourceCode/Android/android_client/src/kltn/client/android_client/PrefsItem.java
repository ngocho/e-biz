package kltn.client.android_client;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author NThanhPhong
 *
 */
public abstract class PrefsItem {

    /**
     * @param context Context
     * @param name String
     */
    protected PrefsItem(Context context, String name) {
        this.name = name.intern();
        this.context = context;
    }

    /**
     * [Give the description for method].
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * [Give the description for method].
     */
    public void unset() {
        SharedPreferences settings = context.getSharedPreferences(PrefsName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(getName());
    }

    /**
     * [Give the description for method].
     * @return
     */
    protected abstract Object getPrefValue();
    /**
     * [Give the description for method].
     * @param value
     */
    protected abstract void setPrefValue(Object value);

    /**  . */
    public static final String PrefsName = "kltn_prefs";
    /**  . */
    private String name;
    /**  . */
    protected Context context;
}
