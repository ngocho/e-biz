package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
public class histoty_buy_item implements BaseColumns {
    /** CONTENT_URI. */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/history_buy");
    /** DEFAULT_SORT_ORDER. */
    public static final String DEFAULT_SORT_ORDER = "date, _id DESC";
    /** IDCUSTOMER. */
    public static final String IDCUSTOMER = "idcustomer";
    /** IDGOODS. */
    public static final String IDGOODS = "idgoods";
    /** GOODSNAME. */
    public static final String GOODSNAME = "goodsname";
    /** IMAGE. */
    public static final String IMAGE = "image";
    /** DATE. */
    public static final String DATE = "datetime";
    /** PRICE. */
    public static final String PRICE = "price";
    /**
     * @param idcustomer String
     * @param idgoods String
     * @param goodsname String
     * @param image String
     * @param datetime String
     * @param price String
     */
    public histoty_buy_item(String idcustomer, String idgoods, String goodsname, String image, String datetime,
            String price) {
        setIdcustomer(idcustomer);
        setGoodsname(goodsname);
        setIdgoods(idgoods);
        setImage(image);
        setDatetime(datetime);
        setPrice(price);
    }
    /**
     * [getIdcustomer].
     * @return Idcustomer
     */
    public String getIdcustomer() {
        return idCustomer;
    }
    /**
     * [getIdgoods].
     * @return Idgoods
     */
    public String getIdgoods() {
        return idGoods;
    }
    /**
     * [getGoodsname].
     * @return Goodsname
     */
    public String getGoodsname() {
        return goodsName;
    }
    /**
     * [getImage].
     * @return Image
     */
    public String getImage() {
        return image;
    }
    /**
     * [getDatetime].
     * @return Datetime
     */
    public String getDatetime() {
        return dateTime;
    }
    /**
     * [getPrice].
     * @return Price
     */
    public String getPrice() {
        return price;
    }

    /**
     * [setIdcustomer].
     * @param idcustomer String
     */
    public void setIdcustomer(String idcustomer) {
        idCustomer = idcustomer;
    }
    /**
     * [setIdgoods].
     * @param idgoods String
     */
    public void setIdgoods(String idgoods) {
        idGoods = idgoods;
    }
    /**
     * [setGoodsname].
     * @param goodsname String
     */
    public void setGoodsname(String goodsname) {
        goodsName = goodsname;
    }
    /**
     * [setImage].
     * @param image String
     */
    public void setImage(String image) {
        image = image;
    }
    /**
     * [setDatetime].
     * @param datetime String
     */
    public void setDatetime(String datetime) {
        dateTime = datetime;
    }
    /**
     * [setPrice].
     * @param price String
     */
    public void setPrice(String price) {
        price = price;
    }
    /**  . */
    private String idCustomer, idGoods, goodsName, image, dateTime, price;
}
