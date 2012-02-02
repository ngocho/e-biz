/**
 * 
 */
package mobile.ebiz.blo;

import mobile.ebiz.dao.gae.PhoneXUDAO;
import mobile.ebiz.dao.inf.IPhoneXUDAO;
import mobile.ebiz.dto.PhoneXU;

/**
 * @author nthanhphong
 *
 */
public class PhoneXUBLO {
	private static IPhoneXUDAO custDao = new PhoneXUDAO();

	public static boolean registerXu(PhoneXU phonexu) {
		boolean   flag = custDao.isPhoneXu(phonexu.getPhone());
		if(!flag){
			return  custDao.savePhoneXu(phonexu);
		}
		return false;
	}
	public static boolean updatePhoneXU(PhoneXU phonexu){
		return custDao.savePhoneXu(phonexu);
	}
	public static boolean isPhoneXu(String phone) {
		// TODO Auto-generated method stub
		return custDao.isPhoneXu(phone);
	}

	public static PhoneXU getPhoneXUById(String phone) {
		// TODO Auto-generated method stub
		return custDao.getPhoneXuById(phone);
	}
}
