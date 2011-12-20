/**
 * 
 */
package kltn.client.android_staff.activity;

import java.util.Vector;

import object.chat;
import object.delivery;
import kltn.client.android_staff.R;
import kltn.client.android_staff.engine.ChatEngine;
import kltn.client.android_staff.engine.engine;
import kltn.client.android_staff.model.chat_item;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
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
public class chatActivity extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_content);
		mengine=new engine();
		chat_engine=new ChatEngine(this);
		data=chat_engine.getAllSortByDate();
		
		mlistchat=(ListView)findViewById(R.id.listView_chat_content);
		datachat=new Vector<chat>();
		datachat.add(new chat("Tới ngã tư", "16/12/2011", false));
		datachat.add(new chat("Ok ", "16/12/2011", true));
		madapter=new mlistAdapter();
		mlistchat.setAdapter(madapter);
		btn_send=(Button)findViewById(R.id.chat_content_send);
		edt_des=(EditText)findViewById(R.id.chat_content_des);
		btn_send.setOnClickListener(this);
		
	}
	private ChatEngine chat_engine;
	private ListView mlistchat;
	private Vector<chat> datachat;
	private Button btn_send;
	private EditText edt_des;
	private Cursor data;
	private mlistAdapter madapter;
	
	public class mlistAdapter extends BaseAdapter{  

		@Override  
		public int getCount() {
			return data.getCount();  
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
				data.moveToPosition(position);
				chat_item item=new chat_item(data.getString(data.getColumnIndex("message")), data.getString(data.getColumnIndex("date")),data.getInt(data.getColumnIndex("state")));
				if(item.getState()==0){
					image.setBackgroundResource(R.drawable.manager_icon);
				}
				else
					image.setBackgroundResource(R.drawable.icon_person);
				content.setText(item.getMessage());
				date.setText(item.getDate());
				
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
	}
	private engine mengine;
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.chat_content_send:
				String messagereceive=mengine.sendMessageChat("123", edt_des.getText().toString());
				if(!messagereceive.equals("")){
					chat_engine.add(new chat_item(messagereceive, "12/12/2011", 0));
				}
				chat_engine.add(new chat_item(edt_des.getText().toString(), "12/02/2011",1));
				edt_des.setText("");
			data=chat_engine.getAllSortByDate();
			madapter.notifyDataSetChanged();
			break;
		}
	}
}
