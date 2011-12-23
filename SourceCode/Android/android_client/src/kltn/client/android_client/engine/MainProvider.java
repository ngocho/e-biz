package kltn.client.android_client.engine;

import kltn.client.android_client.model.date_food_item;
import kltn.client.android_client.model.histoty_buy_item;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class MainProvider extends ContentProvider {

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				Log.w(DEBUG_TAG, "Creating history_buy table...");
				db.execSQL(SQL_CREATE_HISTORY_BUY);
				Log.w(DEBUG_TAG, "creating date_food table");
				db.execSQL(SQL_CREATE_DATE_FOOD);
			} catch (SQLException e) {
				Log.e(DEBUG_TAG, e.getMessage());
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			try {
				Log.w(DEBUG_TAG, "Upgrading database from version "
						+ oldVersion + " to " + newVersion
						+ ", which will destroy all old data");
				db.execSQL(SQL_DROP_HISTORY_BUY);
				db.execSQL(SQL_DROP_CHAT);
				onCreate(db);
			} catch (SQLException e) {
				Log.e(DEBUG_TAG, e.getMessage());
			}
		}

		private static final String SQL_CREATE_HISTORY_BUY = "CREATE TABLE "
				+ TABLE_HISTORY_BUY + "(" + histoty_buy_item._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + histoty_buy_item.IDCUSTOMER
				+ " TEXT, " + histoty_buy_item.IDGOODS + " TEXT, "
				+ histoty_buy_item.GOODSNAME + " TEXT, " + histoty_buy_item.IMAGE
				+ " TEXT, " + histoty_buy_item.DATE + " TEXT, " + histoty_buy_item.PRICE
				+" TEXT);";
		private static final String SQL_DROP_HISTORY_BUY = "DROP TABLE IF EXISTS "
				+ TABLE_HISTORY_BUY;

		private static final String SQL_CREATE_DATE_FOOD = "CREATE TABLE "
				+ TABLE_DATE_FOOD + "(" + date_food_item._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + date_food_item.IDGOODS
				+ " TEXT, " + date_food_item.NAME + " TEXT, "
				+ date_food_item.PRICE + " TEXT, "+ date_food_item.BUYPRICE + " TEXT, "
				+ date_food_item.IMAGEURL + " TEXT, "+ date_food_item.STARTDATE + " TEXT, "
				+ date_food_item.ENDDATE + " TEXT, "+ date_food_item.BUYCOUNT + " TEXT, "
				+ date_food_item.COUNTMIN + " TEXT, "+ date_food_item.COUNTMAX + " TEXT);";

		private static final String SQL_DROP_CHAT = "DROP TABLE IF EXISTS "
				+ TABLE_DATE_FOOD;
	}

	@Override
	public boolean onCreate() {
		Context context = getContext();
		DatabaseHelper dbHelper = new DatabaseHelper(context, DATABASE_NAME,
				null, DATABASE_VERSION);
		mDatabase = dbHelper.getWritableDatabase();
		return (mDatabase == null) ? false : true;
	}

	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		// TODO Auto-generated method stub
		int count;
		switch (mUriMatcher.match(uri)) {
		case CODE_HISTORY_BUY:
			Log.i(DEBUG_TAG, "Delete where: " + where);
			count = mDatabase.delete(TABLE_HISTORY_BUY, where, whereArgs);
			break;
		case CODE_DATE_FOOD:
			Log.i(DEBUG_TAG, "Delete where: " + where);
			count = mDatabase.delete(TABLE_DATE_FOOD, where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (mUriMatcher.match(uri)) {
		case CODE_HISTORY_BUY:
			return "vnd.android.cursor.dir/vnd.kltn.client.android_client";
		case CODE_DATE_FOOD:
			return "vnd.android.cursor.dir/vnd.kltn.client.android_client";
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// Insert the new row, will return the row number if
		// successful.
		long rowID = 0;
		switch (mUriMatcher.match(uri)) {
		case CODE_HISTORY_BUY:
			rowID = mDatabase.insert(TABLE_HISTORY_BUY, null, values);
			if (rowID > 0) {
				Uri uri1 = ContentUris.withAppendedId(histoty_buy_item.CONTENT_URI,
						rowID);
				getContext().getContentResolver().notifyChange(uri1, null);
				// Return a URI to the newly inserted row on success.
				return uri1;
			}
			break;
		case CODE_DATE_FOOD:
			rowID = mDatabase.insert(TABLE_DATE_FOOD, null, values);
			if (rowID > 0) {
				Uri uri1 = ContentUris.withAppendedId(date_food_item.CONTENT_URI,
						rowID);
				getContext().getContentResolver().notifyChange(uri1, null);
				// Return a URI to the newly inserted row on success.
				return uri1;
			}
			break;
		}
		throw new SQLException("Failed to insert row into " + uri);
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Log.i(DEBUG_TAG, "exec query");
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		Cursor c;
		String orderBy;
		// If this is a row query, limit the result set to the passed in row.
		switch (mUriMatcher.match(uri)) {
		case CODE_HISTORY_BUY:
			qb.setTables(TABLE_HISTORY_BUY);
			if (TextUtils.isEmpty(sortOrder)) {
				orderBy = histoty_buy_item.DEFAULT_SORT_ORDER;
			} else {
				orderBy = sortOrder;
			}
			// Apply the query to the underlying database.
			// Log.i(DEBUG_TAG, "Build query: "
			// + qb.buildQuery(projection, selection, selectionArgs, null,
			// null, orderBy, null));
			c = qb.query(mDatabase, projection, selection, selectionArgs, null,
					null, orderBy);
			// Register the contexts ContentResolver to be notified if
			// the cursor result set changes.
			c.setNotificationUri(getContext().getContentResolver(), uri);
			// Return a cursor to the query result.
			return c;
		case CODE_DATE_FOOD:
			qb.setTables(TABLE_DATE_FOOD);
			if (TextUtils.isEmpty(sortOrder)) {
				orderBy = date_food_item.DEFAULT_SORT_ORDER;
			} else {
				orderBy = sortOrder;
			}
			// Apply the query to the underlying database.
			// Log.i(DEBUG_TAG, "Build query: "
			// + qb.buildQuery(projection, selection, selectionArgs, null,
			// null, orderBy, null));
			c = qb.query(mDatabase, projection, selection, selectionArgs, null,
					null, orderBy);
			// Register the contexts ContentResolver to be notified if
			// the cursor result set changes.
			c.setNotificationUri(getContext().getContentResolver(), uri);
			// Return a cursor to the query result.
			return c;
		default:
			break;
		}
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String where,
			String[] whereArgs) {
		int count;
		switch (mUriMatcher.match(uri)) {
		case CODE_HISTORY_BUY:
			count = mDatabase.update(TABLE_HISTORY_BUY, values, where, whereArgs);
			break;
		case CODE_DATE_FOOD:
			count = mDatabase.update(TABLE_DATE_FOOD, values, where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	private static final UriMatcher mUriMatcher;
	private static final String DEBUG_TAG = "[MainProvider]";
	private SQLiteDatabase mDatabase;
	public static final String DATABASE_NAME = "client.db";
	public static final int DATABASE_VERSION = 8;
	public static final String TABLE_HISTORY_BUY = "history_buy";
	public static final String TABLE_DATE_FOOD = "date_food";
	private static final int CODE_HISTORY_BUY = 1;
	private static final int CODE_DATE_FOOD = 2;

	static {
		mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		mUriMatcher.addURI("kltn.client.android_client", "history_buy",
				CODE_HISTORY_BUY);
		mUriMatcher.addURI("kltn.client.android_client", "date_food",
				CODE_DATE_FOOD);
	}
}
