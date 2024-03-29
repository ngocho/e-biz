package kltn.client.android_client.activity;

import kltn.client.android_client.App;
import kltn.client.android_client.PrefUtil;
import kltn.client.android_client.R;
import kltn.client.android_client.engine.Engine;

import org.json.JSONObject;

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
public class AccountAddXuActivity extends Activity implements OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_add_xu);
        mUsername = (TextView) findViewById(R.id.account_add_xu_username);
        mMoney = (TextView) findViewById(R.id.account_add_xu_money);
        mProductkey = (EditText) findViewById(R.id.account_add_xu_productkey);
        mOk = (Button) findViewById(R.id.account_add_xu_ok);
        mEngine = new Engine();
        mUsername.setText(PrefUtil.getStringPref(this, "username"));
        mMoney.setText(PrefUtil.getStringPref(this, "xu"));
        mOk.setOnClickListener(okAction);
    }
    /** . */
    private OnClickListener okAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (!mProductkey.getText().toString().equals("")) {
                mCurrentDialog = ProgressDialog.show(AccountAddXuActivity.this, null, getString(R.string.menu_waiting),
                        true);
                mCurrentDialog.setOnDismissListener(AccountAddXuActivity.this);
                mIsWaiting = true;
                Thread t = new Thread() {
                    public void run() {
                        status = getResultXu(mUsername.getText().toString(), mProductkey.getText().toString());
                        if (status.equals("false")) {
                            status = getString(R.string.add_xu_fasle);
                            flag = false;
                        } else if (status.equals("true")) {
                            status = getString(R.string.add_xu_true);
                            flag = true;
                        }
                        mCurrentDialog.dismiss();
                    }
                };
                t.start();

            } else {
                Toast.makeText(AccountAddXuActivity.this, getString(R.string.add_xu_addproductkey), Toast.LENGTH_LONG)
                        .show();
            }
        }
    };

    /**
     * @param username - username of customer
     * @param productkey - productkey Xu
     * @return 0 - not correct product key; 1 - successful; -1 - username customer not exist
     */
    public String getResultXu(String username, String productkey) {
        String json = mEngine.mQueryURL(PrefUtil.getStringPref(AccountAddXuActivity.this, "linkserver")
                + "/getActiveXU.vn?flag=stp&content=" + username + "@" + productkey);
        return parseJSONXu(json);
    }
    /**
     * @param json - parsejson
     * @return 0 - not correct product key; 1 - successful; -1 - username customer not exist
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

    /**
     * [Give the description for method].
     * @return App
     */
    public App getApp() {
        return (App) getApplication();
    }
    /** . */
    private boolean flag = false;
    /** . */
    private String status;
    /** . */
    private boolean mIsWaiting;
    /** . */
    private TextView mUsername;
    /** . */
    private TextView mMoney;
    /** . */
    private EditText mProductkey;
    /** . */
    private Button mOk;
    /** . */
    private Engine mEngine;
    /** . */
    private Dialog mCurrentDialog;

    /*
     * (non-Javadoc)
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        Toast.makeText(AccountAddXuActivity.this, status, Toast.LENGTH_LONG).show();
        if (flag) {
            mMoney.setText(mEngine.mGetXu(AccountAddXuActivity.this, mUsername.getText().toString(),
                    PrefUtil.getStringPref(AccountAddXuActivity.this, "password")));
            PrefUtil.setPref(AccountAddXuActivity.this, "xu", mMoney.getText());
            mProductkey.setText("");
        }
        mCurrentDialog.cancel();
    }
}
