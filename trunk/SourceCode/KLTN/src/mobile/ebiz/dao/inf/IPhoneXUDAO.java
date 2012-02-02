/**
 * 
 */
package mobile.ebiz.dao.inf;

import mobile.ebiz.dto.PhoneXU;

/**
 * @author nthanhphong
 *
 */
public interface IPhoneXUDAO {
	public boolean savePhoneXu(PhoneXU phonexu);

	public boolean isPhoneXu(String phone);

	public PhoneXU getPhoneXuById(String phone);
}
