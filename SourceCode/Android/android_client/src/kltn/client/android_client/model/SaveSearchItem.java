/**
 * 
 */
package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author NThanhPhong
 */
public class SaveSearchItem implements BaseColumns {
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/save_search_food");

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
    public static final String PROVIDER = "provider";
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
    public String getBuycount() {
        return Buycount;
    }
    public String getProvider() {
        return Provider;
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
    public void setBuycount(String buycount) {
        Buycount = buycount;
    }
    public void setProvider(String provider) {
        Provider = provider;
    }
    private String Id, Name, Introduction, Price, Buyprice, Imageurl, Uploaddate, Savedate, Buycount, Provider;
}
