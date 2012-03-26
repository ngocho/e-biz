package ebiz.dao.hibernate;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.datanucleus.ClassNameConstants;
import org.hibernate.Query;
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

    /**
     * Will implement soon.
     * [Give the description for method].
     * @param className object type
     * @param col column name in database
     * @param order ascending/descending
     * @param record amount of record need to be list
     * @param page index of page need to be list
     * @param sql critical to list object
     * @return list of object
     */
    public static List<?> getObjectList(Class<?> className, String col, String order, int record, int page, String sql) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String tempQuery ="From ";
        tempQuery += className.getName();
        //query.setRange((record * (page - 1)), record * page);
        int fromRecord = (record * (page - 1));
        int toRecord   = (record * page);
        List<Object> results = null;
        tempQuery += sql;

        tempQuery += "Order by " + col + " " + order;
        try {
            //detachedList = (List<Object>) query.execute();
            results = (List<Object>) session.createQuery(tempQuery).list().subList(fromRecord, toRecord);
        } finally {
            session.flush();
            session.close();
        }
        return results;
    }

    public static List<?> displayPageFood(Class<?> className, String col, List<String> numberPageList, String order,
            int record, int page, String sql) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Object> results = null;
        int count;
        String tempSql = "";
        if (!sql.equals("")) {
            tempSql = " where " + sql;
        }

        // re-count amount of page
        Query query = session.createQuery("select count(" + col + ")  from " + className.getName() + tempSql);
        try {
            count = (Integer) query.uniqueResult();
            // count number of page
            int div = count / record;
            if (count % record > 0) {
                div = div + 1;
            }

            // put number of page into HashMap
            for (int i = 1; i <= div; i++) {
                numberPageList.add(String.valueOf(i));
            }
            results = (List<Object>) getObjectList(className, col, order, record, page, sql);

        } finally {
            session.flush();
            session.close();
        }
        return results;
    }

}