/**
 * Licensed to Open-Ones Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Open-Ones Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ebiz.blo.customer;

import java.util.ArrayList;
import java.util.List;

import net.sf.jsr107cache.Cache;
import ebiz.blo.food.SearchBLO;
import ebiz.dao.gae.CustomerDAO;
import ebiz.dao.gae.OrderDAO;
import ebiz.dao.gae.PMF;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Assessment;
import ebiz.dto.account.customer.Comment;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.VoucherBill;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonUtil;
/**
 * @author ThuyNT
 */
public class CustomerBLO {
    private static ICustomerDAO custDao = new CustomerDAO();
    private static IOrderDAO orderDao = new OrderDAO();
    /**
     * [deleteFood by Customer].
     * 
     * @param food Food
     * @return boolean
     */
    public static boolean deleteBillCustomer(Long idBill) {
        if (idBill != null) {
            OrderBill bill = getBillById(idBill);
            if (bill != null) {
                bill.setDeleted(true);
                if (saveBillById(bill) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * [deleteFood by Admin, System].
     * 
     * @param food Food
     * @return boolean
     */
    public static boolean deleteBill(OrderBill bill) {
        return PMF.delete(OrderBill.class, bill.getId());
    }

    /**
     * [get Food by ID(Long)].
     * 
     * @param id Long
     * @return Food
     */
    public static OrderBill getBillById(Long id) {
        return orderDao.getOrderBillById(id);
    }

    /**
     * [saveBillBy].
     * 
     * @param bill OrderBill
     * @return OrderBill
     */
    public static OrderBill saveBillById(OrderBill bill) {
        return orderDao.save(bill);
    }
    /**
     * [saveVoucher].
     * 
     * @param voucher VoucherBill
     * @return VoucherBill
     */
    public static VoucherBill saveVoucher(VoucherBill voucher) {
        return orderDao.saveVoucherBill(voucher);
    }
    public static VoucherBill getVoucherByID(Long idVoucher) {
        return orderDao.getVoucherByID(idVoucher);
    }
    /**
     * [getCustomerList].
     * 
     * @return List<Customer>
     */
    public static List<Customer> getCustomerList() {
        return custDao.getCustomerList();
    }
    /**
     * [getCustomerByID].
     * 
     * @param id getCustomerByID
     * @return Customer
     */
    public static Customer getCustomerByID(String id) {
        return custDao.getCustomerById(id);

    }
    /**
     * [isLoginID].
     * 
     * @param id String
     * @param pass String
     * @return flag int
     */
    public static int isLoginID(String id, String pass) {
        Customer customer = custDao.getCustomerById(id);
        if (null != customer) {
            // get password
            String passCust = customer.getCustomerPassword();
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
     * [isUID].
     * 
     * @param id String
     * @return flag boolean
     */
    public static boolean isUID(String id) {
        return custDao.isCustomer(id);
    }
    /**
     * [getLoginVoucher].
     * 
     * @param login LoginForm
     */
    public static void getLoginVoucher(LoginForm login) {
        if (isUID(login.getLoginId())) {
            Customer customer = getCustomerByID(login.getLoginId());
            login.editForm(customer);
        }
    }
    /**
     * [registerCustomer].
     * 
     * @param customer Customer
     * @return flag boolean
     */
    public static boolean registerCustomer(Customer customer) {

        boolean flag = custDao.isCustomer(customer.getCustomerId());
        if (!flag) {
            return custDao.saveCustomer(customer);
        }
        return false;
    }
    /**
     * [saveComment].
     * 
     * @param comment Comment
     * @return flag boolean
     */
    public static boolean saveComment(Comment comment) {
        return custDao.saveComment(comment);
    }
    /**
     * [saveAss].
     * 
     * @param content Assessment
     * @return flag boolean
     */
    public static boolean saveAss(Assessment content) {
        return custDao.saveAss(content);
    }
    /**
     * [getAss].
     * 
     * @param id String
     * @return Assessment
     */
    public static Assessment getAss(String id) {
        return custDao.getAssByID(id);
    }
    /**
     * [getAssList].
     * 
     * @return List<Assessment>
     */
    public static List<Assessment> getAssList() {
        return custDao.getAssList();
    }
    /**
     * [updateCustomer].
     * 
     * @param customer Customer
     * @return flag boolean
     */
    public static boolean updateCustomer(Customer customer) {
        return custDao.saveCustomer(customer);
    }
    /**
     * [viewOrderHistory].
     * 
     * @param idCustomer String
     * @return List<OrderBill>
     */
    public List<OrderBill> viewOrderHistory(String idCustomer) {

        return orderDao.getOrListByIDCustomer(idCustomer);
    }

    /**
     * [viewOrderDetailHistory].
     * 
     * @param idOrder Long
     * @return List<DetailOrder>
     */
    public List<DetailOrder> viewOrderDetailHistory(Long idOrder) {

        return orderDao.getDetailByIDOrBill(idOrder);
    }
    /**
     * [toStringAddres].
     * 
     * @param add Address
     * @return String
     */
    public static String toStringAddres(Address add) {
        String address = "";
        if (add != null) {
            if (!CommonUtil.isBlankOrNull(add.getHomeNumber())) {
                address = address + add.getHomeNumber().toString() + ", ";
            }
            if (!CommonUtil.isBlankOrNull(add.getBuildingName())) {
                address = address + add.getBuildingName().toString() + ", ";
            }
            if (!CommonUtil.isBlankOrNull(add.getStreetName())) {
                address = address + add.getStreetName().toString() + ", ";
            }
            if (add.getWardName() != null) {
                address = address + add.getWardName().toString() + ", ";
            }
            if (add.getDistrictName() != null) {
                address = address + add.getDistrictName().toString();
            }
        }
        return address;
    }
    public static String toStringAddres(String homeNumber, String buildingName, String streetName, String wardName,
            String districtName) {
        String address = "";
        if (!CommonUtil.isBlankOrNull(homeNumber)) {
            address = address + homeNumber + ", ";
        }
        if (!CommonUtil.isBlankOrNull(buildingName)) {
            address = address + buildingName + ", ";
        }
        if (!CommonUtil.isBlankOrNull(streetName)) {
            address = address + streetName + ", ";
        }
        if (!CommonUtil.isBlankOrNull(wardName)) {
            address = address + wardName + ", ";
        }
        if (!CommonUtil.isBlankOrNull(districtName)) {
            address = address + districtName + ", ";
        }
        return address;
    }
    public static List<OrderBillForm> getOrderBillFormList(String userId, String value) {

        List<OrderBill> orderList = new ArrayList<OrderBill>();
        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
        // get all
        if (value == null) {
            orderList = orderDao.getOrListByIDCustomer(userId);
        }
        // get by attr
        else {
            orderList = orderDao.getOrListByStatus(userId, value);
        }

        for (OrderBill order : orderList) {
            OrderBillForm form = new OrderBillForm();
            // display
            if (!order.isDeleted()) {
                form.editForm(order);
                formList.add(form);
            }
        }
        Cache cache = SearchBLO.getMemcache();
        cache.put("customerBillData", formList);
        return formList;
    }

    // checkout by Xu account
    public static boolean checkoutXuOnline(String uid, long money) {
        Customer customer = custDao.getCustomerById(uid);
        if (customer != null) {
            long moneyXu = customer.getXuOnline();
            if (moneyXu >= money) {
                customer.setXuOnline(moneyXu - money);
                updateCustomer(customer);
                return true;
            }
        }
        return false;
    }

    // transfer Xu account
    public static boolean transferXuOnline(String uidFrom, String uidTo, long money) {
        long result = 0;
        boolean flag = false;
        // down money of uidFrom
        flag = CustomerBLO.checkoutXuOnline(uidFrom, money);
        // up money of uidTo
        if (flag) {
            result = CustomerBLO.addXuOnline(uidTo, money);
        }
        // up money is Error -> roll back
        if (result == 0) {
            CustomerBLO.addXuOnline(uidFrom, money);
            flag = false;
        }
        return true;

    }
    public static boolean isXuOnline(String uid, long money) {
        Customer customer = custDao.getCustomerById(uid);
        if (customer != null) {
            long moneyXu = customer.getXuOnline();
            if (moneyXu >= money) {
                return true;
            }
        }
        return false;
    }

    // add Xu
    public static long addXuOnline(String uid, long money) {
        Customer customer = custDao.getCustomerById(uid);
        if (customer != null) {
            customer.setXuOnline(customer.getXuOnline() + money);
            updateCustomer(customer);
            return customer.getXuOnline();
        }
        return 0;
    }

    public static long getXuOnline(String uid) {
        Customer customer = custDao.getCustomerById(uid);
        if (customer != null) {
            return customer.getXuOnline();
        }
        return 0;
    }

    // public boolean isXuOnline()

    public static String getNameStatusByID(String id) {
        return orderDao.getOrderStatusById(id);
    }
    public static boolean deleteFoodCustomer(Long id) {
        OrderBill bill = orderDao.getOrderBillById(id);
        if (bill != null) {
            bill.setDeleted(true);
            orderDao.save(bill);
            return true;
        }
        return false;
    }

    /*
     * public static long updateXuOnline(String idCustomer, String idXu){ IDXU xu = IDXUBLO.getXuById(idXu); long money
     * = 0; //chua nap if(xu.getFlag().equals("true")){ money = xu.getMoney(); } //update xuOnline for customer Customer
     * customer = getCustomerByID(idCustomer);
     * 
     * customer.setXuOnline(money); if(updatecustomer(customer)){ xu.setFlag("false"); IDXUBLO.updateXu(xu); } return
     * money; } public boolean isCheckoutXuOnline(long money, long moneyXu){
     * 
     * if(moneyXu>=money){ return true; } else{ return false; } }
     */

}
