package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;

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
 */
public class GetPromotion extends BaseAction {
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
        JSONObject jsonPhone = new JSONObject();
        JSONObject jsonFood = new JSONObject();

        // call function get thong tin khuyen mai

        try {

            jsonPhone = MobileBLO.createCustomerPhone();
            json.put(CommonConstant.PHONECUSTOMER, jsonPhone);
            jsonFood = PromotionBLO.createFoodPromotion();
            json.put(CommonConstant.NAMEFOOD_PRO, jsonFood);
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
}
