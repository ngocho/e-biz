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
import ebiz.blo.provider.ProviderBLO;
import ebiz.form.ProviderForm;
import ebiz.util.CommonConstant;
import ebiz.dto.account.provider.Provider;
/**
 * @author Administrator
 */
public class Authentication extends BaseAction {

    /**
     * [AuthenticationProvider].
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
        String code = request.getParameter("valueAuthen");
        if (code != null) {
            if (!code.equals("")) {
                HttpSession se = request.getSession();
                String providerId = (String) se.getAttribute("idProvider");
                if (providerId != null) {
                    Provider pro = ProviderBLO.getProviderById(providerId);
                    if (pro != null) {
                        String codeSecret = pro.getActiveCode();
                        if (codeSecret.equals(code)) {
                            // success
                            pro.setActive(true);
                            boolean flag = ProviderBLO.updateProvider(pro);
                            if (flag) {
                                ProviderForm login = new ProviderForm();
                                login.setLoginId(providerId);
                                se.setAttribute(CommonConstant.PROVIDER, login);
                                se.setAttribute(CommonConstant.WELCOMEP, CommonConstant.WELCOMEP
                                        + login.getLoginId().toUpperCase());
                                return mapping.findForward(SUCCESS);
                            }
                        }
                    }
                    return mapping.findForward(FAILURE);
                }
            }
        }
        return mapping.findForward(FAILURE);
    }
}
