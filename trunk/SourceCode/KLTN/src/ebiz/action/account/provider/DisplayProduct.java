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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.form.FoodForm;
import ebiz.form.Paging;
import ebiz.form.ProductVO;
import ebiz.form.ProviderVO;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class DisplayProduct extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //declare variable
    	ProductVO vo = new ProductVO();
        List<Paging> pageList = new ArrayList<Paging>();
        List<FoodForm> foods = new ArrayList<FoodForm>();
        //get param
        String value = request.getParameter("value");
        System.out.println("typeProduct" + value);
        HttpSession se = request.getSession();
        String idProvider = (String)se.getAttribute("idProvider");
        if (value == null) {
        //get all
            value = "0";
        }
        HashMap<Integer, String> paging = new HashMap<Integer, String>();
        foods = FoodBLO.initFoodCategoryProvider(paging,idProvider);
        pageList = FoodBLO.updateStatusPaging(paging);
        //set attr into VO
        vo.setPagingList(pageList);
        vo.setLimit(CommonConstant.DEFAULT_RECORD);
        vo.setCol(CommonConstant.DEFAULT_COL);
        vo.setPage(CommonConstant.DEFAULT_PAGE);
        vo.setOrder(CommonConstant.DEFAULT_ORDER);
        vo.setStatus(value);
        //save in session
        se.setAttribute(CommonConstant.PROVIDERVO, vo);
        //short display
        FoodBLO.shortDisplay(foods,5);
        // list food to display
        se.setAttribute(CommonConstant.PROVIDER_CATEGORY_F, foods);
      //save attr in app scope
        ProviderVO pvo = new ProviderVO();
        getServlet().getServletContext().setAttribute("PVO", pvo);
        System.out.println("PVO");
        return mapping.findForward(SUCCESS);
    }

}
