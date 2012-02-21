/**
 * 
 */
package mobile.ebiz.dao.gae;

import java.util.Calendar;

import mobile.ebiz.dao.inf.IIdxuDAO;
import mobile.ebiz.dto.IDXU;
import mobile.ebiz.dto.hashXu;

import ebiz.dao.gae.PMF;

/**
 * @author nthanhphong
 *
 */
public class IdxuDAO implements IIdxuDAO{

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see mobile.ebiz.xu.IIdxuDAO#createListxu()
	 */
	@Override
	public boolean createListxu() {
		hashXu hash=new hashXu();
		return hash.CreateXuList(50000);
	}

    /**
     * [Explain the description for this method here].
     * @return
     * @see mobile.ebiz.dao.inf.IIdxuDAO#countXuAvailabel()
     */
    @Override
    public int  countXuAvailabel() {
       int count = PMF.countRecordObject(IDXU.class, "flag", true);
       return count;
    }
}
