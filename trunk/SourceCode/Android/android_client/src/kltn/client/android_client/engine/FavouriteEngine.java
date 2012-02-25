/**
 * 
 */
package kltn.client.android_client.engine;

import java.security.InvalidParameterException;

import kltn.client.android_client.model.FavoriteItem;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * @author nthanhphong
 * 
 */
public class FavouriteEngine {
	public FavouriteEngine(Context context) {
		mResolver = context.getContentResolver();
	}

	public void put(FavoriteItem item) {
		if (item == null) {
			throw new InvalidParameterException();
		}
		String where = FavoriteItem.ID + "=\"" + item.getId() + "\"";
		Cursor c = mResolver.query(FavoriteItem.CONTENT_URI, null, where, null,
				null);
		if (c != null) {
			int dbCount = c.getCount();
			c.close();
			ContentValues values = new ContentValues();
			values.put(FavoriteItem.ID, item.getId());
			values.put(FavoriteItem.NAME, item.getName());
			values.put(FavoriteItem.INTRODUCTION, item.getIntroduction());
			values.put(FavoriteItem.PRICE, item.getPrice());
			values.put(FavoriteItem.BUYPRICE, item.getBuyprice());
			values.put(FavoriteItem.IMAGEURL, item.getImageurl());
			values.put(FavoriteItem.UPLOADDATE, item.getUploaddatedate());
			values.put(FavoriteItem.SAVEDATE, item.getSavedate());
			values.put(FavoriteItem.BUYCOUNT, item.getBuycount());
			values.put(FavoriteItem.PROVIDER, item.getProvider());
			if (dbCount == 0) {
				mResolver.insert(FavoriteItem.CONTENT_URI, values);
			} else {
				mResolver.update(FavoriteItem.CONTENT_URI, values, where, null);
			}
		}
	}

	public void removeItem(String FavoriteId) {
		String where = FavoriteItem.ID + "=" + FavoriteId;
		mResolver.delete(FavoriteItem.CONTENT_URI, where, null);
	}

	public void removeItemsById(String[] ids) {
		if (ids == null) {
			throw new InvalidParameterException();
		}
		StringBuffer where = new StringBuffer();
		for (int i = 0; i < ids.length - 1; i++) {
			where.append(FavoriteItem.ID).append("=? OR ");
		}
		if (ids.length > 0) {
			where.append(FavoriteItem.ID).append("=?");
		}
		String[] args = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			args[i] = ids[i];
		}
		mResolver.delete(FavoriteItem.CONTENT_URI, where.toString(), args);
	}

	public int count() {
		String projection = "COUNT(" + FavoriteItem.ID + ")";
		Cursor c = mResolver.query(FavoriteItem.CONTENT_URI,
				new String[] { projection }, null, null, null);
		int count = 0;
		if (c != null) {
			c.moveToFirst();
			count = c.getInt(c.getColumnIndex(projection));
			c.close();
		}
		return count;
	}

	private Cursor getAll(String sortOrder) {
		String projection[] = { FavoriteItem.ID, FavoriteItem.NAME,
				FavoriteItem.INTRODUCTION, FavoriteItem.PRICE,
				FavoriteItem.BUYPRICE, FavoriteItem.IMAGEURL,
				FavoriteItem.BUYCOUNT, FavoriteItem.MINBUYER,
				FavoriteItem.MAXBUYER, FavoriteItem.RATE,
				FavoriteItem.UPLOADDATE, FavoriteItem.SAVEDATE,
				FavoriteItem.PROVIDER };

		Cursor c = mResolver.query(FavoriteItem.CONTENT_URI, projection, null,
				null, sortOrder);
		return c;
	}
	public int SelectFoodByName(Cursor data,String foodname){
		int result=0;
		try{
			String sqlSearch="name like '"
					+ foodname
					+ "%'";
			Cursor c = mResolver.query(FavoriteItem.CONTENT_URI, null, sqlSearch, null,
					null);
			if(c.moveToFirst())
				result=c.getInt(c.getColumnIndex("_id"));			
			c.close();
			while(data.moveToNext()){
				if(data.getInt(c.getColumnIndex("_id"))==result)
					break;
			}
			return data.getPosition();
		}catch (Exception e) {
			return 0;
		}
	}

	public Cursor getAllSortByDate() {
		return getAll(null);
	}

	private ContentResolver mResolver;
	private static String DEBUG_TAG = "[FavoriteEngine]";
}
