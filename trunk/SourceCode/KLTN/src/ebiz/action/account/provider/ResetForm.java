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
package ebiz.action.account.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.form.ProviderForm;
import ebiz.form.FoodForm;

/**
 * @author ThuyNT
 */
public class ResetForm extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("RESET");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/xml; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		HttpSession se = request.getSession();
        System.out.println("urlImageKey");
        se.removeAttribute("urlImageKey");
		if ("0".equals(type)) {
			ProviderForm pro = (ProviderForm) se.getAttribute("providerFormLogin");
			System.out.println("providerForm" + pro);
			if (pro != null) {
				System.out.println(" remove providerForm");
				se.removeAttribute("providerFormLogin");
				pro = (ProviderForm) se.getAttribute("providerFormLogin");
				System.out.println("FORM" + pro);
			}
		} else if("2".equals(type)) {
			FoodForm food = (FoodForm) se.getAttribute("foodForm");
			if (food != null) {
				se.removeAttribute("foodForm");
			}
		} else if("1".equals(type)){
		    System.out.println("providerForm");
			ProviderForm food = (ProviderForm) se.getAttribute("providerForm");
			//remove url Image

			if (food != null) {
				se.removeAttribute("providerForm");
			}
		}
		return null;

	}

}
