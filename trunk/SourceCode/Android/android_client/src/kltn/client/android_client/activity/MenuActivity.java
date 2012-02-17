/**
 * 
 */
package kltn.client.android_client.activity;


import kltn.client.android_client.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * @author nthanhphong
 *
 */
public class MenuActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);
		mLogin=(Button)findViewById(R.id.menu_login);
		mBest=(LinearLayout)findViewById(R.id.menu_best);
		mDeal=(LinearLayout)findViewById(R.id.menu_deal);
		mBrowser=(LinearLayout)findViewById(R.id.menu_browse);
		mSaveSearch=(LinearLayout)findViewById(R.id.menu_save_search);
		mFavorite=(LinearLayout)findViewById(R.id.menu_favorite);
		mReminder=(LinearLayout)findViewById(R.id.menu_reminder);
		mAbout=(LinearLayout)findViewById(R.id.menu_about);
		mPayment=(LinearLayout)findViewById(R.id.menu_payment);
		mAccount=(LinearLayout)findViewById(R.id.menu_my_account);
		mPayment.setOnClickListener(payment_action);
		mBest.setClickable(true);
		mDialog = new Dialog(this);
		mDialog.setTitle("");
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mDialog.setContentView(R.layout.login_content);
		mDialog.setCancelable(true);
		mLogin.setOnClickListener(login_action);
		mAccount.setOnClickListener(myaccount_action);
		mDeal.setOnClickListener(Deals_Action);
		mBest.setOnClickListener(Best_Action);
		mBrowser.setOnClickListener(Browser_Action);
		mFavorite.setOnClickListener(favourite);
	}
	public OnClickListener Browser_Action=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent browser=new Intent(MenuActivity.this,TabBrowserActivity.class);
			startActivity(browser);
		}
	};
	public OnClickListener Best_Action=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent best=new Intent(MenuActivity.this,TabBestActivity.class);
			startActivity(best);
		}
	};
	public OnClickListener Deals_Action=new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent deals=new Intent(MenuActivity.this,TabDealsActivity.class);
			startActivity(deals);
		}
	};
	public OnClickListener myaccount_action=new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
			Intent myaccount=new Intent(MenuActivity.this,myAccountActivity.class);
			startActivity(myaccount);
		}
	};
	public OnClickListener payment_action=new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
			Intent payment=new Intent(MenuActivity.this,PaymentActivity.class);
			startActivity(payment);
		}
	};
	public OnClickListener about_action=new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent about=new Intent(MenuActivity.this,AboutActivity.class);
			startActivity(about);
		}
	};
	public OnClickListener login_action=new OnClickListener() {

		@Override
		public void onClick(View v) {
			EditText dialog_username=(EditText)mDialog.findViewById(R.id.login_username);
			EditText dialog_password=(EditText)mDialog.findViewById(R.id.login_pass);

			Button dialog_login=(Button)mDialog.findViewById(R.id.login_ok);
			Button dialog_register=(Button)mDialog.findViewById(R.id.login_register);
			dialog_login.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

				}
			});
			dialog_register.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent register=new Intent(MenuActivity.this,registerActivity.class);
					startActivity(register);
				}
			});
			mDialog.show();
		}
	};
	public OnClickListener favourite =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent favourite=new Intent(MenuActivity.this,FavouriteActivity.class);
			startActivity(favourite);
		}
	};

	private Dialog mDialog;
	private Button mLogin;
	private LinearLayout mBest;
	private LinearLayout mDeal;
	private LinearLayout mBrowser;
	private LinearLayout mSaveSearch;
	private LinearLayout mFavorite;
	private LinearLayout mReminder;
	private LinearLayout mMessage;
	private LinearLayout mSetting;
	private LinearLayout mAccount;
	private LinearLayout mPayment;
	private LinearLayout mAbout;

}
