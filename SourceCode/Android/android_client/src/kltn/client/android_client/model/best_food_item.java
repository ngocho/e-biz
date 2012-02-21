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
public class best_food_item implements BaseColumns{
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_client/best_food");

	public static final String DEFAULT_SORT_ORDER = "startdate, _id DESC";
	public static final String ID="id";
	public static final String NAME="name";
	public static final String INTRODUCTION="introduction";
	public static final String PRICE="price";
	public static final String BUYPRICE="buyprice";
	public static final String IMAGEURL="imageurl";
	public static final String STARTDATE="startdate";
	public static final String ENDDATE="enddate";
	public static final String BUYCOUNT="buycount";
	public static final String MINBUYER="minbuyer";
	public static final String MAXBUYER="maxbuyer";
	public static final String RATE="rate";
	
	public best_food_item(String id,String name,String introduction,String price,String buyprice,String imageurl,String startdate,String enddate,int buycount,int minbuyer,int maxbuyer,int rate){
		setId(id);
		setName(name);
		setIntroduction(introduction);
		setPrice(price);
		setBuyprice(buyprice);
		setBuycount(buycount);
		setImageurl(imageurl);
		setStartdate(startdate);
		setEnddate(enddate);
		setBuycount(buycount);
		setMinbuyer(minbuyer);
		setMaxbuyer(maxbuyer);
		setRate(rate);
	}
	public String getId(){
		return Id;
	}
	public String getName(){
		return Name;
	}
	public String getIntroduction(){
		return Introduction;
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
	public int getMinbuyer(){
		return Minbuyer;
	}
	public int getMaxbuyer(){
		return Maxbuyer;
	}
	public int getRate(){
		return Rate;
	}
	public void setId(String id){
		Id=id;
	}
	public void setName(String name){
		Name=name;
	}
	public void setIntroduction(String introduction){
		Introduction=introduction;
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
	public void setMinbuyer(int minbuyer){
		Minbuyer=minbuyer;
	}
	public void setMaxbuyer(int maxbuyer){
		Maxbuyer=maxbuyer;
	}
	public void setRate(int rate){
		Rate=rate;
	}
			
	private String Id,Name,Introduction,Price,Buyprice,Imageurl,Startdate,Enddate;
	private int Rate,Buycount,Minbuyer,Maxbuyer;
}
