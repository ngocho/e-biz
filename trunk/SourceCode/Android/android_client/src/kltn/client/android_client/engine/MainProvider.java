package kltn.client.android_client.engine;

import kltn.client.android_client.model.FavoriteItem;
import kltn.client.android_client.model.DateFoodItem;
import kltn.client.android_client.model.HistotyBuyItem;
import kltn.client.android_client.model.SaveSearchItem;
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

/**
 * @author NThanhPhong
 */
public class MainProvider extends ContentProvider {

    /**
     * @author NThanhPhong
     */
    private static class DatabaseHelper extends SQLiteOpenHelper {
        /**
         * @param context Context
         * @param name String
         * @param factory CursorFactory
         * @param version int
         */
        DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                Log.w(DEBUG_TAG, "Creating history_buy table...");
                db.execSQL(SQL_CREATE_HISTORY_BUY);
                Log.w(DEBUG_TAG, "creating date_food table");
                db.execSQL(SQL_CREATE_DATE_FOOD);
                Log.w(DEBUG_TAG, "creating favorite_food table");
                db.execSQL(SQL_CREATE_FAVORITE_FOOD);
                db.execSQL(SQL_CREATE_SAVESEARCH_FOOD);
            } catch (SQLException e) {
                Log.e(DEBUG_TAG, e.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Log.w(DEBUG_TAG, "Upgrading database from version " + oldVersion + " to " + newVersion
                        + ", which will destroy all old data");
                db.execSQL(SQL_DROP_HISTORY_BUY);
                db.execSQL(SQL_DROP_CHAT);
                db.execSQL(SQL_DROP_FAVORITE);
                db.execSQL(SQL_DROP_SAVESEARCH_FOOD);
                onCreate(db);
            } catch (SQLException e) {
                Log.e(DEBUG_TAG, e.getMessage());
            }
        }

        /** . */
        private static final String SQL_CREATE_HISTORY_BUY = "CREATE TABLE " + TABLE_HISTORY_BUY + "("
                + HistotyBuyItem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HistotyBuyItem.IDCUSTOMER + " TEXT, "
                + HistotyBuyItem.IDGOODS + " TEXT, " + HistotyBuyItem.GOODSNAME + " TEXT, " + HistotyBuyItem.IMAGE
                + " TEXT, " + HistotyBuyItem.DATE + " TEXT, " + HistotyBuyItem.PRICE + " TEXT);";
        /** . */
        private static final String SQL_DROP_HISTORY_BUY = "DROP TABLE IF EXISTS " + TABLE_HISTORY_BUY;

        /** . */
        private static final String SQL_CREATE_DATE_FOOD = "CREATE TABLE " + TABLE_DATE_FOOD + "(" + DateFoodItem._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DateFoodItem.IDGOODS + " TEXT, " + DateFoodItem.NAME
                + " TEXT, " + DateFoodItem.PRICE + " TEXT, " + DateFoodItem.BUYPRICE + " TEXT, "
                + DateFoodItem.IMAGEURL + " TEXT, " + DateFoodItem.STARTDATE + " TEXT, " + DateFoodItem.ENDDATE
                + " TEXT, " + DateFoodItem.BUYCOUNT + " TEXT, " + DateFoodItem.COUNTMIN + " TEXT, "
                + DateFoodItem.COUNTMAX + " TEXT);";

        /** . */
        private static final String SQL_DROP_CHAT = "DROP TABLE IF EXISTS " + TABLE_DATE_FOOD;

        /** . */
        private static final String SQL_CREATE_FAVORITE_FOOD = "CREATE TABLE " + TABLE_FAVORITE_FOOD + "("
                + FavoriteItem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FavoriteItem.ID + " TEXT, "
                + FavoriteItem.NAME + " TEXT, " + FavoriteItem.INTRODUCTION + " TEXT, " + FavoriteItem.PRICE
                + " TEXT, " + FavoriteItem.BUYPRICE + " TEXT, " + FavoriteItem.IMAGEURL + " TEXT, "
                + FavoriteItem.UPLOADDATE + " TEXT, " + FavoriteItem.SAVEDATE + " TEXT, " + FavoriteItem.MAXBUYER
                + " TEXT, " + FavoriteItem.RATE + " TEXT, " + FavoriteItem.PROVIDER + " TEXT, " + FavoriteItem.BUYCOUNT
                + " TEXT, " + FavoriteItem.MINBUYER + " TEXT);";

        /** . */
        private static final String SQL_DROP_SAVESEARCH_FOOD = "DROP TABLE IF EXISTS " + TABLE_SAVE_FOOD;

        /** . */
        private static final String SQL_CREATE_SAVESEARCH_FOOD = "CREATE TABLE " + TABLE_SAVE_FOOD + "("
                + SaveSearchItem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SaveSearchItem.ID + " TEXT, "
                + SaveSearchItem.NAME + " TEXT, " + SaveSearchItem.INTRODUCTION + " TEXT, " + SaveSearchItem.PRICE
                + " TEXT, " + SaveSearchItem.BUYPRICE + " TEXT, " + SaveSearchItem.IMAGEURL + " TEXT, "
                + SaveSearchItem.UPLOADDATE + " TEXT, " + SaveSearchItem.SAVEDATE + " TEXT, " + SaveSearchItem.PROVIDER
                + " TEXT, " + SaveSearchItem.BUYCOUNT + " TEXT);";

        /** . */
        private static final String SQL_DROP_FAVORITE = "DROP TABLE IF EXISTS " + TABLE_FAVORITE_FOOD;
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        mDatabase = dbHelper.getWritableDatabase();
        return (mDatabase == null) ? false : true;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        // TODO Auto-generated method stub
        int count;
        switch (mUriMatcher.match(uri)) {
            case CODE_HISTORY_BUY :
                Log.i(DEBUG_TAG, "Delete where: " + where);
                count = mDatabase.delete(TABLE_HISTORY_BUY, where, whereArgs);
                break;
            case CODE_DATE_FOOD :
                Log.i(DEBUG_TAG, "Delete where: " + where);
                count = mDatabase.delete(TABLE_DATE_FOOD, where, whereArgs);
                break;
            case CODE_FAVORITE_FOOD :
                Log.i(DEBUG_TAG, "Delete where: " + where);
                count = mDatabase.delete(TABLE_FAVORITE_FOOD, where, whereArgs);
                break;
            case CODE_SAVE_FOOD :
                Log.i(DEBUG_TAG, "Delete where: " + where);
                count = mDatabase.delete(TABLE_SAVE_FOOD, where, whereArgs);
                break;
            default :
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO Auto-generated method stub
        switch (mUriMatcher.match(uri)) {
            case CODE_HISTORY_BUY :
                return "vnd.android.cursor.dir/vnd.kltn.client.android_client";
            case CODE_DATE_FOOD :
                return "vnd.android.cursor.dir/vnd.kltn.client.android_client";
            case CODE_FAVORITE_FOOD :
                return "vnd.android.cursor.dir/vnd.kltn.client.android_client";
            case CODE_SAVE_FOOD :
                return "vnd.android.cursor.dir/vnd.kltn.client.android_client";
            default :
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // Insert the new row, will return the row number if
        // successful.
        long rowID = 0;
        switch (mUriMatcher.match(uri)) {
            case CODE_HISTORY_BUY :
                rowID = mDatabase.insert(TABLE_HISTORY_BUY, null, values);
                if (rowID > 0) {
                    Uri uri1 = ContentUris.withAppendedId(HistotyBuyItem.CONTENT_URI, rowID);
                    getContext().getContentResolver().notifyChange(uri1, null);
                    // Return a URI to the newly inserted row on success.
                    return uri1;
                }
                break;
            case CODE_DATE_FOOD :
                rowID = mDatabase.insert(TABLE_DATE_FOOD, null, values);
                if (rowID > 0) {
                    Uri uri1 = ContentUris.withAppendedId(DateFoodItem.CONTENT_URI, rowID);
                    getContext().getContentResolver().notifyChange(uri1, null);
                    // Return a URI to the newly inserted row on success.
                    return uri1;
                }
                break;
            case CODE_FAVORITE_FOOD :
                rowID = mDatabase.insert(TABLE_FAVORITE_FOOD, null, values);
                if (rowID > 0) {
                    Uri uri1 = ContentUris.withAppendedId(FavoriteItem.CONTENT_URI, rowID);
                    getContext().getContentResolver().notifyChange(uri1, null);
                    return uri1;
                }
                break;
            case CODE_SAVE_FOOD :
                rowID = mDatabase.insert(TABLE_SAVE_FOOD, null, values);
                if (rowID > 0) {
                    Uri uri1 = ContentUris.withAppendedId(FavoriteItem.CONTENT_URI, rowID);
                    getContext().getContentResolver().notifyChange(uri1, null);
                    return uri1;
                }
                break;
            default :
                break;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.i(DEBUG_TAG, "exec query");
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        Cursor c;
        String orderBy;
        // If this is a row query, limit the result set to the passed in row.
        switch (mUriMatcher.match(uri)) {
            case CODE_HISTORY_BUY :
                qb.setTables(TABLE_HISTORY_BUY);
                if (TextUtils.isEmpty(sortOrder)) {
                    orderBy = HistotyBuyItem.DEFAULT_SORT_ORDER;
                } else {
                    orderBy = sortOrder;
                }
                c = qb.query(mDatabase, projection, selection, selectionArgs, null, null, orderBy);
                c.setNotificationUri(getContext().getContentResolver(), uri);
                return c;
            case CODE_DATE_FOOD :
                qb.setTables(TABLE_DATE_FOOD);
                if (TextUtils.isEmpty(sortOrder)) {
                    orderBy = DateFoodItem.DEFAULT_SORT_ORDER;
                } else {
                    orderBy = sortOrder;
                }
                c = qb.query(mDatabase, projection, selection, selectionArgs, null, null, orderBy);
                c.setNotificationUri(getContext().getContentResolver(), uri);
                return c;
            case CODE_FAVORITE_FOOD :
                qb.setTables(TABLE_FAVORITE_FOOD);
                if (TextUtils.isEmpty(sortOrder)) {
                    orderBy = FavoriteItem.DEFAULT_SORT_ORDER;
                } else {
                    orderBy = sortOrder;
                }
                c = qb.query(mDatabase, projection, selection, selectionArgs, null, null, orderBy);
                c.setNotificationUri(getContext().getContentResolver(), uri);
                return c;
            case CODE_SAVE_FOOD :
                qb.setTables(TABLE_SAVE_FOOD);
                if (TextUtils.isEmpty(sortOrder)) {
                    orderBy = FavoriteItem.DEFAULT_SORT_ORDER;
                } else {
                    orderBy = sortOrder;
                }
                c = qb.query(mDatabase, projection, selection, selectionArgs, null, null, orderBy);
                c.setNotificationUri(getContext().getContentResolver(), uri);
                return c;
            default :
                break;
        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        int count;
        switch (mUriMatcher.match(uri)) {
            case CODE_HISTORY_BUY :
                count = mDatabase.update(TABLE_HISTORY_BUY, values, where, whereArgs);
                break;
            case CODE_DATE_FOOD :
                count = mDatabase.update(TABLE_DATE_FOOD, values, where, whereArgs);
                break;
            case CODE_FAVORITE_FOOD :
                count = mDatabase.update(TABLE_FAVORITE_FOOD, values, where, whereArgs);
                break;
            case CODE_SAVE_FOOD :
                count = mDatabase.update(TABLE_SAVE_FOOD, values, where, whereArgs);
                break;
            default :
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    /** . */
    private static final UriMatcher mUriMatcher;
    /** . */
    private static final String DEBUG_TAG = "[MainProvider]";
    /** . */
    private SQLiteDatabase mDatabase;
    /** . */
    public static final String DATABASE_NAME = "client.db";
    /** . */
    public static final int DATABASE_VERSION = 8;
    /** . */
    public static final String TABLE_HISTORY_BUY = "history_buy";
    /** . */
    public static final String TABLE_DATE_FOOD = "date_food";
    /** . */
    public static final String TABLE_FAVORITE_FOOD = "favorite_food";
    /** . */
    public static final String TABLE_SAVE_FOOD = "save_search_food";
    /** . */
    private static final int CODE_HISTORY_BUY = 1;
    /** . */
    private static final int CODE_DATE_FOOD = 2;
    /** . */
    private static final int CODE_FAVORITE_FOOD = 3;
    /** . */
    private static final int CODE_SAVE_FOOD = 4;

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI("kltn.client.android_client", "history_buy", CODE_HISTORY_BUY);
        mUriMatcher.addURI("kltn.client.android_client", "date_food", CODE_DATE_FOOD);
        mUriMatcher.addURI("kltn.client.android_client", "favorite_food", CODE_FAVORITE_FOOD);
        mUriMatcher.addURI("kltn.client.android_client", "save_search_food", CODE_SAVE_FOOD);
    }
}
