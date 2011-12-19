/**
 * 
 */
package kltn.client.android_staff.activity;

import java.util.Vector;

import object.chat;
import object.delivery;
import kltn.client.android_staff.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class chatActivity extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_content);
		mlistchat=(ListView)findViewById(R.id.listView_chat_content);
		datachat=new Vector<chat>();
		datachat.add(new chat("Tới ngã tư", "16/12/2011", false));
		datachat.add(new chat("Ok ", "16/12/2011", true));
		mlistchat.setAdapter(new mlistAdapter());
	}
	private ListView mlistchat;
	private Vector<chat> datachat;
	
	public class mlistAdapter extends BaseAdapter{  

		@Override  
		public int getCount() {
			return datachat.size();  
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
				convertView = getLayoutInflater().inflate(R.layout.item_chat, null);  
			ImageView image=(ImageView)convertView.findViewById(R.id.item_chat_image);
			TextView content=(TextView)convertView.findViewById(R.id.item_chat_cos);
			TextView date=(TextView)convertView.findViewById(R.id.item_chat_date);
			try{
				chat item=datachat.get(position);
				if(item.person==false){
					image.setBackgroundResource(R.drawable.manager_icon);
				}
				else
					image.setBackgroundResource(R.drawable.icon_person);
				content.setText(item.content);
				date.setText(item.date);
				
//				msgoods.setText(item.MSgoods);
//				goodsname.setText(item.GoodsName);
//				customer.setText(item.CustomerName);
//				phone.setText(item.Phone);
//				address.setText(item.Address);
//				price.setText(item.Price);
			}catch (Exception e) {
				System.out.println("dsdsd");
			}
			return convertView;
		}  
	};
}
