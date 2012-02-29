package employee.ebiz.dao.inf;

import java.util.List;

import employee.ebiz.dto.Employee;

/**
 * @author nthanhphong
 */
public interface IEmployeeDAO {
    /**
     * [Give the description for method].
     * @param employee Employee
     * @return boolean
     */
    public boolean saveEmployee(Employee employee);

    /**
     * [Give the description for method].
     * @param username String
     * @return boolean
     */
    public boolean isEmployee(String username);

    /**
     * [Give the description for method].
     * @param username String
     * @return Employee
     */
    public Employee getEmployeeById(String username);

    /**
     * [Give the description for method].
     * @return List<Employee>
     */
    public List<Employee> getEmployeeList();

    /**
     * [Give the description for method].
     * @param username String
     * @return boolean
     */
    public boolean deleteEmployee(String username);
}
