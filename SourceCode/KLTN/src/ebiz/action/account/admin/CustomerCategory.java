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
package ebiz.action.account.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jsr107cache.Cache;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.admin.AdminBLO;
import ebiz.blo.food.SearchBLO;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;
/**
 * @author ThuyNT
 */
public class CustomerCategory extends BaseAction {
    /**
     * [Display FoodCategory for Admin].
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
        // String status = (String) request.getParameter("value");
        String page = (String) request.getParameter("page");
        int pageIndex = 1;
        List<String> pageList = new ArrayList<String>();
        List<LoginForm> formList = new ArrayList<LoginForm>();
        if (page != null) {
            pageIndex = Integer.parseInt(page);
        }
        // get form list from Memcache
        Cache cache = SearchBLO.getMemcache();
        formList = (List<LoginForm>) cache.get("adminCustomerData");

        if (formList == null || formList.isEmpty()) {
            formList = AdminBLO.getCustomerList();
        }
        pageList = SearchBLO.paging(formList.size());
        formList = (List<LoginForm>) SearchBLO.getPage(formList, pageIndex);
        // save Bill in session to display
        se.setAttribute(CommonConstant.ADMIN_CUSTOMER, formList);
        // save PagingList in session to display
        se.setAttribute("aPagingList", pageList);
        se.setAttribute("aPageIndex", pageIndex);
        return mapping.findForward(SUCCESS);
    }

}
