package ebiz.dto.checkout;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class VoucherBill implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    @Persistent
    private String idCustomer;
    @Persistent
    private long idFood;
    @Persistent
    private long sumMoney;
    @Persistent
    // number of voucher
    private int number;
    @Persistent
    private String address;
    @Persistent
    private String phone; // authenticate
    @Persistent
    private String email;
    @Persistent
    private String keyVoucher;
    @Persistent
    private Date startDate;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the idCustomer
     */
    public String getIdCustomer() {
        return idCustomer;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the keySecret
     */

    /**
     * @param keySecret the keySecret to set
     */

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the idFood
     */
    public long getIdFood() {
        return idFood;
    }

    /**
     * @param idFood the idFood to set
     */
    public void setIdFood(long idFood) {
        this.idFood = idFood;
    }

    /**
     * @return the sumMoney
     */
    public long getSumMoney() {
        return sumMoney;
    }

    /**
     * @param sumMoney the sumMoney to set
     */
    public void setSumMoney(long sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getKeyVoucher() {
        return keyVoucher;
    }
    public void setKeyVoucher(String keyVoucher) {
        this.keyVoucher = keyVoucher;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
