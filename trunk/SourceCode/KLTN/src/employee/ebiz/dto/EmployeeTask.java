
package employee.ebiz.dto;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import ebiz.dto.account.customer.Address;

/**
 * @author nthanhphong
 *
 */
@PersistenceCapable
public class EmployeeTask {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long taskId;
	@Persistent
    private String usernameEmployee;			//username nguoi giao hang
	@Persistent
	private Long idOrder;						//don dat hang
	@Persistent
	private String idCustomer;					
	@Persistent
	private String nameCustomer;
	@Persistent
	private Address addressCustomer;
	@Persistent
	private String phoneCustomer;
	@Persistent
	private String coorCustomer;				//toa do cua customer neu co  x;y
	@Persistent
	private Date startDate;
	@Persistent
	private Date endDate;
	@Persistent
    private boolean state;
    
    public EmployeeTask(Long taskId,String usernameEmployee,Long idOrder,String idCustomer,String nameCustomer,Address addressCustomer,String phoneCustomer,String coorCustomer,Date startDate,Date endDate,boolean State){
    	setTaskID(taskId);
    	setUsernameEmployee(usernameEmployee);
    	setIdOrder(idOrder);
    	setNameCustomer(nameCustomer);
    	setAddressCustomer(addressCustomer);
    	setPhoneCustomer(phoneCustomer);
    	setCoorCustomer(coorCustomer);
    	setStartDate(startDate);
    	setEndDate(endDate);
    	setState(State);
    }
    public void setUsernameEmployee(String usernameEmployee){
    	this.usernameEmployee=usernameEmployee;
    }
    public void setTaskID(Long taskId){
    	this.taskId=taskId;
    }
    public String getUsernameEmployee(){
    	return usernameEmployee;
    }
    public Long getTaskId(){
    	return taskId;
    }
    public void setIdOrder(Long idorder){
    	this.idOrder=idorder;
    }
    public Long getIdOrder(){
    	return idOrder;
    }
    public void setIdCustomer(String idCustomer){
    	this.idCustomer=idCustomer;
    }
    public String getIdCustomer(){
    	return idCustomer;
    }
    public void setNameCustomer(String nameCustomer){
    	this.nameCustomer=nameCustomer;
    }
    public String getNameCustomer() {
		return nameCustomer;
	}
    public void setAddressCustomer(Address addressCustomer) {
		this.addressCustomer=addressCustomer;
	}
    public Address getAddressCustomer(){
    	return addressCustomer;
    }
    public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer=phoneCustomer;
	}
    public String getPhoneCustomer() {
		return phoneCustomer;
	}
    public void setCoorCustomer(String coorCustomer) {
		this.coorCustomer=coorCustomer;		
	}
    public String getCoorCustomer() {
		return coorCustomer;
	}
    public void setStartDate(Date startDate) {
		this.startDate=startDate;
	}
    public Date getStartDate() {
		return startDate;
	}
    public void setEndDate(Date endDate) {
		this.endDate=endDate;
	}
    public Date getEndDate() {
		return endDate;
	}
    public void setState(boolean State) {
		this.state=State;
	}
    public boolean getState(){
    	return state;
    }
    
}
