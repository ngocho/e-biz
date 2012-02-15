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
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class AccountInfoActivity extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accountinfo_activity);
		mBack=(Button)findViewById(R.id.accountinfo_back);
		mPayment=(Button)findViewById(R.id.accountinfo_payment);
		mUpdate=(Button)findViewById(R.id.accountinfo_update);
		mUsername=(TextView)findViewById(R.id.accountinfo_username);
		mXu=(TextView)findViewById(R.id.accountinfo_money);
		mFullname=(TextView)findViewById(R.id.accountinfo_fullname);
		mPhone=(TextView)findViewById(R.id.accountinfo_phone);
		mEmail=(TextView)findViewById(R.id.accountinfo_email);
		mAddress=(TextView)findViewById(R.id.accountinfo_address);
	}
	private Button mBack;
	private Button mPayment;
	private Button mUpdate;
	private TextView mUsername;
	private TextView mXu;
	private TextView mFullname;
	private TextView mPhone;
	private TextView mEmail;
	private TextView mAddress;
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.accountinfo_back:
			Intent myaccount=new Intent(AccountInfoActivity.this,myAccountActivity.class);
			startActivity(myaccount);
			finish();
			break;
		case R.id.accountinfo_payment:
			Intent payment=new Intent(AccountInfoActivity.this,PaymentActivity.class);
			startActivity(payment);
			finish();
			break;
		case R.id.accountinfo_update:
			break;
		}
	}
}
