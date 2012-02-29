package mobile.ebiz.blo;

import mobile.ebiz.dao.gae.PhoneXUDAO;
import mobile.ebiz.dao.inf.IPhoneXUDAO;
import mobile.ebiz.dto.PhoneXU;

/**
 * @author nthanhphong
 */
public class PhoneXUBLO {
    /** . */
    private static IPhoneXUDAO custDao = new PhoneXUDAO();

    /**
     * [Give the description for method].
     * @param phonexu PhoneXU
     * @return boolean
     */
    public static boolean registerXu(PhoneXU phonexu) {
        boolean flag = custDao.isPhoneXu(phonexu.getPhone());
        if (!flag) {
            return custDao.savePhoneXu(phonexu);
        }
        return false;
    }
    /**
     * [Give the description for method].
     * @param phonexu PhoneXU
     * @return boolean
     */
    public static boolean updatePhoneXU(PhoneXU phonexu) {
        return custDao.savePhoneXu(phonexu);
    }
    /**
     * [Give the description for method].
     * @param phone String
     * @return boolean
     */
    public static boolean isPhoneXu(String phone) {
        // TODO Auto-generated method stub
        return custDao.isPhoneXu(phone);
    }

    /**
     * [Give the description for method].
     * @param phone String
     * @return PhoneXU
     */
    public static PhoneXU getPhoneXUById(String phone) {
        // TODO Auto-generated method stub
        return custDao.getPhoneXuById(phone);
    }
}
