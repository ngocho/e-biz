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
package ebiz.form;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.VoucherBill;
import ebiz.dto.food.Food;
import ebiz.util.CommonConstant;
import ebiz.util.CommonUtil;
/**
 * @author Administrator
 *
 */
public class OrderBillForm extends ValidatorForm implements Serializable {
    /**  . */
    private static final long serialVersionUID = 1L;
    /** id . */
    private Long id;
    /**idCustomer  . */
    private String idCustomer;
    /**  . */
    private String nameCustomer;
    /**address . */
    private String address;
    /**email  . */
    private String email;
    /**phone  . */
    private String phone;
    /**dateOrder  . */
    private String dateOrder;
    /** dateShip . */
    private String dateShip;
    /**sumPrice  . */
    private long sumPrice;
    /**status  . */
    private String status;
    /**status  Name. */
    private String nameStatus;
    /**numberProduct  . */
    private int numberProduct;
    /**phoneWebsite  . */
    private String phoneWebsite;
    /**idEmployee  . */
    private String idEmployee;
    /**homeNumber  . */
    private String homeNumber;
    /** streetName . */
    private String streetName;
    /**wardName  . */
    private String wardName;
    /** districtName . */
    private String districtName;
    /** buildingName . */
    private String buildingName;
    /** note(OrderBill) . */
    private String note;
    /** isPayment . */
    private int  isPayment;
    /**
     *  numberVoucher
     */
    private int numberVoucher;
    private Long idFood;
    /**
     * [editForm].
     * @param order         OrderBill
     */
    public void editForm(OrderBill order) {
        id = order.getId();
        idCustomer = order.getIdCustomer();
        address = order.getAddress();
        email = order.getEmail();
        phone = order.getPhone();
        dateOrder = CommonUtil.convertDateToString(order.getDateOrder());
        dateShip = CommonUtil.convertDateToString(order.getDateShip());
        sumPrice = order.getSumPrice();
        status = order.getStatus();
        nameStatus = CustomerBLO.getNameStatusByID(order.getStatus());
        idEmployee = order.getIdEmployee();
        note = order.getNote();
        isPayment = order.getTypePayment();
        sumPrice = order.getSumPrice();
    }
    public void editFormLogin(LoginForm form) {
    	this.idCustomer = form.getLoginId();
    	this.homeNumber = form.getHomeNumber();
    	this.districtName = form.getDistrictName();
    	this.wardName = form.getWardName();
    	this.buildingName = form.getBuildingName();
    	this.streetName = form.getStreetName();
    	this.email = form.getEmail();
    	this.phone = form.getPhone();
    }
    
    public void sumVoucherMoney(){
    	Food food = FoodBLO.getFoodById(this.idFood);
    	long money = 0;
    	//promotion food
    	if(food.getFoodStatusId().equals("1")){
    		money = food.getPricePromotion();
    	}
    	else{
    		money = food.getPrice();
    	}
    	this.sumPrice = money * this.numberVoucher;
    	
    }
    public VoucherBill getVoucher() {
    	VoucherBill voucher = new VoucherBill();
    	voucher.setIdCustomer(this.idCustomer);
    	voucher.setIdFood(this.idFood);
    	voucher.setSumMoney(this.sumPrice);
    	voucher.setNumber(this.numberVoucher);
    	String add = CustomerBLO.toStringAddres(homeNumber, buildingName, streetName, wardName, districtName);
    	voucher.setAddress(add);
    	return voucher;
    }
    /**
     * [getOrder].
     * @return     OrderBill
     */
    public OrderBill getOrder() {
        OrderBill order = new OrderBill();
        order.setIdCustomer(this.idCustomer);
        order.setEmail(this.email);
        order.setPhone(this.phone);
        order.setStatus(CommonConstant.BILLSTATUS_1); // chua giao
        order.setDateOrder(CommonUtil.formatDateToDate(new Date()));
        order.setDateShip(CommonUtil.convertStringToDate(this.dateShip));
        this.address = CustomerBLO.toStringAddres(homeNumber, buildingName, streetName, wardName, districtName);
        order.setAddress(this.address);
        order.setNote(this.note);
        order.setTypePayment(this.isPayment);
        return order;
    }
    /**
     * [editCustomer].
     * @param user              Customer
     */
    public void editCustomer(Customer user) {
        this.idCustomer = user.getCustomerId();
        this.nameCustomer = user.getCustomerName();
        this.phone = user.getCustomerPhone();
        this.email = user.getCustomerEmail();
        this.buildingName = user.getCustomerAddress().getBuildingName();
        this.districtName = user.getCustomerAddress().getDistrictName();
        this.homeNumber = user.getCustomerAddress().getHomeNumber();
        this.streetName = user.getCustomerAddress().getStreetName();
        this.wardName = user.getCustomerAddress().getWardName();
                                                  
                                                  
                                                  
                                                  
                                                  
    }
    /**
     * Get value of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get value of idCustomer.
     * @return the idCustomer
     */
    public String getIdCustomer() {
        return idCustomer;
    }
    /**
     * Set the value for idCustomer.
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
    /**
     * Get value of address.
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Set the value for address.
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Get value of email.
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set the value for email.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Get value of phone.
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Set the value for phone.
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Get value of dateOrder.
     * @return the dateOrder
     */
    public String getDateOrder() {
        return dateOrder;
    }
    /**
     * Set the value for dateOrder.
     * @param dateOrder the dateOrder to set
     */
    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }
    /**
     * Get value of dateShip.
     * @return the dateShip
     */
    public String getDateShip() {
        return dateShip;
    }
    /**
     * Set the value for dateShip.
     * @param dateShip the dateShip to set
     */
    public void setDateShip(String dateShip) {
        this.dateShip = dateShip;
    }
    /**
     * Get value of sumPrice.
     * @return the sumPrice
     */
    public long getSumPrice() {
        return sumPrice;
    }
    /**
     * Set the value for sumPrice.
     * @param sumPrice the sumPrice to set
     */
    public void setSumPrice(long sumPrice) {
        this.sumPrice = sumPrice;
    }
    /**
     * Get value of numberProduct.
     * @return the numberProduct
     */
    public int getNumberProduct() {
        return numberProduct;
    }
    /**
     * Set the value for numberProduct.
     * @param numberProduct the numberProduct to set
     */
    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }
    /**
     * Get value of nameCustomer.
     * @return the nameCustomer
     */
    public String getNameCustomer() {
        return nameCustomer;
    }
    /**
     * Set the value for nameCustomer.
     * @param nameCustomer the nameCustomer to set
     */
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    /**
     * Get value of phoneWebsite.
     * @return the phoneWebsite
     */
    public String getPhoneWebsite() {
        return phoneWebsite;
    }
    /**
     * Set the value for phoneWebsite.
     * @param phoneWebsite the phoneWebsite to set
     */
    public void setPhoneWebsite(String phoneWebsite) {
        this.phoneWebsite = phoneWebsite;
    }
    /**
     * Get value of status.
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Get value of idEmployee.
     * @return the idEmployee
     */
    public String getIdEmployee() {
        return idEmployee;
    }
    /**
     * Set the value for idEmployee.
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
    /**
     * Get value of homeNumber.
     * @return the homeNumber
     */
    public String getHomeNumber() {
        return homeNumber;
    }
    /**
     * Set the value for homeNumber.
     * @param homeNumber the homeNumber to set
     */
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
    /**
     * Get value of streetName.
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }
    /**
     * Set the value for streetName.
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    /**
     * Get value of wardName.
     * @return the wardName
     */
    public String getWardName() {
        return wardName;
    }
    /**
     * Set the value for wardName.
     * @param wardName the wardName to set
     */
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
    /**
     * Get value of districtName.
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }
    /**
     * Set the value for districtName.
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    /**
     * Get value of buildingName.
     * @return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }
    /**
     * Set the value for buildingName.
     * @param buildingName the buildingName to set
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    /**
     * Get value of note.
     * @return the note
     */
    public String getNote() {
        return note;
    }
    /**
     * Set the value for note.
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     * Get value of isPayment.
     * @return the isPayment
     */
    public int getIsPayment() {
        return isPayment;
    }
    /**
     * Set the value for isPayment.
     * @param isPayment the isPayment to set
     */
    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }
    /**
     * Get value of nameStatus.
     * @return the nameStatus
     */
    public String getNameStatus() {
        return nameStatus;
    }
    /**
     * Set the value for nameStatus.
     * @param nameStatus the nameStatus to set
     */
    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }
	/**
	 * @return the numberVoucher
	 */
	public int getNumberVoucher() {
		return numberVoucher;
	}
	/**
	 * @param numberVoucher the numberVoucher to set
	 */
	public void setNumberVoucher(int numberVoucher) {
		this.numberVoucher = numberVoucher;
	}
	/**
	 * @return the idFood
	 */
	public Long getIdFood() {
		return idFood;
	}
	/**
	 * @param idFood the idFood to set
	 */
	public void setIdFood(Long idFood) {
		this.idFood = idFood;
	}
}
