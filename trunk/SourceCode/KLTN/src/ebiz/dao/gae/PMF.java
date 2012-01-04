package ebiz.dao.gae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.datanucleus.store.appengine.query.JDOCursorHelper;

import com.google.appengine.api.datastore.Cursor;
public final class PMF {
    public static final PersistenceManagerFactory pmfInstance = JDOHelper
            .getPersistenceManagerFactory("transactions-optional");

    private PMF() {
    }

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
    public static PersistenceManager getPMF() {
        return get().getPersistenceManager();
    }

    /**
     * Kiem tra su ton tai cua object trong database
     * 
     * @param className
     * @param key
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

    public static boolean insertObject(Object obj) {
        PersistenceManager pm = getPMF();
        System.out.println("######### ");
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
    
    
    public static Object save(Object obj) {
        PersistenceManager pm = getPMF();

        try {
           return  pm.makePersistent(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            pm.close();
        }
    }
    /**
     * 
     * delete obj in database
     * @param obj
     * @return
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
     * get object by ID(String)
     * 
     * @param className
     * @param key
     * @return
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
     * get object by ID(Long)
     * 
     * @param className
     * @param key
     * @return
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
//    /**
//     * get object by ID (Long)
//     * 
//     * @param className
//     * @param key
//     * @return
//     */
//    public static Object getObjectById(Class<?> className, Long key) {
//        PersistenceManager pm = getPMF();
//        Query query = pm.newQuery(className);
//        query.setFilter("customerEmail == customerEmailParam");
//        Object obj = null;
//        try {
//            obj = pm.getObjectById(className, key);
//        } catch (Exception ex) {
//            return false;
//        } finally {
//            pm.close();
//        }
//        return obj;
//    }

    @SuppressWarnings("unchecked")
    public static List<Object> getObjectByMail(Class<?> className, String mail) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> resultList = new ArrayList<Object>();
        query.setFilter("customerEmail == customerEmailParam");
        query.declareParameters("String customerEmailParam");
        try {
            resultList = (List<Object>) query.execute(mail);

        } finally {
            query.closeAll();
        }
        return resultList;
    }

    /**
     * get list of object
     * 
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectList(Class<?> className) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = new ArrayList<Object>();
        // query.setFilter("lastName == lastNameParam");
       // query.setOrdering("hireDate desc");
        // query.declareParameters("String lastNameParam");
        try {
            results = (List<Object>) query.execute();
        } finally {
            query.closeAll();
        }
        return results;
    }
    /**
     * delete all
     * 
     * @param className
     * @return
     */
 
    public static boolean deleteAll(List<?> objs) {
        PersistenceManager pm = getPMF();
        
        try {
          pm.deletePersistentAll(objs);
          return true;
        }
          catch (Exception ex) {
              return false;
          }
        finally {
           pm.close();
        }
      
    }
    /**
     * delete 1 obj
     * 
     * @param className
     * @return
     */
 
    public static boolean delete( Object obj) {
        PersistenceManager pm = getPMF();
        
        try {
          pm.deletePersistent(obj);
          return true;
        }
          catch (Exception ex) {
              return false;
          }
        finally {
           pm.close();
        }
      
    }
    /**
     * get list of object( order by name)
     * 
     * @param className
     * @return
     */

    @SuppressWarnings("unchecked")
    public static List<?> getObjectList(Class<?> className, String col,HashMap<Integer, String> paging, String order,int record, int page,String filterCol, String typeProduct) {
        
		String cursorString = null;
		PersistenceManager pm = getPMF();
		Cursor cursor;
		if (paging.containsKey(page)) {
			cursorString = paging.get(page);
		}
		Query query = pm.newQuery(className);
		query.setRange((record * (page - 1)), record * page);
		List<Object> results = new ArrayList<Object>();
		query.setFilter(filterCol + " == param");
		query.declareParameters("String param");
		query.setOrdering(col + " " + order);
		try {
            if (cursorString == null) { // first page
                results = (List<Object>) query.execute(typeProduct);
                cursor = JDOCursorHelper.getCursor(results);
                
            } else {
                cursor = Cursor.fromWebSafeString(cursorString);
                Map<String, Object> extensionMap = new HashMap<String, Object>();
                extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
                query.setExtensions(extensionMap);
                results = (List<Object>) query.execute();
            }
            cursorString = cursor.toWebSafeString();
            paging.put(page, cursorString);

        } finally {
            query.closeAll();
        }
        return results;
    }
    
    /**
     * count paging and display first page
     * 
     * @param className
     * @return
     */

    @SuppressWarnings("unchecked")
    public static List<?> diplayPageFood(Class<?> className, String col,HashMap<Integer, String> paging, String order,int record, int page,String filterCol, String typeProduct) {
        
        List<Object> results = new ArrayList<Object>();
        int count ;
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName() + " where "+ filterCol +"  == \""+ typeProduct+ "\"");
        try {
                count = (Integer)query.execute();
                System.out.println("QUERY" +query.toString());
                System.out.println("COUNT"+ count);
                //count number of page
                int div = count /record;
                if(count % record >0){
                    div = div + 1;
                }
                
                //put number of page into HashMap
                for( int  i =1; i<= div; i++){
                    paging.put(i, null);
                }
                results = (List<Object>) getObjectList(className,col,paging,order,record,page,filterCol, typeProduct);

        } finally {
            query.closeAll();
        }
        return results;
    }

//    /**
//     * count paging and display first page
//     * 
//     * @param className
//     * @return
//     */
//
//    @SuppressWarnings("unchecked")
//    public static void   countPaging(Class<?> className, String col,HashMap<Integer, String> paging, String order,int record,int page) {
//        int count ;
//        PersistenceManager pm = getPMF();
//        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName());
//        try {
//                count = (Integer)query.execute();
//                
//                //count number of page
//                int div = count /record;
//                if(count % record >0){
//                    div = div + 1;
//                }
//                
//                //put number of page into HashMap
//                for( int  i =1; i<= div; i++){
//                    paging.put(i, null);
//                }
//                getObjectList(className,col,paging,order,record,page);
//
//        } finally {
//            query.closeAll();
//        }
//        return count;
//    }
   
    /**
     * get list of object by input value order column (search, display
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, String key) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = new ArrayList<Object>();
        query.setFilter(col + " == param");
        query.declareParameters("String param");
        try {
            results = (List<Object>) query.execute(key);
        } finally {
            query.closeAll();
        }
        return results;
    }
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, Long key) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = new ArrayList<Object>();
        query.setFilter(col + " == param");
        query.declareParameters("Long param");
        try {
            results = (List<Object>) query.execute(key);
        } finally {
            query.closeAll();
        }
        return results;
    }
//    /**
//     * get list of object by input value order column (search, display
//     * @param className
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public static List<?> getValueObject(Class<?> className, String col, String key) {
//        PersistenceManager pm = getPMF();
//        Query query = pm.newQuery(className);
//        List<Object> results = new ArrayList<Object>();
//        query.setFilter(col + " == param");
//        query.declareParameters("String param");
//        try {
//            results = (List<Object>) query.execute(key);
//        } finally {
//            query.closeAll();
//        }
//        return results;
//    }

    /**
     * 
     * select column from talbe
     * @param className
     * @param col
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getColList(Class<?> className, String col) {
        PersistenceManager pm = getPMF();
        Query q = pm.newQuery("select " + col + " from  " + className.getName());

        List<Object> results = new ArrayList<Object>();
        try {
            results = (List<Object>) q.execute();
        } finally {
            q.closeAll();
        }
        return results;
    }
//    /**
//     * 
//     * get list attribute, type
//     * @param className
//     * @param id
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public static List<?> getSearch(Class<?> className, String id) {
//        PersistenceManager pm = getPMF();
//        Query query = pm.newQuery(className);
//        List<Object> results = new ArrayList<Object>();
//        query.setFilter(col + " == param");
//        query.declareParameters("String param");
//        try {
//            results = (List<Object>) query.execute(key);
//        } finally {
//            query.closeAll();
//        }
//        return results;
//    }

}