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

import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.checkout.OrderBill;
import ebiz.util.CommonConstant;

/**
 * @author Administrator
 *
 */
public class OrderBillForm extends ValidatorForm{
    /**  . */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String idCustomer;
    private String nameCustomer;
    private String address;
    private String email;
    private String phone;
    private Date dateOrder;
    private Date dateShip;
    private Long sumPrice;
    private Integer status;
    private Integer numberProduct;
    private String phoneWebsite;
    private String idEmployee;
    private String homeNumber;
    private String streetName;
    private String wardName;
    private String districtName;
    private String buildingName;
    private String note; //bill 
    
    public void editForm(OrderBill order){
        id = order.getId();
        idCustomer = order.getIdCustomer();
        address = CustomerBLO.toStringAddres(order.getAddress());
        email = order.getEmail();
        phone = order.getPhone();
        dateOrder = order.getDateOrder();
        dateShip = order.getDateShip();
        sumPrice = order.getSumPrice();
        status = order.getStatus();
        idEmployee = order.getIdEmployee();
    }
    public OrderBill getOrder(){
        OrderBill order = new OrderBill();
        order.setIdCustomer(this.idCustomer);
        order.setIdCustomer(this.address);
       
        order.setEmail(this.email);
        order.setPhone(this.phone);
        order.setStatus(CommonConstant.BILLSTATUS_1); // chua giao
        order.setDateOrder(new Date());
        Address add = new Address();
        add.setBuildingName(this.buildingName);
        add.setDistrictName(this.districtName);
        add.setHomeNumber(this.homeNumber);
        add.setStreetName(this.streetName);
        add.setWardName(this.wardName);
        order.setAddress(add);
        return order;
    }
    
    
    public void editCustomer(Customer user){
        idCustomer = user.getCustomerId();
        nameCustomer = user.getCustomerName();
        phone = user.getCustomerPhone();
        email = user.getCustomerEmail();
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
    public Date getDateOrder() {
        return dateOrder;
    }
    /**
     * Set the value for dateOrder.
     * @param dateOrder the dateOrder to set
     */
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }
    /**
     * Get value of dateShip.
     * @return the dateShip
     */
    public Date getDateShip() {
        return dateShip;
    }
    /**
     * Set the value for dateShip.
     * @param dateShip the dateShip to set
     */
    public void setDateShip(Date dateShip) {
        this.dateShip = dateShip;
    }
    /**
     * Get value of sumPrice.
     * @return the sumPrice
     */
    public Long getSumPrice() {
        return sumPrice;
    }
    /**
     * Set the value for sumPrice.
     * @param sumPrice the sumPrice to set
     */
    public void setSumPrice(Long sumPrice) {
        this.sumPrice = sumPrice;
    }
    /**
     * Get value of numberProduct.
     * @return the numberProduct
     */
    public Integer getNumberProduct() {
        return numberProduct;
    }
    /**
     * Set the value for numberProduct.
     * @param numberProduct the numberProduct to set
     */
    public void setNumberProduct(Integer numberProduct) {
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
    public Integer getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(Integer status) {
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

}
