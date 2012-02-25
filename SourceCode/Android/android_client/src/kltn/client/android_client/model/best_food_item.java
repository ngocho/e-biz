package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
public class best_food_item implements BaseColumns {
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
    public best_food_item(String id, String name, String introduction, String price, String buyprice, String imageurl,
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
        return Id;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getName() {
        return Name;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getIntroduction() {
        return Introduction;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPrice() {
        return Price;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getBuyprice() {
        return Buyprice;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getImageurl() {
        return Imageurl;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getStartdate() {
        return Startdate;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEnddate() {
        return Enddate;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getBuycount() {
        return Buycount;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getMinbuyer() {
        return Minbuyer;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getMaxbuyer() {
        return Maxbuyer;
    }
    /**
     * [Give the description for method].
     * @return int
     */
    public int getRate() {
        return Rate;
    }
    /**
     * [Give the description for method].
     * @param id String
     */
    public void setId(String id) {
        Id = id;
    }
    /**
     * [Give the description for method].
     * @param name String
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * [Give the description for method].
     * @param introduction String
     */
    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }
    /**
     * [Give the description for method].
     * @param price String
     */
    public void setPrice(String price) {
        Price = price;
    }
    /**
     * [Give the description for method].
     * @param buyprice String
     */
    public void setBuyprice(String buyprice) {
        Buyprice = buyprice;
    }
    /**
     * [Give the description for method].
     * @param imageurl String
     */
    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }
    /**
     * [Give the description for method].
     * @param startdate String
     */
    public void setStartdate(String startdate) {
        Startdate = startdate;
    }
    /**
     * [Give the description for method].
     * @param enddate String
     */
    public void setEnddate(String enddate) {
        Enddate = enddate;
    }
    /**
     * [Give the description for method].
     * @param buycount int
     */
    public void setBuycount(int buycount) {
        Buycount = buycount;
    }
    /**
     * [Give the description for method].
     * @param minbuyer int
     */
    public void setMinbuyer(int minbuyer) {
        Minbuyer = minbuyer;
    }
    /**
     * [Give the description for method].
     * @param maxbuyer int
     */
    public void setMaxbuyer(int maxbuyer) {
        Maxbuyer = maxbuyer;
    }
    /**
     * [Give the description for method].
     * @param rate int
     */
    public void setRate(int rate) {
        Rate = rate;
    }

    /** . */
    private String Id, Name, Introduction, Price, Buyprice, Imageurl, Startdate, Enddate;
    /** . */
    private int Rate, Buycount, Minbuyer, Maxbuyer;
}
