package employee.ebiz.dto;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import ebiz.dto.account.customer.Address;

/**
 * @author nthanhphong
 */
@PersistenceCapable
public class EmployeeTask {

    /** . */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long taskId;
    /** . */
    @Persistent
    private String usernameEmployee; // username nguoi giao hang
    /** . */
    @Persistent
    private Long idOrder; // don dat hang
    /** . */
    @Persistent
    private String idCustomer;
    /** . */
    @Persistent
    private String nameCustomer;
    /** . */
    @Persistent
    private Address addressCustomer;
    /** . */
    @Persistent
    private String phoneCustomer;
    /** . */
    @Persistent
    private String coorCustomer; // toa do cua customer neu co x;y
    /** . */
    @Persistent
    private Date startDate;
    /** . */
    @Persistent
    private Date endDate;
    /** . */
    @Persistent
    private boolean state;

    /**
     * @param taskId Long
     * @param usernameEmployee String
     * @param idOrder Long
     * @param idCustomer String
     * @param nameCustomer String
     * @param addressCustomer Address
     * @param phoneCustomer String
     * @param coorCustomer String
     * @param startDate Date
     * @param endDate Date
     * @param state boolean
     */
    public EmployeeTask(Long taskId, String usernameEmployee, Long idOrder, String idCustomer, String nameCustomer,
            Address addressCustomer, String phoneCustomer, String coorCustomer, Date startDate, Date endDate,
            boolean state) {
        setTaskID(taskId);
        setUsernameEmployee(usernameEmployee);
        setIdOrder(idOrder);
        setNameCustomer(nameCustomer);
        setAddressCustomer(addressCustomer);
        setPhoneCustomer(phoneCustomer);
        setCoorCustomer(coorCustomer);
        setStartDate(startDate);
        setEndDate(endDate);
        setState(state);
    }
    /**
     * [Give the description for method].
     * @param usernameEmployee String
     */
    public void setUsernameEmployee(String usernameEmployee) {
        this.usernameEmployee = usernameEmployee;
    }
    /**
     * [Give the description for method].
     * @param taskId Long
     */
    public void setTaskID(Long taskId) {
        this.taskId = taskId;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getUsernameEmployee() {
        return usernameEmployee;
    }
    /**
     * [Give the description for method].
     * @return Long
     */
    public Long getTaskId() {
        return taskId;
    }
    /**
     * [Give the description for method].
     * @param idorder v
     */
    public void setIdOrder(Long idorder) {
        this.idOrder = idorder;
    }
    /**
     * [Give the description for method].
     * @return Long
     */
    public Long getIdOrder() {
        return idOrder;
    }
    /**
     * [Give the description for method].
     * @param idCustomer String
     */
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getIdCustomer() {
        return idCustomer;
    }
    /**
     * [Give the description for method].
     * @param nameCustomer String
     */
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getNameCustomer() {
        return nameCustomer;
    }
    /**
     * [Give the description for method].
     * @param addressCustomer Address
     */
    public void setAddressCustomer(Address addressCustomer) {
        this.addressCustomer = addressCustomer;
    }
    /**
     * [Give the description for method].
     * @return Address
     */
    public Address getAddressCustomer() {
        return addressCustomer;
    }
    /**
     * [Give the description for method].
     * @param phoneCustomer String
     */
    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPhoneCustomer() {
        return phoneCustomer;
    }
    /**
     * [Give the description for method].
     * @param coorCustomer String
     */
    public void setCoorCustomer(String coorCustomer) {
        this.coorCustomer = coorCustomer;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getCoorCustomer() {
        return coorCustomer;
    }
    /**
     * [Give the description for method].
     * @param startDate Date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * [Give the description for method].
     * @return Date
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * [Give the description for method].
     * @param endDate Date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /**
     * [Give the description for method].
     * @return Date
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * [Give the description for method].
     * @param state boolean
     */
    public void setState(boolean state) {
        this.state = state;
    }
    /**
     * [Give the description for method].
     * @return boolean
     */
    public boolean getState() {
        return state;
    }

}
