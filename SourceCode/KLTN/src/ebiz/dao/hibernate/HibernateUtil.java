package ebiz.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Helper class.
 * Use to create session factory
 * @author DuyLT60571
 *
 */
public class HibernateUtil {

    /**
     * Session factory use to return out.
     */
    private static final SessionFactory SESSIONFACTORY;
    static {
    try {
        SESSIONFACTORY = new Configuration().configure()
                             .buildSessionFactory();
    } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Use to return session factory object
     * [Give the description for method].
     * @return
     *          SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        // TODO Auto-generated method stub
        return SESSIONFACTORY;
    }
}
