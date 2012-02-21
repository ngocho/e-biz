/**
 * 
 */
package kltn.client.android_client.activity;

import java.util.Vector;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.model.Browser_food_item;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class TabBrowserActivity extends Activity implements OnClickListener,TextWatcher{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_browser);
		mList=(ListView)findViewById(R.id.tab_browser_list);
		mList.setAdapter(new BrowserAdapter(this));
		mBack=(Button)findViewById(R.id.tab_browser_back);
		mHome=(LinearLayout)findViewById(R.id.tab_browser_home);
		mBest=(LinearLayout)findViewById(R.id.tab_browser_best);
		mBrowser=(LinearLayout)findViewById(R.id.tab_browser_browse);
		mDeal=(LinearLayout)findViewById(R.id.tab_browser_deal);
		mOk=(Button)findViewById(R.id.tab_browser_ok);
		mEdittext=(EditText)findViewById(R.id.tab_browser_edit);
		mBack.setOnClickListener(this);
		mHome.setOnClickListener(this);
		mDeal.setOnClickListener(this);
		mBest.setOnClickListener(this);
		mBrowser.setOnClickListener(this);
		mOk.setOnClickListener(this);
	}
	public class BrowserAdapter extends BaseAdapter{  
		Context context;
		public BrowserAdapter(Context mycontext) {
			context=mycontext;
		}
		@Override  
		public int getCount() {
			return mData.length;  
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
				convertView = getLayoutInflater().inflate(R.layout.item_browser, null);  
			TextView name=(TextView)convertView.findViewById(R.id.item_browser_name);
			name.setText(mData[position]);
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mBrowserItemAdapter=new BrowserItemAdapter();
					mList.setAdapter(mBrowserItemAdapter);
				}
			});
			return convertView;
		}  

	};
	public class BrowserItemAdapter extends BaseAdapter{  

		public BrowserItemAdapter() {
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
				convertView = getLayoutInflater().inflate(R.layout.item_browser_get, null);  
			ImageView image=(ImageView)convertView.findViewById(R.id.item_browser_get_image);
			BitmapManager.INSTANCE.loadBitmap("http://7.test-kltn1.appspot.com/serveImage.vn?urlKey=AMIfv95gfOgW1fEUNHwvmhR3n_m_wY8Z6lFee_4-oJt5NOenUL8Lv9NzmzIt5Gqg-E70k3VCQiNMNpnO9sBu0xi6lZpRsCWZ9cSU36sJP14HqdAkrewpZo3bsqTAmSuUyCCGqKS0L3cCbvXhIYxKruvo2hFcpnfnZg", image, 100, 100);
			return convertView;
		}  

	};
	private Vector<Browser_food_item> mBrowserData;
	private BrowserItemAdapter mBrowserItemAdapter;
	private int flag=0;
	private ListView mList;
	private Button mBack;
	private LinearLayout mHome;
	private LinearLayout mBest;
	private LinearLayout mDeal;
	private LinearLayout mBrowser;
	private EditText mEdittext;
	private Button mOk;
	private String[] mData={"Thực phẩm sơ chế","Thức ăn nấu sẵn","Rau xanh","Trái cây"};
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_browser_back:
			Intent menu=new Intent(TabBrowserActivity.this,MenuActivity.class);
			menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(menu);
			finish();
			break;
		case R.id.tab_browser_best:
			Intent best=new Intent(TabBrowserActivity.this,TabBestActivity.class);
			startActivity(best);
			finish();
			break;
		case R.id.tab_browser_browse:
			break;
		case R.id.tab_browser_deal:
			Intent deals=new Intent(TabBrowserActivity.this,TabDealsActivity.class);
			startActivity(deals);
			finish();
			break;
		case R.id.tab_browser_home:
			Intent home=new Intent(TabBrowserActivity.this,MenuActivity.class);
			home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(home);
			finish();
			break;
		case R.id.tab_browser_ok:
			mOk.setBackgroundResource(R.drawable.search_button_none);
			mEdittext.setText("");
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
