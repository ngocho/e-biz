package kltn.client.android_client.engine;

import kltn.client.android_staff.model.chat_item;
import kltn.client.android_staff.model.delivery_item;
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
				Log.w(DEBUG_TAG, "Creating delivery table...");
				db.execSQL(SQL_CREATE_DELIVERY);
				Log.w(DEBUG_TAG, "creating chat table");
				db.execSQL(SQL_CREATE_CHAT);
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
				db.execSQL(SQL_DROP_DELIVERY);
				db.execSQL(SQL_DROP_CHAT);
				onCreate(db);
			} catch (SQLException e) {
				Log.e(DEBUG_TAG, e.getMessage());
			}
		}

		private static final String SQL_CREATE_DELIVERY = "CREATE TABLE "
				+ TABLE_DELIVERY + "(" + delivery_item._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + delivery_item.IDDELIVERY
				+ " TEXT, " + delivery_item.MSGOODS + " TEXT, "
				+ delivery_item.GOODSNAME + " TEXT, " + delivery_item.PRICE
				+ " TEXT, " + delivery_item.IDCUSTOMER + " TEXT, " + delivery_item.CUSTOMERNAME
				+ " TEXT, " + delivery_item.ADDRESS + " TEXT, " + delivery_item.PHONE
				+ " TEXT, " + delivery_item.IMAGEURL + " TEXT, " + delivery_item.XLONG
				+ " TEXT, " + delivery_item.YLONG + " TEXT, " + delivery_item.DATE
				+ " TEXT, " + delivery_item.STATE + " INTEGER);";
		private static final String SQL_DROP_DELIVERY = "DROP TABLE IF EXISTS "
				+ TABLE_DELIVERY;

		private static final String SQL_CREATE_CHAT = "CREATE TABLE "
				+ TABLE_CHAT + "(" + chat_item._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + chat_item.MESSAGE
				+ " TEXT, " + chat_item.STATE + " INTEGER, "
				+ chat_item.DATE + " TEXT);";

		private static final String SQL_DROP_CHAT = "DROP TABLE IF EXISTS "
				+ TABLE_CHAT;
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
		case CODE_DELIVERY:
			Log.i(DEBUG_TAG, "Delete where: " + where);
			count = mDatabase.delete(TABLE_DELIVERY, where, whereArgs);
			break;
		case CODE_CHAT:
			Log.i(DEBUG_TAG, "Delete where: " + where);
			count = mDatabase.delete(TABLE_CHAT, where, whereArgs);
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
		case CODE_DELIVERY:
			return "vnd.android.cursor.dir/vnd.kltn.client.android_staff";
		case CODE_CHAT:
			return "vnd.android.cursor.dir/vnd.kltn.client.android_staff";
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
		case CODE_DELIVERY:
			rowID = mDatabase.insert(TABLE_DELIVERY, null, values);
			if (rowID > 0) {
				Uri uri1 = ContentUris.withAppendedId(delivery_item.CONTENT_URI,
						rowID);
				getContext().getContentResolver().notifyChange(uri1, null);
				// Return a URI to the newly inserted row on success.
				return uri1;
			}
			break;
		case CODE_CHAT:
			rowID = mDatabase.insert(TABLE_CHAT, null, values);
			if (rowID > 0) {
				Uri uri1 = ContentUris.withAppendedId(delivery_item.CONTENT_URI,
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
		case CODE_DELIVERY:
			qb.setTables(TABLE_DELIVERY);
			if (TextUtils.isEmpty(sortOrder)) {
				orderBy = delivery_item.DEFAULT_SORT_ORDER;
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
		case CODE_CHAT:
			qb.setTables(TABLE_CHAT);
			if (TextUtils.isEmpty(sortOrder)) {
				orderBy = delivery_item.DEFAULT_SORT_ORDER;
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
		case CODE_DELIVERY:
			count = mDatabase.update(TABLE_DELIVERY, values, where, whereArgs);
			break;
		case CODE_CHAT:
			count = mDatabase.update(TABLE_CHAT, values, where, whereArgs);
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
	public static final String DATABASE_NAME = "staff.db";
	public static final int DATABASE_VERSION = 8;
	public static final String TABLE_DELIVERY = "delivery";
	public static final String TABLE_CHAT = "chat";
	private static final int CODE_DELIVERY = 1;
	private static final int CODE_CHAT = 2;

	static {
		mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		mUriMatcher.addURI("kltn.client.android_staff", "delivery",
				CODE_DELIVERY);
		mUriMatcher.addURI("kltn.client.android_staff", "chat",
				CODE_CHAT);
	}
}
