/**
 * 
 */
package employee.ebiz.blo;

import java.util.ArrayList;
import java.util.List;

import ebiz.dao.gae.OrderDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.checkout.OrderBill;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonConstant;
import employee.ebiz.dao.gae.EmployeeDAO;
import employee.ebiz.dao.inf.IEmployeeDAO;
import employee.ebiz.dto.Employee;

/**
 * @author nthanhphong
 *
 */
public class EmployeeBLO {
	private static IEmployeeDAO custDao = new EmployeeDAO();
	private static IOrderDAO orderDao = new OrderDAO();
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
    
    public static int assignJob(String idEmployee,int numberJob) {
        List<OrderBill> orderList = orderDao.getOrderListByStatus(CommonConstant.BILLSTATUS_1);
        orderList.addAll(orderDao.getOrderListByStatus(CommonConstant.BILLSTATUS_2));
        if (!orderList.isEmpty()) {
            if (orderList.size() < numberJob) {
                numberJob = orderList.size();
            }
            for (int i = 0; i < numberJob; i++) {
                // assgin task
                orderList.get(i).setStatus(CommonConstant.BILLSTATUS_5);
                orderList.get(i).setIdEmployee(idEmployee);
                orderDao.save(orderList.get(i));
            }
        }
        return numberJob;

    }
    
    public static List<OrderBillForm> getListBillAssigned(String id){
        List<OrderBill> orderList = orderDao.getOrListByIDEmployee(id);
        List<OrderBillForm> orderFormList =  new ArrayList<OrderBillForm>();
        for(OrderBill bill : orderList){
            if(bill != null){
                OrderBillForm form = new OrderBillForm();
                form.editForm(bill);
                orderFormList.add(form);
            }
        }
        return orderFormList;
    }
}
