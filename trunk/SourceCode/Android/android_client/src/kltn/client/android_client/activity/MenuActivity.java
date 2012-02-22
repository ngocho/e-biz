/**
 * 
 */
package kltn.client.android_client.activity;


import kltn.client.android_client.App;
import kltn.client.android_client.PrefUtil;
import kltn.client.android_client.R;
import kltn.client.android_client.engine.Engine;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author nthanhphong
 *
 */
public class MenuActivity extends Activity implements OnClickListener,OnDismissListener{

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
		mSaveSearch.setOnClickListener(Save_Search_Action);
		//mSetting.setOnClickListener(this);
		mEngine=new Engine();
	}
	public OnClickListener Save_Search_Action=new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent search=new Intent(MenuActivity.this,SavedSearchActivity.class);
			startActivity(search);
		}
	};
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
			Intent myaccount=new Intent(MenuActivity.this,myAccountActivity.class);
			startActivity(myaccount);
		}
	};
	public OnClickListener payment_action=new OnClickListener() {

		@Override
		public void onClick(View v) {
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
			final EditText dialog_username=(EditText)mDialog.findViewById(R.id.login_username);
			final EditText dialog_password=(EditText)mDialog.findViewById(R.id.login_pass);
			final CheckBox show_password=(CheckBox)mDialog.findViewById(R.id.login_showpassword);
			show_password.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(show_password.isChecked()){
						dialog_password.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
					} else {
						dialog_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					}
				}
			});
			Button dialog_login=(Button)mDialog.findViewById(R.id.login_ok);
			Button dialog_register=(Button)mDialog.findViewById(R.id.login_register);
			dialog_login.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mCurrentDialog = ProgressDialog.show(MenuActivity.this, null,
							getString(R.string.menu_waiting), true);
					mCurrentDialog.setOnDismissListener(MenuActivity.this);
					mIsWaiting = true;
					Thread t = new Thread() {
						public void run() {
							flag=mEngine.login(dialog_username.getText().toString(), dialog_password.getText().toString());
							mCurrentDialog.dismiss();
							PrefUtil.SetPref(MenuActivity.this, "username", dialog_username.getText().toString());
							PrefUtil.SetPref(MenuActivity.this, "password", dialog_password.getText().toString());
							PrefUtil.SetPref(MenuActivity.this, "xu", mEngine.GetXu(dialog_username.getText().toString(), dialog_password.getText().toString()));
						}
					};
					t.start();
				}
			});
			dialog_register.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent register=new Intent(MenuActivity.this,RegisterActivity.class);
					startActivity(register);
				}
			});
			mDialog.show();
		}
	};
	public App getApp(){
		return (App)getApplication();
	}
	public OnClickListener favourite =new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent favourite=new Intent(MenuActivity.this,FavouriteActivity.class);
			startActivity(favourite);
		}
	};
	private boolean flag;
	private Dialog mCurrentDialog;
	private Engine mEngine;
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
	private boolean mIsWaiting;
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.string.menu_setting:
			//			Intent setting=new Intent(MenuActivity.this,SettingsActivity.class);
			//			startActivity(setting);
			break;

		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
	 */
	@Override
	public void onDismiss(DialogInterface dialog) {
		mIsWaiting = false;
		if(flag){
			Toast.makeText(MenuActivity.this, getString(R.string.menu_successful), Toast.LENGTH_LONG).show();
			mDialog.cancel();
		}
		else{ 
			Toast.makeText(MenuActivity.this, getString(R.string.menu_fail), Toast.LENGTH_LONG).show();}
	}
}