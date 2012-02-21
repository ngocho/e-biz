/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class SavedSearchActivity extends Activity implements OnClickListener,TextWatcher{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_search_activity);
		mBack=(Button)findViewById(R.id.save_search_back);
		mListview=(ListView)findViewById(R.id.save_search_listView);
		mOk=(Button)findViewById(R.id.save_search_ok);
		mEdittext=(EditText)findViewById(R.id.save_search_edit);
		mListview.setAdapter(new SaveSearchAdapter(this));
		mBack.setOnClickListener(this);
		mOk.setOnClickListener(this);
		mEdittext.addTextChangedListener(this);
	}
	public class SaveSearchAdapter extends BaseAdapter{  
		Context context;
		public SaveSearchAdapter(Context mycontext) {
			context=mycontext;
		}
		@Override  
		public int getCount() {
			return 3;  
		}  

		@Override  
		public Object getItem(int position) {  
			return null;  
		}  

		@Override  
		public long getItemId(int position) {  
			return 0;  
		}  

		@Override  
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView==null)
				convertView = getLayoutInflater().inflate(R.layout.item_search, null);  
			//			ImageView image=(ImageView)convertView.findViewById(R.id.item_deals_image);
			//			image.setImageResource(R.color.black);
			//TextView name=(TextView)convertView.findViewById(R.id.item_search_name);
			ImageView image=(ImageView)convertView.findViewById(R.id.item_search_image);
			BitmapManager.INSTANCE.loadBitmap("http://7.test-kltn1.appspot.com/serveImage.vn?urlKey=AMIfv95gfOgW1fEUNHwvmhR3n_m_wY8Z6lFee_4-oJt5NOenUL8Lv9NzmzIt5Gqg-E70k3VCQiNMNpnO9sBu0xi6lZpRsCWZ9cSU36sJP14HqdAkrewpZo3bsqTAmSuUyCCGqKS0L3cCbvXhIYxKruvo2hFcpnfnZg", image, 100, 100);
			return convertView;
		}  

	};
	private Button mBack;
	private ListView mListview;
	private Button mOk;
	private EditText mEdittext;
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.save_search_ok:
			mOk.setBackgroundResource(R.drawable.search_button_none);
			mEdittext.setText("");
			break;
		case R.id.save_search_back:
			Intent home=new Intent(SavedSearchActivity.this,MenuActivity.class);
			home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(home);
			finish();
			break;
		}
	}
	/* (non-Javadoc)
	 * @see android.text.TextWatcher#afterTextChanged(android.text.Editable)
	 */
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}
	/* (non-Javadoc)
	 * @see android.text.TextWatcher#beforeTextChanged(java.lang.CharSequence, int, int, int)
	 */
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}
	/* (non-Javadoc)
	 * @see android.text.TextWatcher#onTextChanged(java.lang.CharSequence, int, int, int)
	 */
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		if(s.length()>0){
			mOk.setBackgroundResource(R.drawable.search_button_cancel);
		}
	}
}
