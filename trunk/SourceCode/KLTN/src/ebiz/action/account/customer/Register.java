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
import ebiz.blo.common.SendMail;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;

/**
 * @author ThuyNT
 */
public class Register extends BaseAction {

    /**
     * [Register(Customer)].
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
        // after checked validation using xml file
        LoginForm user = (LoginForm) form;
        // check password with re-password
        if (!user.getLoginPassword().equals(user.getLoginPasswordPre())) {
            ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("password.notmatch"));
            saveMessages(request, messages); // storing messages as request attributes
            return mapping.findForward(FAILURE);
        }
        // don't exist User ID in database
        if (!CustomerBLO.isUID(user.getLoginId())) {
            Customer register = user.getCustomer();
            boolean flag;

            flag = CustomerBLO.registerCustomer(register);
            if (flag) {
                HttpSession se = request.getSession();
                if (user.getEmail() != null) {
                    // send mail --> use task queue
                    SendMail.registerSuccess(user.getEmail());
                }
                se.setAttribute("login", user);
                return mapping.findForward(SUCCESS);
            }
        }
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.duplicated"));
        // storing messages as request attributes
        saveMessages(request, messages);
        return mapping.findForward(FAILURE);
    }

}
