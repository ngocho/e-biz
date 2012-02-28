package kltn.client.android_staff.activity;

import kltn.client.android_staff.R;
import kltn.client.android_staff.engine.Engine;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author nthanhphong
 */
public class LoginActivity extends Activity {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        edtPassword = (EditText) findViewById(R.id.edt_login_password);
        edtUsername = (EditText) findViewById(R.id.edt_login_username);
        btnExit = (Button) findViewById(R.id.btn_login_exit);
        btnOk = (Button) findViewById(R.id.btn_login_ok);
        btnExit.setOnClickListener(actionExit);
        btnOk.setOnClickListener(actionOk);
        mengine = new Engine();
    }
    /** . */
    private OnClickListener actionOk = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (!mengine.login(edtUsername.getText().toString(), edtPassword.getText().toString())) {
                Toast.makeText(LoginActivity.this, R.string.login_fasle, Toast.LENGTH_SHORT).show();
            } else {
                finish();
                Intent i = new Intent(LoginActivity.this, DeliveryActivity.class);
                startActivity(i);
            }
        }
    };
    /**  . */
    private OnClickListener actionExit = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();
        }
    };
    /**  . */
    private EditText edtUsername, edtPassword;
    /**  . */
    private Button btnOk, btnExit;
    /**  . */
    private Engine mengine;
}
