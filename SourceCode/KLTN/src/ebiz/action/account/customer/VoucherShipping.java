/**
 * Licensed to Open-Ones Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Open-Ones Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ebiz.action.account.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;

/**
 * @author ThuyNT
 */
public class VoucherShipping extends BaseAction {

	/**
	 * [VoucherShipping].
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 *             Exception
	 * @see ActionForward Struts1 Framework
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String type = request.getParameter("typeShipping");
		String screen;
		HttpSession se = request.getSession();
		if(type.equals("home")){
			screen  = "voucher_info";
		}
		else if(type.equals("message")){
			screen  = "voucher_type";
			se.setAttribute("voucherType", "message");
		}
		else{
			screen  = "voucher_type";
			se.setAttribute("voucherType", "mail");
		}
		System.out.println("checkoutOption" + screen);
		ActionForward forward =   mapping.getInputForward();
    	forward.setPath(screen);
    	return forward;
	}

}
