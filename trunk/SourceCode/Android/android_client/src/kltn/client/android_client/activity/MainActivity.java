/**
 * 
 */
package kltn.client.android_client.activity;


import kltn.client.android_client.R;
import kltn.client.android_client.activity.tab.BaseTab;
import kltn.client.android_client.activity.tab.BestTab;
import kltn.client.android_client.activity.tab.LastestTab;
import kltn.client.android_client.activity.tab.NearestTab;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author nthanhphong
 *
 */
public class MainActivity extends Activity{
	private static final int LASTEST_TAB = 101;
	private static final int NEAREST_TAB = 102;
	private static final int BEST_TAB = 103;

	private LinearLayout mTabView = null;
	private BaseTab mCurrentTab = null;
	private int mCurrentTabId;
	private Button mnearest;
	private Button mlastest;
	private Button mbest;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		this.mTabView = (LinearLayout) this.findViewById(R.id.layout_tab_host);
		this.ChangeTab(LASTEST_TAB);
		
		mlastest=(Button)findViewById(R.id.btn_main_lastest);
		mbest=(Button)findViewById(R.id.btn_main_best);
		mnearest=(Button)findViewById(R.id.btn_main_nearest);
		mbest.setOnClickListener(TabClickListener(BEST_TAB));
		mlastest.setOnClickListener(TabClickListener(LASTEST_TAB));
		mnearest.setOnClickListener(TabClickListener(NEAREST_TAB));
		login=(Button)findViewById(R.id.menu_login);
		login.setOnClickListener(loginaction);
	}
	private OnClickListener loginaction=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i=new Intent(MainActivity.this,imageActivity.class);
			startActivity(i);
		}
	};
	private void ForceChangeTab(int tab) {
		this.mCurrentTabId = -1;
		this.ChangeTab(tab);
	}

	private void ChangeTab(int tab) {
		if (this.mCurrentTabId == tab)
			return;

		this.mCurrentTabId = tab;

		if (this.mCurrentTab != null) {
			this.mTabView.removeView(this.mCurrentTab.GetView());
			this.mCurrentTab.Release();
			this.mCurrentTab = null;
		}

		switch (this.mCurrentTabId) {
		case LASTEST_TAB:
			this.mCurrentTab = new LastestTab(this);
			break;
		case NEAREST_TAB:
			this.mCurrentTab = new NearestTab(this);
			break;
		case BEST_TAB:
			this.mCurrentTab = new BestTab(this);
			break;
		}

		this.mCurrentTab.Initialize();
		this.mTabView.addView(this.mCurrentTab.GetView());

		//		if (this.mCurrentTabId == ABOUT_TAB)
		//			this.mTabView.setGravity(Gravity.CENTER);
		//		else
		this.mTabView.setGravity(Gravity.TOP);
	}
	protected OnClickListener TabClickListener(final int tab) {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				ChangeTab(tab);
				if(tab==101){
					mlastest.setBackgroundResource(R.drawable.nm_tabselect);
					mbest.setBackgroundResource(R.drawable.nm_tabunselect);
					mnearest.setBackgroundResource(R.drawable.nm_tabunselect);
					mlastest.setTextColor(R.color.white);
					mbest.setTextColor(R.color.orange_red);
					mnearest.setTextColor(R.color.orange_red);
				}else if(tab==102){
					mlastest.setBackgroundResource(R.drawable.nm_tabunselect);
					mbest.setBackgroundResource(R.drawable.nm_tabunselect);
					mnearest.setBackgroundResource(R.drawable.nm_tabselect);
					mlastest.setTextColor(R.color.orange_red);
					mbest.setTextColor(R.color.orange_red);
					mnearest.setTextColor(R.color.white);
				}
				else if(tab==103){
					mlastest.setBackgroundResource(R.drawable.nm_tabunselect);
					mbest.setBackgroundResource(R.drawable.nm_tabselect);
					mnearest.setBackgroundResource(R.drawable.nm_tabunselect);
					mlastest.setTextColor(R.color.orange_red);
					mbest.setTextColor(R.color.white);
					mnearest.setTextColor(R.color.orange_red);
				}
			}
		};
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			//			if (this.mCurrentTab.whichViewDisplay() == SearchTab.SEARCH_RESULT_VIEW) {
			//				this.mCurrentTab.pressBackKey();
			//			} else {
			AlertDialog dialog = new AlertDialog.Builder(this).create();
			dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes",
					this.mDialogClickListener);
			dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No",
					this.mDialogClickListener);
			dialog.setTitle(R.string.app_name);
			dialog.setMessage(getString(R.string.exit));
			dialog.show();
			//			}
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}
	android.content.DialogInterface.OnClickListener mDialogClickListener = new android.content.DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == DialogInterface.BUTTON_POSITIVE)
				finish();
		}
	};
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			android.content.Intent data) {
		if ((requestCode == ActivityConst.ACTIVITY_RETURN)
				&& (resultCode == Activity.RESULT_OK)) {
			if (data != null) {
				int action = data.getIntExtra(ActivityConst.ACTION_NAME,
						ActivityConst.ACTION_NONE);

				switch (action) {
				case ActivityConst.ACTION_REFRESH_FAVORITE: {
					if (mCurrentTabId == LASTEST_TAB)
						ForceChangeTab(LASTEST_TAB);
					break;
				}
				case ActivityConst.ACTION_RETURN_2_HOME: {
					ForceChangeTab(BEST_TAB);
					break;
				}
				}
			}
		}
	};
}
