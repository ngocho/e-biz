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
import ebiz.form.ProductVO;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class DisplayProductPaging extends BaseAction {

    /**
     * [DisplayProduct when click paging].
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
        // declare varible
        int record;
        int page = 1;
        String limit, col, status;
        String filterCol = CommonConstant.FOOD_STATUS;
        System.out.println("STATUS" + filterCol);
        List<FoodForm> foods = new ArrayList<FoodForm>();
        List<String> numberPageList = new ArrayList<String>();
        // get param
        String order = request.getParameter("order");
        limit = (String) request.getParameter("limit");
        col = (String) request.getParameter("col");
        String p = (String) request.getParameter("page");
        status = (String) request.getParameter("value");
        // session
        HttpSession se = request.getSession();
        String idProvider = (String) se.getAttribute("idProvider");
        ProductVO vo = (ProductVO) se.getAttribute(CommonConstant.PROVIDERVO);
        if (status == null) {
            status = vo.getStatus();
        }
        if (order == null) {
            order = vo.getOrder();
        }
        if (limit == null) {
            record = vo.getLimit();
        } else {
            record = Integer.parseInt(limit);
        }

        if (col == null) {
            col = vo.getCol();
        }
        if (p != null) {
            page = Integer.parseInt(p);
        }
        // display FoodCategory
        foods = FoodBLO.displayFoodCategoryPaging(col, numberPageList, order, record, page, filterCol, status,
                idProvider);
        // update status of paging
        // save in Session
        se.setAttribute(CommonConstant.PROVIDER_CATEGORY_F, foods);
        vo.setLimit(record);
        vo.setCol(col);
        vo.setPage(page);
        vo.setPagingList(numberPageList);
        vo.setOrder(order);
        vo.setStatus(status);
        return mapping.findForward(SUCCESS);

    }

}
