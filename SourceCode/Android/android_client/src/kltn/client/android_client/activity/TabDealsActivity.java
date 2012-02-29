package kltn.client.android_client.activity;

import java.util.Vector;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.engine.Engine;
import kltn.client.android_client.model.BestFoodItem;
import kltn.client.android_client.ui.CircleFlowIndicator;
import kltn.client.android_client.ui.ViewFlow;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author NThanhPhong
 */
/**
 * @author wind
 */
public class TabDealsActivity extends Activity implements OnClickListener, OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_deals);
        mEngine = new Engine();
        viewFlow = (ViewFlow) findViewById(R.id.viewflow);
        init = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        init.setFillColor(R.color.blue);
        mBack = (Button) findViewById(R.id.tab_deals_back);
        mHome = (LinearLayout) findViewById(R.id.tab_deals_home);
        mDeals = (LinearLayout) findViewById(R.id.tab_deals_deal);
        mBest = (LinearLayout) findViewById(R.id.tab_deals_best);
        mBrowser = (LinearLayout) findViewById(R.id.tab_deals_browse);
        mBack.setOnClickListener(this);
        mHome.setOnClickListener(this);
        mDeals.setOnClickListener(this);
        mBest.setOnClickListener(this);
        mBrowser.setOnClickListener(this);
        loadData();
        // mData=mEngine.get_best_food();
        // mAdapter=new DealsAdapter(this);
        // viewFlow.setAdapter(mAdapter);
        // viewFlow.setFlowIndicator(init);
    }
    /**
     * [LoadData].
     */
    public void loadData() {
        mCurrentDialog = ProgressDialog.show(TabDealsActivity.this, null, getString(R.string.menu_waiting), true);
        mCurrentDialog.setOnDismissListener(TabDealsActivity.this);
        mIsWaiting = true;
        Thread t = new Thread() {
            public void run() {
                mData = mEngine.getBestFood(TabDealsActivity.this);
                mCurrentDialog.dismiss();
            }
        };
        t.start();
    }
    /**
     * @author NThanhPhong
     */
    public class DealsAdapter extends BaseAdapter {
        /** context. */
        private Context context;
        /**
         * @param mycontext Context
         */
        public DealsAdapter(Context mycontext) {
            context = mycontext;
        }
        @Override
        public int getCount() {
            return mData.size();
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
                convertView = getLayoutInflater().inflate(R.layout.item_deals, null);
            }
            ImageView image = (ImageView) convertView.findViewById(R.id.item_deals_image);
            mItemData = mData.get(position);
            TextView mDate = (TextView) convertView.findViewById(R.id.tab_deals_date);
            TextView mCount = (TextView) convertView.findViewById(R.id.tab_deals_count);
            TextView mName = (TextView) convertView.findViewById(R.id.tab_deals_name);
            TextView mPrice = (TextView) convertView.findViewById(R.id.tab_deals_price);
            TextView mPricePromotion = (TextView) convertView.findViewById(R.id.tab_deals_price_promotion);
            mDate.setText(mItemData.getStartdate());
            mCount.setText(mItemData.getBuycount() + " buyer");
            mName.setText(mItemData.getName());
            mPrice.setText(getString(R.string.deals_price) + " " + mItemData.getPrice() + " " + getString(R.string.vnd));
            mPricePromotion.setText(getString(R.string.deals_sale) + " " + mItemData.getBuyprice() + " "
                    + getString(R.string.vnd));
            BitmapManager.INSTANCE.loadBitmap(mEngine.mURLImage + mItemData.getImageurl(), image, 500, 500);
            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(TabDealsActivity.this, DetailFoodActivity.class);
                    i.putExtra("id_food", mItemData.getId());
                    startActivity(i);
                }
            });
            return convertView;
        }
    };
    /** . */
    private BestFoodItem mItemData;
    /** . */
    private Vector<BestFoodItem> mData;
    /** . */
    private Engine mEngine;
    /** . */
    private CircleFlowIndicator init;
    /** . */
    private ViewFlow viewFlow;
    /** . */
    private DealsAdapter mAdapter;
    /** . */
    private Button mBack;
    /** . */
    private LinearLayout mHome;
    /** . */
    private LinearLayout mDeals;
    /** . */
    private LinearLayout mBest;
    /** . */
    private Dialog mCurrentDialog;
    /** . */
    private LinearLayout mBrowser;
    /** . */
    public boolean mIsWaiting;
    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_deals_back :
                Intent menu = new Intent(TabDealsActivity.this, MenuActivity.class);
                menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(menu);
                finish();
                break;
            case R.id.tab_deals_best :
                Intent best = new Intent(TabDealsActivity.this, TabBestActivity.class);
                startActivity(best);
                finish();
                break;
            case R.id.tab_deals_browse :
                Intent browser = new Intent(TabDealsActivity.this, TabBrowserActivity.class);
                startActivity(browser);
                finish();
                break;
            case R.id.tab_deals_deal :
                break;
            case R.id.tab_deals_home :
                Intent home = new Intent(TabDealsActivity.this, MenuActivity.class);
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
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        mIsWaiting = false;
        mAdapter = new DealsAdapter(this);
        viewFlow.setAdapter(mAdapter);
        viewFlow.setFlowIndicator(init);
        mCurrentDialog.cancel();
    }
}
