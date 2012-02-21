/**
 * 
 */
package kltn.client.android_client.activity;

import java.util.Vector;

import kltn.client.android_client.R;
import kltn.client.android_client.activity.TabDealsActivity.DealsAdapter;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.engine.Engine;
import kltn.client.android_client.model.best_food_item;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class TabBestActivity extends Activity implements OnClickListener,OnDismissListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_best); 
		mEngine=new Engine();
		mList=(ListView)findViewById(R.id.tab_best_list);
		mBack=(Button)findViewById(R.id.tab_best_back);
		mHome=(LinearLayout)findViewById(R.id.tab_best_home);
		mBest=(LinearLayout)findViewById(R.id.tab_best_best);
		mDeals=(LinearLayout)findViewById(R.id.tab_best_deal);
		mBrowser=(LinearLayout)findViewById(R.id.tab_best_browse);
		mBack.setOnClickListener(this);
		mHome.setOnClickListener(this);
		mBest.setOnClickListener(this);
		mDeals.setOnClickListener(this);
		mBrowser.setOnClickListener(this);
		LoadData();
	}
	public void LoadData(){
		mCurrentDialog = ProgressDialog.show(TabBestActivity.this, null,
				getString(R.string.menu_waiting), true);
		mCurrentDialog.setOnDismissListener(TabBestActivity.this);
		mIsWaiting = true;
		Thread t = new Thread() {
			public void run() {
				mData=mEngine.get_best_food();
				mCurrentDialog.dismiss();
			}
		};
		t.start();
	}
	public class BestAdapter extends BaseAdapter{  
		Context context;
		public BestAdapter(Context mycontext) {
			context=mycontext;
		}
		@Override  
		public int getCount() {
			return mData.size();  
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
				convertView = getLayoutInflater().inflate(R.layout.item_best, null);  
			ImageView image=(ImageView)convertView.findViewById(R.id.item_best_image);
			best_food_item item=mData.get(position);
			BitmapManager.INSTANCE.loadBitmap(mEngine.URL_Image+item.getImageurl(), image, 300, 300);
			TextView promotion=(TextView)convertView.findViewById(R.id.item_best_gt);
			TextView date=(TextView)convertView.findViewById(R.id.item_best_date);
			TextView price=(TextView)convertView.findViewById(R.id.item_best_price);
			TextView subprice=(TextView)convertView.findViewById(R.id.item_best_pricesub);
			TextView name=(TextView)convertView.findViewById(R.id.item_best_name);
			TextView buyprice=(TextView)convertView.findViewById(R.id.item_best_buyprice);
			TextView countbuyer=(TextView)convertView.findViewById(R.id.item_best_buycount);
			date.setText(item.getStartdate());
			price.setText(item.getPrice()+" "+getString(R.string.vnd));
			buyprice.setText(item.getBuyprice()+" "+getString(R.string.vnd));
			name.setText(item.getName());
			countbuyer.setText(String.valueOf(item.getBuycount()));
			try {
				int num_price,num_buyprice,s,pecent;
				num_price=Integer.parseInt(item.getPrice());
				num_buyprice=Integer.parseInt(item.getBuyprice());
				s=num_price-num_buyprice;
				subprice.setText(String.valueOf(s)+" "+getString(R.string.vnd));
				pecent=(int)((s*100)/num_price);
				promotion.setText(String.valueOf(pecent)+"%");
			} catch (Exception e) {
			}
			return convertView;
		}  
	};
	private ListView mList;
	private Button mBack;
	private LinearLayout mHome;
	private LinearLayout mDeals;
	private LinearLayout mBest;
	private LinearLayout mBrowser;
	private Dialog mCurrentDialog;
	private boolean mIsWaiting;
	private BestAdapter mAdapter;
	private Engine mEngine;
	public Vector<best_food_item> mData;
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		 case R.id.tab_best_back:
			 Intent menu=new Intent(TabBestActivity.this,MenuActivity.class);
			 menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			 startActivity(menu);
			 finish();
		 case R.id.tab_best_best:
			 break;
		 case R.id.tab_best_browse:
			 Intent browser=new Intent(TabBestActivity.this,TabBrowserActivity.class);
			 startActivity(browser);
			 finish();
			 break;
		 case R.id.tab_best_deal:
			 Intent deals=new Intent(TabBestActivity.this,TabDealsActivity.class);
			 startActivity(deals);
			 finish();
			 break;
		 case R.id.tab_best_home:
			 Intent home=new Intent(TabBestActivity.this,MenuActivity.class);
			 home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			 startActivity(home);
			 finish();
			 break;
		 }
	}
	
	/* (non-Javadoc)
	 * @see android.content.DialogInterface.OnDismissListener#onDismiss(android.content.DialogInterface)
	 */
	@Override
	public void onDismiss(DialogInterface dialog) {
		mIsWaiting = false;
		mAdapter=new BestAdapter(this);
		mList.setAdapter(mAdapter);
		mCurrentDialog.cancel();
	}
}