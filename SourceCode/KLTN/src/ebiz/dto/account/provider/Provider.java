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
package ebiz.dto.account.provider;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import ebiz.dto.account.customer.Address;

/**
 * @author ThuyNT
 *
 */
@PersistenceCapable
public class Provider {
  
    //ten dang nhap
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String providerId;
    @Persistent
    private String providerPassword;
    @Persistent
    private String providerName;
    @Persistent
    private String providerGender;
    @Persistent
    private Date providerBirth; 
    @Persistent
    private String providerEmail;           //bat buoc
    @Persistent
    private String providerPhone;           //bat buoc
    @Persistent(defaultFetchGroup = "true")
    private Address providerAddress;        //bat buoc
    @Persistent
    private String providerAccountPayment;   
    @Persistent
    private long xuOnline;
    @Persistent
    private String authentication;
    @Persistent
    private Date loginDate; 
    @Persistent
    private Date dateRegister; 
    @Persistent
    private String detail; 
    @Persistent
    private boolean isActive;  //required
    /**
     * Get value of providerId.
     * @return the providerId
     */
    public String getProviderId() {
        return providerId;
    }
    /**
     * Set the value for providerId.
     * @param providerId the providerId to set
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    /**
     * Get value of providerPassword.
     * @return the providerPassword
     */
    public String getProviderPassword() {
        return providerPassword;
    }
    /**
     * Set the value for providerPassword.
     * @param providerPassword the providerPassword to set
     */
    public void setProviderPassword(String providerPassword) {
        this.providerPassword = providerPassword;
    }
    /**
     * Get value of providerName.
     * @return the providerName
     */
    public String getProviderName() {
        return providerName;
    }
    /**
     * Set the value for providerName.
     * @param providerName the providerName to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    /**
     * Get value of providerGender.
     * @return the providerGender
     */
    public String getProviderGender() {
        return providerGender;
    }
    /**
     * Set the value for providerGender.
     * @param providerGender the providerGender to set
     */
    public void setProviderGender(String providerGender) {
        this.providerGender = providerGender;
    }
    /**
     * Get value of providerBirth.
     * @return the providerBirth
     */
    public Date getProviderBirth() {
        return providerBirth;
    }
    /**
     * Set the value for providerBirth.
     * @param providerBirth the providerBirth to set
     */
    public void setProviderBirth(Date providerBirth) {
        this.providerBirth = providerBirth;
    }
    /**
     * Get value of providerEmail.
     * @return the providerEmail
     */
    public String getProviderEmail() {
        return providerEmail;
    }
    /**
     * Set the value for providerEmail.
     * @param providerEmail the providerEmail to set
     */
    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }
    /**
     * Get value of providerPhone.
     * @return the providerPhone
     */
    public String getProviderPhone() {
        return providerPhone;
    }
    /**
     * Set the value for providerPhone.
     * @param providerPhone the providerPhone to set
     */
    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }
    /**
     * Get value of providerAddress.
     * @return the providerAddress
     */
    public Address getProviderAddress() {
        return providerAddress;
    }
    /**
     * Set the value for providerAddress.
     * @param providerAddress the providerAddress to set
     */
    public void setProviderAddress(Address providerAddress) {
        this.providerAddress = providerAddress;
    }
    /**
     * Get value of providerAccountPayment.
     * @return the providerAccountPayment
     */
    public String getProviderAccountPayment() {
        return providerAccountPayment;
    }
    /**
     * Set the value for providerAccountPayment.
     * @param providerAccountPayment the providerAccountPayment to set
     */
    public void setProviderAccountPayment(String providerAccountPayment) {
        this.providerAccountPayment = providerAccountPayment;
    }
    /**
     * Get value of xuOnline.
     * @return the xuOnline
     */
    public long getXuOnline() {
        return xuOnline;
    }
    /**
     * Set the value for xuOnline.
     * @param xuOnline the xuOnline to set
     */
    public void setXuOnline(long xuOnline) {
        this.xuOnline = xuOnline;
    }
    /**
     * Get value of authentication.
     * @return the authentication
     */
    public String getAuthentication() {
        return authentication;
    }
    /**
     * Set the value for authentication.
     * @param authentication the authentication to set
     */
    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }
    /**
     * Get value of loginDate.
     * @return the loginDate
     */
    public Date getLoginDate() {
        return loginDate;
    }
    /**
     * Set the value for loginDate.
     * @param loginDate the loginDate to set
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
	public Date getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
    /**
     * Get value of isActive.
     * @return the isActive
     */
    public boolean isActive() {
        return isActive;
    }
    /**
     * Set the value for isActive.
     * @param isActive the isActive to set
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
}
