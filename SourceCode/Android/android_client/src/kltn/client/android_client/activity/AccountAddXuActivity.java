/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.App;
import kltn.client.android_client.R;
import kltn.client.android_client.engine.engine;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author nthanhphong
 * 
 */
public class AccountAddXuActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
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
		mEngine = new engine();
	}

	public OnClickListener okAction = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(AccountAddXuActivity.this, R.string.app_name,
					Toast.LENGTH_LONG);
		}
	};

	/**
	 * 
	 * @param username
	 *            - username of customer
	 * @param productkey
	 *            - productkey Xu
	 * @return 0 - not correct product key; 1 - successful; -1 - username
	 *         customer not exist
	 */
	public int getResultXu(String username, String productkey) {
		String json = mEngine
				.Query_URL("http://10.uit-kltn.appspot.com/getActiveXU.vn?flag=stp&content="
						+ username + "@" + productkey);
		return ParseJSON_Xu(json);
	}

	/**
	 * 
	 * @param json
	 *            - parsejson
	 * @return 0 - not correct product key; 1 - successful; -1 - username
	 *         customer not exist
	 */
	private int ParseJSON_Xu(String json) {
		int jResult = 0;
		try {
			JSONArray JsonArray_phone = new JSONArray(json);
			JSONObject item = JsonArray_phone.getJSONObject(0);
			jResult = item.getInt("flag");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jResult;
	}

	public App getApp() {
		return (App) getApplication();
	}

	private TextView mUsername;
	private TextView mMoney;
	private EditText mProductkey;
	private Button mOk;
	private engine mEngine;
}
