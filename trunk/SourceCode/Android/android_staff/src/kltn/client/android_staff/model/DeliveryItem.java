package kltn.client.android_staff.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 */
/**
 * @author wind
 *
 */
public class DeliveryItem implements BaseColumns {
    /**  . */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_staff/delivery");

    /**  . */
    public static final String DEFAULT_SORT_ORDER = "date, _id DESC";

    /**  . */
    public static final String IDDELIVERY = "iddelivery";

    /**  . */
    public static final String MSGOODS = "msgoods";

    /**  . */
    public static final String GOODSNAME = "goosdname";

    /**  . */
    public static final String PRICE = "price";

    /**  . */
    public static final String IDCUSTOMER = "idcustomer";

    /**  . */
    public static final String CUSTOMERNAME = "customername";

    /**  . */
    public static final String ADDRESS = "address";

    /**  . */
    public static final String PHONE = "phone";

    /**  . */
    public static final String IMAGEURL = "imageurl";

    /**  . */
    public static final String XLONG = "xlong";

    /**  . */
    public static final String YLONG = "ylong";

    /**  . */
    public static final String DATE = "date";

    /**  . */
    public static final String STATE = "state";
    /**
     * @param id String
     * @param msgoods String
     * @param goodsname String
     * @param price String
     * @param idcustomer String
     * @param customername String
     * @param address String
     * @param phone String
     * @param imageurl String
     * @param xlong String
     * @param ylong String
     * @param date String
     * @param state boolean
     */
    public DeliveryItem(String id, String msgoods, String goodsname, String price, String idcustomer,
            String customername, String address, String phone, String imageurl, String xlong, String ylong,
            String date, boolean state) {
        setId(id);
        setMsgoods(msgoods);
        setGoodsname(goodsname);
        setPrice(price);
        setIdcustomer(idcustomer);
        setCustomername(customername);
        setAddress(address);
        setPhone(phone);
        setImageurl(imageurl);
        setXlong(xlong);
        setYlong(ylong);
        setDate(date);
        setState(state);
    }

    /**
     * [Give the description for method].
     * @return String
     */
    public String getId() {
        return mId;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getMsgoods() {
        return mMsgoods;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getGoodsname() {
        return mGoodsname;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPrice() {
        return mPrice;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getIdcustomer() {
        return mIdcustomer;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getCustomername() {
        return mCustomername;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getAddress() {
        return mAddress;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPhone() {
        return mPhone;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getImageurl() {
        return mImageurl;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getXlong() {
        return mXlong;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getYlong() {
        return mYlong;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getDate() {
        return mDate;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public boolean getState() {
        return mState;
    }
    /**
     * [Give the description for method].
     * @param id String
     */
    public void setId(String id) {
        mId = id;
    }
    /**
     * [Give the description for method].
     * @param msgoods String
     */
    public void setMsgoods(String msgoods) {
        mMsgoods = msgoods;
    }

    /**
     * [Give the description for method].
     * @param goodsname String
     */
    public void setGoodsname(String goodsname) {
        mGoodsname = goodsname;
    }
    /**
     * [Give the description for method].
     * @param price String
     */
    public void setPrice(String price) {
        mPrice = price;
    }
    /**
     * [Give the description for method].
     * @param idcustomer String
     */
    public void setIdcustomer(String idcustomer) {
        mIdcustomer = idcustomer;
    }
    /**
     * [Give the description for method].
     * @param customername String
     */
    public void setCustomername(String customername) {
        mCustomername = customername;
    }
    /**
     * [Give the description for method].
     * @param address String
     */
    public void setAddress(String address) {
        mAddress = address;
    }
    /**
     * [Give the description for method].
     * @param phone String
     */
    public void setPhone(String phone) {
        mPhone = phone;
    }
    /**
     * [Give the description for method].
     * @param imageurl String
     */
    public void setImageurl(String imageurl) {
        mImageurl = imageurl;
    }
    /**
     * [Give the description for method].
     * @param xlong String
     */
    public void setXlong(String xlong) {
        mXlong = xlong;
    }
    /**
     * [Give the description for method].
     * @param ylong  String
     */
    public void setYlong(String ylong) {
        mYlong = ylong;
    }
    /**
     * [Give the description for method].
     * @param date String
     */
    public void setDate(String date) {
        mDate = date;
    }
    /**
     * [Give the description for method].
     * @param state boolean
     */
    public void setState(boolean state) {
        mState = state;
    }
    /**  . */
    private String mId, mMsgoods, mGoodsname, mPrice, mIdcustomer, mCustomername, mAddress, mPhone, mImageurl, mXlong,
            mYlong, mDate;
    /**  . */
    private boolean mState;
}
