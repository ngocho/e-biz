/**
 * 
 */
package kltn.client.android_staff.engine;

import java.security.InvalidParameterException;

import kltn.client.android_staff.model.chat_item;

import object.chat;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * @author nthanhphong
 *
 */
public class ChatEngine {
	public ChatEngine(Context context) {
		mResolver = context.getContentResolver();
	}

	public void add(chat_item item) {
		if (item == null) {
			throw new InvalidParameterException();
		}
		ContentValues values = new ContentValues();
		values.put(chat_item.MESSAGE, item.getMessage());
		values.put(chat_item.DATE, item.getDate());
		values.put(chat_item.STATE, item.getState());
		mResolver.insert(chat_item.CONTENT_URI, values);
		if (count() > 100) {
			removeLast();
		}
	}
	
	public void removeLast() {
		String where = chat_item.DATE + "=(SELECT MIN(" + chat_item.DATE + ") FROM " + MainProvider.TABLE_CHAT + ")";
		mResolver.delete(chat_item.CONTENT_URI, where, null);
	}

	private Cursor getAll(String sortOrder) {
		String projection[] = {
				chat_item._ID,
				chat_item.MESSAGE,
				chat_item.STATE,
				chat_item.DATE
		};
		
		Cursor c = mResolver.query(chat_item.CONTENT_URI, projection, null, null, sortOrder);
		return c;
	}
	
	public Cursor getItemsBySelection(String selection, String selectionArgs[], String sortOrder) {
		String projection[] = {
				chat_item._ID,
				chat_item.MESSAGE,
				chat_item.STATE,
				chat_item.DATE
		};
		Cursor c = mResolver.query(chat_item.CONTENT_URI, projection, selection, selectionArgs, sortOrder);
		return c;
	}
	
	public Cursor getItemsByDictionary(String dictPath) {
		String projection[] = {
				chat_item._ID,
				chat_item.MESSAGE,
				chat_item.STATE,
				chat_item.DATE
		};
		String selection = chat_item.DATE + "=\"" + dictPath + "\"";
		Cursor c = mResolver.query(chat_item.CONTENT_URI, projection, selection, null, null);
		return c;
	}
	
	public Cursor getAllSortByDate() {
		return getAll(null);
	}
	
	public void removeItemById(int id) {
		String where = chat_item._ID + "=" + id;
		mResolver.delete(chat_item.CONTENT_URI, where, null);
	}

	public void removeItemsById(long[] ids) {
		if (ids == null) {
			throw new InvalidParameterException();
		}
		StringBuffer where = new StringBuffer();
		for (int i = 0; i < ids.length - 1; i++) {
			where.append(chat_item._ID).append("=? OR ");
		}
		if (ids.length > 0) {
			where.append(chat_item._ID).append("=?");
		}
		String[] args = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			args[i] = String.valueOf(ids[i]);
		}
		mResolver.delete(chat_item.CONTENT_URI, where.toString(), args);
	}
	
	public int count() {
		String projection = "COUNT(" + chat_item._ID + ")";
		Cursor c = mResolver.query(chat_item.CONTENT_URI,
				new String[] { projection }, null, null, null);
		int count = 0;
		if (c != null) {
			c.moveToFirst();
			count = c.getInt(c.getColumnIndex(projection));
			c.close();
		}
		return count;
	}
		
	public void removeAll() {
		mResolver.delete(chat_item.CONTENT_URI, null, null);
	}
	
	private ContentResolver mResolver;
}
