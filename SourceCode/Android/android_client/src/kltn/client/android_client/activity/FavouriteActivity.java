/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class FavouriteActivity extends Activity{

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
		mList.setAdapter(new FavouriteAdapter(this));
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
			return convertView;
		}  

	};
	private Button mBack;
	private Button mAdvance;
	private ListView mList;
	private TextView mCount;
}
