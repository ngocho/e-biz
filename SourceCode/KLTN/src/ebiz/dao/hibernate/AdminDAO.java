package ebiz.dao.hibernate;

import ebiz.dao.inf.IAdminDAO;
import ebiz.dto.account.admin.Admin;

/**
 * @author DuyLT2
 *
 */
public class AdminDAO implements IAdminDAO {
    @Override
    public Admin getAdminById(String id) {
        return (Admin) HibernateHelper.getObjectById(Admin.class, id);
    }

    @Override
    public boolean saveAdmin(Admin admin) {
        return HibernateHelper.saveObject(admin);
    }

    @Override
    public boolean isAdmin(String id) {
        return HibernateHelper.isObject(Admin.class, id);
    }

}
