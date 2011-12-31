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
package ebiz.dto.account.customer;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author ThuyNT
 *
 */
@PersistenceCapable
public class Address {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
    @Persistent(mappedBy = "customerAddress")
    private Customer customer;
    @Persistent
    private String homeNumber;
    @Persistent
    private String streetName;
    @Persistent
    private String wardName;
    @Persistent
    private String districtName;
    @Persistent
    private String buildingName;
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
     * Get value of customer.
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * Set the value for customer.
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    /**
     * Get value of key.
     * @return the key
     */
    public Key getKey() {
        return key;
    }
    /**
     * Set the value for key.
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }
    

}
