package ebiz.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ebiz.dto.account.admin.Admin;

/**
 * Provide some basic hibernate action.
 * @author DuyLT60571
 *
 */
public class HibernateHelper {

    /**
     * Use to save an object to database.
     * @param obj input object
     * @return true/false
     */
    public static boolean saveObject(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean saveSuccess = false;
        try {
        transaction = session.beginTransaction();
        session.saveOrUpdate(obj);
        saveSuccess = true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return saveSuccess;
    }

    /**
     * Deleted an object in database.
     * @param obj input object
     * @return true/false
     */
    public static boolean deleteObject(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean saveSuccess = false;
        try {
        transaction = session.beginTransaction();
        session.delete(obj);
        saveSuccess = true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return saveSuccess;
    }

}