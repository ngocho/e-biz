/**
 * 
 */
package employee.ebiz.dao.inf;

import java.util.List;

import employee.ebiz.dto.Employee;

/**
 * @author nthanhphong
 *
 */
public interface IEmployeeDAO {
	
	public boolean saveEmployee(Employee employee);

	public boolean isEmployee(String username);

	public Employee getEmployeeById(String username);
	
	public List<Employee> getEmployeeList();
	
	public boolean deleteEmployee(String username);
}
