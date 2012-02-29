package kltn.client.android_client.activity;

import org.json.JSONObject;

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
public class AccountTransferXuActivity extends Activity implements OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_transfer_xu);
        mOk = (Button) findViewById(R.id.account_transfer_submit);
        mOwner = (TextView) findViewById(R.id.account_tramsfer_xu_owner);
        mOwnerXu = (TextView) findViewById(R.id.account_tramsfer_xu_money);
        mUser = (EditText) findViewById(R.id.account_tramsfer_xu_username);
        mNumber = (EditText) findViewById(R.id.account_tramsfer_xu_number);
        mOk.setOnClickListener(okAction);
        mOwner.setText(PrefUtil.getStringPref(this, "username"));
        mOwnerXu.setText(PrefUtil.getStringPref(this, "xu"));
        mEngine = new Engine();
    }

    /** . */
    private OnClickListener okAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (!mUser.getText().toString().equals("") && !mNumber.getText().toString().equals("")) {
                mCurrentDialog = ProgressDialog.show(AccountTransferXuActivity.this, null,
                        getString(R.string.menu_waiting), true);
                mCurrentDialog.setOnDismissListener(AccountTransferXuActivity.this);
                mIsWaiting = true;
                Thread t = new Thread() {
                    public void run() {
                        status = getResultXu(mOwner.getText().toString(), PrefUtil.getStringPref(
                                AccountTransferXuActivity.this, "password"), mNumber.getText().toString(), mUser
                                .getText().toString());
                        if (status.equals("1")) {
                            status = getString(R.string.transfer_successful);
                            flag = true;
                        } else {
                            if (status.equals("2")) {
                                status = getString(R.string.transfer_enough_xu);
                            } else if (status.equals("3")) {
                                status = getString(R.string.transfer_username);
                            } else {
                                status = getString(R.string.transfer_not_successful);
                            }
                            flag = false;
                        }
                        mCurrentDialog.dismiss();
                    }
                };
                t.start();

            } else {
                Toast.makeText(AccountTransferXuActivity.this, getString(R.string.transfer_xu_status),
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    /**
     * [Give the description for method].
     * @param mOwner String
     * @param password String
     * @param mOwnerXu String
     * @param mUser String
     * @return String
     */
    public String getResultXu(String mOwner, String password, String mOwnerXu, String mUser) {
        String json = mEngine
                .mQueryURL("http://16.test-kltn1.appspot.com/getUserFuntion.vn?flag=XuSendCustomer&content=" + mOwner
                        + "@" + password + "@" + mOwnerXu + "@" + mUser);
        return parseJSONXu(json);
    }

    /**
     * @param json - parsejson
     * @return 0 - not correct product key; 1 - successful; -1 - username customer not exist
     */
    /**
     * [Give the description for method].
     * @param json String
     * @return String
     */
    private String parseJSONXu(String json) {
        String jResult = "";
        try {
            JSONObject item = new JSONObject(json);
            jResult = item.getString("flag");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jResult;
    }

    /** . */
    private boolean flag = false;
    /** . */
    private Button mOk;
    /** . */
    private TextView mOwner;
    /** . */
    private TextView mOwnerXu;
    /** . */
    private EditText mUser;
    /** . */
    private String status;
    /** . */
    private EditText mNumber;
    /** . */
    private boolean mIsWaiting;
    /** . */
    private Dialog mCurrentDialog;
    /** . */
    private Engine mEngine;

    /*
     * (non-Javadoc)
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content .DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        Toast.makeText(AccountTransferXuActivity.this, status, Toast.LENGTH_LONG).show();
        if (flag) {
            mOwnerXu.setText(mEngine.mGetXu(AccountTransferXuActivity.this, mOwner.getText().toString(),
                    PrefUtil.getStringPref(AccountTransferXuActivity.this, "password")));
            mNumber.setText("");
            mUser.setText("");
        }
        mCurrentDialog.cancel();
    }
}
