package kltn.client.android_client.engine;

import java.security.InvalidParameterException;

import kltn.client.android_client.model.SaveSearchItem;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * @author NThanhPhong
 */
public class SaveSearchEngine {
    /**
     * @param context Context
     */
    public SaveSearchEngine(Context context) {
        mResolver = context.getContentResolver();
    }

    /**
     * [Give the description for method].
     * @param item SaveSearchItem
     */
    public void put(SaveSearchItem item) {
        if (item == null) {
            throw new InvalidParameterException();
        }
        String where = SaveSearchItem.ID + "=\"" + item.getId() + "\"";
        Cursor c = mResolver.query(SaveSearchItem.CONTENT_URI, null, where, null, null);
        if (c != null) {
            int dbCount = c.getCount();
            c.close();
            ContentValues values = new ContentValues();
            values.put(SaveSearchItem.ID, item.getId());
            values.put(SaveSearchItem.NAME, item.getName());
            values.put(SaveSearchItem.INTRODUCTION, item.getIntroduction());
            values.put(SaveSearchItem.PRICE, item.getPrice());
            values.put(SaveSearchItem.BUYPRICE, item.getBuyprice());
            values.put(SaveSearchItem.IMAGEURL, item.getImageurl());
            values.put(SaveSearchItem.UPLOADDATE, item.getUploaddatedate());
            values.put(SaveSearchItem.SAVEDATE, item.getSavedate());
            values.put(SaveSearchItem.BUYCOUNT, item.getBuycount());
            values.put(SaveSearchItem.PROVIDER, item.getProvider());
            if (dbCount == 0) {
                mResolver.insert(SaveSearchItem.CONTENT_URI, values);
            } else {
                mResolver.update(SaveSearchItem.CONTENT_URI, values, where, null);
            }
        }
    }

    /**
     * [Give the description for method].
     * @param saveSearchId String
     */
    public void removeItem(String saveSearchId) {
        String where = SaveSearchItem.ID + "=" + saveSearchId;
        mResolver.delete(SaveSearchItem.CONTENT_URI, where, null);
    }

    /**
     * [Give the description for method].
     * @param saveSearchId String
     * @return boolean
     */
    public boolean isItem(String saveSearchId) {
        String where = SaveSearchItem.ID + "=\"" + saveSearchId + "\"";
        Cursor c = mResolver.query(SaveSearchItem.CONTENT_URI, null, where, null, null);
        if (c != null) {
            int dbCount = c.getCount();
            if (dbCount > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     * [Give the description for method].
     * @param ids String[]
     */
    public void removeItemsById(String[] ids) {
        if (ids == null) {
            throw new InvalidParameterException();
        }
        StringBuffer where = new StringBuffer();
        for (int i = 0; i < ids.length - 1; i++) {
            where.append(SaveSearchItem.ID).append("=? OR ");
        }
        if (ids.length > 0) {
            where.append(SaveSearchItem.ID).append("=?");
        }
        String[] args = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            args[i] = ids[i];
        }
        mResolver.delete(SaveSearchItem.CONTENT_URI, where.toString(), args);
    }

    /**
     * [Give the description for method].
     * @return int
     */
    public int count() {
        String projection = "COUNT(" + SaveSearchItem.ID + ")";
        Cursor c = mResolver.query(SaveSearchItem.CONTENT_URI, new String[]{projection}, null, null, null);
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
     * @param sortOrder String
     * @return Cursor
     */
    private Cursor getAll(String sortOrder) {
        String projection[] = {SaveSearchItem.ID, SaveSearchItem.NAME, SaveSearchItem.INTRODUCTION,
                SaveSearchItem.PRICE, SaveSearchItem.BUYPRICE, SaveSearchItem.IMAGEURL, SaveSearchItem.BUYCOUNT,
                SaveSearchItem.UPLOADDATE, SaveSearchItem.SAVEDATE, SaveSearchItem.PROVIDER};

        Cursor c = mResolver.query(SaveSearchItem.CONTENT_URI, projection, null, null, sortOrder);
        return c;
    }
    /**
     * [Give the description for method].
     * @param data Cursor
     * @param foodname String
     * @return int
     */
    public int selectFoodByName(Cursor data, String foodname) {
        int result = 0;
        try {
            String sqlSearch = "name like '" + foodname + "%'";
            Cursor c = mResolver.query(SaveSearchItem.CONTENT_URI, null, sqlSearch, null, null);
            if (c.moveToFirst()) {
                result = c.getInt(c.getColumnIndex("_id"));
            }
            c.close();
            while (data.moveToNext()) {
                if (data.getInt(c.getColumnIndex("_id")) == result) {
                    break;
                }
            }
            return data.getPosition();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * [Give the description for method].
     * @return Cursor
     */
    public Cursor getAllSortByDate() {
        return getAll(null);
    }

    /** . */
    private ContentResolver mResolver;
    /** . */
    private static String mDEBUGTAG = "[SaveSearchEngine]";
}
