package kltn.client.android_client;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtil 
{
	private static final String PREF_NAME = "kltn_prefs";
	public static final int NO_EXIST_VALUE = -167; 
	
	public static void SetPref(Context context, String name, Object value)
	{
		SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		
		if(value instanceof String)
			editor.putString(name, (String)value);
		else if(value instanceof Integer)
			editor.putInt(name, (Integer)value);
		else if(value instanceof Boolean)
			editor.putBoolean(name, (Boolean)value);
		
		editor.commit();
	}
	
	public static void RemovePref(Context context, String name)
	{
		SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.remove(name);
	}
	
	public static int GetIntPref(Context context, String name)
	{
		SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		return settings.getInt(name, NO_EXIST_VALUE);
	}
	
	public static String GetStringPref(Context context, String name)
	{
		SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		return settings.getString(name, null);
	}
	
	public static boolean GetBooleanPref(Context context, String name)
	{
		SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		return settings.getBoolean(name, false);
	}
}
