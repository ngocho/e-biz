package employee.ebiz.dto;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author nthanhphong
 */
@PersistenceCapable
public class Employee {

    /** . */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String employeeId;
    /** . */
    @Persistent
    private String employeePassword;
    /** . */
    @Persistent
    private Date employeeBirth;
    /** . */
    @Persistent
    private String employeeAddress;
    /** . */
    @Persistent
    private String employeeMail;
    /** . */
    @Persistent
    private String employeePhone;
    /** . */
    @Persistent
    private boolean employeeSex;
    /** . */
    @Persistent
    private String employeeFullname;

    /**
     * [Give the description for method].
     * @param employeId String
     */
    public void setEmployeeId(String employeId) {
        this.employeeId = employeId;
    }
    /**
     * [Give the description for method].
     * @param employeePassword String
     */
    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    /**
     * [Give the description for method].
     * @param employeeBirth Date
     */
    public void setEmployeeBirth(Date employeeBirth) {
        this.employeeBirth = employeeBirth;
    }
    /**
     * [Give the description for method].
     * @param employeeAddress String
     */
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
    /**
     * [Give the description for method].
     * @param employeEmail String
     */
    public void setEmployeeMail(String employeEmail) {
        this.employeeMail = employeEmail;
    }
    /**
     * [Give the description for method].
     * @param employeePhone String
     */
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
    /**
     * [Give the description for method].
     * @param employeeSex boolean
     */
    public void setEmployeeSex(boolean employeeSex) {
        this.employeeSex = employeeSex;
    }
    /**
     * [Give the description for method].
     * @param employeeFullname String
     */
    public void setEmployeeFullname(String employeeFullname) {
        this.employeeFullname = employeeFullname;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEmployeePassword() {
        return employeePassword;
    }
    /**
     * [Give the description for method].
     * @return Date
     */
    public Date getEmployeeBirth() {
        return employeeBirth;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEmployeeAddress() {
        return employeeAddress;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEmployeeEmail() {
        return employeeMail;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEmployeePhone() {
        return employeePhone;
    }
    /**
     * [Give the description for method].
     * @return
     */
    /**
     * [Give the description for method].
     * @return boolean
     */
    public boolean getEmployeeSex() {
        return employeeSex;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getEmployeeFullname() {
        return employeeFullname;
    }
}
