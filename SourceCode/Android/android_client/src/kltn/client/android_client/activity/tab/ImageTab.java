//======================================================================================================

package kltn.client.android_client.activity.tab;

import kltn.client.android_client.R;
import kltn.client.android_client.engine.BitmapManager;
import kltn.client.android_client.engine.Engine;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

//======================================================================================================

/**
 * @author NThanhPhong
 */
public class ImageTab extends BaseTab {
    // ======================================================================================================

    /** . */
    private JSONObject mData;
    /** . */
    private Gallery mGallery;
    /** . */
    private Engine mEngine;

    // ======================================================================================================

    /**
     * @param activity Activity
     * @param mdata JSONObject
     */
    public ImageTab(Activity activity, JSONObject mdata) {
        super(activity);
        mData = mdata;
    }

    @Override
    public void Initialize() {
        this.mView = this.mParentActivity.getLayoutInflater().inflate(R.layout.tab_detail_image, null);
        mGallery = (Gallery) this.mView.findViewById(R.id.tab_detail_image_gallery);
        mEngine = new Engine();
        mGallery.setAdapter(new AddImgAdp(this.mParentActivity));
    }

    @Override
    public void Release() {
    }

    @Override
    public void pressBackKey() {

    }

    @Override
    public int whichViewDisplay() {
        return 0;
    }
    /**
     * @author NThanhPhong
     */
    public class AddImgAdp extends BaseAdapter {
        /** . */
        private int mGalItemBg;
        /** . */
        private Context cont;

        /**
         * @param c Context
         */
        public AddImgAdp(Context c) {
            cont = c;
            TypedArray typArray = cont.obtainStyledAttributes(R.styleable.GalleryTheme);
            mGalItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
            typArray.recycle();
        }

        /**
         * [Explain the description for this method here].
         * @return int
         * @see android.widget.Adapter#getCount()
         */
        public int getCount() {
            return 1;
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
            imgView.setLayoutParams(new Gallery.LayoutParams(250, 250));
            imgView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgView.setBackgroundResource(R.drawable.loading);
            try {
                BitmapManager.INSTANCE.loadBitmap(mEngine.getUrlImage(this.cont) + mData.getString("image"), imgView,
                        250, 250);
            } catch (Exception e) {
                System.out.println(e);
            }
            return imgView;
        }
    }
}
