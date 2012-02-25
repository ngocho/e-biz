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
 * @author NThanhPhong
 */
/**
 * @author wind
 *
 */
public class MenuActivity extends Activity implements OnClickListener, OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        mLogin = (Button) findViewById(R.id.menu_login);
        mBest = (LinearLayout) findViewById(R.id.menu_best);
        mDeal = (LinearLayout) findViewById(R.id.menu_deal);
        mBrowser = (LinearLayout) findViewById(R.id.menu_browse);
        mSaveSearch = (LinearLayout) findViewById(R.id.menu_save_search);
        mFavorite = (LinearLayout) findViewById(R.id.menu_favorite);
        mReminder = (LinearLayout) findViewById(R.id.menu_reminder);
        mAbout = (LinearLayout) findViewById(R.id.menu_about);
        mPayment = (LinearLayout) findViewById(R.id.menu_payment);
        mAccount = (LinearLayout) findViewById(R.id.menu_my_account);
        mPayment.setOnClickListener(this);
        mBest.setClickable(true);
        mDialog = new Dialog(this);
        mDialog.setTitle("");
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.login_content);
        mDialog.setCancelable(true);
        mLogin.setOnClickListener(mLoginAction);
        mAccount.setOnClickListener(this);
        mDeal.setOnClickListener(mDealsAction);
        mBest.setOnClickListener(mBestAction);
        mBrowser.setOnClickListener(mBrowserAction);
        mFavorite.setOnClickListener(this);
        mSaveSearch.setOnClickListener(this);
        // mSetting.setOnClickListener(this);
        mEngine = new Engine();
        if (PrefUtil.getStringPref(MenuActivity.this, "username").equals("")
                && PrefUtil.getStringPref(MenuActivity.this, "password").equals("")) {
            mLogin.setText(R.string.menu_login);
            flag = false;
        } else {
            mLogin.setText(R.string.menu_logout);
            flag = true;
        }
    }

    /**  . */
    private OnClickListener mBrowserAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent browser = new Intent(MenuActivity.this, TabBrowserActivity.class);
            startActivity(browser);
        }
    };
    /**  . */
    private OnClickListener mBestAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent best = new Intent(MenuActivity.this, TabBestActivity.class);
            startActivity(best);
        }
    };
    /**  . */
    private OnClickListener mDealsAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent deals = new Intent(MenuActivity.this, TabDealsActivity.class);
            startActivity(deals);
        }
    };

    /**  . */
    private OnClickListener mAboutAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent about = new Intent(MenuActivity.this, AboutActivity.class);
            startActivity(about);
        }
    };
    /**  . */
    private OnClickListener mLoginAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (flag) {
                PrefUtil.setPref(MenuActivity.this, "username", "");
                PrefUtil.setPref(MenuActivity.this, "password", "");
                PrefUtil.setPref(MenuActivity.this, "xu", "0");
                mLogin.setText(R.string.menu_login);
                flag = false;
            } else {
                mShowDialogLogin();
            }
        }
    };

    /**
     * [Give the description for method].
     */
    public void mShowDialogLogin() {
        final EditText dialogusername = (EditText) mDialog.findViewById(R.id.login_username);
        final EditText dialogpassword = (EditText) mDialog.findViewById(R.id.login_pass);
        final CheckBox showpassword = (CheckBox) mDialog.findViewById(R.id.login_showpassword);
        showpassword.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (showpassword.isChecked()) {
                    dialogpassword.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
                } else {
                    dialogpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        Button dialoglogin = (Button) mDialog.findViewById(R.id.login_ok);
        Button dialogregister = (Button) mDialog.findViewById(R.id.login_register);
        dialoglogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mCurrentDialog = ProgressDialog.show(MenuActivity.this, null, getString(R.string.menu_waiting), true);
                mCurrentDialog.setOnDismissListener(MenuActivity.this);
                mIsWaiting = true;
                Thread t = new Thread() {
                    public void run() {
                        flag = mEngine
                                .login(dialogusername.getText().toString(), dialogpassword.getText().toString());
                        PrefUtil.setPref(MenuActivity.this, "username", dialogusername.getText().toString());
                        PrefUtil.setPref(MenuActivity.this, "password", dialogpassword.getText().toString());
                        PrefUtil.setPref(MenuActivity.this, "xu", mEngine.mGetXu(dialogusername.getText().toString(),
                                dialogpassword.getText().toString()));
                        mCurrentDialog.dismiss();
                    }
                };
                t.start();
            }
        });
        dialogregister.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent register = new Intent(MenuActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
        mDialog.show();
    }

    /**
     * [Give the description for method].
     * @return App
     */
    public App getApp() {
        return (App) getApplication();
    }

    @Override
    public void onClick(View v) {
        if (!flag) {
            mShowDialogLogin();
        } else {
            switch (v.getId()) {
                case R.id.menu_payment :
                    Intent payment = new Intent(MenuActivity.this, PaymentActivity.class);
                    startActivity(payment);
                    break;
                case R.id.menu_save_search :
                    Intent search = new Intent(MenuActivity.this, SavedSearchActivity.class);
                    startActivity(search);
                    break;
                case R.id.menu_favorite :
                    Intent favourite = new Intent(MenuActivity.this, FavouriteActivity.class);
                    startActivity(favourite);
                    break;
                case R.id.menu_my_account :
                    Intent myaccount = new Intent(MenuActivity.this, MyAccountActivity.class);
                    startActivity(myaccount);
                    break;
                default :
                    break;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mIsWaiting = false;
        if (flag) {
            Toast.makeText(MenuActivity.this, getString(R.string.menu_successful), Toast.LENGTH_LONG).show();
            mLogin.setText(R.string.menu_logout);
            mDialog.cancel();
        } else {
            Toast.makeText(MenuActivity.this, getString(R.string.menu_fail), Toast.LENGTH_LONG).show();
        }
    }

    /**  . */
    private boolean flag = false;
    /**  . */
    private Dialog mCurrentDialog;
    /**  . */
    private Engine mEngine;
    /**  . */
    private Button mLogin;
    /**  . */
    private Dialog mDialog;
    /**  . */
    private LinearLayout mBest;
    /**  . */
    private LinearLayout mDeal;
    /**  . */
    private LinearLayout mBrowser;
    /**  . */
    private LinearLayout mSaveSearch;
    /**  . */
    private LinearLayout mFavorite;
    /**  . */
    private LinearLayout mReminder;
    /**  . */
    private LinearLayout mMessage;
    /**  . */
    private LinearLayout mSetting;
    /**  . */
    private LinearLayout mAccount;
    /**  . */
    private LinearLayout mPayment;
    /**  . */
    private LinearLayout mAbout;
    /**  . */
    private boolean mIsWaiting;
}
