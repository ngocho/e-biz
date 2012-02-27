/**
 * 
 */
package mobile.ebiz.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

import mobile.ebiz.blo.IDXUBLO;

/**
 * @author nthanhphong
 *
 */
public class hashXu {
	private int numberXu=50;
	public boolean CreateXuList(long menhgia){
		boolean result=false;
		for(int i=0;i<50;i++){
			Random random=new Random();
			String idxu= String.valueOf(Calendar.getInstance().getTimeInMillis())+String.valueOf(random.nextInt(50));
			IDXU xu=new IDXU();
			xu.setFlag("true");
			xu.setMoney(menhgia);
			xu.setId(hashID(idxu, 0));
			IDXUBLO.registerXu(xu);
			System.out.println(xu.getId()+" "+xu.getMoney()+" "+xu.getFlag());
		}
		return result;
	}
	//ham hash 1 chuoi dau vao theo thuat toan md5
	//0 - tao ra hash theo dec
	//1 - tao ra hash theo hexa
	public String hashID(String inhash,int style){
		String result="";
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(inhash.getBytes(),0,inhash.length());
		// get md5 bytes
		byte p_md5Data[] = m.digest();
		// create a hex string
		String m_szUniqueID = new String();
		for (int i=0;i
		<p_md5Data.length;i++) {
			int b =  (0xFF & p_md5Data[i]);
			// if it is a single digit, make sure it have 0 in front (proper padding)
			if (b <= 0xF) m_szUniqueID+="0";
			// add number to string
			m_szUniqueID+=Integer.toHexString(b);
		}
		// hex string to uppercase
		m_szUniqueID = m_szUniqueID.toUpperCase();
		result=m_szUniqueID;
        if (style == 0) {
			String hextodec = convertHexToString(result);
			result=hextodec.substring(hextodec.length()-15, hextodec.length());
		}
		return result;
	}
	public String convertHexToString(String hex){

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		//49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for( int i=0; i<hex.length()-1; i+=2 ){

			//grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			//convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			//convert the decimal to character
			sb.append((char)decimal);

			temp.append(decimal);
		}
		System.out.println("Decimal : " + temp.toString());
		return temp.toString();
	}
}
