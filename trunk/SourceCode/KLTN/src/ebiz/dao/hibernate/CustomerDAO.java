package ebiz.dao.hibernate;

import java.util.List;

import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Assessment;
import ebiz.dto.account.customer.Comment;
import ebiz.dto.account.customer.Customer;

public class CustomerDAO implements ICustomerDAO {

    @Override
    public boolean saveCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean saveComment(Comment comment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean saveAss(Assessment content) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Assessment getAssByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCustomer(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Customer getCustomerById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getPhoneList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> getCustomerList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Assessment> getAssList() {
        // TODO Auto-generated method stub
        return null;
    }

}
