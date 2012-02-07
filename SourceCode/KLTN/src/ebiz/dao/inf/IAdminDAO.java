package ebiz.dao.inf;

import ebiz.dto.account.admin.Admin;
public interface IAdminDAO {
	public Admin getAdminById(String id);
	public boolean isAdmin(String id);
	public boolean saveAdmin(Admin admin);

}
