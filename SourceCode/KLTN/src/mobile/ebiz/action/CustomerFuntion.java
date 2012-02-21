/**
 * 
 */
package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import mobile.ebiz.blo.IDXUBLO;
import mobile.ebiz.dto.IDXU;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Customer;

/**
 * @author nthanhphong
 * 
 */
public class CustomerFuntion extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;

		JSONObject json = new JSONObject();
		String flag = "0";
		String[] items;
		String flaguser = request.getParameter("flag");
		String content = request.getParameter("content");
		try {
			if(flaguser.equals("login")){
				items=content.split("@");
				flag=login(items[0], items[1]);
			}else if(flaguser.equals("update")){
				flag=update(content);
			}else if(flaguser.equals("register")){
				flag=register(content);
			}else if(flaguser.equals("changepass")){
				flag=changepass(content);
			}else if(flaguser.equals("XuActive")){
				flag=XuActive(content);
			}else if(flaguser.equals("XuSendCustomer")){
				flag=XuSendCustomer(content);
			}else if(flaguser.equals("GetXu")){
				items=content.split("@");
				flag=getxu(items[0], items[1]);
			}
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
	public String getxu(String username, String pass) {
		Customer customerowner = CustomerBLO.getCustomerByID(username);
		int i = CustomerBLO.isLoginID(username, pass);
		if (i == 1) {
			return String.valueOf(customerowner.getXuOnline());
		} else {
			return "0";
		}
	}

	/**
	 * login Parameters: id is username customer pass is password customer
	 * Returns: true login successful false login fasle
	 */
	
	public String login(String id, String pass) {
		int i = CustomerBLO.isLoginID(id, pass);
		if (i == 1) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * update customer
	 * 
	 * @param content
	 *            (username@fullname@phone@email@birthday@gender@address)
	 * @return
	 */
	public String update(String content) {
		String[] list = content.split("@");
		Customer customer = CustomerBLO.getCustomerByID(list[0]);
		if (null != customer) {
			customer.setCustomerName(list[1]);
			customer.setCustomerPhone(list[2]);
			customer.setCustomerEmail(list[3]);
			customer.setCustomerBirth(new Date(list[4]));
			customer.setCustomerGender(list[5]);
			Address address = new Address();
			address.setStreetName(list[6]);
			if(CustomerBLO.updateCustomer(customer))
				return "1";
			else return "0";
		} else {
			return "0";
		}
	}

	/**
	 * register
	 * 
	 * @param content
	 *            (username@password@fullname@phone@email@birthday@gender@address
	 *            )
	 * @return
	 */
	public String register(String content) {
		Customer customer = new Customer();
		String[] list = content.split("@");
		customer.setCustomerId(list[0]);
		customer.setCustomerPassword(list[1]);
		customer.setCustomerName(list[2]);
		customer.setCustomerPhone(list[3]);
		customer.setCustomerEmail(list[4]);
		customer.setCustomerBirth(new Date(list[5]));
		customer.setCustomerGender(list[6]);
		Address address = new Address();
		address.setStreetName(list[7]);
		customer.setCustomerAddress(address);
		if(CustomerBLO.registerCustomer(customer))
			return "1";
		else return "0";
	}

	/**
	 * Changepass
	 * 
	 * @param content
	 *            (username@oldpass@newpass)
	 * @return true change successful, false can not change password
	 */
	public String changepass(String content) {
		String[] list = content.split("@");
		if (CustomerBLO.isLoginID(list[0], list[1]) == 1) {
			Customer customer = CustomerBLO.getCustomerByID(list[0]);
			customer.setCustomerPassword(list[2]);
			CustomerBLO.updateCustomer(customer);
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * XuActive
	 * 
	 * @param content
	 *            (username@productkey)
	 * @return -1: username not exist; 1: successful; 0: produckey not correct
	 */
	public String XuActive(String content) {
		String[] list = content.split("@");
		if (null != CustomerBLO.getCustomerByID(list[0])) {
			IDXU xu = IDXUBLO.getXuById(list[1]);
			if (xu.getFlag().equals("true")) {
				return "1";
			} else {
				return "0";
			}
		} else {
			return "-1";
		}
	}

	/**
	 * 
	 * @param content
	 *            (usernameOwner@password@numberXu@usernameTransfer)
	 * @return 1: successful; -1 username owner not correct; 2: not enough Xu;
	 *         3: username transfer not exist; 0: password username owner not
	 *         correct
	 */
	public String XuSendCustomer(String content) {
		String[] list = content.split("@");
		long xu = Long.parseLong(list[2]);
		Customer customerowner = CustomerBLO.getCustomerByID(list[0]);
		Customer usertransfer = CustomerBLO.getCustomerByID(list[3]);
		if (null != customerowner) {
			if (customerowner.getCustomerPassword().equals(list[1])) {
				if (customerowner.getXuOnline() >= xu) {
					if (null != usertransfer) {
						customerowner.setXuOnline(customerowner.getXuOnline()
								- xu);
						usertransfer.setXuOnline(usertransfer.getXuOnline()
								+ xu);
						CustomerBLO.updateCustomer(customerowner);
						CustomerBLO.updateCustomer(usertransfer);
						return "1"; // successful
					} else {
						return "3";// usertransfer not exist
					}
				} else {
					return "2";// khong du xu giao dich
				}
			} else {
				return "0";// password userOwner not correct
			}
		} else {
			return "-1";// usernameowner not correct
		}
	}
}
