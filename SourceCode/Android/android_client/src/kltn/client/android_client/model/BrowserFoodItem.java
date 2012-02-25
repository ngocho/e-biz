package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
/**
 * @author wind
 *
 */
public class BrowserFoodItem implements BaseColumns {
    /**  . */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/browser_food");

    /**  . */
    public static final String DEFAULT_SORT_ORDER = "startdate, _id DESC";
    /**  . */
    public static final String ID = "id";
    /**  . */
    public static final String NAME = "name";
    /**  . */
    public static final String INTRODUCTION = "introduction";
    /**  . */
    public static final String PRICE = "price";
    /**  . */
    public static final String BUYPRICE = "buyprice";
    /**  . */
    public static final String IMAGEURL = "imageurl";
    /**  . */
    public static final String STARTDATE = "startdate";
    /**  . */
    public static final String ENDDATE = "enddate";
    /**  . */
    public static final String BUYCOUNT = "buycount";
    /**  . */
    public static final String MINBUYER = "minbuyer";
    /**  . */
    public static final String RATE = "rate";
    /**  . */
    public static final String MAXBUYER = "maxbuyer";
    /**  . */
    public static final String TYPE = "type";
    /**  . */
    public static final String PROVIDER = "provider";

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
     * @param type String
     * @param provider String
     */
    public BrowserFoodItem(String id, String name, String introduction, String price, String buyprice,
            String imageurl, String startdate, String enddate, int buycount, int minbuyer, int maxbuyer, int rate,
            String type, String provider) {
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
        setType(type);
        setProvider(provider);
    }
    /**
     * [Give the description for method].
     * @param provider String
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getProvider() {
        return provider;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getType() {
        return type;
    }
    /**
     * [Give the description for method].
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
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

    /**  . */
    private String id, name, introduction, price, buyprice, imageurl, startdate, enddate, type, provider;
    /**  . */
    private int rate, buycount, minbuyer, maxbuyer;
}
