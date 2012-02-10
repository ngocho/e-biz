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

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import employee.ebiz.blo.EmployeeTaskBLO;

/**
 * @author nthanhphong
 *
 */
public class EmployeeFuntion extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		List<JSONObject> objList = new ArrayList<JSONObject>();

		// call function get thong tin khuyen mai

		try {

			objList = MobileBLO.createEmployeeInfo();
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

		return mapping.findForward(null);

	}
	public List<JSONObject> getListTask(String usernameEmployee,String password){
		List<JSONObject> objList = new ArrayList<JSONObject>();
		EmployeeTaskBLO.getEmployeeTaskList();
		return objList;
	}
}
