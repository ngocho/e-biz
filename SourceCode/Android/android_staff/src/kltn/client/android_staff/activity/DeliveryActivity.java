package kltn.client.android_staff.activity;

import java.util.Vector;

import kltn.client.android_staff.R;
import object.delivery;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author nthanhphong
 */
public class DeliveryActivity extends Activity implements OnClickListener {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_content);
        mlistviewDelivery = (ListView) findViewById(R.id.listView_delivery_content);
        menudelivery = (ImageButton) findViewById(R.id.delivery_home);
        menufood = (ImageButton) findViewById(R.id.delivery_food);
        menustatistic = (ImageButton) findViewById(R.id.delivery_statistic);
        memuchat = (ImageButton) findViewById(R.id.delivery_chat);

        datadelivery = new Vector<delivery>();
        datadelivery.add(new delivery("D2", "P3", "Tủ lạnh Panasonic", "4.000.000 VNĐ", "Phú Nhuận", "01229905085",
                "A.Long", "1.675", "34.8966", false));
        MlistAdapter adapter = new MlistAdapter();
        mlistviewDelivery.setAdapter(adapter);
        // Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //
        // // Vibrate for 300 milliseconds
        // v.vibrate(300);
    }
    /** . */
    private ImageButton menudelivery, menustatistic, memuchat, menufood;
    /** . */
    private ListView mlistviewDelivery;
    /** . */
    private Vector<delivery> datadelivery;
    /**
     * @author NThanhPhong
     */
    public class MlistAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datadelivery.size();
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
                convertView = getLayoutInflater().inflate(R.layout.item_delivery, null);
            }
            ImageView image = (ImageView) convertView.findViewById(R.id.item_delivery_image);
            TextView msgoods = (TextView) convertView.findViewById(R.id.item_delivery_MSgoods);
            TextView goodsname = (TextView) convertView.findViewById(R.id.item_delivery_goodsname);
            TextView customer = (TextView) convertView.findViewById(R.id.item_delivery_customer);
            TextView phone = (TextView) convertView.findViewById(R.id.item_delivery_phone);
            TextView address = (TextView) convertView.findViewById(R.id.item_delivery_address);
            TextView price = (TextView) convertView.findViewById(R.id.item_delivery_price);
            try {
                final delivery item = datadelivery.get(position);
                msgoods.setText(item.MSgoods);
                goodsname.setText(item.GoodsName);
                customer.setText(item.CustomerName);
                phone.setText(item.Phone);
                address.setText(item.Address);
                price.setText(item.Price);
                convertView.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        showDialogDetail(item);
                    }
                });
            } catch (Exception e) {
                System.out.println("dsdsd");
            }
            return convertView;
        }
    };
    /**
     * [Give the description for method].
     * @param item delivery
     */
    public void showDialogDetail(delivery item) {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_detail);
        dialog.setCancelable(true);
        TextView msgoods = (TextView) dialog.findViewById(R.id.dialog_delivery_MSgoods);
        TextView goodsname = (TextView) dialog.findViewById(R.id.dialog_delivery_goodsname);
        TextView customer = (TextView) dialog.findViewById(R.id.dialog_delivery_customer);
        TextView phone = (TextView) dialog.findViewById(R.id.dialog_delivery_phone);
        TextView address = (TextView) dialog.findViewById(R.id.dialog_delivery_address);
        TextView price = (TextView) dialog.findViewById(R.id.dialog_delivery_price);
        TextView date = (TextView) dialog.findViewById(R.id.dialog_delivery_date);
        EditText note = (EditText) dialog.findViewById(R.id.dialog_delivery_note);
        CheckBox check = (CheckBox) dialog.findViewById(R.id.dialog_delivery_check);
        Button ok = (Button) dialog.findViewById(R.id.dialog_delivery_ok);
        Button map = (Button) dialog.findViewById(R.id.dialog_delivery_map);
        Button close = (Button) dialog.findViewById(R.id.dialog_delivery_close);
        msgoods.setText(item.MSgoods);
        goodsname.setText(item.GoodsName);
        customer.setText(item.CustomerName);
        phone.setText(item.Phone);
        address.setText(item.Address);
        price.setText(item.Price);
        date.setText("");
        note.setText("");
        check.setChecked(false);
        close.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        map.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(DeliveryActivity.this, mapActivity.class);
                startActivity(i);
                dialog.cancel();
            }
        });
        dialog.show();
    }
    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delivery_chat :
                Intent chat = new Intent(DeliveryActivity.this, ChatActivity.class);
                startActivity(chat);
                break;
            case R.id.delivery_food :
                Intent food = new Intent(DeliveryActivity.this, DeliveryActivity.class);
                startActivity(food);
                break;
            case R.id.delivery_home :
                Intent home = new Intent(DeliveryActivity.this, DeliveryActivity.class);
                startActivity(home);
                break;
            case R.id.delivery_statistic :
                Intent statistic = new Intent(DeliveryActivity.this, DeliveryActivity.class);
                startActivity(statistic);
                break;
            default :
                break;
        }
    }
}
