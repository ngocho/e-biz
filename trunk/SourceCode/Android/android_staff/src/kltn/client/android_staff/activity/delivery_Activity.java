/**
 * 
 */
package kltn.client.android_staff.activity;

import java.util.Locale;
import java.util.Vector;

import object.delivery;

import kltn.client.android_staff.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class delivery_Activity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delivery_content);
		mlistviewDelivery=(ListView)findViewById(R.id.listView_delivery_content);
		data_delivery=new Vector<delivery>();
		data_delivery.add(new delivery("D2", "P3", "Tủ lạnh Panasonic", "4.000.000 VNĐ", "Phú Nhuận", "01229905085", "A.Long", "1.675", "34.8966", false));
		mlistAdapter adapter=new mlistAdapter();
		mlistviewDelivery.setAdapter(adapter);
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		 
		// Vibrate for 300 milliseconds
		v.vibrate(300);
	}
	private ListView mlistviewDelivery;
	Vector<delivery> data_delivery;
	public class mlistAdapter extends BaseAdapter{  

		@Override  
		public int getCount() {
			return data_delivery.size();  
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
				convertView = getLayoutInflater().inflate(R.layout.item_delivery, null);  
			ImageView image=(ImageView)convertView.findViewById(R.id.item_delivery_image);
			TextView msgoods=(TextView)convertView.findViewById(R.id.item_delivery_MSgoods);
			TextView goodsname=(TextView)convertView.findViewById(R.id.item_delivery_goodsname);
			TextView customer=(TextView)convertView.findViewById(R.id.item_delivery_customer);
			TextView phone=(TextView)convertView.findViewById(R.id.item_delivery_phone);
			TextView address=(TextView)convertView.findViewById(R.id.item_delivery_address);
			TextView price=(TextView)convertView.findViewById(R.id.item_delivery_price);
			try{
				delivery item=data_delivery.get(position);
				msgoods.setText(item.MSgoods);
				goodsname.setText(item.GoodsName);
				customer.setText(item.CustomerName);
				phone.setText(item.Phone);
				address.setText(item.Address);
				price.setText(item.Price);
			}catch (Exception e) {
				System.out.println("dsdsd");
			}
			return convertView;
		}  
	};
	public void showDialogDetail(){
		
	}
}
