/**
 * 
 */
package mobile.ebiz.blo;

import mobile.ebiz.dao.gae.IdxuDAO;
import mobile.ebiz.dao.inf.IIdxuDAO;
import mobile.ebiz.dto.IDXU;
import mobile.ebiz.dto.USERXUHISTORY;

/**
 * @author nthanhphong
 *
 */
public class IDXUBLO {
	private static IIdxuDAO custDao = new IdxuDAO();
	
	public static boolean registerXu(IDXU idxu) {
		boolean   flag = custDao.isXu(idxu.getId());
        if(!flag){
        return  custDao.saveXu(idxu);
        }
        return false;
	}

	public static boolean isXu(String id) {
		// TODO Auto-generated method stub
		return custDao.isXu(id);
	}

	public static IDXU getXuById(String id) {
		// TODO Auto-generated method stub
		return custDao.getXuById(id);
	}
	public static boolean CreateListXu(){
		return custDao.createListxu();
	}
	public static boolean updateXu(IDXU idxu){
		return custDao.saveXu(idxu);
	}
	public static long getMoneyByID(String id) {
        // TODO Auto-generated method stub
	    IDXU xu = getXuById(id);
        long money = 0;
        if (xu != null) {
            if (xu.getFlag().equals("true")) {
                money = xu.getMoney();
                xu.setFlag("false");
                IDXUBLO.updateXu(xu);
            }
        }
        return money;
    }
    public static  int  countXuAvailabel() {
       return custDao.countXuAvailabel();
    }
    public static boolean updateHistoryXu(USERXUHISTORY userHistory){
    	return custDao.updateHistory(userHistory);
    }
}
