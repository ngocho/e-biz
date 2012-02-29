package mobile.ebiz.dao.inf;

import mobile.ebiz.dto.IDXU;
import mobile.ebiz.dto.USERXUHISTORY;

/**
 * @author nthanhphong
 */
public interface IIdxuDAO {
    /**
     * [Give the description for method].
     * @param idxu IDXU
     * @return boolean
     */
    public boolean saveXu(IDXU idxu);

    /**
     * [Give the description for method].
     * @param id String
     * @return boolean
     */
    public boolean isXu(String id);

    /**
     * [Give the description for method].
     * @param id String
     * @return IDXU
     */
    public IDXU getXuById(String id);

    /**
     * [Give the description for method].
     * @return boolean
     */
    public boolean createListxu();
    /**
     * [Give the description for method].
     * @return int
     */
    public int countXuAvailabel();
    /**
     * [Give the description for method].
     * @param history USERXUHISTORY
     * @return boolean
     */
    public boolean updateHistory(USERXUHISTORY history);
}
