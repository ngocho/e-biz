package ebiz.form;

import java.io.Serializable;
import org.apache.struts.validator.ValidatorForm;
import ebiz.dto.account.admin.*;
public class AdminForm  extends ValidatorForm implements Serializable{
	/** . */
    private static final long serialVersionUID = 1L;
	private String id ;
	private String pass;
//	private String rePass;
	
	public void editForm(Admin admin){
		this.id = admin.getId();
		this.pass = admin.getPassword();
		
	}
	
	public Admin getAdmin(){
		Admin admin = new Admin();
		admin.setId(this.id);
		admin.setPassword(this.pass);
		return admin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
//	public String getRePass() {
//		return rePass;
//	}
//	public void setRePass(String rePass) {
//		this.rePass = rePass;
//	}

}
