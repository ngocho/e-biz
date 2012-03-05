package ebiz.mobile.dao.gae;

import ebiz.dao.gae.PMF;
import ebiz.mobile.dao.inf.IPhoneXUDAO;
import ebiz.mobile.dto.PhoneXU;

/**
 * @author nthanhphong
 */
public class PhoneXUDAO implements IPhoneXUDAO {

    /*
     * (non-Javadoc)
     * @see mobile.ebiz.xu.IPhoneXUDAO#savePhoneXu(mobile.ebiz.xu.PhoneXU)
     */
    @Override
    public boolean savePhoneXu(PhoneXU phonexu) {
        // TODO Auto-generated method stub
        return PMF.insertObject(phonexu);
    }

    /*
     * (non-Javadoc)
     * @see mobile.ebiz.xu.IPhoneXUDAO#isPhoneXu(java.lang.String)
     */
    @Override
    public boolean isPhoneXu(String phone) {
        // TODO Auto-generated method stub
        return PMF.isObject(PhoneXU.class, phone);
    }

    /*
     * (non-Javadoc)
     * @see mobile.ebiz.xu.IPhoneXUDAO#getPhoneXuById(java.lang.String)
     */
    @Override
    public PhoneXU getPhoneXuById(String phone) {
        // TODO Auto-generated method stub
        PhoneXU phonexu = null;
        phonexu = (PhoneXU) PMF.getObjectById(PhoneXU.class, phone);
        return phonexu;
    }

}
