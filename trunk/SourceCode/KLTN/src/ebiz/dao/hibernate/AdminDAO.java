package ebiz.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dto.account.admin.Admin;

/**
 * @author DuyLT2
 *
 */
public class AdminDAO implements IAdminDAO {
    @Override
    public Admin getAdminById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Admin admin = null;
        try {
        transaction = session.beginTransaction();
        admin = (Admin) session.get(Admin.class, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return admin;
    }

    @Override
    public boolean saveAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean saveSuccess = false;
        try {
        transaction = session.beginTransaction();
        session.saveOrUpdate(admin);
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

    @Override
    public boolean isAdmin(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Admin admin = null;
        try {
        transaction = session.beginTransaction();
        admin = (Admin) session.get(Admin.class, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return (admin != null);
    }

}
