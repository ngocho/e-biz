package mobile.ebiz.dao.inf;

import mobile.ebiz.dto.PhoneXU;

/**
 * @author nthanhphong
 */
public interface IPhoneXUDAO {
    /**
     * [Give the description for method].
     * @param phonexu PhoneXU
     * @return boolean
     */
    public boolean savePhoneXu(PhoneXU phonexu);

    /**
     * [Give the description for method].
     * @param phone String
     * @return boolean
     */
    public boolean isPhoneXu(String phone);

    /**
     * [Give the description for method].
     * @param phone String
     * @return PhoneXU
     */
    public PhoneXU getPhoneXuById(String phone);
}
