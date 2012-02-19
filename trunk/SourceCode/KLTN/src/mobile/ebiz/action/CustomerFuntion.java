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
	 * login Parameters: id is username customer pass is password customer
	 * Returns: true login successful false login fasle
	 */

	public boolean login(String id, String pass) {
		int i = CustomerBLO.isLoginID(id, pass);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * update customer
	 * 
	 * @param content
	 *            (username@fullname@phone@email@birthday@gender@address)
	 * @return
	 */
	public boolean update(String content) {
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
			return CustomerBLO.updateCustomer(customer);
		} else {
			return false;
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
	public boolean register(String content) {
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
		return CustomerBLO.registerCustomer(customer);
	}

	/**
	 * Changepass
	 * 
	 * @param content
	 *            (username@oldpass@newpass)
	 * @return true change successful, false can not change password
	 */
	public boolean changepass(String content) {
		String[] list = content.split("@");
		if (CustomerBLO.isLoginID(list[0], list[1]) == 1) {
			Customer customer = CustomerBLO.getCustomerByID(list[0]);
			customer.setCustomerPassword(list[2]);
			CustomerBLO.updateCustomer(customer);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * XuActive
	 * 
	 * @param content
	 *            (username@productkey)
	 * @return -1: username not exist; 1: successful; 0: produckey not correct
	 */
	public int XuActive(String content) {
		String[] list = content.split("@");
		if (null != CustomerBLO.getCustomerByID(list[0])) {
			IDXU xu = IDXUBLO.getXuById(list[1]);
			if (xu.getFlag().equals("true")) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
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
	public int XuSendCustomer(String content) {
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
						return 1; // successful
					} else {
						return 3;// usertransfer not exist
					}
				} else {
					return 2;// khong du xu giao dich
				}
			} else {
				return 0;// password userOwner not correct
			}
		} else {
			return -1;// usernameowner not correct
		}
	}
}
