package kltn.client.android_client.model;

import android.net.Uri;

/**
 * @author NThanhPhong
 */
public class CommentItem {
    /** CONTENT_URI . */
    public static final Uri CONTENT_URI = Uri.parse("content://kltn.client.android_client/comment_item");
    /** DEFAULT_SORT_ORDER . */
    public static final String DEFAULT_SORT_ORDER = "datetime, _id DESC";
    /** IDGOODS . */
    public static final String IDGOODS = "idgoods";
    /** USERNAME. */
    public static final String USERNAME = "username";
    /** IMAGE. */
    public static final String IMAGE = "image";
    /** CONTENT . */
    public static final String CONTENT = "content";
    /** DATETIME. */
    public static final String DATETIME = "datetime";
    /** OWNER. */
    public static final String OWNER = "owner";
    /** COUNTUSER. */
    public static final String COUNTUSER = "countuser";

    /**
     * [getIdgoods].
     * @return Idgoods
     */
    public String getIdgoods() {
        return idgoods;
    }
    /**
     * [getUsername].
     * @return Username
     */
    public String getUsername() {
        return username;
    }
    /**
     * [getImage].
     * @return Image
     */
    public byte[] getImage() {
        return image;
    }
    /**
     * [getContent].
     * @return Content
     */
    public String getContent() {
        return content;
    }
    /**
     * [getDatetime].
     * @return Datetime
     */
    public String getDatetime() {
        return datetime;
    }
    /**
     * [getOwner].
     * @return Owner
     */
    public String getOwner() {
        return owner;
    }
    /**
     * [getCountuser].
     * @return Countuser
     */
    public int getCountuser() {
        return countuser;
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
    public CommentItem(String idgoods, String username, byte[] image, String content, String datetime, String owner,
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
        this.idgoods = idgoods;
    }
    /**
     * [setUsername].
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * [setImage].
     * @param image byte[]
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
    /**
     * [setContent].
     * @param content String
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * [setDatetime].
     * @param datetime String
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    /**
     * [setOwner].
     * @param owner String
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * [setCountuser].
     * @param countuser int
     */
    public void setCountuser(int countuser) {
        this.countuser = countuser;
    }

    /** . */
    private String idgoods, username, content, datetime, owner;
    /** Countuser. */
    private int countuser;
    /** Image. */
    private byte[] image;
}
