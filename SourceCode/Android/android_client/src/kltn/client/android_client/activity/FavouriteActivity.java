package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.engine.Engine;
import kltn.client.android_client.engine.FavouriteEngine;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author NThanhPhong
 */
public class FavouriteActivity extends Activity implements OnClickListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_activity);
        mEngine = new Engine();
        mFavoriteEngine = new FavouriteEngine(this);
        mData = mFavoriteEngine.getAllSortByDate();
        mBack = (Button) findViewById(R.id.favourite_back);
        mAdvance = (Button) findViewById(R.id.favourite_advance);
        mList = (ListView) findViewById(R.id.favourite_listView);
        mCount = (TextView) findViewById(R.id.favourite_count);
        mFavouriteAdapter = new FavouriteAdapter(this);
        mList.setAdapter(mFavouriteAdapter);
        mCount.setText(mList.getCount() + " " + getString(R.string.item));
        mBack.setOnClickListener(this);
        mAdvance.setOnClickListener(this);
    }

    /**
     * @author NThanhPhong
     *
     */
    public class FavouriteAdapter extends BaseAdapter {
        /**  . */
        private Context context;

        /**
         * @param mycontext Context
         */
        public FavouriteAdapter(Context mycontext) {
            context = mycontext;
        }

        @Override
        public int getCount() {
            return mData.getCount();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_favourite, null);
            }
            TextView name = (TextView) convertView.findViewById(R.id.item_favourite_name);
            TextView datesaved = (TextView) convertView.findViewById(R.id.item_favourite_datesaved);
            TextView content = (TextView) convertView.findViewById(R.id.item_favourite_content);
            ImageView image = (ImageView) convertView.findViewById(R.id.item_favourite_image);
            TextView price = (TextView) convertView.findViewById(R.id.item_favourite_buy);
            TextView promotionprice = (TextView) convertView.findViewById(R.id.item_favourite_buyend);
            TextView provider = (TextView) convertView.findViewById(R.id.item_favourite_provider);
            CheckBox flag = (CheckBox) convertView.findViewById(R.id.item_favourite_flag);
            mData.moveToPosition(position);
            name.setText(mData.getString(mData.getColumnIndex("id")) + " - "
                    + mData.getString(mData.getColumnIndex("name")));
            datesaved.setText(getString(R.string.saved_date) + " " + mData.getString(mData.getColumnIndex("savedate")));
            content.setText(mData.getString(mData.getColumnIndex("introduction")));
            price.setText("$" + mData.getString(mData.getColumnIndex("price")));
            price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            promotionprice.setText("$" + mData.getString(mData.getColumnIndex("buyprice")));
            provider.setText(getString(R.string.provider) + " " + mData.getString(mData.getColumnIndex("provider")));
            BitmapManager.INSTANCE.loadBitmap(mEngine.mURLImage + mData.getString(mData.getColumnIndex("imageurl")),
                    image, 90, 90);
            if (mflag) {
                flag.setVisibility(0);
            } else {
                flag.setVisibility(4);
            }
            final String id = mData.getString(mData.getColumnIndex("id"));
            flag.setChecked(false);
            flag.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        listDelete += id + "@";
                    }
                }
            });
            return convertView;
        }
    };

    /**  . */
    private String listDelete = "";
    /**  . */
    private Engine mEngine;
    /**  . */
    private FavouriteEngine mFavoriteEngine;
    /**  . */
    private Cursor mData;
    /**  . */
    private boolean mflag = false;
    /**  . */
    private Button mBack;
    /**  . */
    private Button mAdvance;
    /**  . */
    private ListView mList;
    /**  . */
    private TextView mCount;
    /**  . */
    private FavouriteAdapter mFavouriteAdapter;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.favourite_back :
                Intent menu = new Intent(FavouriteActivity.this, MenuActivity.class);
                menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(menu);
                finish();
                break;
            case R.id.favourite_advance :
                if (mflag) {
                    mflag = false;
                    mFavoriteEngine.removeItemsById(listDelete.split("@"));
                    mData = mFavoriteEngine.getAllSortByDate();
                    mFavouriteAdapter.notifyDataSetChanged();
                    mAdvance.setText(R.string.favourite_advance_a);
                    mCount.setText(mData.getCount() + " " + getString(R.string.item));
                } else {
                    mflag = true;
                    mFavouriteAdapter.notifyDataSetChanged();
                    mAdvance.setText(R.string.favourite_advance_b);
                }
                break;
            default :
                break;
        }
    }
}
