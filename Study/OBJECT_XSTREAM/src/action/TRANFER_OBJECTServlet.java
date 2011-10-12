package action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dto.SV;
@SuppressWarnings("serial")
public class TRANFER_OBJECTServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        resp.setContentType("text/xml");
        PrintWriter out=resp.getWriter();
        
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("SINHVIEN", SV.class);
       
        SV sv = new SV("1","Nguyen Van A");
        SV sv1 = new SV("1","Nguyen Van A");
        List<SV> svList = new ArrayList<SV>();
        xstream.alias("DANHSACH", List.class);
        svList.add(sv);
        svList.add(sv1);
        String xml = xstream.toXML(svList);
        System.out.println(xml);
        out.println(xml);
        out.flush();

        
    }
}
