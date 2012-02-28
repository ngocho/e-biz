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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.food.SearchBLO;
import ebiz.blo.provider.ProviderBLO;
import ebiz.form.ProviderForm;

/**
 * @author ThuyNT
 */
public class ProviderList extends BaseAction {
    /**
     * [ProviderList ].
     *
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see ActionForward Struts1 Framework
     */
    @SuppressWarnings("unchecked")
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession se = request.getSession();
        String page = request.getParameter("page");
        int pageIndex = 1;
        if (page != null) {
            pageIndex = Integer.parseInt(page);
        }
        List<ProviderForm> displayList = ProviderBLO.getProviderFormAll();
        List<String> pageList = (List<String>) se.getAttribute("pageList");
        if (pageList == null) {
            pageList = SearchBLO.paging(displayList.size());
                                                      
            se.setAttribute("pageList", pageList);
        }
        displayList = (List<ProviderForm>) SearchBLO.getPage(displayList, pageIndex);
        se.setAttribute("providerList", displayList);
        se.setAttribute("pageIndex", pageIndex);
        return mapping.findForward(SUCCESS);

    }

}
