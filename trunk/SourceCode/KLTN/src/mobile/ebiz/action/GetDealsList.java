/**
 * 
 */
package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobile.ebiz.blo.MobileBLO;
import mobile.ebiz.blo.PromotionBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.util.CommonConstant;

/**
 * @author nthanhphong
 *
 */
public class GetDealsList extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        List<JSONObject> objList = new ArrayList<JSONObject>();

        try {
            
            objList = MobileBLO.getBestListAll();
            out = response.getWriter();
            out.println(objList);
            out.flush();
        } catch (JSONException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return null;
    }
}