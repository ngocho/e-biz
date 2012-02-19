package ebiz.form;

import java.io.Serializable;
/**
 * @author ThuyNT
 */
public class ProviderStatus implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    /**  . */
    private String id;
    /**  . */
    private String display;
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
     * Get value of display.
     * @return the display
     */
    public String getDisplay() {
        return display;
    }
    /**
     * Set the value for display.
     * @param display the display to set
     */
    public void setDisplay(String display) {
        this.display = display;
    }

}
