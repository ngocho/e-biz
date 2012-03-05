package ebiz.action;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ebiz.blo.admin.AdminBLO;
import ebiz.blo.common.Initialize;
import ebiz.blo.provider.ProviderBLO;
import ebiz.dto.account.admin.Admin;
import ebiz.dto.account.provider.Provider;
import ebiz.form.ProviderVO;
import ebiz.mobile.blo.IDXUBLO;
/**
 * @author ThuyNT
 */
public class InitDataListener implements ServletContextListener {
    /** . */
    private ServletContext servletContext;
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        ProviderVO pvo = new ProviderVO();
        servletContext.setAttribute("PVO", pvo);
        // init Food Attr
        Initialize.initializeFoodAttribute();
        Initialize.initializeFoodPriceLevel();
        // init hash code
        Initialize.createAss();
        // init xu
        IDXUBLO.createListXu();
        // init
        Provider pro = new Provider();
        pro.setProviderId("4");
        pro.setProviderName("thuyuit");
        pro.setProviderPassword("12345678");
        pro.setProviderAddress("Hai Bà Trưng, Quận 1");
        pro.setActive(true);
        ProviderBLO.updateProvider(pro);

        Provider pro1 = new Provider();
        pro1.setProviderId("5");
        pro1.setProviderName("thuyuit1");
        pro1.setProviderPassword("12345678");
        pro1.setProviderAddress("Võ Văn Ngân, Thủ Đức");
        pro1.setActive(true);
        ProviderBLO.updateProvider(pro1);

        Provider pro2 = new Provider();
        pro2.setProviderId("6");
        pro2.setProviderName("thuyuit2");
        pro2.setProviderPassword("12345678");
        pro2.setProviderAddress("Võ Văn Ngân, Thủ Đức");
        pro2.setActive(true);
        ProviderBLO.updateProvider(pro2);

        Admin ad = new Admin();
        ad.setId("admin");
        ad.setPassword("12345678");
        AdminBLO.registerAdmin(ad);

    }

}
