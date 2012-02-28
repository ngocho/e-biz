package kltn.client.android_staff.object;

/**
 * @author nthanhphong
 */
public class Chat {
    /** . */
    private String content, date;
    /** . */
    private boolean person;
    /**
     * @param mcontent String
     * @param mdate String
     * @param mperson String
     */
    public Chat(String mcontent, String mdate, boolean mperson) {
        content = mcontent;
        date = mdate;
        person = mperson;
    }
}
