package ebiz.form;

import java.io.Serializable;
import org.apache.struts.validator.ValidatorForm;
import ebiz.dto.account.admin.Admin;
/**
 * @author Administrator
 */
public class AdminForm extends ValidatorForm implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    /** . */
    private String id;
    /** . */
    private String pass;

    /**
     * [Give the description for method].
     *
     * @param admin Admin
     */
    public void editForm(Admin admin) {
        this.id = admin.getId();
        this.pass = admin.getPassword();

    }

    /**
     * [Give the description for method].
     *
     * @return Admin
     */
    public Admin getAdmin() {
        Admin admin = new Admin();
        admin.setId(this.id);
        admin.setPassword(this.pass);
        return admin;
    }

    /**
     * Get value of id.
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get value of pass.
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Set the value for pass.
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}
