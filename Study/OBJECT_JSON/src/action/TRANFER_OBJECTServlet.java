package action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import dto.SV;
@SuppressWarnings("serial")
public class TRANFER_OBJECTServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/text");
        PrintWriter out = resp.getWriter();

        // XStream xstream = new XStream(new DomDriver());
        // xstream.alias("SINHVIEN", SV.class);
        //
        // SV sv = new SV("1","Nguyen Van A");
        // SV sv1 = new SV("1","Nguyen Van A");
        // List<SV> svList = new ArrayList<SV>();
        // xstream.alias("DANHSACH", List.class);
        // svList.add(sv);
        // svList.add(sv1);
        // String xml = xstream.toXML(svList);
        // System.out.println(xml);
        // out.println(xml);
        // out.flush();
        JSONArray jsonList = new JSONArray();

        List<SV> svList = new ArrayList<SV>();
        JSONObject json1 = new JSONObject();
        SV sv = new SV("1", "Nguyen Van A");
        SV sv1 = new SV("2", "Nguyen Van A");
        SV sv2 = new SV("3", "Nguyen Van A");
        SV sv3 = new SV("4", "Nguyen Van A");
        svList.add(sv);
        svList.add(sv1);
        svList.add(sv2);
        svList.add(sv3);
        try {

            for (SV s : svList) {
                JSONObject json = new JSONObject();
                json.put("id", s.getId());
                json.put("name", s.getName());
                jsonList.put(json);

            }

            // put jsonList into json object
            json1.put("SV", jsonList);
        } catch (JSONException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }

        String strJson;
        strJson = jsonList.toString();
        System.out.println(strJson);
        System.out.println(json1.toString());
        out.println(strJson);
        out.flush();

    }
}
