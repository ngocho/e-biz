/**
 * 
 */
package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 */
public class FavoriteItem implements BaseColumns {
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/favorite_food");

    public static final String DEFAULT_SORT_ORDER = "savedate, id DESC";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String INTRODUCTION = "introduction";
    public static final String PRICE = "price";
    public static final String BUYPRICE = "buyprice";
    public static final String IMAGEURL = "imageurl";
    public static final String UPLOADDATE = "uploaddate";
    public static final String SAVEDATE = "savedate";
    public static final String BUYCOUNT = "buycount";
    public static final String MINBUYER = "minbuyer";
    public static final String MAXBUYER = "maxbuyer";
    public static final String RATE = "rate";
    public static final String PROVIDER = "provider";

    public FavoriteItem(String id, String name, String introduction, String price, String buyprice, String imageurl,
            String uploadate, String savedate, int buycount, int minbuyer, int maxbuyer, int rate, String provider) {
        setId(id);
        setName(name);
        setIntroduction(introduction);
        setPrice(price);
        setBuyprice(buyprice);
        setBuycount(buycount);
        setImageurl(imageurl);
        setUploaddate(uploadate);
        setSavedate(savedate);
        setBuycount(buycount);
        setMinbuyer(minbuyer);
        setMaxbuyer(maxbuyer);
        setRate(rate);
        setProvider(provider);
    }
    public String getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getIntroduction() {
        return Introduction;
    }
    public String getPrice() {
        return Price;
    }
    public String getBuyprice() {
        return Buyprice;
    }
    public String getImageurl() {
        return Imageurl;
    }
    public String getUploaddatedate() {
        return Uploaddate;
    }
    public String getSavedate() {
        return Savedate;
    }
    public int getBuycount() {
        return Buycount;
    }
    public int getMinbuyer() {
        return Minbuyer;
    }
    public int getMaxbuyer() {
        return Maxbuyer;
    }
    public int getRate() {
        return Rate;
    }
    public void setId(String id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }
    public void setPrice(String price) {
        Price = price;
    }
    public void setBuyprice(String buyprice) {
        Buyprice = buyprice;
    }
    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }
    public void setUploaddate(String uploadadte) {
        Uploaddate = uploadadte;
    }
    public void setSavedate(String savedate) {
        Savedate = savedate;
    }
    public void setBuycount(int buycount) {
        Buycount = buycount;
    }
    public void setMinbuyer(int minbuyer) {
        Minbuyer = minbuyer;
    }
    public void setMaxbuyer(int maxbuyer) {
        Maxbuyer = maxbuyer;
    }
    public void setRate(int rate) {
        Rate = rate;
    }
    public void setProvider(String provider) {
        this.Provider = provider;
    }
    public String getProvider() {
        return Provider;
    }

    private String Id, Name, Introduction, Price, Buyprice, Imageurl, Uploaddate, Savedate, Provider;
    private int Rate, Buycount, Minbuyer, Maxbuyer;
}
