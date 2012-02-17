/**
 * 
 */
package kltn.client.android_client.activity;

import kltn.client.android_client.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class detail_food extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_food_activity);
		subbuy=(TextView)findViewById(R.id.detail_food_sub);
		price=(TextView)findViewById(R.id.detail_food_price);
		buyprice=(TextView)findViewById(R.id.detail_food_buyprice);
		title=(TextView)findViewById(R.id .detail_title);
		countbuy=(TextView)findViewById(R.id.detail_food_count);
		back=(Button)findViewById(R.id.detail_back);
		ok=(Button)findViewById(R.id.detail_food_ok);
		ok.setOnClickListener(okaction);
		back.setOnClickListener(backaction);
		introduction=(Button)findViewById(R.id.detail_food_tab_content);
		image=(Button)findViewById(R.id.detail_food_tab_image);
		comment=(Button)findViewById(R.id.detail_food_tab_comment);
		stores=(Button)findViewById(R.id.detail_food_tab_contact);
	}
	private OnClickListener okaction=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		}
	};
	private OnClickListener backaction=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		}
	};
	private TextView subbuy,price,buyprice,title,hour,minute,second,countbuy;
	private Button back,ok,introduction,image,comment,stores;
}
