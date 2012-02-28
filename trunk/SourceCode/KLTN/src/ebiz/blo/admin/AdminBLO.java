package ebiz.blo.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jsr107cache.Cache;
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.SearchBLO;
import ebiz.dao.gae.AdminDAO;
import ebiz.dao.gae.OrderDAO;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.account.admin.Admin;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.checkout.OrderBill;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonUtil;
/**
 * @author ThuyNT
 */
public class AdminBLO {
    /** . */
    private static IAdminDAO adminDao = new AdminDAO();
    /** . */
    private static IOrderDAO orderDao = new OrderDAO();
    /**
     * [isLoginID].
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
     * [registerAdmin].
     * @param admin Admin
     * @return boolean
     */
    public static boolean registerAdmin(Admin admin) {

        boolean flag = adminDao.isAdmin(admin.getId());
        if (!flag) {
            return adminDao.saveAdmin(admin);
        }
        return false;
    }

    public static List<OrderBillForm> getOrderBillFormList(String value) {

        List<OrderBill> orderList = new ArrayList<OrderBill>();
        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
        // get all
        if ("0".equals(value)) {
            orderList = orderDao.getOrderList();
            // get by attr
        } else {
            orderList = orderDao.getOrderListByStatus(value);
        }

        for (OrderBill order : orderList) {
            OrderBillForm form = new OrderBillForm();
            // display
            form.editForm(order);
            formList.add(form);

        }
        return formList;
    }
    // get bill to shipping
    public static List<OrderBillForm> getOrderBillFormListDaily() {
        Date date = new Date();
        String d = CommonUtil.convertDateToString(date);
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
        // get money at home
        orderList = orderDao.getOrderList();
        for (OrderBill order : orderList) {
            if (order.getStatus().equals("1") || order.getStatus().equals("2")) {
                String dateOrder = CommonUtil.convertDateToString(order.getDateShip());
                // convert
                if (d.equals(dateOrder)) {
                    OrderBillForm form = new OrderBillForm();
                    // display
                    form.editForm(order);
                    formList.add(form);
                }
            }
        }
        return formList;
    }

    public static List<LoginForm> getCustomerList() {

        List<Customer> customerList = new ArrayList<Customer>();
        List<LoginForm> formList = new ArrayList<LoginForm>();
        // get all
        customerList = CustomerBLO.getCustomerList();
        for (Customer customer : customerList) {
            LoginForm form = new LoginForm();
            // display
            form.editForm(customer);
            formList.add(form);

        }
        Cache cache = SearchBLO.getMemcache();
        cache.put("adminCustomerData", formList);
        return formList;
    }

}
