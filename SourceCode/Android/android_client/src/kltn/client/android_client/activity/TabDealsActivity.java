/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import kltn.client.android_client.ui.CircleFlowIndicator;
import kltn.client.android_client.ui.ViewFlow;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * @author nthanhphong
 *
 */
public class TabDealsActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_deals);
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		mAdapter=new DealsAdapter(this);
		viewFlow.setAdapter(mAdapter);
		init=(CircleFlowIndicator) findViewById(R.id.viewflowindic);
		init.setFillColor(R.color.blue);
		viewFlow.setFlowIndicator(init);
	}
	public class DealsAdapter extends BaseAdapter{  
		Context context;
		public DealsAdapter(Context mycontext) {
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
				convertView = getLayoutInflater().inflate(R.layout.item_deals, null);  
			ImageView image=(ImageView)convertView.findViewById(R.id.item_deals_image);
			image.setImageResource(R.color.black);
			return convertView;
		}  

	};
	private CircleFlowIndicator init;
	private ViewFlow viewFlow;
	private DealsAdapter mAdapter;
}
