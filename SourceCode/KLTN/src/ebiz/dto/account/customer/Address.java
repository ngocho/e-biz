package ebiz.dto.account.customer;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author ThuyNT
 */
@PersistenceCapable
public class Address implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
    @Persistent
    private String buildingName;
    @Persistent
    private String districtName;
    @Persistent
    private String homeNumber;
    @Persistent
    private String streetName;
    @Persistent
    private String wardName;
    @Persistent(mappedBy = "customerAddress")
    private Customer customer;

    private String customerId;

    /**
     * Get value of customerId.
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }
    /**
     * Set the value for customerId.
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getBuildingName() {
        return buildingName;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getHomeNumber() {
        return homeNumber;
    }
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getWardName() {
        return wardName;
    }
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
    /**
     * Get value of key.
     * 
     * @return the key
     */
    public Key getKey() {
        return key;
    }
    /**
     * Set the value for key.
     * 
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }
    /**
     * Get value of customer.
     * 
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * Set the value for customer.
     * 
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
