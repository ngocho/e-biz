package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.dao.gae.PMF;
import ebiz.dto.account.provider.Provider;

/**
 * @author nthanhphong
 */
public class GetActiveCode extends BaseAction {
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
        List<JSONObject> objList = new ArrayList<JSONObject>();
        try {

            objList = getVoucherList();
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
    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    @SuppressWarnings("unchecked")
    public List<JSONObject> getVoucherList() throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<Provider> listprovider = (List<Provider>) PMF.getObjectList(Provider.class);
        for (int i = 0; i < listprovider.size(); i++) {
            try {
                if (listprovider.get(i).getProviderPhone() != null && !listprovider.get(i).isActive()) {
                    JSONObject json = new JSONObject();
                    json.put("phone", listprovider.get(i).getProviderPhone());
                    json.put("code", listprovider.get(i).getActiveCode());
                    objList.add(json);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return objList;
    }

}
