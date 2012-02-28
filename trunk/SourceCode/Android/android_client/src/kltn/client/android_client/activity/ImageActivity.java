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
 * @author NThanhPhong
 */
public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        gallery = (Gallery) findViewById(R.id.image_activity_gallery);
        back = (Button) findViewById(R.id.image_activity_back);
        save = (Button) findViewById(R.id.image_activity_save);
        number = (TextView) findViewById(R.id.image_activity_number);
        image = (ImageView) findViewById(R.id.image_activity_content);
        gallery.setAdapter(new AddImgAdp(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                image.setImageResource(R.drawable.back);
                number.setText((position + 1) + "/" + gallery.getCount());
            }
        });
        back.setOnClickListener(backAction);
        save.setOnClickListener(saveAction);
    }

    /** saveAction. */
    private OnClickListener saveAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

        }
    };
    /**  . */
    private OnClickListener backAction = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

        }
    };
    /**
     * @author NThanhPhong
     *
     */
    public class AddImgAdp extends BaseAdapter {
        /**  . */
        private int mGalItemBg;
        /**  . */
        private Context cont;

        /**
         * @param c Context
         */
        public AddImgAdp(Context c) {
            cont = c;
            TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);
            mGalItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
            typArray.recycle();
        }

        /**
         * [Explain the description for this method here].
         * @return int
         * @see android.widget.Adapter#getCount()
         */
        public int getCount() {
            return 2;
        }

        /**
         * [Explain the description for this method here].
         * @param position int
         * @return Object
         * @see android.widget.Adapter#getItem(int)
         */
        public Object getItem(int position) {
            return position;
        }

        /**
         * [Explain the description for this method here].
         * @param position int
         * @return long
         * @see android.widget.Adapter#getItemId(int)
         */
        public long getItemId(int position) {
            return position;
        }

        /**
         * [Explain the description for this method here].
         * @param position int
         * @param convertView View
         * @param parent ViewGroup
         * @return View
         * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgView = new ImageView(cont);
            // imgView.setImageResource(Imgid[position]);
            imgView.setLayoutParams(new Gallery.LayoutParams(80, 70));
            imgView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgView.setBackgroundResource(R.drawable.back);
            return imgView;
        }
    }
    /**  . */
    private Gallery gallery;
    /**  . */
    private Button back, save;
    /**  . */
    private TextView number;
    /**  . */
    private ImageView image;
}
