/**
 * 
 */
package kltn.client.android_client.activity;


import kltn.client.android_client.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author nthanhphong
 *
 */
public class imageActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_activity);
		gallery=(Gallery)findViewById(R.id.image_activity_gallery);
		back=(Button)findViewById(R.id.image_activity_back);
		save=(Button)findViewById(R.id.image_activity_save);
		number=(TextView)findViewById(R.id.image_activity_number);
		image=(ImageView)findViewById(R.id.image_activity_content);
		gallery.setAdapter(new AddImgAdp(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position,  long id) {
				image.setImageResource(R.drawable.back);
				number.setText((position+1)+"/"+gallery.getCount());
			}
		});
		back.setOnClickListener(backAction);
		save.setOnClickListener(saveAction);
	}
	public OnClickListener saveAction=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};
	public OnClickListener backAction=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};
	public class AddImgAdp extends BaseAdapter {
		int GalItemBg;
		private Context cont;


		public AddImgAdp(Context c) {
			cont = c;
			TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);
			GalItemBg = typArray.getResourceId(
					R.styleable.GalleryTheme_android_galleryItemBackground, 0);
			typArray.recycle();
		}


		public int getCount() {
			return 2;
		}


		public Object getItem(int position) {
			return position;
		}


		public long getItemId(int position) {
			return position;
		}


		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imgView = new ImageView(cont);
			//              imgView.setImageResource(Imgid[position]);
			imgView.setLayoutParams(new Gallery.LayoutParams(80, 70));
			imgView.setScaleType(ImageView.ScaleType.FIT_XY);
			imgView.setBackgroundResource(R.drawable.back);
			return imgView;
		}
	}
	private Gallery gallery;
	private Button back,save;
	private TextView number;
	private ImageView image;
}
