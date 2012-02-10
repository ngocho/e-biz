/**
 * 
 */
package mobile.ebiz.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

/**
 * @author nthanhphong
 * 
 */
public class hashCode {
	/**
	 * 
	 * @return random ID Code, lenght 6 char
	 */
	public String hashID() {
		Random random = new Random();
		String inhash = String
				.valueOf(Calendar.getInstance().getTimeInMillis())
				+ String.valueOf(random.nextInt(50));
		String result = "";
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(inhash.getBytes(), 0, inhash.length());
		// get md5 bytes
		byte p_md5Data[] = m.digest();
		// create a hex string
		String m_szUniqueID = new String();
		for (int i = 0; i < p_md5Data.length; i++) {
			int b = (0xFF & p_md5Data[i]);
			// if it is a single digit, make sure it have 0 in front (proper
			// padding)
			if (b <= 0xF)
				m_szUniqueID += "0";
			// add number to string
			m_szUniqueID += Integer.toHexString(b);
		}
		// hex string to uppercase
		m_szUniqueID = m_szUniqueID.toUpperCase();
		result = m_szUniqueID;
		return result.substring(result.length() - 6, result.length());
	}
}
