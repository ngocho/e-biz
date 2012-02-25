package ebiz.form;

import java.io.Serializable;

public class PFoodName implements Serializable {

    /** . */
    private static final long serialVersionUID = 1L;
    private String id;
    private String display;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDisplay() {
        return display;
    }
    public void setDisplay(String display) {
        this.display = display;
    }

}
