/**
 * 
 */
package employee.ebiz.dto;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * @author nthanhphong
 *
 */
@PersistenceCapable
public class Employee {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String employeeId;
	@Persistent
	private String employeePassword;
	@Persistent
	private Date employeeBirth;
	@Persistent
	private String employeeAddress;
	@Persistent
	private String employeeMail;
	@Persistent
	private String employeePhone;
	@Persistent
	private boolean employeeSex;
	@Persistent
	private String employeeFullname;
	
	public void setEmployeeId(String employeId){
		this.employeeId=employeId;
	}
	public void setEmployeePassword(String employeePassword){
		this.employeePassword=employeePassword;
	}
	public void setEmployeeBirth(Date employeeBirth){
		this.employeeBirth=employeeBirth;
	}
	public void setEmployeeAddress(String employeeAddress){
		this.employeeAddress=employeeAddress;
	}
	public void setEmployeeMail(String employeEmail){
		this.employeeMail=employeEmail;
	}
	public void setEmployeePhone(String employeePhone){
		this.employeePhone=employeePhone;
	}
	public void setEmployeeSex(boolean employeeSex){
		this.employeeSex=employeeSex;
	}
	public void setEmployeeFullname(String employeeFullname){
		this.employeeFullname=employeeFullname;
	}
	public String getEmployeeId(){
		return employeeId;
	}
	public String getEmployeePassword(){
		return employeePassword;
	}
	public Date getEmployeeBirth(){
		return employeeBirth;
	}
	public String getEmployeeAddress(){
		return employeeAddress;
	}
	public String getEmployeeEmail(){
		return employeeMail;
	}
	public String getEmployeePhone(){
		return employeePhone;
	}
	public boolean getEmployeeSex(){
		return employeeSex;
	}
	public String getEmployeeFullname(){
		return employeeFullname;
	}
}
