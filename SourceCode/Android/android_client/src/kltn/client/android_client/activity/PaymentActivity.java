/**
 * 
 */
package kltn.client.android_client.activity;

import java.text.BreakIterator;

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
public class PaymentActivity extends Activity implements OnClickListener{
 
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_content);
		mBack=(Button)findViewById(R.id.payment_back);
		mAddXu=(LinearLayout)findViewById(R.id.payment_add_xu);
		mTransferXu=(LinearLayout)findViewById(R.id.payment_transfer_xu);
		mHome=(LinearLayout)findViewById(R.id.payment_home);
		mDeals=(LinearLayout)findViewById(R.id.payment_deal);
		mBest=(LinearLayout)findViewById(R.id.payment_best);
		mBrowser=(LinearLayout)findViewById(R.id.payment_browse);
		mBack.setOnClickListener(this);
		mAddXu.setOnClickListener(this);
		mTransferXu.setOnClickListener(this);
		mHome.setOnClickListener(this);
		mDeals.setOnClickListener(this);
		mBest.setOnClickListener(this);
		mBrowser.setOnClickListener(this);
	}
	private Button mBack;
	private LinearLayout mAddXu;
	private LinearLayout mTransferXu;
	private LinearLayout mHome;
	private LinearLayout mDeals;
	private LinearLayout mBest;
	private LinearLayout mBrowser;
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.payment_back:
			finish();
			Intent back=new Intent(PaymentActivity.this,MenuActivity.class);
			back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(back);
			break;
		case R.id.payment_add_xu:
			Intent add_xu=new Intent(PaymentActivity.this,AccountAddXuActivity.class);
			startActivity(add_xu);
			break;
		case R.id.payment_transfer_xu:
			Intent transfer_xu=new Intent(PaymentActivity.this,AccountTransferXuActivity.class);
			startActivity(transfer_xu);
			break;
		case R.id.payment_home:
			break;
		case R.id.payment_deal:
			break;
		case R.id.payment_best:
			break;
		case R.id.payment_browse:
			break;
		}
	}
}
