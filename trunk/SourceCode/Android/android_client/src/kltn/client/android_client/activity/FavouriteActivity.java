/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class FavouriteActivity extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favourite_activity);
		mBack=(Button)findViewById(R.id.favourite_back);
		mAdvance=(Button)findViewById(R.id.favourite_advance);
		mList=(ListView)findViewById(R.id.favourite_listView);
		mCount=(TextView)findViewById(R.id.favourite_count);
		mFavouriteAdapter =new FavouriteAdapter(this);
		mList.setAdapter(mFavouriteAdapter);
		mCount.setText(mList.getCount()+" "+getString(R.string.item));
		mBack.setOnClickListener(this);
		mAdvance.setOnClickListener(this);
	}
	public class FavouriteAdapter extends BaseAdapter{  
		Context context;
		public FavouriteAdapter(Context mycontext) {
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
				convertView = getLayoutInflater().inflate(R.layout.item_favourite, null);  
			//			ImageView image=(ImageView)convertView.findViewById(R.id.item_deals_image);
			//			image.setImageResource(R.color.black);
			TextView name=(TextView)convertView.findViewById(R.id.item_favourite_name);
			ImageView image=(ImageView)convertView.findViewById(R.id.item_favourite_image);
			BitmapManager.INSTANCE.loadBitmap("http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg", image, 100, 100);
			TextView price=(TextView)convertView.findViewById(R.id.item_favourite_buy);
			TextView endprice=(TextView)convertView.findViewById(R.id.item_favourite_buyend);
			TextView date=(TextView)convertView.findViewById(R.id.item_favourite_date);
			CheckBox flag=(CheckBox)convertView.findViewById(R.id.item_favourite_flag);
			if(mflag)
				flag.setVisibility(0);
			else 
				flag.setVisibility(4);
			return convertView;
		}  
	};
	private boolean mflag=false;
	private Button mBack;
	private Button mAdvance;
	private ListView mList;
	private TextView mCount;
	private FavouriteAdapter mFavouriteAdapter;
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.favourite_back:
			Intent menu=new Intent(FavouriteActivity.this,MenuActivity.class);
			menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			menu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(menu);
			finish();
			break;
		case R.id.favourite_advance:
			if(mflag){
				mflag=false;
				mFavouriteAdapter.notifyDataSetChanged();
				mAdvance.setText(R.string.favourite_advance_a);
			}
			else{ 
				mflag=true;
				mFavouriteAdapter.notifyDataSetChanged();
				mAdvance.setText(R.string.favourite_advance_b);
			}
			break;
		}
	}
}
