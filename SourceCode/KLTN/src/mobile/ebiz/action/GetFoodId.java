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
import ebiz.blo.food.FoodBLO;
import ebiz.blo.provider.ProviderBLO;
import ebiz.dto.account.provider.Provider;
import ebiz.dto.food.Food;
import ebiz.util.CommonUtil;

/**
 * @author nthanhphong
 *
 */
public class GetFoodId extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        JSONObject objList = new JSONObject();

        try {
        	String content=request.getParameter("idfood");
            objList = GetFood(content);
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
	public JSONObject GetFood(String idfood)throws JSONException{
		JSONObject object=new JSONObject();
		Food item=FoodBLO.getFoodById(Long.valueOf(idfood));
		object.put("id", item.getFoodId());
		object.put("name", item.getFoodName());
		object.put("price", item.getPrice());
		object.put("pricepromotion", item.getPricePromotion());
		object.put("providerid", item.getProviderID());
		object.put("uploaddate", CommonUtil.convertDateToString(item.getUploadDate()));
		object.put("countbuy", item.getSaleProduct());
		object.put("image", item.getUrlKey());
		object.put("detail", item.getDetail());
		object.put("cooking", item.getCooking());
//		Provider provider=ProviderBLO.getProviderById(item.getProviderID());
//		object.put("providername", provider.getProviderName());
//		object.put("provideraddress", provider.getProviderAddress().getStreetName());
//		object.put("providerphone", provider.getProviderPhone());
//		object.put("provideremail", provider.getProviderEmail());
		return object;
	}
}
