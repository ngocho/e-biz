//========================================================================================================

package kltn.client.android_client.engine.adapter;

import kltn.client.android_client.R;
import android.app.Activity;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//========================================================================================================

public class LastestAdapter extends MCursorAdapter {
    // ========================================================================================================

    Cursor mMonAnNameCursor;
    public LastestAdapter(Activity _activity) {
        super(_activity);
    }

    // ========================================================================================================

    @Override
    protected String GetQuery() {
        return "SELECT " + "MonAn_ID, MonAn_Name, MonAn_pic " + "FROM " + "MonAnDB " + "ORDER BY " + "MonAn_ID ASC";
    }
    protected String GetMonAnNameQuery() {
        return "SELECT " + "MonAn_ID, MonAn_Name " + "FROM " + "MonAnDB " + "ORDER BY " + "MonAn_ID ASC";
    }
    public void InitMonAnNameCursor() {
        // this.mMonAnNameCursor = MainEngine.GetInstance().Content().GetData(this.GetMonAnNameQuery());

        if (this.mMonAnNameCursor != null)
            this.mActivity.startManagingCursor(this.mMonAnNameCursor);
    }

    @Override
    public void Close() {
        if (this.mMonAnNameCursor != null) {
            if (!this.mMonAnNameCursor.isClosed()) {
                this.mActivity.stopManagingCursor(this.mMonAnNameCursor);
                this.mMonAnNameCursor.close();
            }

            this.mMonAnNameCursor = null;
        }
        super.Close();
    }

    // public Bitmap getItemImage(int position) {
    // if (this.mCursor == null)
    // return null;
    //
    // this.mCursor.moveToPosition(position);
    // byte[] rawData = mCursor.getBlob(2);
    // if (rawData != null) {
    // byte[] data = DESutil.DecryptByteToByte(rawData, MainEngine.DESKEY,
    // MainEngine.DESIV);
    // return BitmapFactory.decodeByteArray(data, 0, data.length);
    // } else
    // return null;
    //
    // }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // convertView = mActivity.getLayoutInflater().inflate(
            // R.layout.item_buyer_date, null);
            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);
            // viewHolder.image = (ImageView) convertView.findViewById(R.id.item_buyer_date_image);
            // viewHolder.name = ((TextView) convertView.findViewById(R.id.item_buyer_date_name));
            // // viewHolder.hour=(TextView)convertView.findViewById(R.id.item_buyer_date_hou);
            // // viewHolder.minute=(TextView)convertView.findViewById(R.id.item_buyer_date_mi);
            // // viewHolder.second=(TextView)convertView.findViewById(R.id.item_buyer_date_se);
            // viewHolder.ok=(Button)convertView.findViewById(R.id.item_buyer_date_ok);
            // viewHolder.price=(TextView)convertView.findViewById(R.id.item_buyer_date_price);
            // viewHolder.buyprice=(TextView)convertView.findViewById(R.id.item_buyer_date_buyprice);
            // viewHolder.date=(TextView)convertView.findViewById(R.id.item_buyer_date_buyprice);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText((String) this.getItem(position));
        // viewHolder.image.setImageBitmap(getItemImage(position));

        return convertView;
    }

    public static class ViewHolder {
        ImageView image;
        TextView name;
        TextView hour;
        TextView minute;
        TextView second;
        Button ok;
        TextView price;
        TextView buyprice;
        TextView date;
    }
    // ========================================================================================================

    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
