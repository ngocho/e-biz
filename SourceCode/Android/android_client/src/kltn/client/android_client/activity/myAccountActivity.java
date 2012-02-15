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
public class myAccountActivity extends Activity implements OnClickListener {

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
			break;
		case R.id.myaccount_back:
			finish();
			Intent back=new Intent(myAccountActivity.this,MenuActivity.class);
			startActivity(back);
			break;
		case R.id.myaccount_home:
			break;
		case R.id.myaccount_deal:
			break;
		case R.id.myaccount_best:
			break;
		case R.id.myaccount_browse:
			break;
		case R.id.myaccount_payment:
			Intent payment=new Intent(myAccountActivity.this,PaymentActivity.class);
			startActivity(payment);
			finish();
			break;
		case R.id.myaccount_order:
			break;
		case R.id.myaccount_history:
			break;
		}
	}
}
