package ebiz.dao.inf;

import java.util.List;

import ebiz.dto.account.customer.Customer;

public interface ICustomerDAO {

	public boolean saveCustomer(Customer customer);

	public boolean isCustomer(String id);

	public Customer getCustomerById(String id);

	public List<String> getPhoneList();
	
	public List<Customer> getCustomerList();

}
