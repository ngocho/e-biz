package ebiz.dao.hibernate;

import java.util.List;

import org.datanucleus.ClassNameConstants;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ebiz.dto.account.admin.Admin;
import ebiz.dto.account.customer.Customer;

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

    /**
     * Check object exist by long id.
     * @param classname type of dto
     * @param id primary key of dto
     * @return true/false
     */
    public static boolean isObject(Class<?> classname, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Object object = null;
        try {
        transaction = session.beginTransaction();
        object = session.get(classname, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return (object != null);
    }

    /**
     * Check object exist by string id.
     * @param classname type of dto
     * @param id primary key of dto
     * @return true/false
     */
    public static boolean isObject(Class<?> classname, String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Object object = null;
        try {
        transaction = session.beginTransaction();
        object = session.get(classname, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return (object != null);
    }
    /**
     * Check object exist by long id.
     * @param classname type of dto
     * @param id primary key of dto
     * @return true/false
     */
    public static boolean isObject(Class<?> classname, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Object object = null;
        try {
        transaction = session.beginTransaction();
        object = session.get(classname, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return (object != null);
    }

    /**
     * get an object in database by id.
     * @param classname type of dto
     * @param id string id of object
     * @return object with id
     */
    public static Object getObjectById(Class<?> classname, String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Object object = null;
        try {
        transaction = session.beginTransaction();
        object =  session.get(classname, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return object;
    }

    /**
     * get an object in database by id.
     * @param classname type of dto
     * @param id int id of object
     * @return object with id
     */
    public static Object getObjectById(Class<?> classname, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Object object = null;
        try {
        transaction = session.beginTransaction();
        object =  session.get(classname, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return object;
    }

    /**
     * get an object in database by id.
     * @param classname type of dto
     * @param id long id of object
     * @return object with id
     */
    public static Object getObjectById(Class<?> classname, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Object object = null;
        try {
        transaction = session.beginTransaction();
        object =  session.get(classname, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return object;
    }
    
    /**
     * Get list of all object exist in database.
     * @param classname type of dto
     * @return list of dto
     */
    public static List<?> getObjectList(Class<?> classname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Object> objectlist = null;
        try {
        transaction = session.beginTransaction();
        objectlist = (List<Object>) session.createQuery("from " + classname.getName()).list();
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return objectlist;
    }

}
