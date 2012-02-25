package kltn.client.android_client.activity;

import kltn.client.android_client.PrefUtil;
import kltn.client.android_client.R;
import kltn.client.android_client.engine.Engine;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author NThanhPhong
 */
public class AccountChangePassAtivity extends Activity implements OnClickListener, OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_changepass_activity);
        mBack = (Button) findViewById(R.id.account_changepass_back);
        mOk = (Button) findViewById(R.id.account_changepass_ok);
        mOldPass = (EditText) findViewById(R.id.account_changepass_old);
        mNewPass = (EditText) findViewById(R.id.account_changepass_new);
        mComfirmPass = (EditText) findViewById(R.id.account_changepass_confirm);
        mName = (TextView) findViewById(R.id.account_changepass_username);
        mBack.setOnClickListener(this);
        mOk.setOnClickListener(this);
        mEngine = new Engine();
        mName.setText(PrefUtil.GetStringPref(this, "username"));
    }
    private Button mBack, mOk;
    private EditText mOldPass, mNewPass, mComfirmPass;
    private TextView mName;
    private Dialog mCurrentDialog;
    public boolean mIsWaiting;
    private Engine mEngine;
    private boolean flag = false;
    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account_changepass_ok :
                if (!mOldPass.getText().equals("") && !mNewPass.getText().equals("")
                        && !mComfirmPass.getText().equals("")) {
                    LoadData();
                } else {
                    Toast.makeText(AccountChangePassAtivity.this, getString(R.string.transfer_xu_status),
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.account_changepass_back :
                finish();
                break;
        }
    }
    /*
     * (non-Javadoc)
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        mCurrentDialog.dismiss();
        if (flag) {
            Toast.makeText(AccountChangePassAtivity.this, getString(R.string.accountchange_true), Toast.LENGTH_LONG)
                    .show();
            PrefUtil.SetPref(AccountChangePassAtivity.this, "password", mComfirmPass.getText());
            finish();
        } else {
            Toast.makeText(AccountChangePassAtivity.this, getString(R.string.accountchange_false), Toast.LENGTH_LONG)
                    .show();
        }

    }
    public void LoadData() {
        mCurrentDialog = ProgressDialog.show(AccountChangePassAtivity.this, null, getString(R.string.menu_waiting),
                true);
        mCurrentDialog.setOnDismissListener(AccountChangePassAtivity.this);
        mIsWaiting = true;
        Thread t = new Thread() {
            public void run() {
                flag = mEngine.ChangePass(PrefUtil.GetStringPref(AccountChangePassAtivity.this, "username"), mOldPass
                        .getText().toString(), mNewPass.getText().toString());
                mCurrentDialog.dismiss();
            }
        };
        t.start();
    }
}
