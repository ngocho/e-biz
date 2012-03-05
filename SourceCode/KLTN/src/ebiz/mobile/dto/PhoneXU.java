package ebiz.mobile.dto;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author nthanhphong
 */
@PersistenceCapable
public class PhoneXU implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    /** . */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String phone;
    /** . */
    @Persistent
    private long money;

    /**
     * [Give the description for method].
     * @param mphone String
     */
    public void setPhone(String mphone) {
        this.phone = mphone;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getPhone() {
        return phone;
    }
    /**
     * [Give the description for method].
     * @param mmoney long
     */
    public void setMoney(long mmoney) {
        this.money = mmoney;
    }
    /**
     * [Give the description for method].
     * @return long
     */
    public long getMoney() {
        return money;
    }
}
