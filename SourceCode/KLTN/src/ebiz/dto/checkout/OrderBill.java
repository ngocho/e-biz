package ebiz.dto.checkout;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Administrator
 */
@PersistenceCapable
public class OrderBill implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    /** . */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    /** . */
    @Persistent
    private String idCustomer;
    /** . */
    @Persistent
    private String address;
    /** . */
    @Persistent
    private String email;
    /** . */
    @Persistent
    private String phone;
    /** . */
    @Persistent
    private String status;
    /** . */
    @Persistent
    private Date dateOrder;
    /** . */
    @Persistent
    private Date dateShip;
    /** . */
    @Persistent
    private long sumPrice;
    /** . */
    @Persistent
    private String idEmployee;
    /** . */
    @Persistent
    private String note;
    /** . */
    @Persistent
    private int typePayment;
    /** . */
    @Persistent
    private boolean isDeleted;

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
     * Get value of status.
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(String status) {
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
    public long getSumPrice() {
        return sumPrice;
    }
    /**
     * Set the value for sumPrice.
     * @param sumPrice the sumPrice to set
     */
    public void setSumPrice(long sumPrice) {
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
    /**
     * Get value of typePayment.
     * @return the typePayment
     */
    public int getTypePayment() {
        return typePayment;
    }
    /**
     * Set the value for typePayment.
     * @param typePayment the typePayment to set
     */
    public void setTypePayment(int typePayment) {
        this.typePayment = typePayment;
    }
    /**
     * Get value of isDeleted.
     * @return the isDeleted
     */
    public boolean isDeleted() {
        return isDeleted;
    }
    /**
     * Set the value for isDeleted.
     * @param isDeleted the isDeleted to set
     */
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
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
