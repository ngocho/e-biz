package ebiz.form;
import org.apache.struts.action.ActionForm;
import java.io.Serializable;

public class SearchForm extends ActionForm implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    private String searchText;
    private String type;
    private String attr;
    private String price;
    private String status;
    private String districtNameS;
    private String provider;
    private String dis;
    public String getSearchText() {
        return searchText;
    }
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    public String getAttr() {
        return attr;
    }
    public void setAttr(String attr) {
        this.attr = attr;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }
    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }
    /**
     * @return the districtNameS
     */
    public String getDistrictNameS() {
        return districtNameS;
    }
    /**
     * @param districtNameS the districtNameS to set
     */
    public void setDistrictNameS(String districtNameS) {
        this.districtNameS = districtNameS;
    }
    /**
     * @return the dis
     */
    public String getDis() {
        return dis;
    }
    /**
     * @param dis the dis to set
     */
    public void setDis(String dis) {
        this.dis = dis;
    }

}
