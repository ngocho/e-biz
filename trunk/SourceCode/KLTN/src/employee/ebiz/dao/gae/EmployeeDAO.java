package employee.ebiz.dao.gae;

import java.util.ArrayList;
import java.util.List;

import ebiz.dao.gae.PMF;
import employee.ebiz.dao.inf.IEmployeeDAO;
import employee.ebiz.dto.Employee;

/**
 * @author nthanhphong
 */
public class EmployeeDAO implements IEmployeeDAO {

    /*
     * (non-Javadoc)
     * @see employee.ebiz.dao.inf.IemployeeDAO#saveEmployee(employee.ebiz.dto.Employee)
     */
    @Override
    public boolean saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return PMF.insertObject(employee);
    }

    /*
     * (non-Javadoc)
     * @see employee.ebiz.dao.inf.IemployeeDAO#isEmployee(java.lang.String)
     */
    @Override
    public boolean isEmployee(String username) {
        // TODO Auto-generated method stub
        return PMF.isObject(Employee.class, username);
    }

    /*
     * (non-Javadoc)
     * @see employee.ebiz.dao.inf.IemployeeDAO#getEmployeeById(java.lang.String)
     */
    @Override
    public Employee getEmployeeById(String username) {
        // TODO Auto-generated method stub
        Employee employee = null;
        employee = (Employee) PMF.getObjectById(Employee.class, username);
        return employee;
    }

    /*
     * (non-Javadoc)
     * @see employee.ebiz.dao.inf.IemployeeDAO#getEmployeeList()
     */
    @Override
    public List<Employee> getEmployeeList() {
        // TODO Auto-generated method stub
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList = (List<Employee>) PMF.getObjectList(Employee.class);
        return employeeList;
    }

    /*
     * (non-Javadoc)
     * @see employee.ebiz.dao.inf.IEmployeeDAO#deleteEmployee(java.lang.String)
     */
    @Override
    public boolean deleteEmployee(String username) {
        return PMF.deleteObject(getEmployeeById(username));
    }

}
