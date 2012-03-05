package ebiz.mobile.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

/**
 * @author nthanhphong
 */
public class HashCode {
    /**
     * [hashID].
     * @param len int
     * @return String
     */
    public static String hashID(int len) {
        Random random = new Random();
        String inhash = String.valueOf(Calendar.getInstance().getTimeInMillis()) + String.valueOf(random.nextInt(50));
        String result = "";
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(inhash.getBytes(), 0, inhash.length());
        // get md5 bytes
        byte pmd5Data[] = m.digest();
        // create a hex string
        String mszUniqueID = new String();
        for (int i = 0; i < pmd5Data.length; i++) {
            int b = (0xFF & pmd5Data[i]);
            // if it is a single digit, make sure it have 0 in front (proper
            // padding)
            if (b <= 0xF) {
                mszUniqueID += "0";
            }
            // add number to string
            mszUniqueID += Integer.toHexString(b);
        }
        // hex string to uppercase
        mszUniqueID = mszUniqueID.toUpperCase();
        result = mszUniqueID;
        return result.substring(result.length() - len, result.length());
    }
}
