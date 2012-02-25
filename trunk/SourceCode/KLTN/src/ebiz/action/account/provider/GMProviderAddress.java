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
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.provider.ProviderBLO;
import ebiz.dto.account.provider.Provider;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class GMProviderAddress extends BaseAction {
    /**
     * [Logout ].
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
        
        String id = request.getParameter("id");
        HttpSession se = request.getSession();
        if(id != null){
        Provider provider = ProviderBLO.getProviderById(id);
        String add = provider.getProviderAddress();
        LoginForm login = (LoginForm)se.getAttribute(CommonConstant.USER);
        if(login != null){
            se.setAttribute("startProvider", CustomerBLO.toStringAddres(login.getHomeNumber(), login.getBuildingName(),login.getStreetName(),login.getWardName(),
                    login.getDistrictName()));
        }
        else{
            se.setAttribute("startProvider", "Bến Thành");
        }
        request.setAttribute("gmFlag", 1);
        se.setAttribute("endProvider", add);
        se.setAttribute("nameProvider", provider.getProviderName());
        }
        return mapping.findForward(SUCCESS);

    }

}
