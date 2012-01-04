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

import ebiz.blo.customer.CustomerBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ebiz.action.BaseAction;
import ebiz.blo.common.SendMail;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class Register extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("REGISTER");
       
        // after checked validation using xml file
        LoginForm user = (LoginForm) form;
        Customer register = user.getCustomer();
        boolean f;

        f = CustomerBLO.registerCustomer(register);
        System.out.println("RESULT" + f);
        if (f) {
            HttpSession se = request.getSession();
            // save value in session
//            se.setAttribute(CommonConstant.USER, user);

            //send mail  --> use task queue
            SendMail.registerSuccess(user.getEmail());

            return mapping.findForward(SUCCESS);
        }

        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.duplicated"));
        saveMessages(request, messages); // storing messages as request attributes
        return mapping.findForward(FAILURE);
    }

}