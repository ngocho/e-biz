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

import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.checkout.OrderBill;

/**
 * @author Administrator
 *
 */
public class OrderBillForm {
    private Long id;
    private String idCustomer;
    private String nameCustomer;
    private String address;
    private String email;
    private String phone;
    private Date dateOrder;
    private Date dateShip;
    private Long sumPrice;
    private Integer numberProduct;
    private String phoneWebsite;
    
    public void getOrderBill(OrderBill order){
        id = order.getId();
        idCustomer = order.getIdCustomer();
        address = CustomerBLO.toStringAddres(order.getAddress());
        email = order.getEmail();
        phone = order.getPhone();
        dateOrder = order.getDateOrder();
        dateShip = order.getDateShip();
        sumPrice = order.getSumPrice();
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

}
