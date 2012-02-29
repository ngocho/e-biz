package kltn.client.android_server;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author NThanhPhong
 */
public class PrefUtil {
    /** . */
    private static final String PREF_NAME = "kltn_prefs";
    /** . */
    public static final int NO_EXIST_VALUE = -167;

    /**
     * [Give the description for method].
     * @param context Context
     * @param name String
     * @param value Object
     */
    public static void setPref(Context context, String name, Object value) {
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        if (value instanceof String) {
            editor.putString(name, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(name, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(name, (Boolean) value);
        }

        editor.commit();
    }
    /**
     * [Give the description for method].
     * @param context Context
     * @param name String
     */
    public static void removePref(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(name);
    }

    /**
     * [Give the description for method].
     * @param context Context
     * @param name String
     * @return int
     */
    public static int getIntPref(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return settings.getInt(name, NO_EXIST_VALUE);
    }

    /**
     * [Give the description for method].
     * @param context Context
     * @param name String
     * @return String
     */
    public static String getStringPref(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return settings.getString(name, null);
    }

    /**
     * [Give the description for method].
     * @param context Context
     * @param name String
     * @return String
     */
    public static boolean getBooleanPref(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(name, false);
    }
}
