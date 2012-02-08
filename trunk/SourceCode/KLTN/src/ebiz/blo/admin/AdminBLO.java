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
import ebiz.dto.account.customer.Customer;

/**
 * @author ThuyNT
 */
public class AdminBLO {
    /** . */
    private static IAdminDAO adminDao = new AdminDAO();
    /** . */
    private static IOrderDAO orderDao = new OrderDAO();
    /**
     * [test isLoginID].
     *
     * @param id String
     * @param pass String
     * @return int
     */
    public static int isLoginID(String id, String pass) {
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

    /**
     * [register Admin].
     *
     * @param admin Admin
     * @return true if success, else failed
     */
    public static boolean registerAdmin(Admin admin) {

        boolean flag = adminDao.isAdmin(admin.getId());
        if (!flag) {
            return adminDao.saveAdmin(admin);
        }
        return false;
    }

    /**
     * [getOrderBillFormList].
     *
     * @param value : status of Bill
     * @return  List<OrderBillForm>
     */
    public static List<OrderBillForm> getOrderBillFormList(String value) {

        List<OrderBill> orderList = new ArrayList<OrderBill>();
        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
        // get all
        if (value == null) {
            orderList = orderDao.getOrderList();
        } else {
            orderList = orderDao.getOrderListByStatus(value);
        }

        for (OrderBill order : orderList) {
            OrderBillForm form = new OrderBillForm();
            // display
            form.editForm(order);
            formList.add(form);

        }
        Cache cache = SearchBLO.getMemcache();
        cache.put("customerBillData", formList);
        return formList;
    }

    /**
     * [getCustomerList].
     *
     * @return List<LoginForm>
     */
    public static List<LoginForm> getCustomerList() {

        List<Customer> customerList = new ArrayList<Customer>();
        List<LoginForm> formList = new ArrayList<LoginForm>();
        customerList = CustomerBLO.getCustomerList();
        for (Customer customer : customerList) {
            LoginForm form = new LoginForm();
            // display
            form.editForm(customer);
            formList.add(form);

        }
        //save in Memcache
        Cache cache = SearchBLO.getMemcache();
        cache.put("adminCustomerData", formList);
        return formList;
    }

}
