package ebiz.dao.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Assessment;
import ebiz.dto.account.customer.Comment;
import ebiz.dto.account.customer.Customer;
/**
 * Customer dao implement in hibernate.
 * @author DuyLT60571
 *
 */
public class CustomerDAO implements ICustomerDAO {

    @Override
    public boolean saveCustomer(Customer customer) {
        return HibernateHelper.saveObject(customer);
    }

    @Override
    public boolean saveComment(Comment comment) {
        return HibernateHelper.saveObject(comment);
    }

    @Override
    public boolean saveAss(Assessment content) {
        return HibernateHelper.saveObject(content);
    }

    @Override
    public Assessment getAssByID(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Assessment assessment = null;
        try {
        transaction = session.beginTransaction();
        assessment = (Assessment) session.get(Assessment.class, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return assessment;
    }

    @Override
    public boolean isCustomer(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Customer customer = null;
        try {
        transaction = session.beginTransaction();
        customer = (Customer) session.get(Customer.class, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return (customer != null);
    }

    @Override
    public Customer getCustomerById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Customer customer = null;
        try {
        transaction = session.beginTransaction();
        customer = (Customer) session.get(Customer.class, id);
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return customer;
    }

    @Override //not implement, will be implement in next short time
    public List<String> getPhoneList() {
        return null;
    }

    @Override
    public List<Customer> getCustomerList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Customer> customers = null;
        try {
        transaction = session.beginTransaction();
        customers = (List<Customer>) session.createQuery("from Customer");
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return customers;
    }

    @Override
    public List<Assessment> getAssList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Assessment> assessment = null;
        try {
        transaction = session.beginTransaction();
        assessment = (List<Assessment>) session.createQuery("from Assessment");
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return assessment;
    }

}
