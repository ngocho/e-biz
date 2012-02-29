package mobile.ebiz.blo;

import mobile.ebiz.dao.gae.IdxuDAO;
import mobile.ebiz.dao.inf.IIdxuDAO;
import mobile.ebiz.dto.IDXU;
import mobile.ebiz.dto.USERXUHISTORY;

/**
 * @author nthanhphong
 */
public class IDXUBLO {
    /**  . */
    private static IIdxuDAO custDao = new IdxuDAO();

    /**
     * [Give the description for method].
     * @param idxu IDXU
     * @return boolean
     */
    public static boolean registerXu(IDXU idxu) {
        boolean flag = custDao.isXu(idxu.getId());
        if (!flag) {
            return custDao.saveXu(idxu);
        }
        return false;
    }

    /**
     * [Give the description for method].
     * @param id String
     * @return boolean
     */
    public static boolean isXu(String id) {
        // TODO Auto-generated method stub
        return custDao.isXu(id);
    }

    /**
     * [Give the description for method].
     * @param id String
     * @return IDXU
     */
    public static IDXU getXuById(String id) {
        // TODO Auto-generated method stub
        return custDao.getXuById(id);
    }
    /**
     * [Give the description for method].
     * @return boolean
     */
    public static boolean createListXu() {
        return custDao.createListxu();
    }
    /**
     * [Give the description for method].
     * @param idxu IDXU
     * @return boolean
     */
    public static boolean updateXu(IDXU idxu) {
        return custDao.saveXu(idxu);
    }
    /**
     * [Give the description for method].
     * @param id String
     * @return long
     */
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
    /**
     * [Give the description for method].
     * @return int
     */
    public static int countXuAvailabel() {
        return custDao.countXuAvailabel();
    }
    /**
     * [Give the description for method].
     * @param userHistory USERXUHISTORY
     * @return boolean
     */
    public static boolean updateHistoryXu(USERXUHISTORY userHistory) {
        return custDao.updateHistory(userHistory);
    }
}
