package ebiz.dao.gae;

import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

/**
 * PersistenceManagerFactory class.
 * @author ThuyNT
 *
 */
public final class PMF {
    /**
     * PersistenceManagerFactory object.
     */
    public static final PersistenceManagerFactory pmfInstance = JDOHelper
            .getPersistenceManagerFactory("transactions-optional");

    /**
     * Default constructor.
     */
    private PMF() {
    }

    /**
     * get PersistenceManagerFactory.
     * @return PersistenceManagerFactory
     */
    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }

    /**
     * Get PersistenceManager.
     * @return PersistenceManager
     */
    public static PersistenceManager getPMF() {
        return get().getPersistenceManager();
    }

    /**
     * Kiem tra su ton tai cua object trong database.
     * @param className object type
     * @param key primary key of object
     * @return boolean
     */
    public static boolean isObject(Class<?> className, String key) {
        PersistenceManager pm = getPMF();
        try {

            pm.getObjectById(className, key);
        } catch (JDOObjectNotFoundException e) {
            return false;
        } finally {
            pm.close();
        }
        return true;
    }

    /**
     * Insert data of object to database.
     * @param obj input object
     * @return true/false
     */
    public static boolean insertObject(Object obj) {
        PersistenceManager pm = getPMF();
        try {
            pm.makePersistent(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            pm.close();
        }
        return true;
    }

    /**
     * Save data of an object to database.
     * @param obj input object
     * @return object after save
     */
    public static Object save(Object obj) {
        PersistenceManager pm = getPMF();

        try {
            return pm.makePersistent(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            pm.close();
        }
    }

    /**
     * delete obj in database.
     * @param obj input object
     * @return true/false
     */
    public static boolean deleteObject(Object obj) {
        PersistenceManager pm = getPMF();

        try {
            pm.deletePersistent(obj);
        } catch (Exception ex) {
            return false;
        } finally {
            pm.close();
        }
        return true;
    }

    /**
     * get object by ID(String).
     * @param className object type
     * @param key of object
     * @return object
     */
    public static Object getObjectById(Class<?> className, String key) {
        PersistenceManager pm = getPMF();
        Object obj = null;
        try {
            obj = pm.getObjectById(className, key);
        } catch (Exception ex) {
            return null;
        } finally {
            pm.close();
        }
        return obj;
    }

    /**
     * get object by ID(Long).
     * @param className object type
     * @param key of object
     * @return output object
     */
    public static Object getObjectById(Class<?> className, Long key) {
        PersistenceManager pm = getPMF();
        Object obj = null;
        try {
            obj = pm.getObjectById(className, key);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            pm.close();
        }
        return obj;
    }

    /**
     * List object by emain.
     * @param className object type
     * @param mail email address
     * @return list of object
     */
    @SuppressWarnings("unchecked")
    public static List<Object> getObjectByMail(Class<?> className, String mail) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter("customerEmail == customerEmailParam");
        query.declareParameters("String customerEmailParam");
        try {
            detachedList = (List<Object>) query.execute(mail);
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }

    /**
     * get list of object.
     * @param className object type
     * @return list of object
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectList(Class<?> className) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        try {
            detachedList = (List<Object>) query.execute();
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }
    /**
     * delete all.
     * @param objs object type
     * @return true/false
     */
    public static boolean deleteAll(List<?> objs) {
        PersistenceManager pm = getPMF();

        try {
            pm.deletePersistentAll(objs);
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            pm.close();
        }

    }
    /**
     * delete 1 obj.
     * @param className object type
     * @param id of object
     * @return true/false
     */
    // OK
    public static boolean delete(Class<?> className, Long id) {
        PersistenceManager pm = getPMF();

        try {
            pm.deletePersistent(pm.getObjectById(className, id));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            pm.close();
        }

    }

    /**
     * delete 1 obj.
     * @param obj object
     * @return true/false
     */
    // fail
    public static boolean delete(Object obj) {
        PersistenceManager pm = getPMF();

        try {
            pm.deletePersistent(obj);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            pm.close();
        }

    }

    /**
     * get list of object( order by name).
     * @param className
     * @return
     */

    /**
     * getObjectList by some critical below.
     * @param className object type
     * @param col column name in database
     * @param order ascending/descending
     * @param record amount of record need to be list
     * @param page index of page need to be list
     * @param sql critical to list
     * @return list of object
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectList(Class<?> className, String col, String order, int record, int page, String sql) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        query.setRange((record * (page - 1)), record * page);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter(sql);

        query.setOrdering(col + " " + order);
        try {
            detachedList = (List<Object>) query.execute();
            results = (List<Object>) pm.detachCopyAll(detachedList);

        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }

    /**
     * List all object in a page.
     * @param className object type
     * @param col column name
     * @param numberPageList list of page list
     * @param order ascending/descending
     * @param record amount of record need to be list
     * @param page page to be list
     * @param sql critical to list
     * @return list of object
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListAll(Class<?> className, String col, List<String> numberPageList, String order,
            int record, int page, String sql) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        query.setRange((record * (page - 1)), record * page);
        List<Object> results = null;
        List<Object> detachedList = null;
        if (!sql.equals("")) {
            query.setFilter(sql);

        }
        query.setOrdering(col + " " + order);
        try {
            detachedList = (List<Object>) query.execute();
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }

    /**
     * count available object.
     * @param className object type
     * @param col column name
     * @param flag active/deactive (true/false)
     * @return amount of object
     */
    public static int countRecordObject(Class<?> className, String col, boolean flag) {
        int count = 0;
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName() + " where " + col + " == \'"
                + flag + "\'");
        try {
            count = (Integer) query.execute();
        } finally {
            pm.close();
        }
        return count;
    }
    @SuppressWarnings("unchecked")
    public static List<?> displayPageFood(Class<?> className, String col, List<String> numberPageList, String order,
            int record, int page, String sql) {

        List<Object> results = null;
        int count;
        String tempSql = "";
        PersistenceManager pm = getPMF();
        if (!sql.equals("")) {
            tempSql = " where " + sql;
        }

        // re-count amount of page
        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName() + tempSql);
        try {
            count = (Integer) query.execute();
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
            query.closeAll();
            pm.close();
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public static List<?> displayPageFoodAll(Class<?> className, String col, List<String> numberPageList, String order,
            int record, int page, String sql) {

        List<Object> results = null;
        int count;
        String tempSql = "";
        PersistenceManager pm = getPMF();
        if (!sql.equals("")) {
            tempSql = " where " + sql;

        }
        // re-count amount of page
        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName() + tempSql);
        try {
            count = (Integer) query.execute();
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
            query.closeAll();
            pm.close();
        }
        return results;
    }

    /**
     * get list of object by input value order column (search, display.
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, String key) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter(col + " == param");

        query.declareParameters("String param");
        try {
            detachedList = (List<Object>) query.execute(key);
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, Date key) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter(col + " == param");

        query.declareParameters("Date param");
        try {
            detachedList = (List<Object>) query.execute(key);
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValueOrder(Class<?> className, String col, Date key, String orderCol,
            String order) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter(col + " == param");

        query.setOrdering(orderCol + " " + order);
        query.declareParameters("Date param");
        try {
            detachedList = (List<Object>) query.execute(key);
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }

    /**
     * get list of object by input value order column (search, display
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, Integer value) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter(col + " == param");

        query.declareParameters("String param");
        try {
            detachedList = (List<Object>) query.execute(value);
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, Long key) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        query.setFilter(col + " == param");

        query.declareParameters("Long param");
        try {
            detachedList = (List<Object>) query.execute(key);
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            query.closeAll();
            pm.close();
        }
        return results;
    }
    /**
     * get list of object by input value order column (search, display
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByTwoValues(Class<?> className, String col1, String key1, String col2,
            Integer key2) {
        PersistenceManager pm = getPMF();

        StringBuffer sql = new StringBuffer();
        sql.append("( ");
        sql.append(col1);
        sql.append(" == \'");
        sql.append(key1);
        sql.append("\'");
        sql.append(" && ");
        sql.append(col2);
        sql.append(" == ");
        sql.append(key2);
        sql.append(" )");
        Query q = pm.newQuery(className, sql.toString());

        // Query q = pm.newQuery("select  from  " + className.getName()+ " where "+col1 +"== \""+key1 +"\" and  "+col2
        // +"== " + key2);
        List<Object> results = null;
        List<Object> detachedList = null;
        try {
            detachedList = (List<Object>) q.execute();
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            q.closeAll();
            pm.close();
        }
        return results;
    }
    /**
     * get list of object by input value order column (search, display).
     * 
     * @param className class name
     * @param col1 column
     * @param key1 key
     * @param col2 column
     * @param key2 key
     * @return list of object
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByTwoValues(Class<?> className, String col1, String key1, String col2,
            String key2) {
        PersistenceManager pm = getPMF();

        StringBuffer sql = new StringBuffer();
        sql.append("( ");
        sql.append(col1);
        sql.append(" == \'");
        sql.append(key1);
        sql.append("\'");
        sql.append(" && ");
        sql.append(col2);
        sql.append(" == \'");
        sql.append(key2);
        sql.append("\')");
        Query q = pm.newQuery(className, sql.toString());

        // Query q = pm.newQuery("select  from  " + className.getName()+ " where "+col1 +"== \""+key1 +"\" and  "+col2
        // +"== " + key2);
        List<Object> results = null;
        List<Object> detachedList = null;
        try {
            detachedList = (List<Object>) q.execute();
            results = (List<Object>) pm.detachCopyAll(detachedList);

        } finally {
            q.closeAll();
            pm.close();
        }
        return results;
    }

    /**
     * select column from table.
     * @param className name
     * @param col column
     * @return list of column
     */
    @SuppressWarnings("unchecked")
    public static List<?> getColList(Class<?> className, String col) {
        PersistenceManager pm = getPMF();
        Query q = pm.newQuery("select " + col + " from  " + className.getName());

        List<Object> results = null;
        List<Object> detachedList = null;
        try {
            detachedList = (List<Object>) q.execute();
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            q.closeAll();
            pm.close();
        }
        return results;
    }
    @SuppressWarnings("unchecked")
    public static List<?> searchListFoodByName(Class<?> className, String searchText, String type, String attr,
            String price, String status, String provider) {
        PersistenceManager pm = getPMF();
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

        Query q = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        // set the filter and params
        q.setFilter("foodName >= :1 && foodName < :2" + sqlSearch);

        // run query with param values and return results
        try {
            detachedList = (List<Object>) q.execute(searchText, (searchText + "\ufffd"));
            // db.GqlQuery("SELECT * FROM MyModel WHERE prop >= :1 AND prop < :2", "abc", u"abc" + u"\ufffd")
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            q.closeAll();
            pm.close();
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public static List<?> searchListProviderByName(Class<?> className, String value) {
        PersistenceManager pm = getPMF();
        // StringBuffer sqlSearch = new StringBuffer();
        // sqlSearch.append("");
        // if (!("0".equals(type))) {
        // sqlSearch.append(" && ");
        // sqlSearch.append("foodTypeId == \'" + type + "\'");
        // }
        // if (!("0".equals(attr))) {
        // sqlSearch.append(" && ");
        // sqlSearch.append("productAttributeId == \'" + attr + "\'");
        // }
        // if (!("0".equals(price))) {
        // sqlSearch.append(" && ");
        // sqlSearch.append("foodPriceLevelId == \'" + price + "\'");
        // }
        // if (!("0".equals(status))) {
        // sqlSearch.append(" && ");
        // sqlSearch.append("foodStatusId == \'" + status + "\'");
        // }
        //
        Query q = pm.newQuery(className);
        List<Object> results = null;
        List<Object> detachedList = null;
        // set the filter and params
        q.setFilter("providerName >= :1 && providerName < :2");

        // run query with param values and return results
        try {
            detachedList = (List<Object>) q.execute(value, (value + "\ufffd"));
            results = (List<Object>) pm.detachCopyAll(detachedList);
        } finally {
            q.closeAll();
            pm.close();
        }
        return results;
    }

}
