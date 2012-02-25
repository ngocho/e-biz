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
import ebiz.util.CommonConstant;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
/**
 * @author ThuyNT
 */
public class VoucherProcess extends BaseAction {

    /**
     * [Voucher(Customer)].
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
        String screen = request.getParameter("checkoutOption");
        String type = request.getParameter("checkoutOption");
        HttpSession se = request.getSession();
        LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
        if (type.equals("home")) {
            screen = "voucher_info";
        } else if (type.equals("xu")) {
            // test xu account money : enough?
            OrderBillForm voucherForm = (OrderBillForm) se.getAttribute("voucherForm");
            boolean flag = CustomerBLO.isXuOnline(user.getLoginId(), voucherForm.getSumPrice());
            if (flag) {
                // if enough
                screen = "voucher_shipping";
            } else {
                // else
                // display message : choose different way or input money into xu account
                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.password.wrong"));
                saveMessages(request, messages);
                screen = "voucher_optional";
                se.setAttribute("inputXu", "xu");
            }
        } else {
            screen = "voucher_shipping";
        }
        ActionForward forward = mapping.getInputForward();
        forward.setPath(screen);
        return forward;
    }

}
