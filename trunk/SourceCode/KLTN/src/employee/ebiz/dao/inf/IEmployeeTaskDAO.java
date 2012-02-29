package employee.ebiz.dao.inf;

import java.util.List;

import employee.ebiz.dto.EmployeeTask;

/**
 * @author nthanhphong
 */
public interface IEmployeeTaskDAO {

    /**
     * [Give the description for method].
     * @param employeeTask EmployeeTask
     * @return boolean
     */
    public boolean saveEmployeeTask(EmployeeTask employeeTask);

    /**
     * [Give the description for method].
     * @param IdTask Long
     * @return boolean
     */
    public boolean isEmployeeTask(Long IdTask);

    /**
     * [Give the description for method].
     * @param IdTask Long
     * @return EmployeeTask
     */
    public EmployeeTask getEmployeeTaskById(Long IdTask);

    /**
     * [Give the description for method].
     * @return List<EmployeeTask>
     */
    public List<EmployeeTask> getEmployeeTaskList();

    /**
     * [Give the description for method].
     * @param employeeTask EmployeeTask
     * @return boolean
     */
    public boolean deleteEmployeeTask(EmployeeTask employeeTask);
}
