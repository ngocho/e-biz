package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.Engine;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author NThanhPhong
 */
public class RegisterActivity extends Activity implements OnDismissListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_content);
        nickname = (EditText) findViewById(R.id.register_nickname);
        password = (EditText) findViewById(R.id.register_password);
        fullname = (EditText) findViewById(R.id.register_fullname);
        email = (EditText) findViewById(R.id.register_mail);
        phone = (EditText) findViewById(R.id.register_phone);
        address = (EditText) findViewById(R.id.register_address);
        birthday = (EditText) findViewById(R.id.register_birthday);
        back = (Button) findViewById(R.id.register_back);
        ok = (Button) findViewById(R.id.register_ok);
        male = (CheckBox) findViewById(R.id.register_male);
        female = (CheckBox) findViewById(R.id.register_female);
        check = (CheckBox) findViewById(R.id.register_check);
        back.setOnClickListener(backAction);
        ok.setOnClickListener(mOkAction);
        mEngine = new Engine();
        male.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                male.setChecked(true);
                female.setChecked(false);
            }
        });
        female.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                male.setChecked(false);
                female.setChecked(true);
            }
        });
    }
    /** . */
    private OnClickListener backAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            finish();
            Intent home = new Intent(RegisterActivity.this, MenuActivity.class);
            home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(home);
        }
    };
    /** . */
    private OnClickListener mOkAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            mCurrentDialog = ProgressDialog.show(RegisterActivity.this, null, getString(R.string.menu_waiting), true);
            mCurrentDialog.setOnDismissListener(RegisterActivity.this);
            mIsWaiting = true;
            Thread t = new Thread() {
                public void run() {
                    flag = mEngine.mRegister(RegisterActivity.this, nickname.getText().toString(), password.getText()
                            .toString(), fullname.getText().toString(), "male", email.getText().toString(), phone
                            .getText().toString(), address.getText().toString(), birthday.getText().toString());
                    mCurrentDialog.dismiss();
                }
            };
            t.start();
        }
    };
    /** . */
    private Engine mEngine;
    /** . */
    private boolean flag;
    /** . */
    private boolean mIsWaiting;
    /** . */
    private Dialog mCurrentDialog;
    /** . */
    private EditText nickname, password, fullname, email, phone, address, birthday;
    /** . */
    private Button back, ok;
    /** . */
    private CheckBox male, female, check;
    /*
     * (non-Javadoc)
     * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        mIsWaiting = false;
        if (flag) {
            Toast.makeText(RegisterActivity.this, getString(R.string.register_statusa), Toast.LENGTH_LONG).show();
            Intent menu = new Intent(RegisterActivity.this, MenuActivity.class);
            menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(menu);
            finish();
        } else {
            Toast.makeText(RegisterActivity.this, getString(R.string.register_statusb), Toast.LENGTH_LONG).show();
        }
    }
}
