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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;

import java.util.List;
import java.util.ArrayList;
import ebiz.action.BaseAction;
import ebiz.blo.food.SearchBLO;
import ebiz.form.FoodForm;
import ebiz.form.SearchForm;;
/**
 * @author ThuyNT
 */
public class Search extends BaseAction {

    @SuppressWarnings("unchecked")
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    		SearchForm searchForm = (SearchForm)form;
    		if(searchForm.getSearchText() != null){
    		HttpSession se = request.getSession();
//    	    HashMap<Integer, String> paging = new HashMap<Integer, String>();
//    	    String page = request.getParameter("page");
    	    int pageIndex = 1;
    		List<FoodForm> formList = new ArrayList<FoodForm>();
    		List<String> pageList = new ArrayList<String>();
//    		Cache cache = SearchBLO.getMemcache();
    		
    		formList = SearchBLO.searchFullText(searchForm);
    		pageList = SearchBLO.paging(formList.size());
    		System.out.println("pageList" + pageList.size());
    		//display first page
    		formList = (List<FoodForm>)SearchBLO.getPage(formList, pageIndex);
    		se.setAttribute("pageList", pageList);
    		se.setAttribute("searchForm",searchForm);
    		se.setAttribute("pageIndex", 1);
    		if(!formList.isEmpty()){
    		se.setAttribute("searchResult", formList);
    		return mapping.findForward(SUCCESS);
    		}
    		}
    		return mapping.findForward(FAILURE);
    }
}
