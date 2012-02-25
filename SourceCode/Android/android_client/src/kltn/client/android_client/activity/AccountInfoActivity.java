/**
 * 
 */
package kltn.client.android_client.activity;

import org.json.JSONObject;

import kltn.client.android_client.PrefUtil;
import kltn.client.android_client.R;
import kltn.client.android_client.engine.Engine;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author NThanhPhong
 */
public class AccountInfoActivity extends Activity implements OnClickListener, OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountinfo_activity);
        mBack = (Button) findViewById(R.id.accountinfo_back);
        mPayment = (Button) findViewById(R.id.accountinfo_payment);
        mUpdate = (Button) findViewById(R.id.accountinfo_update);
        mUsername = (TextView) findViewById(R.id.accountinfo_username);
        mXu = (TextView) findViewById(R.id.accountinfo_money);
        mFullname = (TextView) findViewById(R.id.accountinfo_fullname);
        mPhone = (TextView) findViewById(R.id.accountinfo_phone);
        mEmail = (TextView) findViewById(R.id.accountinfo_email);
        mAddress = (TextView) findViewById(R.id.accountinfo_address);
        mEngine = new Engine();
        LoadData();
        mBack.setOnClickListener(this);
        mPayment.setOnClickListener(this);
    }
    public void LoadData() {
        mCurrentDialog = ProgressDialog.show(AccountInfoActivity.this, null, getString(R.string.menu_waiting), true);
        mCurrentDialog.setOnDismissListener(AccountInfoActivity.this);
        mIsWaiting = true;
        Thread t = new Thread() {
            public void run() {
                Data = mEngine.GetInfo(PrefUtil.GetStringPref(AccountInfoActivity.this, "username"),
                        PrefUtil.GetStringPref(AccountInfoActivity.this, "password"));
                mCurrentDialog.dismiss();
            }
        };
        t.start();
    }
    private Engine mEngine;
    private JSONObject Data;
    private Button mBack;
    private Button mPayment;
    private Button mUpdate;
    private TextView mUsername;
    private TextView mXu;
    private TextView mFullname;
    private TextView mPhone;
    private TextView mEmail;
    private TextView mAddress;
    private Dialog mCurrentDialog;
    public boolean mIsWaiting;
    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.accountinfo_back :
                finish();
                break;
            case R.id.accountinfo_payment :
                Intent payment = new Intent(AccountInfoActivity.this, PaymentActivity.class);
                startActivity(payment);
                finish();
                break;
            case R.id.accountinfo_update :
                break;
        }
    }
    /*
     * (non-Javadoc)
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        try {
            mFullname.setText(Data.getString("fullname"));
            mXu.setText(Data.getString("xu"));
            mPhone.setText(Data.getString("phone"));
            mAddress.setText(Data.getString("address"));
            mEmail.setText(Data.getString("email"));
            mUsername.setText(Data.getString("username"));
        } catch (Exception e) {
            System.out.println(e);
        }
        mCurrentDialog.dismiss();
    }
}
