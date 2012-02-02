/**
 * 
 */
package employee.ebiz.blo;

import java.util.List;

import ebiz.dao.gae.CustomerDAO;
import ebiz.dao.gae.OrderDAO;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.account.customer.Customer;
import employee.ebiz.dao.gae.EmployeeDAO;
import employee.ebiz.dao.inf.IEmployeeDAO;
import employee.ebiz.dto.Employee;

/**
 * @author nthanhphong
 *
 */
public class EmployeeBLO {
	private static IEmployeeDAO custDao = new EmployeeDAO();
	
    public static List<Employee> getEmployeeList(){
        return custDao.getEmployeeList();
    }
    public static Employee getEmployeeByID(String username){
        return custDao.getEmployeeById(username);
    }
    public static int isLoginID(String username, String pass){
    	Employee employee = custDao.getEmployeeById(username);
    	if (null != employee) {
			// get password
			String passCust = employee.getEmployeePassword();
			if (pass.equals(passCust)) {
				return 1; // success
			} else {
				return 0; // didn't match
			}
		} else {
			return -1; // didn't exist this user
		}

    }
    public static boolean registerEmployee(Employee employee){
        
        boolean   flag = custDao.isEmployee(employee.getEmployeeId());
           if(!flag){
           return  custDao.saveEmployee(employee);
           }
           return false;
     }
    public static boolean updateEmployee(Employee employee) {
        return custDao.saveEmployee(employee);
     }
    public static boolean deleteEmployee(String username){
    	boolean   flag = custDao.isEmployee(username);
        if(flag){
        	return  custDao.deleteEmployee(username);
        }
        return false;
    }
}
