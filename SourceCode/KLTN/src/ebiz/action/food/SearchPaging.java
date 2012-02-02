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
import ebiz.blo.food.SearchBLO;
import ebiz.form.FoodForm;
import ebiz.form.SearchForm;
/**
 * @author ThuyNT
 */
public class SearchPaging extends BaseAction {

    @SuppressWarnings("unchecked")
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            HttpSession se = request.getSession();
//          HashMap<Integer, String> paging = new HashMap<Integer, String>();
    		SearchForm searchForm = (SearchForm) se.getAttribute("searchForm");
    	    String page = request.getParameter("page");
    	    int pageIndex = Integer.parseInt(page);
    		List<FoodForm> formList = new ArrayList<FoodForm>();
    		Cache cache = SearchBLO.getMemcache();
    		formList = (List<FoodForm>) cache.get("searchData");
    		//had
    		if (formList == null) {
    			formList = SearchBLO.searchFullText(searchForm);
    			List<String> pageList = new ArrayList<String>();
    			pageList = SearchBLO.paging(formList.size());
    			se.setAttribute("pageList", pageList);
    		}
    		formList = SearchBLO.getPage(formList, pageIndex);
    		if (!formList.isEmpty()) {
    		se.setAttribute("searchResult", formList);
    		se.setAttribute("pageIndex", page);
    		return mapping.findForward(SUCCESS);
    		}
    		return mapping.findForward(FAILURE);
    }
}
