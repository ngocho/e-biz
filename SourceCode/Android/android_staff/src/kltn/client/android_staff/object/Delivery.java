package kltn.client.android_staff.object;

import android.text.format.Time;

/**
 * @author nthanhphong
 */
public class Delivery {
    /** . */
    private String iD, mSgoods, goodsName, price, address, phone, customerName, x, y;
    /** . */
    private Time deliveryTime;
    /** . */
    private byte[] image;
    /** . */
    private boolean state;
    /**
     * @param id String
     * @param msgoods String
     * @param goodsname String
     * @param price String
     * @param address String
     * @param phone String
     * @param customername String
     * @param xlong String
     * @param ylong String
     * @param status boolean
     */
    public Delivery(String id, String msgoods, String goodsname, String price, String address, String phone,
            String customername, String xlong, String ylong, boolean status) {
        this.iD = id;
        this.mSgoods = msgoods;
        this.goodsName = goodsname;
        this.price = price;
        this.address = address;
        this.phone = phone;
        this.customerName = customername;
        this.x = xlong;
        this.y = ylong;
        this.state = status;
    }
}
