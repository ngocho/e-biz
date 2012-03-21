/**
 *Licensed to Open-Ones Group under one or more contributor license
 *agreements. See the NOTICE file distributed with this work
 *for additional information regarding copyright ownership.
 *Open-Ones Group licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file
 *except in compliance with the License. You may obtain a
 *copy of the License at:
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on
 *an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied. See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */
package ebiz.dto.account.customer;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *@author ThuyNT Customer
 */
@PersistenceCapable
public class Customer implements Serializable {
    /**. */
    private static final long serialVersionUID = 1L;
    // ten dang nhap
    /**. customerId */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String customerId;
    /**. customerPassword */
    @Persistent
    private String customerPassword;
    /**. customerName */
    @Persistent
    private String customerName;
    /**. customerGender */
    @Persistent
    private String customerGender;
    /**. customerBirth */
    @Persistent
    private Date customerBirth;
    /**. customerEmail */
    @Persistent
    private String customerEmail; // bat buoc
    /**. customerPhone */
    @Persistent
    private String customerPhone;
    /**. customerAddress */
    @Persistent(defaultFetchGroup = "true")
    private Address customerAddress;
    /**. customerType */
    @Persistent
    private String customerType;
    /**. customerSumMoney */
    @Persistent
    private long customerSumMoney;
    /**. customerMark */
    @Persistent
    private int customerMark;
    /**. isPay */
    @Persistent
    private boolean isPay;
    /**. payOnlineType */
    @Persistent
    private String payOnlineType;
    /**. isAdEmail */
    @Persistent
    private boolean isAdEmail;
    /**. isAdPhone */
    @Persistent
    private boolean isAdPhone;
    /**. isActive */
    @Persistent
    private boolean isActive;
    /**. xuOnline */
    @Persistent
    private long xuOnline;
    /**. loginDate */
    @Persistent
    private Date loginDate;
    /**. url */
    @Persistent
    private String url;
    /**
     *Get value of customerId.
     *
     *@return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }
    /**
     *Set the value for customerId.
     *
     *@param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    /**
     *Get value of customerPassword.
     *
     *@return the customerPassword
     */
    public String getCustomerPassword() {
        return customerPassword;
    }
    /**
     *Set the value for customerPassword.
     *
     *@param customerPassword the customerPassword to set
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    /**
     *Get value of customerName.
     *
     *@return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     *Set the value for customerName.
     *
     *@param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     *Get value of customerGender.
     *
     *@return the customerGender
     */
    public String getCustomerGender() {
        return customerGender;
    }
    /**
     *Set the value for customerGender.
     *
     *@param customerGender the customerGender to set
     */
    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }
    /**
     *Get value of customerBirth.
     *
     *@return the customerBirth
     */
    public Date getCustomerBirth() {
        return customerBirth;
    }
    /**
     *Set the value for customerBirth.
     *
     *@param customerBirth the customerBirth to set
     */
    public void setCustomerBirth(Date customerBirth) {
        this.customerBirth = customerBirth;
    }
    /**
     *Get value of customerEmail.
     *
     *@return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }
    /**
     *Set the value for customerEmail.
     *
     *@param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    /**
     *Get value of customerPhone.
     *
     *@return the customerPhone
     */
    public String getCustomerPhone() {
        return customerPhone;
    }
    /**
     *Set the value for customerPhone.
     *
     *@param customerPhone the customerPhone to set
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    /**
     *Get value of customerAddress.
     *
     *@return the customerAddress
     */
    public Address getCustomerAddress() {
        /*this.customerAddress.setBuildingName(this.buildingName);
        this.customerAddress.setDistrictName(this.districtName);
        this.customerAddress.setHomeNumber(this.homeNumber);
        this.customerAddress.setStreetName(this.streetName);
        this.customerAddress.setWardName(this.wardName);*/
        return customerAddress;
    }
    /**
     *Set the value for customerAddress.
     *
     *@param address the address to set
     */
    public void setCustomerAddress(Address address) {
        /*this.buildingName = address.getBuildingName();
        this.districtName = address.getDistrictName();
        this.homeNumber   = address.getHomeNumber();
        this.streetName   = address.getStreetName();
        this.wardName     = address.getWardName();*/
        this.customerAddress = address;
    }
    /**
     *Get value of customerType.
     *
     *@return the customerType
     */
    public String getCustomerType() {
        return customerType;
    }
    /**
     *Set the value for customerType.
     *
     *@param customerType the customerType to set
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    /**
     *Get value of customerSumMoney.
     *
     *@return the customerSumMoney
     */
    public long getCustomerSumMoney() {
        return customerSumMoney;
    }
    /**
     *Set the value for customerSumMoney.
     *
     *@param customerSumMoney the customerSumMoney to set
     */
    public void setCustomerSumMoney(long customerSumMoney) {
        this.customerSumMoney = customerSumMoney;
    }
    /**
     *Get value of customerMark.
     *
     *@return the customerMark
     */
    public Integer getCustomerMark() {
        return customerMark;
    }
    /**
     *Set the value for customerMark.
     *
     *@param customerMark the customerMark to set
     */
    public void setCustomerMark(Integer customerMark) {
        this.customerMark = customerMark;
    }
    /**
     *Get value of isPay.
     *
     *@return the isPay
     */
    public boolean getIsPay() {
        return isPay;
    }
    /**
     *Set the value for isPay.
     *
     *@param isPay the isPay to set
     */
    public void setIsPay(boolean isPay) {
        this.isPay = isPay;
    }
    /**
     *Get value of payOnlineType.
     *
     *@return the payOnlineType
     */
    public String getPayOnlineType() {
        return payOnlineType;
    }
    /**
     *Set the value for payOnlineType.
     *
     *@param payOnlineType the payOnlineType to set
     */
    public void setPayOnlineType(String payOnlineType) {
        this.payOnlineType = payOnlineType;
    }
    /**
     *Get value of isActive.
     *
     *@return the isActive
     */
    public boolean getIsActive() {
        return isActive;
    }
    /**
     *Set the value for isActive.
     *
     *@param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    /**
     *Get value of isAdEmail.
     *
     *@return the isAdEmail
     */
    public boolean getIsAdEmail() {
        return isAdEmail;
    }
    /**
     *Set the value for isAdEmail.
     *
     *@param isAdEmail the isAdEmail to set
     */
    public void setIsAdEmail(boolean isAdEmail) {
        this.isAdEmail = isAdEmail;
    }
    /**
     *Get value of isAdPhone.
     *
     *@return the isAdPhone
     */
    public boolean getIsAdPhone() {
        return isAdPhone;
    }
    /**
     *Set the value for isAdPhone.
     *
     *@param isAdPhone the isAdPhone to set
     */
    public void setIsAdPhone(boolean isAdPhone) {
        this.isAdPhone = isAdPhone;
    }
    /**
     *Get value of xuOnline.
     *
     *@return the xuOnline
     */
    public long getXuOnline() {
        return xuOnline;
    }
    /**
     *Set the value for xuOnline.
     *
     *@param xuOnline the xuOnline to set
     */
    public void setXuOnline(long xuOnline) {
        this.xuOnline = xuOnline;
    }
    /**
     *Get value of loginDate.
     *
     *@return the loginDate
     */
    public Date getLoginDate() {
        return loginDate;
    }
    /**
     *Set the value for loginDate.
     *
     *@param loginDate the loginDate to set
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    /**
     *Set the value for customerMark.
     *
     *@param customerMark the customerMark to set
     */
    public void setCustomerMark(int customerMark) {
        this.customerMark = customerMark;
    }
    /**
     *Set the value for isPay.
     *
     *@param isPay the isPay to set
     */
    public void setPay(boolean isPay) {
        this.isPay = isPay;
    }
    /**
     *Set the value for isAdEmail.
     *
     *@param isAdEmail the isAdEmail to set
     */
    public void setAdEmail(boolean isAdEmail) {
        this.isAdEmail = isAdEmail;
    }
    /**
     *Set the value for isAdPhone.
     *
     *@param isAdPhone the isAdPhone to set
     */
    public void setAdPhone(boolean isAdPhone) {
        this.isAdPhone = isAdPhone;
    }
    /**
     *Set the value for isActive.
     *
     *@param isActive the isActive to set
     */

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    /**
     *Get value of url.
     *
     *@return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     *Set the value for url.
     *
     *@param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
