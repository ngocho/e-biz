package ebiz.mobile.dao.gae;

import ebiz.dao.gae.PMF;
import ebiz.mobile.dao.inf.IIdxuDAO;
import ebiz.mobile.dto.HashXu;
import ebiz.mobile.dto.IDXU;
import ebiz.mobile.dto.USERXUHISTORY;
/**
 * @author nthanhphong
 */
public class IdxuDAO implements IIdxuDAO {

    /*
     * (non-Javadoc)
     * @see mobile.ebiz.xu.IIdxuDAO#saveXu(mobile.ebiz.xu.IDXU)
     */
    @Override
    public boolean saveXu(IDXU idxu) {
        // TODO Auto-generated method stub
        return PMF.insertObject(idxu);
    }

    @Override
    public boolean isXu(String id) {
        // TODO Auto-generated method stub
        return PMF.isObject(IDXU.class, id);
    }

    @Override
    public IDXU getXuById(String id) {
        // TODO Auto-generated method stub
        IDXU xu = null;
        xu = (IDXU) PMF.getObjectById(IDXU.class, id);
        return xu;
    }

    /*
     * (non-Javadoc)
     * @see mobile.ebiz.xu.IIdxuDAO#createListxu()
     */
    @Override
    public boolean createListxu() {
        HashXu hash = new HashXu();
        return hash.createXuList(50000);
    }
    @Override
    public boolean updateHistory(USERXUHISTORY history) {
        return PMF.insertObject(history);
    }
    /**
     * [Explain the description for this method here].
     * @return int
     * @see ebiz.mobile.dao.inf.IIdxuDAO#countXuAvailabel()
     */
    @Override
    public int countXuAvailabel() {
        int count = PMF.countRecordObject(IDXU.class, "flag", true);
        return count;
    }
}
