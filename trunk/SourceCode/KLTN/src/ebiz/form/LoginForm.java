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

import org.apache.struts.validator.ValidatorForm;

import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Customer;
import ebiz.util.CommonUtil;

/**
 * @author Administrator
 */
public class LoginForm extends ValidatorForm implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    /** . */
    private String loginId;
    /** . */
    private String loginPassword;
    /** . */
    private String loginPasswordPre;
    /** . */
    private String loginName;
    /** . */
    private String type; // type of account : customer, admin, employee
    /** . */
    private String gender;
    /** . */
    private String birthDate;
    /** . */
    private String email;
    /** . */
    private String phone;
    /** . */
    private String homeNumber;
    /** . */
    private String streetName;
    /** . */
    private String wardName;
    /** . */
    private String districtName;
    /** . */
    private String buildingName;
    /** . note for OrderBill*/
    private String note;
    /** . */
    private boolean isAdEmail;
    /** . */
    private boolean isAdPhone;
    /** . select type of bill to display*/
    private int isCustomerBill;
    /** . */
    private String url;
    private long xuOnline;
    /**
     * IsEmpty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return CommonUtil.isBlankOrNull(loginId);
    }

    /**
     * [getCustomer].
     * @return Customer
     */
    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(this.loginId);
        customer.setCustomerPassword(this.loginPassword);
        customer.setCustomerName(this.loginName);
        customer.setCustomerGender(this.gender);
        customer.setCustomerPhone(this.phone);
        customer.setCustomerEmail(this.email);
        customer.setCustomerBirth(CommonUtil.convertStringToDate(this.birthDate));
        customer.setIsAdEmail(this.isAdEmail);
        customer.setIsAdPhone(this.isAdPhone);
        Address add = new Address();
        add.setBuildingName(this.buildingName);
        add.setDistrictName(this.districtName);
        add.setHomeNumber(this.homeNumber);
        add.setStreetName(this.streetName);
        add.setWardName(this.wardName);
        customer.setCustomerAddress(add);
        customer.setUrl(this.url);
        customer.setXuOnline(this.xuOnline);
        return customer;

    }

    /**
     * [get Form from Customer object].
     * @param customer Customer
     */
    public void editForm(Customer customer) {
        this.loginId = customer.getCustomerId();
        this.loginName = customer.getCustomerName();
        this.loginPassword = customer.getCustomerPassword();
        this.gender = customer.getCustomerGender();
        this.phone = customer.getCustomerPhone();
        this.email = customer.getCustomerEmail();
        this.buildingName = customer.getCustomerAddress().getBuildingName();
        this.districtName = customer.getCustomerAddress().getDistrictName();
        this.homeNumber = customer.getCustomerAddress().getHomeNumber();
        this.streetName = customer.getCustomerAddress().getStreetName();
        this.wardName = customer.getCustomerAddress().getWardName();
        this.url = customer.getUrl();
        this.isAdEmail = customer.getIsAdEmail();
        this.isAdPhone = customer.getIsAdPhone();
        this.xuOnline = customer.getXuOnline();
        // return this;
    }
    
   
    /**
     * Get value of loginId.
     *
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Set the value for loginId.
     *
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Get value of loginPassword.
     *
     * @return the loginPassword
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * Set the value for loginPassword.
     *
     * @param loginPassword the loginPassword to set
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * Get value of loginName.
     *
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Set the value for loginName.
     *
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Get value of type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value for type.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get value of phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value for phone.
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get value of note.
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Set the value for note.
     *
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     * Get value of homeNumber.
     *
     * @return the homeNumber
     */
    public String getHomeNumber() {
        return homeNumber;
    }
    /**
     * Set the value for homeNumber.
     *
     * @param homeNumber the homeNumber to set
     */
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
    /**
     * Get value of streetName.
     *
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }
    /**
     * Set the value for streetName.
     *
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    /**
     * Get value of wardName.
     *
     * @return the wardName
     */
    public String getWardName() {
        return wardName;
    }
    /**
     * Set the value for wardName.
     *
     * @param wardName the wardName to set
     */
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
    /**
     * Get value of districtName.
     *
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }
    /**
     * Set the value for districtName.
     *
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    /**
     * Get value of buildingName.
     *
     * @return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }
    /**
     * Set the value for buildingName.
     *
     * @param buildingName the buildingName to set
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    /**
     * Get value of loginPasswordPre.
     *
     * @return the loginPasswordPre
     */
    public String getLoginPasswordPre() {
        return loginPasswordPre;
    }
    /**
     * Set the value for loginPasswordPre.
     *
     * @param loginPasswordPre the loginPasswordPre to set
     */
    public void setLoginPasswordPre(String loginPasswordPre) {
        this.loginPasswordPre = loginPasswordPre;
    }
    /**
     * Get value of gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * Set the value for gender.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Get value of email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set the value for email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Get value of isAdPhone.
     *
     * @return the isAdPhone
     */
    public boolean getIsAdPhone() {
        return isAdPhone;
    }
    /**
     * Set the value for isAdPhone.
     *
     * @param isAdPhone the isAdPhone to set
     */
    public void setIsAdPhone(boolean isAdPhone) {
        this.isAdPhone = isAdPhone;
    }
    /**
     * Get value of isAdEmail.
     *
     * @return the isAdEmail
     */
    public boolean getIsAdEmail() {
        return isAdEmail;
    }
    /**
     * Set the value for isAdEmail.
     *
     * @param isAdEmail the isAdEmail to set
     */
    public void setIsAdEmail(boolean isAdEmail) {
        this.isAdEmail = isAdEmail;
    }

    /**
     * Get value of isCustomerBill.
     *
     * @return the isCustomerBill
     */
    public Integer getIsCustomerBill() {
        return isCustomerBill;
    }

    /**
     * Set the value for isCustomerBill.
     *
     * @param isCustomerBill the isCustomerBill to set
     */
    public void setIsCustomerBill(int isCustomerBill) {
        this.isCustomerBill = isCustomerBill;
    }

    /**
     * [Set the value for birthDate].
     * @return String
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * [Set the value for birthDate].
     * @param birthDate String
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * [Set the value for isAdEmail].
     * @param isAdEmail boolean
     */
    public void setAdEmail(boolean isAdEmail) {
        this.isAdEmail = isAdEmail;
    }

    /**
     * [Set the value for isAdPhone].
     * @param isAdPhone boolean
     */
    public void setAdPhone(boolean isAdPhone) {
        this.isAdPhone = isAdPhone;
    }

    /**
     * [Get the value of url].
     * @return String
     */
    public String getUrl() {
        return url;
    }

    /**
     * [Set the value for url].
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }

	/**
	 * @return the xuOnline
	 */
	public long getXuOnline() {
		return xuOnline;
	}

	/**
	 * @param xuOnline the xuOnline to set
	 */
	public void setXuOnline(long xuOnline) {
		this.xuOnline = xuOnline;
	}

}
