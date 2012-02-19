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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.SearchBLO;

import net.sf.jsr107cache.Cache;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonConstant;

/**
 * @author Administrator
 */
public class DisplayBill extends BaseAction {
    /**
     * [DisplayBill(Customer Account)].
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
        String status = (String) request.getParameter("value");
        String page = (String) request.getParameter("page");
        LoginForm login = (LoginForm) se.getAttribute(CommonConstant.USER);
        int pageIndex = 1;
        List<String> pageList = new ArrayList<String>();
        List<OrderBillForm> formList = new ArrayList<OrderBillForm>();
        if (page != null) {
            pageIndex = Integer.parseInt(page);
        }
        // get form list from Memcache
        Cache cache = SearchBLO.getMemcache();
        formList = (List<OrderBillForm>) cache.get("customerBillData");

        if (formList == null || formList.isEmpty()) {
            formList = CustomerBLO.getOrderBillFormList(login.getLoginId(), status);
        }
        pageList = SearchBLO.paging(formList.size());
        formList = (List<OrderBillForm>) SearchBLO.getPage(formList, pageIndex);
        //save Bill in session to display
        se.setAttribute(CommonConstant.BILL, formList);
        //save PagingList in session to display
        se.setAttribute("pagingList", pageList);
        return mapping.findForward(SUCCESS);
    }

}
