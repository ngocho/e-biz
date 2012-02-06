package ebiz.dao.gae;

import ebiz.dao.inf.IAdminDAO;
import ebiz.dto.account.admin.Admin;

public class AdminDAO implements IAdminDAO{
	 @Override
	 public Admin getAdminById(String id){
	       Admin admin = null;
	       admin = (Admin) PMF.getObjectById(Admin.class, id);
	       return admin;
	    }

}
