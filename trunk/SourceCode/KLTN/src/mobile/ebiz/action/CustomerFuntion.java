/**
 * 
 */
package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.api.search.ExpressionParser.num_return;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Customer;

/**
 * @author nthanhphong
 *
 */
public class CustomerFuntion extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;

		JSONObject json = new JSONObject();
		boolean flag = false;
		//flag active xu
		String flagxu=request.getParameter("flag");
		String content=request.getParameter("content");
		try {
			
			json.put("flag", flag);
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
	//username,password
	public boolean customer_login(String content){
		boolean result=false;
		try {
			String[] listitem=content.split("@");
			if(CustomerBLO.isLoginID(listitem[0], listitem[1])==1){
				result=true;
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	//username,pass,ten,email,address,phone,gioitinh,birthday
	public boolean customer_register(String content){
		boolean result=false;
		try {
			String[] listitem=content.split("@");
			Customer customer=new Customer();
			customer.setActive(true);
			customer.setCustomerId(listitem[0]);
			customer.setCustomerPassword(listitem[1]);
			customer.setCustomerName(listitem[2]);
			customer.setCustomerEmail(listitem[4]);
			customer.setCustomerPhone(listitem[5]);
			if(CustomerBLO.registerCustomer(customer))
				result=true;
		} catch (Exception e) {
		}
		return result;
	}
	//username,pass,newpass
	public boolean customer_changepass(String content){
		boolean result=false;
		try {
			String[] listitem=content.split("@");
			Customer customer=CustomerBLO.getCustomerByID(listitem[0]);
			if(customer!=null&&customer.getCustomerPassword().equals(listitem[1])){
				customer.setCustomerPassword(listitem[2]);
				CustomerBLO.updatecustomer(customer);
			}
		} catch (Exception e) {
		}
		return result;
	}
}
