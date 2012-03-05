package ebiz.mobile.blo;

import ebiz.mobile.dao.MobileDaoManager;
import ebiz.mobile.dao.inf.IPhoneXUDAO;
import ebiz.mobile.dto.PhoneXU;

/**
 * @author nthanhphong
 */
public class PhoneXUBLO {
    /** . */
    private static IPhoneXUDAO custDao = MobileDaoManager.getInstance().getPhoneXuDao();

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
