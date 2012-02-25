package kltn.client.android_client.activity;

import java.util.Vector;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.engine.Engine;
import kltn.client.android_client.engine.FavouriteEngine;
import kltn.client.android_client.model.Browser_food_item;
import kltn.client.android_client.model.FavoriteItem;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author NThanhPhong
 */
public class TabBrowserActivity extends Activity implements OnClickListener, TextWatcher, OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_browser);
        mList = (ListView) findViewById(R.id.tab_browser_list);
        mList.setAdapter(new BrowserAdapter(this));
        mBack = (Button) findViewById(R.id.tab_browser_back);
        mHome = (LinearLayout) findViewById(R.id.tab_browser_home);
        mBest = (LinearLayout) findViewById(R.id.tab_browser_best);
        mBrowser = (LinearLayout) findViewById(R.id.tab_browser_browse);
        mDeal = (LinearLayout) findViewById(R.id.tab_browser_deal);
        mOk = (Button) findViewById(R.id.tab_browser_ok);
        mEdittext = (EditText) findViewById(R.id.tab_browser_edit);
        mBack.setOnClickListener(this);
        mHome.setOnClickListener(this);
        mDeal.setOnClickListener(this);
        mBest.setOnClickListener(this);
        mBrowser.setOnClickListener(this);
        mOk.setOnClickListener(this);
        mEdittext.addTextChangedListener(this);
        mEngine = new Engine();
        mItemsData = new Vector<Browser_food_item>();
        mSave = (Button) findViewById(R.id.tab_browser_savesearch);
        mSave.setOnClickListener(this);
        mLoadData();
        mFavoriteEngine = new FavouriteEngine(this);
    }

    /**
     * [LoadData].
     */
    public void mLoadData() {
        mCurrentDialog = ProgressDialog.show(TabBrowserActivity.this, null, getString(R.string.menu_waiting), true);
        mCurrentDialog.setOnDismissListener(TabBrowserActivity.this);
        mIsWaiting = true;
        Thread t = new Thread() {
            public void run() {
                mListBrowser = mEngine.getBrowserFood(TabBrowserActivity.this);
                mCurrentDialog.dismiss();
            }
        };
        t.start();
    }

    /**
     * @author NThanhPhong
     */
    public class BrowserAdapter extends BaseAdapter {
        /** . */
        private Context context;

        /**
         * @param mycontext Context
         */
        public BrowserAdapter(Context mycontext) {
            context = mycontext;
        }

        @Override
        public int getCount() {
            return mData.length;
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
                convertView = getLayoutInflater().inflate(R.layout.item_browser, null);
            }
            TextView name = (TextView) convertView.findViewById(R.id.item_browser_name);
            name.setText(mData[position]);
            final int pos = position;
            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    mItemsData.clear();
                    for (int i = 0; i < mListBrowser.size(); i++) {
                        if (mListBrowser.get(i).getType().equals(String.valueOf(pos + 1))) {
                            mItemsData.add(mListBrowser.get(i));
                        }
                    }
                    flag = true;
                    mBrowserItemAdapter = new BrowserItemAdapter();
                    mList.setAdapter(mBrowserItemAdapter);
                }
            });
            return convertView;
        }

    };

    /**
     * @author NThanhPhong
     */
    public class BrowserItemAdapter extends BaseAdapter {

        /**
         * 
         */
        public BrowserItemAdapter() {
        }

        @Override
        public int getCount() {
            return mItemsData.size();
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
                convertView = getLayoutInflater().inflate(R.layout.item_browser_get, null);
            }
            ImageView image = (ImageView) convertView.findViewById(R.id.item_browser_get_image);
            BitmapManager.INSTANCE.loadBitmap(mEngine.mURLImage + mItemsData.get(position).getImageurl(), image, 500,
                    500);
            TextView name = (TextView) convertView.findViewById(R.id.item_browser_get_name);
            TextView price = (TextView) convertView.findViewById(R.id.item_browser_get_buy);
            TextView pricepromotion = (TextView) convertView.findViewById(R.id.item_browser_get_buyend);
            TextView date = (TextView) convertView.findViewById(R.id.item_browser_get_date);
            TextView content = (TextView) convertView.findViewById(R.id.item_browser_get_content);
            final Browser_food_item item = mItemsData.get(position);
            name.setText(item.getId() + " - " + item.getName());
            price.setText("$" + item.getPrice() + " " + getString(R.string.vnd));
            price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            pricepromotion.setText("$" + item.getBuyprice() + " " + getString(R.string.vnd));
            TextView provider = (TextView) convertView.findViewById(R.id.item_browser_get_provider);
            provider.setText(getString(R.string.provider) + " " + item.getProvider());
            content.setText(mEngine.fillString(item.getIntroduction(), 40));
            date.setText(item.getStartdate());
            TextView buyer = (TextView) convertView.findViewById(R.id.item_browser_get_buyer);
            buyer.setText(item.getBuycount() + " " + getString(R.string.buyer));
            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(TabBrowserActivity.this, DetailFoodActivity.class);
                    i.putExtra("id_food", item.getId());
                    startActivity(i);
                }
            });
            return convertView;
        }
    };

    /** . */
    private Vector<Browser_food_item> mItemsData;
    /** . */
    private BrowserItemAdapter mBrowserItemAdapter;
    /** . */
    private boolean flag = false;
    /** . */
    private ListView mList;
    /** . */
    private Button mBack;
    /** . */
    private LinearLayout mHome;
    /** . */
    private LinearLayout mBest;
    /** . */
    private LinearLayout mDeal;
    /** . */
    private LinearLayout mBrowser;
    /** . */
    private EditText mEdittext;
    /** . */
    private Button mOk;
    /** . */
    private String[] mData = {"Thực phẩm sơ chế", "Thức ăn nấu sẵn", "Rau xanh", "Trái cây", "Cửa hàng"};
    /** . */
    private Dialog mCurrentDialog;
    /** . */
    public boolean mIsWaiting;
    /** . */
    private Vector<Browser_food_item> mListBrowser;
    /** . */
    private Engine mEngine;
    /** . */
    private Button mSave;
    /** . */
    private FavouriteEngine mFavoriteEngine;

    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_browser_back :
                if (!flag) {
                    Intent menu = new Intent(TabBrowserActivity.this, MenuActivity.class);
                    menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(menu);
                    finish();
                } else {
                    mList.setAdapter(new BrowserAdapter(this));
                    flag = false;
                }
                break;
            case R.id.tab_browser_best :
                Intent best = new Intent(TabBrowserActivity.this, TabBestActivity.class);
                startActivity(best);
                finish();
                break;
            case R.id.tab_browser_browse :
                break;
            case R.id.tab_browser_deal :
                Intent deals = new Intent(TabBrowserActivity.this, TabDealsActivity.class);
                startActivity(deals);
                finish();
                break;
            case R.id.tab_browser_home :
                Intent home = new Intent(TabBrowserActivity.this, MenuActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
                break;
            case R.id.tab_browser_ok :
                mOk.setBackgroundResource(R.drawable.search_button_none);
                mEdittext.setText("");
                break;
            case R.id.tab_browser_savesearch :
                if (flag) {
                    for (int i = 0; i < mItemsData.size(); i++) {
                        Browser_food_item item = mItemsData.get(i);
                        mFavoriteEngine.put(new FavoriteItem(item.getId(), item.getName(), item.getIntroduction(), item
                                .getPrice(), item.getBuyprice(), item.getImageurl(), item.getStartdate(), item
                                .getStartdate(), item.getBuycount(), item.getBuycount(), item.getBuycount(), item
                                .getBuycount(), item.getProvider()));
                    }
                }
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
            mOk.setBackgroundResource(R.drawable.search_button_cancel);
        }
    }

    /*
     * (non-Javadoc)
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content .DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        mIsWaiting = false;
        mCurrentDialog.cancel();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (flag) {
                mList.setAdapter(new BrowserAdapter(this));
                flag = false;

            } else {
                this.finish();
            }
        }
        return false;
    }
}
