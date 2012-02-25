package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
public class BestFoodItem implements BaseColumns {
    /** CONTENT_URI. */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/best_food");

    /** DEFAULT_SORT_ORDER. */
    public static final String DEFAULT_SORT_ORDER = "startdate, _id DESC";
    /** ID. */
    public static final String ID = "id";
    /** NAME. */
    public static final String NAME = "name";
    /** INTRODUCTION. */
    public static final String INTRODUCTION = "introduction";
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
    /** MINBUYER. */
    public static final String MINBUYER = "minbuyer";
    /** MAXBUYER. */
    public static final String MAXBUYER = "maxbuyer";
    /** RATE. */
    public static final String RATE = "rate";

    /**
     * @param id String
     * @param name String
     * @param introduction String
     * @param price String
     * @param buyprice String
     * @param imageurl String
     * @param startdate String
     * @param enddate String
     * @param buycount int
     * @param minbuyer int
     * @param maxbuyer int
     * @param rate int
     */
    public BestFoodItem(String id, String name, String introduction, String price, String buyprice, String imageurl,
            String startdate, String enddate, int buycount, int minbuyer, int maxbuyer, int rate) {
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
    /**
     * [Give the description for method].
     * @return String
     */
    public String getId() {
        return id;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getIntroduction() {
        return introduction;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPrice() {
        return price;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getBuyprice() {
        return buyprice;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getImageurl() {
        return imageurl;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getStartdate() {
        return startdate;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEnddate() {
        return enddate;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getBuycount() {
        return buycount;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getMinbuyer() {
        return minbuyer;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getMaxbuyer() {
        return maxbuyer;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getRate() {
        return rate;
    }
    /**
     * [Give the description for method].
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * [Give the description for method].
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * [Give the description for method].
     * @param introduction String
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    /**
     * [Give the description for method].
     * @param price String
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
     * [Give the description for method].
     * @param buyprice String
     */
    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }
    /**
     * [Give the description for method].
     * @param imageurl String
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    /**
     * [Give the description for method].
     * @param startdate String
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    /**
     * [Give the description for method].
     * @param enddate String
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    /**
     * [Give the description for method].
     * @param buycount int
     */
    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }
    /**
     * [Give the description for method].
     * @param minbuyer int
     */
    public void setMinbuyer(int minbuyer) {
        this.minbuyer = minbuyer;
    }
    /**
     * [Give the description for method].
     * @param maxbuyer int
     */
    public void setMaxbuyer(int maxbuyer) {
        this.maxbuyer = maxbuyer;
    }
    /**
     * [Give the description for method].
     * @param rate int
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /** . */
    private String id, name, introduction, price, buyprice, imageurl, startdate, enddate;
    /** . */
    private int rate, buycount, minbuyer, maxbuyer;
}
