/**
 * 
 */
package mobile.ebiz.dao.inf;

import mobile.ebiz.dto.IDXU;

/**
 * @author nthanhphong
 *
 */
public interface IIdxuDAO {
	public boolean saveXu(IDXU idxu);

	public boolean isXu(String id);

	public IDXU getXuById(String id);
	
	public boolean createListxu();
}
