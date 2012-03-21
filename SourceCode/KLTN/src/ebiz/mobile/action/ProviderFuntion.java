package ebiz.mobile.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;

/**
 * @author nthanhphong
 */
public class ProviderFuntion extends BaseAction {
    /**
     * [Explain the description for this method here].
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;

        JSONObject json = new JSONObject();
        String flag = "false";
        // flag active xu
        String flagxu = request.getParameter("flag");
        String content = request.getParameter("content");
        try {

            json.put("flag", flag);
            // json.put("content", arg1)
            out = response.getWriter();
            out.println(json);
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
    /**
     * [Give the description for method].
     * @return JSONObject
     */
    public JSONObject getCodeActive() {
        JSONObject result = new JSONObject();
        JSONObject jsonPhone = new JSONObject();
        JSONObject jsonCode = new JSONObject();

        return result;
    }
}