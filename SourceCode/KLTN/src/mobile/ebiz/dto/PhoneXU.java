/**
 * 
 */
package mobile.ebiz.dto;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author nthanhphong
 *
 *
 */
@PersistenceCapable
public class PhoneXU implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String phone;
	@Persistent
	private long money;
	
	public void setPhone(String mphone){
		this.phone=mphone;
	}
	public String getPhone(){
		return phone;
	}
	public void setMoney(long mmoney){
		this.money=mmoney;
	}
	public long getMoney(){
		return money;
	}
}
