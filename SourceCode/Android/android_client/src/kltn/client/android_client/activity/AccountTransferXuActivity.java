/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class AccountTransferXuActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_transfer_xu);
		mOk=(Button)findViewById(R.id.account_transfer_submit);
		mOwner=(TextView)findViewById(R.id.account_tramsfer_xu_owner);
		mOwnerXu=(TextView)findViewById(R.id.account_tramsfer_xu_money);
		mUser=(EditText)findViewById(R.id.account_tramsfer_xu_username);
		mNumber=(EditText)findViewById(R.id.account_tramsfer_xu_number);
		mOk.setOnClickListener(okAction);
	}
	public OnClickListener okAction=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		}
	};
	private Button mOk;
	private TextView mOwner;
	private TextView mOwnerXu;
	private EditText mUser;
	private EditText mNumber;
}
