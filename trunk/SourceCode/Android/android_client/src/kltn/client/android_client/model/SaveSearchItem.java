package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
public class SaveSearchItem implements BaseColumns {
    /** . */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/save_search_food");

    /** . */
    public static final String DEFAULT_SORT_ORDER = "savedate, id DESC";
    /** . */
    public static final String ID = "id";
    /** . */
    public static final String NAME = "name";
    /** . */
    public static final String INTRODUCTION = "introduction";
    /** . */
    public static final String PRICE = "price";
    /** . */
    public static final String BUYPRICE = "buyprice";
    /** . */
    public static final String IMAGEURL = "imageurl";
    /** . */
    public static final String UPLOADDATE = "uploaddate";
    /** . */
    public static final String SAVEDATE = "savedate";
    /** . */
    public static final String BUYCOUNT = "buycount";
    /** . */
    public static final String PROVIDER = "provider";
    /**
     * @param id String
     * @param name String
     * @param introduction String
     * @param price String
     * @param buyprice String
     * @param image String
     * @param uploaddate String
     * @param savedate String
     * @param buycount String
     * @param provider String
     */
    public SaveSearchItem(String id, String name, String introduction, String price, String buyprice, String image,
            String uploaddate, String savedate, String buycount, String provider) {
        setId(id);
        setName(name);
        setIntroduction(introduction);
        setPrice(price);
        setBuyprice(buyprice);
        setImageurl(image);
        setUploaddate(uploaddate);
        setSavedate(savedate);
        setBuycount(buycount);
        setProvider(provider);
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
    public String getUploaddatedate() {
        return uploaddate;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getSavedate() {
        return savedate;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getBuycount() {
        return buycount;
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
     * @param uploadadte String
     */
    public void setUploaddate(String uploadadte) {
        this.uploaddate = uploadadte;
    }
    /**
     * [Give the description for method].
     * @param savedate String
     */
    public void setSavedate(String savedate) {
        this.savedate = savedate;
    }
    /**
     * [Give the description for method].
     * @param buycount String
     */
    public void setBuycount(String buycount) {
        this.buycount = buycount;
    }
    /**
     * [Give the description for method].
     * @param provider String
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }
    /** . */
    private String id, name, introduction, price, buyprice, imageurl, uploaddate, savedate, buycount, provider;
}
