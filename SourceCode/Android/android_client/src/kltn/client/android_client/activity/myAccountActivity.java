/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author nthanhphong
 * 
 */
public class MyAccountActivity extends Activity implements OnClickListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myaccount_activity);
		mAccountchangepass = (LinearLayout) findViewById(R.id.myaccount_changepass);
		mAccountInfo = (LinearLayout) findViewById(R.id.myaccount_info);
		mBack = (Button) findViewById(R.id.myaccount_back);
		mHome = (LinearLayout) findViewById(R.id.myaccount_home);
		mDeals = (LinearLayout) findViewById(R.id.myaccount_deal);
		mBest = (LinearLayout) findViewById(R.id.myaccount_best);
		mBrowse = (LinearLayout) findViewById(R.id.myaccount_browse);
		mPayment=(LinearLayout)findViewById(R.id.myaccount_payment);
		mOrder=(LinearLayout)findViewById(R.id.myaccount_order);
		mHistory=(LinearLayout)findViewById(R.id.myaccount_history);
		mAccountchangepass.setOnClickListener(this);
		mAccountInfo.setOnClickListener(this);
		mBack.setOnClickListener(this);
		mHome.setOnClickListener(this);
		mDeals.setOnClickListener(this);
		mBest.setOnClickListener(this);
		mBrowse.setOnClickListener(this);
		mPayment.setOnClickListener(this);
		mOrder.setOnClickListener(this);
		mHistory.setOnClickListener(this);
	}

	private LinearLayout mAccountInfo;
	private LinearLayout mAccountchangepass;
	private Button mBack;
	private LinearLayout mHome;
	private LinearLayout mDeals;
	private LinearLayout mBest;
	private LinearLayout mBrowse;
	private LinearLayout mPayment;
	private LinearLayout mOrder;
	private LinearLayout mHistory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.myaccount_changepass:
			Intent changepass=new Intent(MyAccountActivity.this,AccountChangePassAtivity.class);
			startActivity(changepass);
			break;
		case R.id.myaccount_back:
			finish();
			Intent back=new Intent(MyAccountActivity.this,MenuActivity.class);
			back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(back);
			break;
		case R.id.myaccount_home:
			Intent home=new Intent(MyAccountActivity.this,MenuActivity.class);
			home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(home);
			finish();
			break;
		case R.id.myaccount_deal:
			Intent deals=new Intent(MyAccountActivity.this,TabDealsActivity.class);
			startActivity(deals);
			finish();
			break;
		case R.id.myaccount_best:
			Intent best=new Intent(MyAccountActivity.this,TabBestActivity.class);
			startActivity(best);
			finish();
			break;
		case R.id.myaccount_browse:
			Intent browser=new Intent(MyAccountActivity.this,TabBrowserActivity.class);
			startActivity(browser);
			finish();
			break;
		case R.id.myaccount_payment:
			Intent payment=new Intent(MyAccountActivity.this,PaymentActivity.class);
			startActivity(payment);
			finish();
			break;
		case R.id.myaccount_order:
			Intent order=new Intent(MyAccountActivity.this,TabDealsActivity.class);
			startActivity(order);
			finish();
			break;
		case R.id.myaccount_history:
			break;
		case R.id.myaccount_info:
			Intent info=new Intent(MyAccountActivity.this,AccountInfoActivity.class);
			startActivity(info);
			break;
		}
	}
}
