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

        try {
            pm.makePersistent(obj);
        } catch (Exception ex) {
            return false;
        } finally {
            pm.close();
        }
        return true;
    }
    /**
     * 
     * get object by ID
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
            return false;
        } finally {
            pm.close();
        }
        return obj;
    }
    
    @SuppressWarnings("unchecked")
    public static List<Object> getObjectList(Class<?> className){
        PersistenceManager pm = getPMF();
        Query query = pm.newQuery(className);
        List<Object> results = new ArrayList<Object>();
//        query.setFilter("lastName == lastNameParam");
//        query.setOrdering("hireDate desc");
//        query.declareParameters("String lastNameParam");
        try {
            results = (List<Object>) query.execute();
        } finally {
            query.closeAll();
        }
        return results;
    }
}
