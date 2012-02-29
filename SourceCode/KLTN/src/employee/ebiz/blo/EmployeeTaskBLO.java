package employee.ebiz.blo;

import java.util.List;

import employee.ebiz.dao.gae.EmployeeTaskDAO;
import employee.ebiz.dao.inf.IEmployeeTaskDAO;
import employee.ebiz.dto.EmployeeTask;

/**
 * @author nthanhphong
 */
public class EmployeeTaskBLO {
    /** . */
    private static IEmployeeTaskDAO custDao = new EmployeeTaskDAO();

    /**
     * [Give the description for method].
     * @return List<EmployeeTask>
     */
    public static List<EmployeeTask> getEmployeeTaskList() {
        return custDao.getEmployeeTaskList();
    }

    /**
     * [Give the description for method].
     * @param idTask Long
     * @return EmployeeTask
     */
    public static EmployeeTask getEmployeeTaskByID(Long idTask) {
        return custDao.getEmployeeTaskById(idTask);
    }

    /**
     * [Give the description for method].
     * @param employeeTask EmployeeTask
     * @return boolean
     */
    public static boolean registerEmployeeTask(EmployeeTask employeeTask) {

        boolean flag = custDao.isEmployeeTask(employeeTask.getTaskId());
        if (!flag) {
            return custDao.saveEmployeeTask(employeeTask);
        }
        return false;
    }

    /**
     * [Give the description for method].
     * @param employeeTask EmployeeTask
     * @return boolean
     */
    public static boolean updateEmployeeTask(EmployeeTask employeeTask) {
        return custDao.saveEmployeeTask(employeeTask);
    }

    /**
     * [Give the description for method].
     * @param employeeTask EmployeeTask
     * @return boolean
     */
    public static boolean deleteEmployee(EmployeeTask employeeTask) {
        boolean flag = custDao.isEmployeeTask(employeeTask.getTaskId());
        if (flag) {
            return custDao.deleteEmployeeTask(employeeTask);
        }
        return false;
    }
}
