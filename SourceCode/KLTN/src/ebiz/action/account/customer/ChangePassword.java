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
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class ChangePassword extends BaseAction {

    /**
     * [ChangePassword Action].
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
        boolean flag = true;
        ActionMessages messages = new ActionMessages();
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String reNew = request.getParameter("reNew");
        LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
        String pass = user.getLoginPassword();
        // check validation
        if (oldPass.equals("") || newPass.equals("") || reNew.equals("")) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("changePassword.madatory"));
            saveMessages(request, messages);
            return mapping.findForward(FAILURE);
        }
        if (!(pass.equals(oldPass))) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("changePassword.passwrong"));
            flag = false;
        }
        if (!(newPass.equals(reNew))) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("changePassword.duplicated"));
            flag = false;
        }
        if (flag) {
            Customer customer = user.getCustomer();
            flag = CustomerBLO.updateCustomer(customer);
            if (flag) {
                return mapping.findForward(SUCCESS);
            }
        }
        saveMessages(request, messages);
        return mapping.findForward(FAILURE);

    }

}
