package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
public class DateFoodItem implements BaseColumns {
    /** CONTENT_URI. */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/date_food");

    /** DEFAULT_SORT_ORDER. */
    public static final String DEFAULT_SORT_ORDER = "startdate, _id DESC";

    /** IDGOODS. */
    public static final String IDGOODS = "id";
    /** NAME. */
    public static final String NAME = "name";
    /** PRICE. */
    public static final String PRICE = "price";
    /** BUYPRICE. */
    public static final String BUYPRICE = "buyprice";
    /** IMAGEURL. */
    public static final String IMAGEURL = "imageurl";
    /** STARTDATE. */
    public static final String STARTDATE = "startdate";
    /** ENDDATE. */
    public static final String ENDDATE = "enddate";
    /** BUYCOUNT. */
    public static final String BUYCOUNT = "buycount";
    /** COUNTMIN. */
    public static final String COUNTMIN = "countmin";
    /** COUNTMAX. */
    public static final String COUNTMAX = "countmax";

    /**
     * @param id String
     * @param name String
     * @param price String
     * @param buyprice String
     * @param imageurl String
     * @param startdate String
     * @param enddate String
     * @param buycount String
     * @param countmin String
     * @param countmax String
     */
    public DateFoodItem(String id, String name, String price, String buyprice, String imageurl, String startdate,
            String enddate, int buycount, int countmin, int countmax) {
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

    /**
     * [getIdgoods].
     * @return Idgoods
     */
    public String getIdgoods() {
        return idgoods;
    }
    /**
     * [getName].
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * [getPrice].
     * @return String
     */
    public String getPrice() {
        return price;
    }
    /**
     * [getBuyprice].
     * @return String
     */
    public String getBuyprice() {
        return buyprice;
    }
    /**
     * [getImageurl].
     * @return String
     */
    public String getImageurl() {
        return imageurl;
    }
    /**
     * [getStartdate].
     * @return String
     */
    public String getStartdate() {
        return startdate;
    }
    /**
     * [getEnddate].
     * @return String
     */
    public String getEnddate() {
        return enddate;
    }
    /**
     * [getBuycount].
     * @return int
     */
    public int getBuycount() {
        return buycount;
    }
    /**
     * [getCountmin].
     * @return int
     */
    public int getCountmin() {
        return countmin;
    }
    /**
     * [getCountmax].
     * @return int
     */
    public int getCountmax() {
        return countmax;
    }
    /**
     * [setIdgoods].
     * @param id String
     */
    public void setIdgoods(String id) {
        idgoods = id;
    }
    /**
     * [setName].
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * [setPrice].
     * @param price String
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
     * [setBuyprice].
     * @param buyprice String
     */
    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }
    /**
     * [setImageurl].
     * @param imageurl String
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    /**
     * [setStartdate].
     * @param startdate String
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    /**
     * [setEnddate].
     * @param enddate String
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    /**
     * [setBuycount].
     * @param buycount int
     */
    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }
    /**
     * [setCountmin].
     * @param countmin int
     */
    public void setCountmin(int countmin) {
        this.countmin = countmin;
    }
    /**
     * [setCountmax].
     * @param countmax int
     */
    public void setCountmax(int countmax) {
        this.countmax = countmax;
    }

    /** . */
    private String idgoods, name, price, buyprice, imageurl, startdate, enddate;
    /** . */
    private int buycount, countmin, countmax;
}
