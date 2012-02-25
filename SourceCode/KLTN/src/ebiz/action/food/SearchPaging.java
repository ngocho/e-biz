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
package ebiz.action.food;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.food.SearchBLO;
import ebiz.form.FoodForm;
/**
 * @author ThuyNT
 */
public class SearchPaging extends BaseAction {
    /**
     * [Search Food Paging].
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
        // HashMap<Integer, String> paging = new HashMap<Integer, String>();
//        SearchForm searchForm = (SearchForm) se.getAttribute("searchForm");
        String page = request.getParameter("page");
        int pageIndex = Integer.parseInt(page);
        List<FoodForm> formList =(List<FoodForm>) se.getAttribute("searchResult");
//        Cache cache = SearchBLO.getMemcache();
//        formList = (List<FoodForm>) cache.get("searchData");
//        // had
//        if (formList == null || formList.isEmpty()) {
//            formList = SearchBLO.searchFullText(searchForm);
//        }
//        formList = SearchBLO.searchFullText(searchForm);
        formList = (List<FoodForm>) SearchBLO.getPage(formList, pageIndex);
        se.setAttribute("pageIndex", pageIndex);
        if (!formList.isEmpty()) {
            se.setAttribute("searchResult", formList);
        }
        return mapping.findForward(SUCCESS);
    }
}
