package kltn.client.android_server.object;

/**
 * @author nthanhphong
 */
public class ActivecodeObject {
    /** . */
    private String phonenumber, code;
    /**
     * @param phone String
     * @param activecode String
     */
    public ActivecodeObject(String phone, String activecode) {
        this.phonenumber = phone;
        this.code = activecode;
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
    public String getCode() {
        return code;
    }
    /**
     * [Give the description for method].
     * @param code String
     */
    public void setCode(String code) {
        this.code = code;
    }
}
