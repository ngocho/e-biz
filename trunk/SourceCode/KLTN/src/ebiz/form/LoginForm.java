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

import org.apache.struts.validator.ValidatorForm;

import ebiz.dto.account.customer.Customer;

/**
 * @author Administrator
 *
 */
public class LoginForm extends ValidatorForm{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    private String loginId;
    private String loginPassword;
    private String loginName;
    private String type;            //type of account : customer, admin, employee
    
//    public Customer getCustomer(){
//        Customer customer = new Customer();
//        customer.setCustomerId(loginId);
//        return new Customer();
//        
//    }

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

}
