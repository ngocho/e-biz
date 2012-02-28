package kltn.client.android_staff.activity;

import java.util.Vector;

import kltn.client.android_staff.R;
import kltn.client.android_staff.engine.ChatEngine;
import kltn.client.android_staff.engine.Engine;
import kltn.client.android_staff.model.ChatItem;
import kltn.client.android_staff.object.Chat;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 */
public class ChatActivity extends Activity implements OnClickListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_content);
        mengine = new Engine();
        chatengine = new ChatEngine(this);
        data = chatengine.getAllSortByDate();

        mlistchat = (ListView) findViewById(R.id.listView_chat_content);
        datachat = new Vector<Chat>();
        datachat.add(new Chat("Tới ngã tư", "16/12/2011", false));
        datachat.add(new Chat("Ok ", "16/12/2011", true));
        madapter = new MListAdapter();
        mlistchat.setAdapter(madapter);
        btnsend = (Button) findViewById(R.id.chat_content_send);
        edtdes = (EditText) findViewById(R.id.chat_content_des);
        btnsend.setOnClickListener(this);

    }
    /** . */
    private ChatEngine chatengine;
    /** . */
    private ListView mlistchat;
    /** . */
    private Vector<Chat> datachat;
    /** . */
    private Button btnsend;
    /** . */
    private Cursor data;
    /** . */
    private EditText edtdes;
    /** . */
    private MListAdapter madapter;

    /**
     * @author NThanhPhong
     */
    public class MListAdapter extends BaseAdapter {

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
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_chat, null);
            }
            ImageView image = (ImageView) convertView.findViewById(R.id.item_chat_image);
            TextView content = (TextView) convertView.findViewById(R.id.item_chat_cos);
            TextView date = (TextView) convertView.findViewById(R.id.item_chat_date);
            try {
                data.moveToPosition(position);
                ChatItem item = new ChatItem(data.getString(data.getColumnIndex("message")), data.getString(data
                        .getColumnIndex("date")), data.getInt(data.getColumnIndex("state")));
                if (item.getState() == 0) {
                    image.setBackgroundResource(R.drawable.manager_icon);
                } else {
                    image.setBackgroundResource(R.drawable.icon_person);
                }
                content.setText(item.getMessage());
                date.setText(item.getDate());

                // msgoods.setText(item.MSgoods);
                // goodsname.setText(item.GoodsName);
                // customer.setText(item.CustomerName);
                // phone.setText(item.Phone);
                // address.setText(item.Address);
                // price.setText(item.Price);
            } catch (Exception e) {
                System.out.println("dsdsd");
            }
            return convertView;
        }
    }
    /** . */
    private Engine mengine;
    /**
     * [Explain the description for this method here].
     * @param v View
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chat_content_send :
                String messagereceive = mengine.sendMessageChat("123", edtdes.getText().toString());
                if (!messagereceive.equals("")) {
                    chatengine.add(new ChatItem(messagereceive, "12/12/2011", 0));
                }
                chatengine.add(new ChatItem(edtdes.getText().toString(), "12/02/2011", 1));
                edtdes.setText("");
                data = chatengine.getAllSortByDate();
                madapter.notifyDataSetChanged();
                break;
            default :
                break;
        }
    }
}
