/**
 * 
 */
package employee.ebiz.blo;

import java.util.List;

import employee.ebiz.dao.gae.EmployeeDAO;
import employee.ebiz.dao.gae.EmployeeTaskDAO;
import employee.ebiz.dao.inf.IEmployeeDAO;
import employee.ebiz.dao.inf.IEmployeeTaskDAO;
import employee.ebiz.dto.Employee;
import employee.ebiz.dto.EmployeeTask;

/**
 * @author nthanhphong
 *
 */
public class EmployeeTaskBLO {
	private static IEmployeeTaskDAO custDao = new EmployeeTaskDAO();
	
	public static List<EmployeeTask> getEmployeeTaskList(){
        return custDao.getEmployeeTaskList();
    }
	
    public static EmployeeTask getEmployeeTaskByID(Long idTask){
        return custDao.getEmployeeTaskById(idTask);
    }
    
    public static boolean registerEmployeeTask(EmployeeTask employeeTask){
        
        boolean   flag = custDao.isEmployeeTask(employeeTask.getTaskId());
           if(!flag){
           return  custDao.saveEmployeeTask(employeeTask);
           }
           return false;
     }
    
    public static boolean updateEmployeeTask(EmployeeTask employeeTask) {
        return custDao.saveEmployeeTask(employeeTask);
     }
    
    public static boolean deleteEmployee(EmployeeTask employeeTask){
    	boolean   flag = custDao.isEmployeeTask(employeeTask.getTaskId());
        if(flag){
        	return  custDao.deleteEmployeeTask(employeeTask);
        }
        return false;
    }
}
