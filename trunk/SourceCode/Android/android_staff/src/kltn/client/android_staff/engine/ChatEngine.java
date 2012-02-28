package kltn.client.android_staff.engine;

import java.security.InvalidParameterException;

import kltn.client.android_staff.model.ChatItem;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * @author NThanhPhong
 */
public class ChatEngine {
    /**
     * @param context Context
     */
    public ChatEngine(Context context) {
        mResolver = context.getContentResolver();
    }

    /**
     * [Give the description for method].
     * @param item chat_item
     */
    public void add(ChatItem item) {
        if (item == null) {
            throw new InvalidParameterException();
        }
        ContentValues values = new ContentValues();
        values.put(ChatItem.MESSAGE, item.getMessage());
        values.put(ChatItem.DATE, item.getDate());
        values.put(ChatItem.STATE, item.getState());
        mResolver.insert(ChatItem.CONTENT_URI, values);
        if (count() > 100) {
            removeLast();
        }
    }

    /**
     * [Give the description for method].
     */
    public void removeLast() {
        String where = ChatItem.DATE + "=(SELECT MIN(" + ChatItem.DATE + ") FROM " + MainProvider.TABLE_CHAT + ")";
        mResolver.delete(ChatItem.CONTENT_URI, where, null);
    }

    /**
     * [Give the description for method].
     * @param sortOrder String
     * @return Cursor
     */
    private Cursor getAll(String sortOrder) {
        String projection[] = {ChatItem._ID, ChatItem.MESSAGE, ChatItem.STATE, ChatItem.DATE};

        Cursor c = mResolver.query(ChatItem.CONTENT_URI, projection, null, null, sortOrder);
        return c;
    }

    /**
     * [Give the description for method].
     * @param selection String
     * @param selectionArgs String
     * @param sortOrder String
     * @return Cursor
     */
    public Cursor getItemsBySelection(String selection, String selectionArgs[], String sortOrder) {
        String projection[] = {ChatItem._ID, ChatItem.MESSAGE, ChatItem.STATE, ChatItem.DATE};
        Cursor c = mResolver.query(ChatItem.CONTENT_URI, projection, selection, selectionArgs, sortOrder);
        return c;
    }

    /**
     * [Give the description for method].
     * @param dictPath String
     * @return Cursor
     */
    public Cursor getItemsByDictionary(String dictPath) {
        String projection[] = {ChatItem._ID, ChatItem.MESSAGE, ChatItem.STATE, ChatItem.DATE};
        String selection = ChatItem.DATE + "=\"" + dictPath + "\"";
        Cursor c = mResolver.query(ChatItem.CONTENT_URI, projection, selection, null, null);
        return c;
    }

    /**
     * [Give the description for method].
     * @return Cursor
     */
    public Cursor getAllSortByDate() {
        return getAll(null);
    }

    /**
     * [Give the description for method].
     * @param id int
     */
    public void removeItemById(int id) {
        String where = ChatItem._ID + "=" + id;
        mResolver.delete(ChatItem.CONTENT_URI, where, null);
    }

    /**
     * [Give the description for method].
     * @param ids long[]
     */
    public void removeItemsById(long[] ids) {
        if (ids == null) {
            throw new InvalidParameterException();
        }
        StringBuffer where = new StringBuffer();
        for (int i = 0; i < ids.length - 1; i++) {
            where.append(ChatItem._ID).append("=? OR ");
        }
        if (ids.length > 0) {
            where.append(ChatItem._ID).append("=?");
        }
        String[] args = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            args[i] = String.valueOf(ids[i]);
        }
        mResolver.delete(ChatItem.CONTENT_URI, where.toString(), args);
    }

    /**
     * [Give the description for method].
     * @return int
     */
    public int count() {
        String projection = "COUNT(" + ChatItem._ID + ")";
        Cursor c = mResolver.query(ChatItem.CONTENT_URI, new String[]{projection}, null, null, null);
        int count = 0;
        if (c != null) {
            c.moveToFirst();
            count = c.getInt(c.getColumnIndex(projection));
            c.close();
        }
        return count;
    }

    /**
     * [Give the description for method].
     */
    public void removeAll() {
        mResolver.delete(ChatItem.CONTENT_URI, null, null);
    }

    /**  . */
    private ContentResolver mResolver;
}
