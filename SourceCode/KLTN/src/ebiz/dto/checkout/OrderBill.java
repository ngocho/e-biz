package ebiz.dto.checkout;

import ebiz.dto.account.customer.Address;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class OrderBill  implements Serializable{
    /**  . */
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
    @Persistent
	private String idCustomer;
    @Persistent
	private Address address;
    @Persistent
	private String email;
    @Persistent
	private String phone;
    @Persistent
	private Integer status;
    @Persistent
	private Date dateOrder;
    @Persistent
    private Date dateShip;
    @Persistent
	private Long sumPrice;
    @Persistent
	private String idEmployee;
//    @Persistent(mappedBy = "orderBill")
//    private List<DetailOrder> detailOrders;
    /**
     * Get value of detailOrders.
     * @return the detailOrders
     */
//    public List<DetailOrder> getDetailOrders() {
//        return detailOrders;
//    }
//    /**
//     * Set the value for detailOrders.
//     * @param detailOrders the detailOrders to set
//     */
//    public void setDetailOrders(List<DetailOrder> detailOrders) {
//        this.detailOrders = detailOrders;
//    }
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
    public Address getAddress() {
        return address;
    }
    /**
     * Set the value for address.
     * @param address the address to set
     */
    public void setAddress(Address address) {
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
     * Get value of status.
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * Get value of idEmployee.
     * @return the idEmployee
     */
    public String getIdEmployee() {
        return idEmployee;
    }
    /**
     * Set the value for idEmployee.
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
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
	

}
