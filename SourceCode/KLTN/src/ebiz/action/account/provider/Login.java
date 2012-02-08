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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ebiz.action.BaseAction;
import ebiz.blo.provider.ProviderBLO;
import ebiz.form.ProviderForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class Login extends BaseAction {
    /**
     * [Login ].
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

        // after checked validation using xml file
        ProviderForm login = (ProviderForm) form;
        ActionMessages messages = new ActionMessages();
        HttpSession se = request.getSession();
        int flag = -1;
        // test exist in database
        flag = ProviderBLO.isLoginID(login.getLoginId(), login.getLoginPassword());
        if (flag == 2) { // don't authentication
            return mapping.findForward(SUCCESS1);
        } else if (flag == 1) {
            // save in session
            se.setAttribute(CommonConstant.PROVIDER, login);
            se.setAttribute("idProvider", login.getLoginId());
            se.setAttribute(CommonConstant.WELCOME, CommonConstant.WELCOME + login.getLoginId().toUpperCase());
            return mapping.findForward(SUCCESS);
        } else if (flag == -1) {
            // add error password wrong
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.user.existed"));
        } else if (flag == 0) {
            // user input didn't exist
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.password.wrong"));
        }
        saveMessages(request, messages); // storing messages as request attributes
        return mapping.findForward(FAILURE);

    }

}
