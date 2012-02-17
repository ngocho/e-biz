/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * @author nthanhphong
 *
 */
public class TabBrowserActivity extends Activity implements OnClickListener{

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
		mList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(flag==0){
					mList.setAdapter(new BrowserItemAdapter(TabBrowserActivity.this));
					flag=1;
				}
				else {

				}

			}
		});
		mBack=(Button)findViewById(R.id.tab_browser_back);
		mHome=(LinearLayout)findViewById(R.id.tab_browser_home);
		mBest=(LinearLayout)findViewById(R.id.tab_browser_best);
		mBrowser=(LinearLayout)findViewById(R.id.tab_browser_browse);
		mDeal=(LinearLayout)findViewById(R.id.tab_browser_deal);
		mBack.setOnClickListener(this);
		mHome.setOnClickListener(this);
		mDeal.setOnClickListener(this);
		mBest.setOnClickListener(this);
		mBrowser.setOnClickListener(this);
	}
	public class BrowserAdapter extends BaseAdapter{  
		Context context;
		public BrowserAdapter(Context mycontext) {
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
				convertView = getLayoutInflater().inflate(R.layout.item_browser, null);  
			//			ImageView image=(ImageView)convertView.findViewById(R.id.item_deals_image);
			//			image.setImageResource(R.color.black);
			return convertView;
		}  

	};
	public class BrowserItemAdapter extends BaseAdapter{  
		Context context;
		public BrowserItemAdapter(Context mycontext) {
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
				convertView = getLayoutInflater().inflate(R.layout.item_browser_get, null);  
			//			ImageView image=(ImageView)convertView.findViewById(R.id.item_deals_image);
			//			image.setImageResource(R.color.black);
			return convertView;
		}  

	};
	private int flag=0;
	private ListView mList;
	private Button mBack;
	private LinearLayout mHome;
	private LinearLayout mBest;
	private LinearLayout mDeal;
	private LinearLayout mBrowser;
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		 case R.id.tab_browser_back:
			 Intent menu=new Intent(TabBrowserActivity.this,MenuActivity.class);
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
		 }
	}
}
