package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.engine.Engine;
import kltn.client.android_client.engine.FavouriteEngine;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author NThanhPhong
 */
public class SavedSearchActivity extends Activity implements OnClickListener, TextWatcher {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_search_activity);
        mBack = (Button) findViewById(R.id.save_search_back);
        mListview = (ListView) findViewById(R.id.save_search_listView);
        mOk = (Button) findViewById(R.id.save_search_ok);
        mEdittext = (EditText) findViewById(R.id.save_search_edit);
        mBack.setOnClickListener(this);
        mOk.setOnClickListener(this);
        mEdittext.addTextChangedListener(this);
        mFavoriteEngine = new FavouriteEngine(this);
        mData = mFavoriteEngine.getAllSortByDate();
        mEngine = new Engine();
        mListview.setAdapter(new SaveSearchAdapter(this));
    }
    /**
     * @author NThanhPhong
     */
    public class SaveSearchAdapter extends BaseAdapter {
        /**  . */
        private Context context;
        /**
         * @param mycontext Context
         */
        public SaveSearchAdapter(Context mycontext) {
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
                convertView = getLayoutInflater().inflate(R.layout.item_search, null);
            }
            mData.moveToPosition(position);
            String url = mEngine.mURLImage + mData.getString(mData.getColumnIndex("imageurl"));
            ImageView image = (ImageView) convertView.findViewById(R.id.item_search_image);
            TextView name = (TextView) convertView.findViewById(R.id.item_search_name);
            TextView price = (TextView) convertView.findViewById(R.id.item_search_price);
            TextView buyprice = (TextView) convertView.findViewById(R.id.item_search_buyprice);
            TextView provider = (TextView) convertView.findViewById(R.id.item_search_provider);
            TextView count = (TextView) convertView.findViewById(R.id.item_search_count);
            TextView saveddate = (TextView) convertView.findViewById(R.id.item_search_saveddate);
            name.setText(mData.getString(mData.getColumnIndex("id")) + " - "
                    + mData.getString(mData.getColumnIndex("name")));
            price.setText(mData.getString(mData.getColumnIndex("price")) + getString(R.string.vnd));
            buyprice.setText(mData.getString(mData.getColumnIndex("buyprice")) + getString(R.string.vnd));
            provider.setText(getString(R.string.provider) + " " + mData.getString(mData.getColumnIndex("provider")));
            count.setText(getString(R.string.buyer) + " " + mData.getString(mData.getColumnIndex("buycount")));
            saveddate.setText(getString(R.string.saved_date) + " " + mData.getString(mData.getColumnIndex("savedate")));
            BitmapManager.INSTANCE.loadBitmap(url, image, 150, 150);
            return convertView;
        }
    };
    /**  . */
    private Engine mEngine;
    /**  . */
    private FavouriteEngine mFavoriteEngine;
    /**  . */
    private Button mBack;
    /**  . */
    private ListView mListview;
    /**  . */
    private Button mOk;
    /**  . */
    private EditText mEdittext;
    /**  . */
    private Cursor mData;
    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_search_ok :
                mOk.setBackgroundResource(R.drawable.search_button_none);
                mEdittext.setText("");
                break;
            case R.id.save_search_back :
                Intent home = new Intent(SavedSearchActivity.this, MenuActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
                break;
            default :
                break;
        }
    }
    /*
     * (non-Javadoc)
     * @see android.text.TextWatcher#afterTextChanged(android.text.Editable)
     */
    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub

    }
    /*
     * (non-Javadoc)
     * @see android.text.TextWatcher#beforeTextChanged(java.lang.CharSequence, int, int, int)
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO Auto-generated method stub

    }
    /*
     * (non-Javadoc)
     * @see android.text.TextWatcher#onTextChanged(java.lang.CharSequence, int, int, int)
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            mListview.setSelection(mFavoriteEngine.selectFoodByName(mData, s.toString()));
            mOk.setBackgroundResource(R.drawable.search_button_cancel);
        }
    }
}
