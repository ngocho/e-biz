package ebiz.dao.hibernate;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.datanucleus.ClassNameConstants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ebiz.dto.account.admin.Admin;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.VoucherBill;
import ebiz.dto.food.Food;

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
        transaction.commit();
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
        transaction.commit();
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

    public static List<?> displayPageFoodAll(Class<?> className, String col, List<String> numberPageList,
            String order, int record, int page, String sql) {
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
            results = (List<Object>) getObjectListAll(className, col, numberPageList, order, record, page, sql);

        } finally {
            session.close();
        }
        return results;
    }

    private static List<Object> getObjectListAll(Class<?> className, String col, List<String> numberPageList,
            String order, int record, int page, String sql) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String tempQuery = "";
        tempQuery += "From " + className.getName();
        List<Object> results = null;
        if (!sql.equals("")) {
            tempQuery += " Where " + sql;
        }
        //query.setOrdering(col + " " + order);
        tempQuery += "Order by " + col + " " + order;
        try {
            Query query = session.createQuery(tempQuery);
            results = (List<Object>) query.list().subList((record * (page - 1)), record * page);
        } finally {
            session.close();
        }
        return results;
    }

    /**
     * [searchListFoodByName].
     * @param classname object type
     * @param searchText critical to search
     * @param type type of food
     * @param attr attribute of food
     * @param price price of food
     * @param status status of food
     * @param provider provider of food
     * @return list of result
     */
    public static List<?> searchListFoodByName(Class<?> classname, String searchText, String type, String attr,
            String price, String status, String provider) {
        //PersistenceManager pm = getPMF();
        Session session = HibernateUtil.getSessionFactory().openSession();
        StringBuffer sqlSearch = new StringBuffer();
        sqlSearch.append("");
        if (!("0".equals(type))) {
            sqlSearch.append(" && ");
            sqlSearch.append("foodTypeId == \'" + type + "\'");
        }
        if (!("0".equals(attr))) {
            sqlSearch.append(" && ");
            sqlSearch.append("productAttributeId == \'" + attr + "\'");
        }
        if (!("0".equals(price))) {
            sqlSearch.append(" && ");
            sqlSearch.append("foodPriceLevelId == \'" + price + "\'");
        }
        if (!("0".equals(status))) {
            sqlSearch.append(" && ");
            sqlSearch.append("foodStatusId == \'" + status + "\'");
        }
        if (!("0".equals(provider))) {
            sqlSearch.append(" && ");
            sqlSearch.append("providerID == \'" + provider + "\'");
        }

        //Query q = pm.newQuery(className);
        String tempQuery = "";
        tempQuery += "From " + classname.getName();
        List<Object> results = null;
        // set the filter and params
        //q.setFilter("foodName >= :1 && foodName < :2" + sqlSearch);
        tempQuery += " Where foodName like %:searchtext% " + sqlSearch;

        // run query with param values and return results
        try {
            Query query = session.createQuery(tempQuery);
            query.setString(":searchtext", searchText);
            //detachedList = (List<Object>) q.execute(searchText, (searchText + "\ufffd"));
            // db.GqlQuery("SELECT * FROM MyModel WHERE prop >= :1 AND prop < :2", "abc", u"abc" + u"\ufffd")
            results = (List<Object>) query.list();
        } finally {
            session.close();
        }
        return results;
    }

    /**
     *
     * Save an order to database.
     * @param order input order use to save
     * @return order object with it's id
     */
    public static OrderBill saveOrder(OrderBill order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        session.flush();
        transaction.commit();
        return order;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
    /**
    *
    * Save an order to database.
    * @param bill input order use to save
    * @return order object with it's id
    */
   public static VoucherBill saveVoucherBill(VoucherBill bill) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction transaction = null;
       try {
       transaction = session.beginTransaction();
       session.saveOrUpdate(bill);
       session.flush();
       transaction.commit();
       return bill;
       } catch (Exception e) {
           transaction.rollback();
           e.printStackTrace();
       } finally {
           session.close();
       }
       return null;
   }

    /**
     * Delete list of object with transaction implement.
     * @param list list of object
     * @return true/false success/not success
     */
    public static boolean deleteListObject(List<?> list) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        for (Object object : list) {
            session.delete(object);
        }
        session.flush();
        transaction.commit();
        return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     *
     * Get list of object depend it's attribute.
     * @param className object type
     * @param col name of attribute
     * @param key value of above attribute
     * @return list of result object
     */
    public static List<?> getObjectListByValue(Class<?> className, String col, String key) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object> results = null;

        String queryString = "From " + className.getName();
        queryString += " Where " + col + " = :value";

        Query query = session.createQuery(queryString);
        query.setString(":value", key);

        try {
            results = (List<Object>) query.list();
        } finally {
            session.close();
        }
        return results;
    }

    /**
    *
    * Get list of object depend it's attribute.
    * @param className object type
    * @param col name of attribute
    * @param key value of above attribute
    * @return list of result object
    */
   public static List<?> getObjectListByValue(Class<?> className, String col, Long key) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       List<Object> results = null;

       String queryString = "From " + className.getName();
       queryString += " Where " + col + " = :value";

       Query query = session.createQuery(queryString);
       query.setLong(":value", key);

       try {
           results = (List<Object>) query.list();
       } finally {
           session.close();
       }
       return results;
   }

    /**
     * getObjectListByTwoValues - get list of object depend 2 attribute.
     * @param className object type
     * @param col1 attribute 1
     * @param key1 value of attribute 1
     * @param col2 attribute 2
     * @param key2 value of attribute 2
     * @return list of object
     */
    public static List<?> getObjectListByTwoValues(Class<?> className, String col1, String key1, String col2,
            String key2) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        StringBuffer criticalSql = new StringBuffer();
        criticalSql.append("( ");
        criticalSql.append(col1);
        criticalSql.append(" == :value1");
        criticalSql.append(" && ");
        criticalSql.append(col2);
        criticalSql.append(" == :value2");
        criticalSql.append(" )");

        //Create query string from input parameter.
        String queryString = "From " + className.getName() + " Where " + criticalSql.toString();

        /**
         * create query in hibernate with 2 parameter.
         */
        Query query = session.createQuery(queryString);
        query.setString(":value1", key1);
        query.setString(":value2", key1);

        List<Object> results = null;
        try {
            results = (List<Object>) query.list();

        } finally {
            session.close();
        }
        return results;
    }

}
