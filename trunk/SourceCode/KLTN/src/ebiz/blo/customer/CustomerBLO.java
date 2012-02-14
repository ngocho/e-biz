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
import ebiz.dto.account.customer.Comment;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.VoucherBill;
import ebiz.dto.checkout.OrderBill;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonUtil;
/**
 * @author ThuyNT
 *
 */
public class CustomerBLO {
    private static ICustomerDAO custDao = new CustomerDAO();
    private static IOrderDAO orderDao = new OrderDAO();
//    public static JSONObject getCustomerPhone() throws JSONException {
//        JSONObject json = new JSONObject();
//        List<String> phones = new ArrayList<String>();
//        // JSONArray phoneList = new JSONArray();
//        CustomerDAO dao = new CustomerDAO();
//        phones = dao.getPhoneList();
//
////        json.put("info", CommonConstant.CODECUSTOMER_0);
//
//        json.put("data", phones);
//
//        return json;
//    }
//    public static JSONObject createCustomerPhone() throws JSONException {
//        JSONObject json = new JSONObject();
//        List<String> phones = new ArrayList<String>();
//        //add data
//        phones.add("0978354952");
//        phones.add("0978354950");
//        phones.add("0978354951");
//        json.put("data", phones);
//
//        return json;
//    }
//    public static JSONObject createName() throws JSONException {
//        JSONObject json = new JSONObject();
//        List<String> names = new ArrayList<String>();
//        //add data
//        names.add("Mr A");
//        names.add("Mrs B ");
//        names.add("Mss C");
//        json.put("name", names);
//
//        return json;
//    }
//    public static List<JSONObject> createHappyBirth() throws JSONException {
//        List<JSONObject> objList = new ArrayList<JSONObject>();
//        JSONObject json = new JSONObject();
//        JSONObject json1 = new JSONObject();
//        //add data
//        json.put("phone", "0978349998");
//        json.put("name", " ChÃºc má»«ng sinh nháº­t Mr A! Tháº­t nhiá»�u may máº¯n vÃ  thÃ nh cÃ´ng");
//        objList.add(json);
//        json1.put("phone", "0978349999");
//        json1.put("name", "ChÃºc má»«ng sinh nháº­t Mrs B!  Tháº­t nhiá»�u may máº¯n vÃ  thÃ nh cÃ´ng");
//        objList.add(json1);
//        return objList;
//    }
//    public static List<JSONObject> createEmployeeInfo() throws JSONException {
//        List<JSONObject> objList = new ArrayList<JSONObject>();
//        
//        JSONObject json = new JSONObject();
//        JSONObject json1 = new JSONObject();
//        //add data
//        json.put("id", "123");
//        json.put("name", "Mr A");
//        json.put("x", "1");
//        json.put("y", "2");
//        objList.add(json);
//        json1.put("id", "123");
//        json1.put("name", "Mr B");
//        json1.put("x", "1");
//        json1.put("y", "2");
//        objList.add(json1);
//        return objList;
//    }
    /**
     * [deleteFood].
     * @param food          Food
     * @return              boolean
     */
    public static boolean deleteBill(Long idBill) {
        if (idBill != null) {
            OrderBill bill = getBillById(idBill);
            if (bill != null) {
                bill.setDeleted(true);
                System.out.println("DELETE");
                if (saveBillById(bill) != null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * [deleteFood].
     * @param food          Food
     * @return              boolean
     */
    public static boolean deleteBill(OrderBill bill) {
        return PMF.delete(OrderBill.class, bill.getId());
    }
    
    /**
     * [get Food by ID(Long type)].
     * @param id Long
     * @return Food
     */
    public static OrderBill getBillById(Long id) {
        return orderDao.getOrderBillById(id);
    }
    
    /**
     * [get Food by ID(Long type)].
     * @param id Long
     * @return Food
     */
    public static OrderBill saveBillById(OrderBill bill) {
        return orderDao.save(bill);
    }
    
    public static VoucherBill saveVoucher(VoucherBill voucher) {
        return orderDao.saveVoucherBill(voucher);
    }

    
    /**
     * get Customer by ID
     */
    
    public static List<Customer> getCustomerList(){
        return custDao.getCustomerList();
    }
    public static Customer getCustomerByID(String id){
        return custDao.getCustomerById(id);
        
    }
   /**
    * login
    * 
    */
    public static int isLoginID(String id, String pass){
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
    
    public static boolean isUID(String id){
        return custDao.isCustomer(id);
    }
    
    public static void getLoginVoucher(LoginForm login){
    	if(isUID(login.getLoginId())){
    		Customer customer = getCustomerByID(login.getLoginId());
    		login.editForm(customer);
    	}
    }
//    /**
//     * login
//     * 
//     */
//     public static int isLoginMailID(String id, String pass){
//     	Customer customer = custDao.getCustomerById(id);
//     	if (null != customer) {
// 			// get password
// 			String passCust = customer.getCustomerPassword();
// 			if (pass.equals(passCust)) {
// 				return 1; // success
// 			} else {
// 				return 0; // didn't match
// 			}
// 		} else {
// 			return -1; // didn't exist this user
// 		}
//
//     }
    
//    public static Customer getObject(LoginForm user){
//      Customer customer = new Customer();
//      customer.setCustomerId(user.getLoginId());
//      customer.setCustomerPassword(user.getLoginPassword());
//      customer.setCustomerName(user.getLoginName());
//      customer.setCustomerGender(user.getGender());
//      customer.setCustomerPhone(user.getPhone());
//      customer.setCustomerEmail(user.getEmail());
//      customer.setIsAdEmail(user.getIsAdEmail());
//      customer.setIsAdPhone(user.getIsAdPhone());
//      Address add = new Address();
//      add.setBuildingName(user.getBuildingName());
//      add.setDistrictName(user.getDistrictName());
//      add.setHomeNumber(user.getHomeNumber());
//      add.setStreetName(user.getStreetName());
//      add.setWardName(user.getWardName());
//      customer.setCustomerAddress(add);
//      return customer;
//        
//    }
    
//    public static LoginForm editForm(Customer customer){
//        LoginForm form  = new LoginForm();
//    }
    /**
     * get Customer by ID
     */
    
    public static boolean registerCustomer(Customer customer){
      
      boolean   flag = custDao.isCustomer(customer.getCustomerId());
         if(!flag){
         return  custDao.saveCustomer(customer);
         }
         return false;
   }
    public static boolean saveComment(Comment  comment){
    	return custDao.saveComment(comment);
    }
        
  
   
//    public static int testCustomerID(String id, String pass) {
//
//        return custDao.isCustomerID(id, pass);
//    }
//    public static int testCustomerEmail(String email, String pass) {
//
//        return custDao.isCustomerMail(email, pass);
//    }
    /**
     * 
     * if duplicate primarikey = over write
     * @param customer
     * @return
     */
    public static boolean updatecustomer(Customer customer) {
       return custDao.saveCustomer(customer);
    }
    
    public List<OrderBill> viewOrderHistory(String idCustomer){
    	
    	return orderDao.getOrListByIDCustomer(idCustomer);
    }
    
    public List<DetailOrder> viewOrderDetailHistory(Long idOrder){
    	
    	return orderDao.getDetailByIDOrBill(idOrder);
    }
    
    public static String toStringAddres(Address add){
        String address ="";
        if(!CommonUtil.isBlankOrNull(add.getHomeNumber())){
            address = address + add.getHomeNumber().toString() + ", ";
        }
        if(!CommonUtil.isBlankOrNull(add.getBuildingName())){
            address = address + add.getBuildingName().toString() + ", ";
        }
        if(!CommonUtil.isBlankOrNull(add.getStreetName())){
            address = address + add.getStreetName().toString() + ", ";
        }
        if(add.getWardName()!=null){
            address = address + add.getWardName().toString() + ", ";
        }
        if(add.getDistrictName()!=null){
            address = address + add.getDistrictName().toString();
        }
        return address;
    }
    
    public static String toStringAddres(String homeNumber , String buildingName , String streetName, String wardName, String districtName){
    	 String address ="";
    	 if(!CommonUtil.isBlankOrNull(homeNumber)){
             address = address + homeNumber + ", ";
         }
    	 if(!CommonUtil.isBlankOrNull(buildingName)){
             address = address + buildingName + ", ";
         }
    	 if(!CommonUtil.isBlankOrNull(streetName)){
             address = address + streetName + ", ";
         }
    	 if(!CommonUtil.isBlankOrNull(wardName)){
             address = address + wardName + ", ";
         }
    	 if(!CommonUtil.isBlankOrNull(districtName)){
             address = address + districtName + ", ";
         }
    	 return address;
    }
    public static List<OrderBillForm> getOrderBillFormList(String userId,String value){
        
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
        //get all
        if(value == null){
            orderList = orderDao.getOrListByIDCustomer(userId);
        }
        //get by attr
        else{
        orderList = orderDao.getOrListByStatus(userId,value);
        }
        
        for(OrderBill order :orderList ){
            OrderBillForm form = new OrderBillForm();
            System.out.println("Danh sach "+orderList.size() + " status "+ order.isDeleted());
            //display
            if(!order.isDeleted()){
            form.editForm(order);
            formList.add(form);
            }
        }
        Cache cache = SearchBLO.getMemcache();
        cache.put("customerBillData", formList);
        return formList;
    }
    
    //checkout by Xu account
    public static boolean checkoutXuOnline(String uid, long money){
        Customer customer = custDao.getCustomerById(uid);
        System.out.println("customer money " + customer.getXuOnline());
        if(customer !=null){
            long moneyXu = customer.getXuOnline();
            if(moneyXu >= money){
                customer.setXuOnline(moneyXu -money);
                updatecustomer(customer);
                return true;
            }
        }
        return false;
    }
    
  //checkout by Xu account
    public static boolean isXuOnline(String uid, long money){
        Customer customer = custDao.getCustomerById(uid);
        if(customer !=null){
            long moneyXu = customer.getXuOnline();
            if(moneyXu >= money){
                return true;
            }
        }
        return false;
    }
    
//    add Xu
	public static long  addXuOnline(String uid, long money) {
		Customer customer = custDao.getCustomerById(uid);
		if (customer != null) {
			customer.setXuOnline(customer.getXuOnline() + money);
			updatecustomer(customer);
			return customer.getXuOnline();
		}
		return 0;
	}
    
	 public static long getXuOnline(String uid){
		 Customer customer = custDao.getCustomerById(uid);
			if (customer != null) {
				return customer.getXuOnline();
			}
			return 0;
	 }
	 
    public static String getNameStatusByID(String id){
        return orderDao.getOrderStatusById(id);
    }
    public static boolean deleteFoodCustomer(Long id){
        OrderBill bill = orderDao.getOrderBillById(id);
        if(bill != null){
            bill.setDeleted(true);
            orderDao.save(bill);
            return true;
        }
        return false;
    }
    
   /* public static long updateXuOnline(String idCustomer, String idXu){
        IDXU xu = IDXUBLO.getXuById(idXu);
        long money = 0;
        //chua nap
        if(xu.getFlag().equals("true")){
            money = xu.getMoney();
        }
        //update xuOnline for customer
        Customer customer = getCustomerByID(idCustomer);
        
        customer.setXuOnline(money);
        if(updatecustomer(customer)){
            xu.setFlag("false");
            IDXUBLO.updateXu(xu);
        }
        return money;
    }
    public boolean isCheckoutXuOnline(long money, long moneyXu){
       
        if(moneyXu>=money){
            return true;
        }
        else{
            return false;
        }
    }*/
    
}
