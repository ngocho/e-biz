package kltn.client.android_client.model;

import android.net.Uri;

/**
 * @author NThanhPhong
 */
public class comment_item {
    /** CONTENT_URI . */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/comment_item");
    /** DEFAULT_SORT_ORDER . */
    public static final String DEFAULT_SORT_ORDER = "datetime, _id DESC";
    /** IDGOODS . */
    public static final String IDGOODS = "idgoods";
    /**  USERNAME. */
    public static final String USERNAME = "username";
    /**  IMAGE. */
    public static final String IMAGE = "image";
    /** CONTENT . */
    public static final String CONTENT = "content";
    /**  DATETIME. */
    public static final String DATETIME = "datetime";
    /**  OWNER. */
    public static final String OWNER = "owner";
    /**  COUNTUSER. */
    public static final String COUNTUSER = "countuser";

    /**
     * [getIdgoods].
     * @return Idgoods
     */
    public String getIdgoods() {
        return Idgoods;
    }
    /**
     * [getUsername].
     * @return Username
     */
    public String getUsername() {
        return Username;
    }
    /**
     * [getImage].
     * @return Image
     */
    public byte[] getImage() {
        return Image;
    }
    /**
     * [getContent].
     * @return Content
     */
    public String getContent() {
        return Content;
    }
    /**
     * [getDatetime].
     * @return Datetime
     */
    public String getDatetime() {
        return Datetime;
    }
    /**
     * [getOwner].
     * @return Owner
     */
    public String getOwner() {
        return Owner;
    }
    /**
     * [getCountuser].
     * @return Countuser
     */
    public int getCountuser() {
        return Countuser;
    }
    /**
     * @param idgoods String
     * @param username String
     * @param image byte[]
     * @param content String
     * @param datetime String
     * @param owner String
     * @param countuser int
     */
    public comment_item(String idgoods, String username, byte[] image, String content, String datetime, String owner,
            int countuser) {
        setIdgoods(idgoods);
        setUsername(username);
        setImage(image);
        setContent(content);
        setDatetime(datetime);
        setOwner(owner);
        setCountuser(countuser);
    }
    /**
     * [setIdgoods].
     * @param idgoods String
     */
    public void setIdgoods(String idgoods) {
        Idgoods = idgoods;
    }
    /**
     * [setUsername].
     * @param username String
     */
    public void setUsername(String username) {
        Username = username;
    }
    /**
     * [setImage].
     * @param image byte[]
     */
    public void setImage(byte[] image) {
        Image = image;
    }
    /**
     * [setContent].
     * @param content String
     */
    public void setContent(String content) {
        Content = content;
    }
    /**
     * [setDatetime].
     * @param datetime String
     */
    public void setDatetime(String datetime) {
        Datetime = datetime;
    }
    /**
     * [setOwner].
     * @param owner String
     */
    public void setOwner(String owner) {
        Owner = owner;
    }
    /**
     * [setCountuser].
     * @param countuser int
     */
    public void setCountuser(int countuser) {
        Countuser = countuser;
    }

    /**  . */
    private String Idgoods, Username, Content, Datetime, Owner;
    /**  Countuser. */
    private int Countuser;
    /**  Image. */
    private byte[] Image;
}
