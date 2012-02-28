package kltn.client.android_server.object;

/**
 * @author nthanhphong
 */
public class HappybirthdayObject {
    /** . */
    private String phonenumber, message;
    /**
     * @param phone String
     * @param messagecontent String
     */
    public HappybirthdayObject(String phone, String messagecontent) {
        this.phonenumber = phone;
        this.message = messagecontent;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPhone() {
        return phonenumber;
    }
    /**
     * [Give the description for method].
     * @param phone String
     */
    public void setPhone(String phone) {
        this.phonenumber = phone;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getMessage() {
        return message;
    }
    /**
     * [Give the description for method].
     * @param message String
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
