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

import ebiz.blo.customer.CustomerBLO;

import org.apache.struts.validator.ValidatorForm;

import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Customer;
import ebiz.util.CommonUtil;

/**
 * @author Administrator
 *
 */
public class LoginForm extends ValidatorForm{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    private String loginId;
    private String loginPassword;
    private String loginPasswordPre;
    private String loginName;
    private String type;            //type of account : customer, admin, employee
    private String gender;
    private String email;
    private String phone;
    private String homeNumber;
    private String streetName;
    private String wardName;
    private String districtName;
    private String buildingName;
    private String note; //bill 
    private Boolean isAdEmail; 
    private Boolean isAdPhone; 
    public boolean isEmpty(){
        return CommonUtil.isBlankOrNull(loginId);
    }
    
    public  Customer getCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId(this.loginId);
        customer.setCustomerPassword(this.loginPassword);
        customer.setCustomerName(this.loginName);
        customer.setCustomerGender(this.gender);
        customer.setCustomerPhone(this.phone);
        customer.setCustomerEmail(this.email);
        customer.setIsAdEmail(this.isAdEmail);
        customer.setIsAdPhone(this.isAdPhone);
        Address add = new Address();
        add.setBuildingName(this.buildingName);
        add.setDistrictName(this.districtName);
        add.setHomeNumber(this.homeNumber);
        add.setStreetName(this.streetName);
        add.setWardName(this.wardName);
        customer.setCustomerAddress(add);
        return customer;
          
      }
    
    public void  editForm(Customer customer){
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
        
        
    }
    /**
     * Get value of loginId.
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Set the value for loginId.
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Get value of loginPassword.
     * @return the loginPassword
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * Set the value for loginPassword.
     * @param loginPassword the loginPassword to set
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * Get value of loginName.
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Set the value for loginName.
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Get value of type.
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value for type.
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * Get value of loginPasswordPre.
     * @return the loginPasswordPre
     */
    public String getLoginPasswordPre() {
        return loginPasswordPre;
    }
    /**
     * Set the value for loginPasswordPre.
     * @param loginPasswordPre the loginPasswordPre to set
     */
    public void setLoginPasswordPre(String loginPasswordPre) {
        this.loginPasswordPre = loginPasswordPre;
    }
    /**
     * Get value of gender.
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * Set the value for gender.
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * Get value of isAdPhone.
     * @return the isAdPhone
     */
    public Boolean getIsAdPhone() {
        return isAdPhone;
    }
    /**
     * Set the value for isAdPhone.
     * @param isAdPhone the isAdPhone to set
     */
    public void setIsAdPhone(Boolean isAdPhone) {
        this.isAdPhone = isAdPhone;
    }
    /**
     * Get value of isAdEmail.
     * @return the isAdEmail
     */
    public Boolean getIsAdEmail() {
        return isAdEmail;
    }
    /**
     * Set the value for isAdEmail.
     * @param isAdEmail the isAdEmail to set
     */
    public void setIsAdEmail(Boolean isAdEmail) {
        this.isAdEmail = isAdEmail;
    }

}
