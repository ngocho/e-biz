/**
 * 
 */
package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 *
 */
public class date_food_item implements BaseColumns{
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_client/date_food");

	public static final String DEFAULT_SORT_ORDER = "startdate, _id DESC";
	
	public static final String IDGOODS = "id";
	public static final String NAME = "name";
	public static final String PRICE  = "price";
	public static final String BUYPRICE="buyprice";
	public static final String IMAGEURL="imageurl";
	public static final String STARTDATE="startdate";
	public static final String ENDDATE="enddate";
	public static final String BUYCOUNT="buycount";
	public static final String COUNTMIN="countmin";
	public static final String COUNTMAX="countmax";
	
	public date_food_item(String id,String name,String price,String buyprice,String imageurl,String startdate,String enddate,int buycount,int countmin,int countmax){
		setIdgoods(id);
		setName(name);
		setPrice(price);
		setBuyprice(buyprice);
		setImageurl(imageurl);
		setStartdate(startdate);
		setEnddate(enddate);
		setBuycount(buycount);
		setCountmin(countmin);
		setCountmax(countmax);
	}
	
	public String getIdgoods(){
		return Idgoods;
	}
	public String getName(){
		return Name;
	}
	public String getPrice(){
		return Price;
	}
	public String getBuyprice(){
		return Buyprice;
	}
	public String getImageurl(){
		return Imageurl;
	}
	public String getStartdate(){
		return Startdate;
	}
	public String getEnddate(){
		return Enddate;
	}
	public int getBuycount(){
		return Buycount;
	}
	public int getCountmin(){
		return Countmin;
	}
	public int getCountmax(){
		return Countmax;
	}
	public void setIdgoods(String id){
		Idgoods=id;
	}
	public void setName(String name){
		Name=name;
	}
	public void setPrice(String price){
		Price=price;
	}
	public void setBuyprice(String buyprice){
		Buyprice=buyprice;
	}
	public void setImageurl(String imageurl){
		Imageurl=imageurl;
	}
	public void setStartdate(String startdate){
		Startdate=startdate;
	}
	public void setEnddate(String enddate){
		Enddate=enddate;
	}
	public void setBuycount(int buycount){
		Buycount=buycount;
	}
	public void setCountmin(int countmin){
		Countmin=countmin;
	}
	public void setCountmax(int countmax){
		Countmax=countmax;
	}
	
	private String Idgoods,Name,Price,Buyprice,Imageurl,Startdate,Enddate;
	private int Buycount,Countmin,Countmax;
}
