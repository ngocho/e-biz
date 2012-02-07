package ebiz.blo.admin;

import ebiz.dao.gae.AdminDAO;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dto.account.admin.Admin;
public class AdminBLO {
	private static IAdminDAO adminDao = new AdminDAO();
	    public static int isLoginID(String id, String pass){
	    	Admin admin = adminDao.getAdminById(id);
	    	if (null != admin) {
				// get password
				String passCust = admin.getPassword();
				if (pass.equals(passCust)) {
					return 1; // success
				} else {
					return 0; // didn't match
				}
			} else {
				return -1; // didn't exist this user
			}
	    }
	    
	    public static boolean registerAdmin(Admin admin) {

	        boolean flag = adminDao.isAdmin(admin.getId());
	        if (!flag) {
	            return adminDao.saveAdmin(admin);
	        }
	        return false;
	    }

}
