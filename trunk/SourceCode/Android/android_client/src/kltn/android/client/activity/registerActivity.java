/**
 * 
 */
package kltn.android.client.activity;

import kltn.android.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * @author nthanhphong
 *
 */
public class registerActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_content);
		nickname=(EditText)findViewById(R.id.register_nickname);
		password=(EditText)findViewById(R.id.register_password);
		fullname=(EditText)findViewById(R.id.register_fullname);
		email=(EditText)findViewById(R.id.register_mail);
		phone=(EditText)findViewById(R.id.register_phone);
		address=(EditText)findViewById(R.id.register_address);
		birthday=(EditText)findViewById(R.id.register_birthday);
		back=(Button)findViewById(R.id.register_back);
		ok=(Button)findViewById(R.id.register_back);
		male=(CheckBox)findViewById(R.id.register_male);
		female=(CheckBox)findViewById(R.id.register_female);
		check=(CheckBox)findViewById(R.id.register_check);
		//password=(EditText)findViewById(R.id.)
	}
	private EditText nickname,password,fullname,email,phone,address,birthday;
	private Button back,ok;
	private CheckBox male,female,check;
}
