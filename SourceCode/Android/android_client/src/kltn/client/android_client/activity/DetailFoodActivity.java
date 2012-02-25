package kltn.client.android_client.activity;

import org.json.JSONObject;

import kltn.client.android_client.R;
import kltn.client.android_client.activity.tab.BaseTab;
import kltn.client.android_client.activity.tab.CommentTab;
import kltn.client.android_client.activity.tab.ContentTab;
import kltn.client.android_client.activity.tab.ImageTab;
import kltn.client.android_client.activity.tab.ProviderTab;
import kltn.client.android_client.engine.Engine;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author NThanhPhong
 */
/**
 * @author wind
 */
public class DetailFoodActivity extends Activity implements OnClickListener, OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_food_activity);
        mEngine = new Engine();
        mTabView = (LinearLayout) findViewById(R.id.detail_food_tab_host);
        subprice = (TextView) findViewById(R.id.detail_food_subprice);
        price = (TextView) findViewById(R.id.detail_food_price);
        promotionprice = (TextView) findViewById(R.id.detail_food_buyprice);
        name = (TextView) findViewById(R.id.detail_food_name);
        countbuy = (TextView) findViewById(R.id.detail_food_count);
        back = (Button) findViewById(R.id.detail_food_back);
        ok = (Button) findViewById(R.id.detail_food_ok);
        introduction = (Button) findViewById(R.id.detail_food_tab_content);
        image = (Button) findViewById(R.id.detail_food_tab_image);
        comment = (Button) findViewById(R.id.detail_food_tab_comment);
        provider = (Button) findViewById(R.id.detail_food_tab_contact);
        ok.setOnClickListener(this);
        back.setOnClickListener(this);
        // LoadData("");
        introduction.setOnClickListener(tabClickListener(CONTENT_TAB));
        image.setOnClickListener(tabClickListener(IMAGE_TAB));
        comment.setOnClickListener(tabClickListener(COMMENT_TAB));
        provider.setOnClickListener(tabClickListener(PROVIDER_TAB));
        Bundle receive = this.getIntent().getExtras();
        idfood = receive.getString("id_food");
        mLoadData();
    }
    /**
     * [Give the description for method].
     */
    public void mLoadData() {
        mCurrentDialog = ProgressDialog.show(DetailFoodActivity.this, null, getString(R.string.menu_waiting), true);
        mCurrentDialog.setOnDismissListener(DetailFoodActivity.this);
        mIsWaiting = true;
        Thread t = new Thread() {
            public void run() {
                mData = mEngine.mGetFood(idfood);
                mCurrentDialog.dismiss();
            }
        };
        t.start();
    }
    /** . */
    private String idfood;
    /** . */
    private TextView subprice, price, promotionprice, name, countbuy;
    /** . */
    private JSONObject mData;
    /** . */
    private Button back, ok, introduction, image, comment, provider;
    /** . */
    private Dialog mCurrentDialog;
    /** . */
    private boolean mIsWaiting;
    /** . */
    private Engine mEngine;
    /** . */
    private LinearLayout mTabView;
    /** . */
    private static final int CONTENT_TAB = 101;
    /** . */
    private static final int IMAGE_TAB = 102;
    /** . */
    private static final int COMMENT_TAB = 103;
    /** . */
    private static final int PROVIDER_TAB = 104;
    /** . */
    private BaseTab mCurrentTab = null;
    /** . */
    private int mCurrentTabId;
    /**
     * [Explain the description for this method here].
     * @param dialog DialogInterface
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        mCurrentDialog.dismiss();
        try {
            name.setText("MS: " + mData.getString("id") + " - " + mData.getString("name"));
            price.setText(mData.getString("price") + getString(R.string.vnd));
            promotionprice.setText(mData.getString("pricepromotion") + getString(R.string.vnd));
            subprice.setText(String.valueOf((Long.valueOf(mData.getString("price")) - Long.valueOf(mData
                    .getString("pricepromotion")))) + getString(R.string.vnd));
            countbuy.setText(mData.getString("uploaddate"));
            mChangeTab(CONTENT_TAB);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_food_ok :

                break;
            case R.id.detail_food_back :
                finish();
                break;
            case R.id.detail_food_tab_content :
                break;
            default :
                break;
        }
    }
    /**
     * [Give the description for method].
     * @param tab int
     */
    private void mChangeTab(int tab) {
        if (this.mCurrentTabId == tab) {
            return;
        }

        this.mCurrentTabId = tab;

        if (this.mCurrentTab != null) {
            this.mTabView.removeView(this.mCurrentTab.GetView());
            this.mCurrentTab.Release();
            this.mCurrentTab = null;
        }

        switch (this.mCurrentTabId) {
            case CONTENT_TAB :
                this.mCurrentTab = new ContentTab(this, mData);
                break;
            case IMAGE_TAB :
                this.mCurrentTab = new ImageTab(this, mData);
                break;
            case COMMENT_TAB :
                this.mCurrentTab = new CommentTab(this);
                break;
            case PROVIDER_TAB :
                this.mCurrentTab = new ProviderTab(this, 1);
                break;
            default :
                break;
        }

        this.mCurrentTab.Initialize();
        this.mTabView.addView(this.mCurrentTab.GetView());
        this.mTabView.setGravity(Gravity.TOP);
    }
    /**
     * [Give the description for method].
     * @param tab int
     */
    private void forceChangeTab(int tab) {
        this.mCurrentTabId = -1;
        this.mChangeTab(tab);
    }
    /**
     * [Give the description for method].
     * @param tab int
     * @return OnClickListener
     */
    public OnClickListener tabClickListener(final int tab) {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                mChangeTab(tab);
                if (tab == 101) {

                } else if (tab == 102) {
                } else if (tab == 103) {
                } else if (tab == 104) {
                }
            }
        };
    }
}
