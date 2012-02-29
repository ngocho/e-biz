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

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class UpdateCustomerInfo extends BaseAction {

    /**
     * [UpdateCustomerInfo].
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see ActionForward Struts1 Framework
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType(CommonConstant.CONTENTTYPE);
        response.setCharacterEncoding(CommonConstant.CHARACTERENCODING);
        HttpSession se = request.getSession();
        LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
        Customer customer = CustomerBLO.getCustomerByID(user.getLoginId());
        //set value
        customer.setCustomerName(request.getParameter("name"));
        customer.setCustomerEmail(request.getParameter("mail"));
        customer.setCustomerPhone(request.getParameter("phone"));
        customer.getCustomerAddress().setBuildingName(request.getParameter("buildingName"));
        customer.getCustomerAddress().setDistrictName(request.getParameter("districtName"));
        customer.getCustomerAddress().setHomeNumber(request.getParameter("homeNumber"));
        customer.getCustomerAddress().setStreetName(request.getParameter("streetName"));
        customer.getCustomerAddress().setWardName(request.getParameter("wardName"));
        //update
        boolean flag =  CustomerBLO.updateCustomer(customer);
        if (flag) {
            out.println("1");
        }
        return null;
    }
}
