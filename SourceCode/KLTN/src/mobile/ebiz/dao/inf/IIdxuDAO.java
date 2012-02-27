/**
 * 
 */
package mobile.ebiz.dao.inf;

import mobile.ebiz.dto.IDXU;
import mobile.ebiz.dto.USERXUHISTORY;

/**
 * @author nthanhphong
 *
 */
public interface IIdxuDAO {
	public boolean saveXu(IDXU idxu);

	public boolean isXu(String id);

	public IDXU getXuById(String id);
	
	public boolean createListxu();
	public int countXuAvailabel();
	public boolean updateHistory(USERXUHISTORY history);
}
