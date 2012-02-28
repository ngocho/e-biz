package kltn.client.android_server.object;

/**
 * @author nthanhphong
 */
public class Promotion {
    /** . */
    private String[] phonenumber, content;
    /**
     * 
     */
    public Promotion() {
    }
    /**
     * @param phone String[]
     * @param message String[]
     */
    public Promotion(String[] phone, String[] message) {
        phonenumber = phone;
        content = message;
    }
}
