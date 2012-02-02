/**
 * 
 */
package employee.ebiz.dao.gae;

import java.util.ArrayList;
import java.util.List;

import ebiz.dao.gae.PMF;
import ebiz.dto.food.Food;
import employee.ebiz.dao.inf.IEmployeeTaskDAO;
import employee.ebiz.dto.Employee;
import employee.ebiz.dto.EmployeeTask;

/**
 * @author nthanhphong
 *
 */
public class EmployeeTaskDAO implements IEmployeeTaskDAO{

	/* (non-Javadoc)
	 * @see employee.ebiz.dao.inf.IEmployeeTaskDAO#saveEmployeeTask(employee.ebiz.dto.EmployeeTask)
	 */
	@Override
	public boolean saveEmployeeTask(EmployeeTask employeeTask) {
		// TODO Auto-generated method stub
		return PMF.insertObject(employeeTask);
	}

	/* (non-Javadoc)
	 * @see employee.ebiz.dao.inf.IEmployeeTaskDAO#isEmployeeTask(java.lang.String)
	 */
	@Override
	public boolean isEmployeeTask(Long IdTask) {
		// TODO Auto-generated method stub
		if (IdTask != null) {
			return PMF.isObject(EmployeeTask.class, String.valueOf(IdTask));
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see employee.ebiz.dao.inf.IEmployeeTaskDAO#getEmployeeTaskById(java.lang.String)
	 */
	@Override
	public EmployeeTask getEmployeeTaskById(Long IdTask) {
		// TODO Auto-generated method stub
		EmployeeTask employeeTask = null;
		employeeTask = (EmployeeTask) PMF.getObjectById(EmployeeTask.class, IdTask);
		return employeeTask;
	}

	/* (non-Javadoc)
	 * @see employee.ebiz.dao.inf.IEmployeeTaskDAO#getEmployeeTaskList()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EmployeeTask> getEmployeeTaskList() {
		// TODO Auto-generated method stub
		List<EmployeeTask>  employeeTaskList = new ArrayList<EmployeeTask>();
		employeeTaskList = (List<EmployeeTask>) PMF.getObjectList(EmployeeTask.class);
		return employeeTaskList;
	}

	/* (non-Javadoc)
	 * @see employee.ebiz.dao.inf.IEmployeeTaskDAO#deleteEmployeeTask(java.lang.String)
	 */
	@Override
	public boolean deleteEmployeeTask(EmployeeTask employeeTask) {
		// TODO Auto-generated method stub
		return PMF.delete(employeeTask);
	}

}
