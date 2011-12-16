/**
 * 
 */
package kltn.client.android_staff.activity;

import kltn.client.android_staff.R;
import kltn.client.android_staff.engine.engine;
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
 *
 */
public class loginActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		edt_password=(EditText)findViewById(R.id.edt_login_password);
		edt_username=(EditText)findViewById(R.id.edt_login_username);
		btn_exit=(Button)findViewById(R.id.btn_login_exit);
		btn_ok=(Button)findViewById(R.id.btn_login_ok);
		btn_exit.setOnClickListener(action_exit);
		btn_ok.setOnClickListener(action_ok);
		mengine=new engine();
	}
	private OnClickListener action_ok=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(!mengine.login(edt_username.getText().toString(), edt_password.getText().toString()))
					Toast.makeText(loginActivity.this, R.string.login_fasle, Toast.LENGTH_SHORT).show();
			else{
				finish();
				Intent i=new Intent(loginActivity.this,loginActivity.class);
				startActivity(i);
			}
		}
	};
	private OnClickListener action_exit=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};
	private EditText edt_username,edt_password;
	private Button btn_ok,btn_exit;
	private engine mengine;
}
