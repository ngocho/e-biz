package ebiz.blo.admin;

import java.util.ArrayList;
import java.util.List;

import net.sf.jsr107cache.Cache;
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.SearchBLO;
import ebiz.dao.gae.AdminDAO;
import ebiz.dao.gae.OrderDAO;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.account.admin.Admin;
import ebiz.dto.checkout.OrderBill;
import ebiz.form.OrderBillForm;
import ebiz.form.LoginForm;
import ebiz.util.CommonUtil;
import ebiz.dto.account.customer.Customer;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class AdminBLO {
	private static IAdminDAO adminDao = new AdminDAO();
	private static IOrderDAO orderDao = new OrderDAO();
	    public static int isLoginID(String id, String pass){
	    	Admin admin = adminDao.getAdminById(id);
	    	if (null != admin) {
				// get password
				String passCust = admin.getPassword();
				if (pass.equals(passCust)) {
					return 1; // success
				} else {
					return 0; // didn't match
				}
			} else {
				return -1; // didn't exist this user
			}
	    }
	    
	    public static boolean registerAdmin(Admin admin) {

	        boolean flag = adminDao.isAdmin(admin.getId());
	        if (!flag) {
	            return adminDao.saveAdmin(admin);
	        }
	        return false;
	    }
	    
	    public static List<OrderBillForm> getOrderBillFormList(String value){
	        
	        List<OrderBill> orderList = new ArrayList<OrderBill>();
	        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
	        //get all
	        if("0".equals(value)){
	            orderList = orderDao.getOrderList();
	        //get by attr
        } else {
	        orderList = orderDao.getOrderListByStatus(value);
	        }
	        
	        for(OrderBill order :orderList ){
	            OrderBillForm form = new OrderBillForm();
	            //display
	            form.editForm(order);
	            formList.add(form);
	            
	        }
//	        Cache cache = SearchBLO.getMemcache();
//	        cache.put("customerBillData", formList);
	        return formList;
	    }
	    //get bill to shipping
  public static List<OrderBillForm> getOrderBillFormListDaily(){
	  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  		Date date = new Date();
	  		String d = CommonUtil.convertDateToString(date);
	  		System.out.println(dateFormat.format(date));
	  		System.out.println("DATE BILL" + date);
	        List<OrderBill> orderList = new ArrayList<OrderBill>();
	        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
	        //get money at home
	        orderList = orderDao.getOrderList();
//	        //shipping
//	        orderList.addAll(orderDao.getOrderListByStatus("2"));
		for (OrderBill order : orderList) {
			if (order.getStatus().equals("1") || order.getStatus().equals("2")) {
				String dateOrder = CommonUtil.convertDateToString(order.getDateShip());
				//convert
				if(d.equals(dateOrder)){
				OrderBillForm form = new OrderBillForm();
				// display
				form.editForm(order);
				formList.add(form);
				}
			}
		}
//	        Cache cache = SearchBLO.getMemcache();
//	        cache.put("customerBillData", formList);
	        return formList;
	    }
  
	    public static List<LoginForm> getCustomerList(){
	        
	        List<Customer> customerList = new ArrayList<Customer>();
	        List<LoginForm> formList = new ArrayList<LoginForm>();
	        //get all
//	        if(value == null){
	        	customerList = CustomerBLO.getCustomerList();
//	        }
//	        //get by attr
//	        else{
//	        orderList = orderDao.getOrderListByStatus(value);
//	        }
//	        
	        for(Customer customer :customerList ){
	        	LoginForm form = new LoginForm();
	            //display
	            form.editForm(customer);
	            formList.add(form);
	            
	        }
	        Cache cache = SearchBLO.getMemcache();
	        cache.put("adminCustomerData", formList);
	        return formList;
	    }

}
