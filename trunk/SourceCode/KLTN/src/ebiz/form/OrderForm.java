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

import ebiz.dto.account.customer.Customer;

/**
 * @author Administrator
 *
 */
public class OrderForm implements Serializable {
    /**  . */
    private static final long serialVersionUID = 1L;
    private String idCustomer;
    private String nameCustomer;
    private String address;
    private String email;
    private String phone;
    private String homeNumber;
    private String streetName;
    private String wardName;
    private String districtName;
    private String buildingName;
    private String note; //bill 
    
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
