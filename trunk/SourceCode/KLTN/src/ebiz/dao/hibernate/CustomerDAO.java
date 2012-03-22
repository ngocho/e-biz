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
        return (Assessment) HibernateHelper.getObjectById(Assessment.class, id);
    }

    @Override
    public boolean isCustomer(String id) {
        return HibernateHelper.isObject(Customer.class, id);
    }

    @Override
    public Customer getCustomerById(String id) {
        return (Customer) HibernateHelper.getObjectById(Customer.class, id);
    }


    @Override
    public List<Customer> getCustomerList() {
        return (List<Customer>) HibernateHelper.getObjectList(Customer.class);
    }

    @Override
    public List<Assessment> getAssList() {
        return (List<Assessment>) HibernateHelper.getObjectList(Assessment.class);
    }

}
