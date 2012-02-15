/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * @author nthanhphong
 *
 */
public class TabBestActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_best); 
		mList=(ListView)findViewById(R.id.tab_best_list);
		mList.setAdapter(new BestAdapter(this));
	}
	public class BestAdapter extends BaseAdapter{  
		Context context;
		public BestAdapter(Context mycontext) {
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
				convertView = getLayoutInflater().inflate(R.layout.item_best, null);  
//			ImageView image=(ImageView)convertView.findViewById(R.id.item_deals_image);
//			image.setImageResource(R.color.black);
			return convertView;
		}  

	};
	private ListView mList;
}
