package ebiz.dao.inf;

import ebiz.dto.account.admin.Admin;
/**
 * @author ThuyNT
 *
 */
public interface IAdminDAO {
    /**
     * [getAdminById].
     * @param id  String
     * @return  Admin
     */
    Admin getAdminById(String id);
    /**
     * [getAdminById].
     * @param id String
     * @return boolean
     */
    boolean isAdmin(String id);
    /**
     * [saveAdmin].
     * @param admin Admin
     * @return  boolean
     */
    boolean saveAdmin(Admin admin);

}
