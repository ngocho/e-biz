/**
 * 
 */
package object;

import android.text.format.Time;

/**
 * @author nthanhphong
 *
 */
public class delivery {
	public String ID,MSgoods,GoodsName,Price,Address,Phone,CustomerName,x,y;
	public Time DeliveryTime;
	public byte[] image;
	public boolean State;
	public delivery(String id,String msgoods,String goodsname,String price,String address,String phone, String customername,String xlong,String ylong,boolean status){
		ID=id;
		MSgoods=msgoods;
		GoodsName=goodsname;
		Price=price;
		Address=address;
		Phone=phone;
		CustomerName=customername;
		x=xlong;
		y=ylong;
		State=status;
	}
}
