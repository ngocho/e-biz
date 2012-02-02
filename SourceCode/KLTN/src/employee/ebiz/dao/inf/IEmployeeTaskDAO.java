/**
 * 
 */
package employee.ebiz.dao.inf;

import java.util.List;

import employee.ebiz.dto.Employee;
import employee.ebiz.dto.EmployeeTask;

/**
 * @author nthanhphong
 *
 */
public interface IEmployeeTaskDAO {
	
	public boolean saveEmployeeTask(EmployeeTask employeeTask);

	public boolean isEmployeeTask(Long IdTask);

	public EmployeeTask getEmployeeTaskById(Long IdTask);
	
	public List<EmployeeTask> getEmployeeTaskList();
	
	public boolean deleteEmployeeTask(EmployeeTask employeeTask);
}
