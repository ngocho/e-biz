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
public class histoty_buy_item implements BaseColumns{
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_client/history_buy");

	public static final String DEFAULT_SORT_ORDER = "date, _id DESC";
	public static final String IDCUSTOMER="idcustomer";
	public static final String IDGOODS="idgoods";
	public static final String GOODSNAME="goodsname";
	public static final String IMAGE="image";
	public static final String DATE="datetime";
	public static final String PRICE="price";
	public histoty_buy_item(String idcustomer,String idgoods,String goodsname,String image,String datetime,String price){
		setIdcustomer(idcustomer);
		setGoodsname(goodsname);
		setIdgoods(idgoods);
		setImage(image);
		setDatetime(datetime);
		setPrice(price);
	}
	public String getIdcustomer(){
		return Idcustomer;
	}
	public String getIdgoods(){
		return Idgoods;
	}
	public String getGoodsname(){
		return Goodsname;
	}
	public String getImage(){
		return Image;
	}
	public String getDatetime(){
		return Datetime;
	}
	public String getPrice(){
		return Price;
	}
	
	public void setIdcustomer(String idcustomer){
		Idcustomer=idcustomer;
	}
	public void setIdgoods(String idgoods){
		Idgoods=idgoods;
	}
	public void setGoodsname(String goodsname){
		Goodsname=goodsname;
	}
	public void setImage(String image){
		Image=image;
	}
	public void setDatetime(String datetime){
		Datetime=datetime;
	}
	public void setPrice(String price){
		Price=price;
	}
	private String Idcustomer,Idgoods,Goodsname,Image,Datetime,Price;
}
