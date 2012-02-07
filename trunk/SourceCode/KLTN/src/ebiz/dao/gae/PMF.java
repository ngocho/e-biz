package ebiz.dao.gae;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
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
     * @param string
     * @return boolean
     */
    public static boolean isObject(Class<?> className, String string) {
        PersistenceManager pm = getPMF();
        try {

            pm.getObjectById(className, string);
        } catch (JDOObjectNotFoundException e) {
            return false;
        } finally {
            pm.close();
        }
        return true;
    }

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
 //OK
    public static boolean delete(Class<?> className,  Long id) {
        PersistenceManager pm = getPMF();
        
        try {
          pm.deletePersistent(pm.getObjectById(className , id));
          return true;
        }
          catch (Exception ex) {
              ex.printStackTrace();
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
//fail
    public static boolean delete(Object obj) {
        PersistenceManager pm = getPMF();
        
        try {
          pm.deletePersistent(obj);
          return true;
        }
          catch (Exception ex) {
              ex.printStackTrace();
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
    public static List<?> getObjectList(Class<?> className, String col, String order,int record, int page,String sql) {
		PersistenceManager pm = getPMF();
		Query query = pm.newQuery(className);
		query.setRange((record * (page - 1)), record * page);
		List<Object> results = new ArrayList<Object>();
		query.setFilter(sql);
		query.setOrdering(col + " " + order);
		System.out.println("QUERY !!!!!!!!!!!!!!" + query);
		try {
                results = (List<Object>) query.execute();

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
    public static List<?> getObjectListAll(Class<?> className, String col,List<String> numberPageList, String order,int record, int page, String sql) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        query.setRange((record * (page - 1)), record * page);
        List<Object> results = new ArrayList<Object>();
        if(!sql.equals("")){
        	 query.setFilter(sql);
        }
        query.setOrdering(col + " " + order);
        System.out.println("SQL"+query);
        try {
                results = (List<Object>) query.execute();
        } finally {
            query.closeAll();
        }
        System.out.println("SQL Result"+results.size());
        return results;
    }
    
    @SuppressWarnings("unchecked")
    public static List<?> displayPageFood(Class<?> className, String col,List<String> numberPageList, String order,int record, int page,String sql) {
        
        List<Object> results = new ArrayList<Object>();
        int count ;
        String tempSql ="";
        PersistenceManager pm = getPMF();
        if(!sql.equals("")){
        	tempSql = " where " + sql;
        }
        System.out.println("SQL "+sql);
        //re-count amount of page
        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName() + tempSql );
        try {
                count = (Integer)query.execute();
                //count number of page
                int div = count /record;
                if(count % record >0){
                    div = div + 1;
                }
                
         //put number of page into HashMap
                for( int  i =1; i<= div; i++){
                	numberPageList.add(String.valueOf(i));
                }
                results = (List<Object>) getObjectList(className,col,order,record,page,sql);

        } finally {
            query.closeAll();
        }
        return results;
    }
    
    @SuppressWarnings("unchecked")
    public static List<?> displayPageFoodAll(Class<?> className, String col,List<String> numberPageList, String order,int record, int page, String sql) {
        
        List<Object> results = new ArrayList<Object>();
        int count ;
        String tempSql ="";
        PersistenceManager pm = getPMF();
        if(!sql.equals("")){
        	tempSql = " where " + sql;
        	System.out.println("sql"+sql);
        }
        //re-count amount of page
        Query query = pm.newQuery("select count(" + col + ")  from " + className.getName() + tempSql) ;
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
                	numberPageList.add(String.valueOf(i));
                }
                results = (List<Object>) getObjectListAll(className,col,numberPageList,order,record,page, sql);

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
    /**
     * get list of object by input value order column (search, display
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByValue(Class<?> className, String col, Integer value) {
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = new ArrayList<Object>();
        query.setFilter(col + " == param");
        query.declareParameters("String param");
        try {
            results = (List<Object>) query.execute(value);
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
    /**
     * get list of object by input value order column (search, display
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByTwoValues(Class<?> className, String col1, String key1, String col2, Integer key2) {
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
        Query q = pm.newQuery(className,sql.toString());
        System.out.println(sql.toString());
//        Query q = pm.newQuery("select  from  " + className.getName()+ " where "+col1 +"== \""+key1 +"\" and  "+col2 +"== " + key2);
        List<Object> results = new ArrayList<Object>();
        try {
            results = (List<Object>) q.execute();
        } finally {
            q.closeAll();
        }
        return results;
    }
    /**
     * get list of object by input value order column (search, display
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<?> getObjectListByTwoValues(Class<?> className, String col1, String key1, String col2, String key2) {
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
        Query q = pm.newQuery(className,sql.toString());
        System.out.println(sql.toString());
//        Query q = pm.newQuery("select  from  " + className.getName()+ " where "+col1 +"== \""+key1 +"\" and  "+col2 +"== " + key2);
        List<Object> results = new ArrayList<Object>();
        try {
            results = (List<Object>) q.execute();
        } finally {
            q.closeAll();
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
    @SuppressWarnings("unchecked")
    public static List<?> searchListFoodByName(Class<?> className,String searchText, String type, String attr, String price, String status){
    	 PersistenceManager pm = getPMF();
    	 StringBuffer sqlSearch = new StringBuffer();
    	 sqlSearch.append("");
    	 if(!("0".equals(type))){
    		 sqlSearch.append(" && ");
    		 sqlSearch.append("foodStatusId == \'"+ type +"\'" );
    	 }
    	 if(!("0".equals(attr))){
    		 sqlSearch.append(" && ");
    		 sqlSearch.append("productAttributeId == \'"+ attr +"\'" );
    	 }
    	 if(!("0".equals(price))){
    		 sqlSearch.append(" && ");
    		 sqlSearch.append("foodPriceLevelId == \'"+ price +"\'" );
    	 }
    	 if(!("0".equals(status))){
    		 sqlSearch.append(" && ");
    		 sqlSearch.append("foodStatusId == \'"+ status +"\'" );
    	 }
    	 System.out.println("SQL SEARCH" +sqlSearch);
    	 Query q = pm.newQuery(className);

    	  // set the filter and params
    	  q.setFilter("foodName >= :1 && foodName < :2" + sqlSearch);
    	  System.out.println("TEXT SEARCH " + searchText);
    	  // run query with param values and return results
    	  return (List<Object>) q.execute(searchText , ( searchText + "\ufffd"));
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
