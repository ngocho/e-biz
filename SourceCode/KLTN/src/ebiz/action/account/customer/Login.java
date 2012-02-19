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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class Login extends BaseAction {

    /**
     * [Login(Customer)].
     *
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
        HttpSession se = request.getSession();
        LoginForm login = (LoginForm) form;
        int flag = -1;
        ActionMessages messages = new ActionMessages();
        // test exist in database
        flag = CustomerBLO.isLoginID(login.getLoginId(), login.getLoginPassword());
        if (flag == 1) {
            login.setXuOnline(CustomerBLO.getXuOnline(login.getLoginId()));
            // save user in session
            se.setAttribute(CommonConstant.USER, login);
            // shopping cart
            se.setAttribute(CommonConstant.WELCOME, CommonConstant.WELCOME + login.getLoginId().toUpperCase());
            // remove LoginForm from session
            se.removeAttribute("login");
            String screen = (String) se.getAttribute("screen");
            System.out.println("SCREEN" + screen);
            if (screen != null) {
                if (screen.equals(CommonConstant.SCREEN_CHECKOUT)) {
                    se.removeAttribute("screen");
                    // checkout screen
                    return mapping.findForward(SUCCESS1);
                } else if (screen.equals("voucher_optional")) {
                    OrderBillForm voucherForm = (OrderBillForm) se.getAttribute("voucherForm");
                    System.out.println("Voucher Form" + voucherForm.getSumPrice());
                    CustomerBLO.getLoginVoucher(login);
                    voucherForm.editFormLogin(login);
                    ActionForward forward = mapping.getInputForward();
                    forward.setPath(screen);
                    return forward;
                }
            }
            // home screen
            return mapping.findForward(SUCCESS);
        } else if (flag == -1) {
            // add error password wrong
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.user.existed"));
        } else if (flag == 0) {
            // account didn't exist
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.password.wrong"));
        }
        // storing messages as request attributes
        saveMessages(request, messages);
        return mapping.findForward(FAILURE);

    }

}
