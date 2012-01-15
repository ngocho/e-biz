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

import ebiz.dto.account.customer.Address;
import ebiz.dto.account.provider.Provider;
import ebiz.util.CommonUtil;

/**
 * @author Administrator
 */
public class ProviderForm extends ValidatorForm implements Serializable{

    /** . */
    private static final long serialVersionUID = 1L;
    private String loginId;
    private String loginPassword;
    private String loginPasswordPre;
    private String loginName;
    private String type;
    private String gender;
    private String email;
    private String phone;
    private String homeNumber;
    private String streetName;
    private String wardName;
    private String districtName;
    private String buildingName;
    private String authentication;
    private String accountPayment;
    private String detail;
    private Date birth;

    public boolean isEmpty() {
        return CommonUtil.isBlankOrNull(loginId);
    }

    public Provider getProvider() {
        Provider provider = new Provider();
        provider.setProviderId(this.loginId);
        provider.setProviderPassword(this.loginPassword);
        provider.setProviderEmail(this.email);
        provider.setProviderPhone(this.phone);
        provider.setProviderBirth(this.birth);
        provider.setProviderGender(this.gender);
        provider.setAuthentication(this.authentication);
        provider.setProviderAccountPayment(this.accountPayment);
        Address add = new Address();
        add.setBuildingName(this.buildingName);
        add.setDistrictName(this.districtName);
        add.setHomeNumber(this.homeNumber);
        add.setStreetName(this.streetName);
        add.setWardName(this.wardName);
        provider.setProviderAddress(add);
        provider.setLoginDate(new Date());
        provider.setDetail(this.detail);
        return provider;

    }

    public void editForm(Provider provider) {
        this.loginId = provider.getProviderId();
        this.loginPassword = provider.getProviderPassword();
        this.loginName = provider.getProviderName();
        this.gender = provider.getProviderGender();
        this.accountPayment = provider.getProviderAccountPayment();
        this.authentication = provider.getAuthentication();
        this.birth = provider.getProviderBirth();
        this.email = provider.getProviderEmail();
        this.phone = provider.getProviderPhone();
        this.buildingName = provider.getProviderAddress().getBuildingName();
        this.districtName = provider.getProviderAddress().getDistrictName();
        this.homeNumber = provider.getProviderAddress().getHomeNumber();
        this.streetName = provider.getProviderAddress().getStreetName();
        this.wardName = provider.getProviderAddress().getWardName();
        this.detail = provider.getDetail();
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
     * Get value of authentication.
     * 
     * @return the authentication
     */
    public String getAuthentication() {
        return authentication;
    }

    /**
     * Set the value for authentication.
     * 
     * @param authentication the authentication to set
     */
    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    /**
     * Get value of accountPayment.
     * 
     * @return the accountPayment
     */
    public String getAccountPayment() {
        return accountPayment;
    }

    /**
     * Set the value for accountPayment.
     * 
     * @param accountPayment the accountPayment to set
     */
    public void setAccountPayment(String accountPayment) {
        this.accountPayment = accountPayment;
    }

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
