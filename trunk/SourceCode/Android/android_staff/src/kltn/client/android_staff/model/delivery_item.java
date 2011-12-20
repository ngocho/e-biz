/**
 * 
 */
package kltn.client.android_staff.model;

import android.R.bool;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 *
 */
public class delivery_item implements BaseColumns{
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_staff/delivery");

	public static final String DEFAULT_SORT_ORDER = "date, _id DESC";
	
	public static final String IDDELIVERY = "iddelivery";

	public static final String MSGOODS = "msgoods";

	public static final String GOODSNAME = "goosdname";

	public static final String PRICE = "price";

	public static final String IDCUSTOMER = "idcustomer";

	public static final String CUSTOMERNAME = "customername";

	public static final String ADDRESS = "address";

	public static final String PHONE = "phone";

	public static final String IMAGEURL = "imageurl";

	public static final String XLONG = "xlong";
	
	public static final String YLONG = "ylong";

	public static final String DATE = "date";

	public static final String STATE = "state";
	public delivery_item(String id,String msgoods,String goodsname,String price,String idcustomer,String customername,String address,String phone,String imageurl,String xlong,String ylong,String date,boolean state){
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
	
	public String getId(){
		return mId;
	}
	public String getMsgoods(){
		return mMsgoods;
	}
	public String getGoodsname(){
		return mGoodsname;
	}
	public String getPrice(){
		return mPrice;
	}
	public String getIdcustomer(){
		return mIdcustomer;
	}
	public String getCustomername(){
		return mCustomername;
	}
	public String getAddress(){
		return mAddress;
	}
	public String getPhone(){
		return mPhone;
	}
	public String getImageurl(){
		return mImageurl;
	}
	public String getXlong(){
		return mXlong;
	}
	public String getYlong(){
		return mYlong;
	}
	public String getDate(){
		return mDate;
	}
	public boolean getState(){
		return mState;
	}
	public void setId(String id){
		mId=id;
	}
	public void setMsgoods(String msgoods){
		mMsgoods=msgoods;
	}
	
	public void setGoodsname(String goodsname){
		mGoodsname=goodsname;
	}
	public void setPrice(String price){
		mPrice=price;
	}
	public void setIdcustomer(String idcustomer){
		mIdcustomer=idcustomer;
	}
	public void setCustomername(String customername){
		mCustomername=customername;
	}
	public void setAddress(String address){
		mAddress=address;
	}
	public void setPhone(String phone){
		mPhone=phone;
	}
	public void setImageurl(String imageurl){
		mImageurl=imageurl;
	}
	public void setXlong(String xlong){
		mXlong=xlong;
	}
	public void setYlong(String ylong){
		mYlong=ylong;
	}
	public void setDate(String date){
		mDate=date;
	}
	public void setState(boolean state){
		mState=state;
	}
	private String mId,mMsgoods,mGoodsname,mPrice,mIdcustomer,mCustomername,mAddress,mPhone,mImageurl,mXlong,mYlong,mDate;
	private boolean mState;
}
