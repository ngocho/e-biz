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
public class DisplayCategoryRecord extends BaseAction {
    /**
     * [DisplayCategoryRecord Paging].
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

        String attr = request.getParameter("attr");
        String price = request.getParameter("price");
        String order = request.getParameter("order");
        HttpSession se = request.getSession();
        List<FoodForm> foods = new ArrayList<FoodForm>();
        List<String> numberPageList = new ArrayList<String>();
        String providerId =(String)se.getAttribute("ProviderFood");
        ProductVO vo = (ProductVO) se.getAttribute(CommonConstant.PRODUCTVO);
        int record = CommonConstant.DEFAULT_RECORD;
        String limit;
        String col;
        if (order == null) {
            order = vo.getOrder();
        }
        int page = 1;

        // get info from request
        limit = (String) request.getParameter("limit");
        col = (String) request.getParameter("col");
        String p = (String) request.getParameter("page");
        if (limit == null) {
            record = vo.getLimit();
        } else {
            record = Integer.parseInt(limit);
        }

        if (col == null) {
            col = vo.getCol();
        }
        if (attr == null) {
            attr = vo.getAttr();
        }
        if (price == null) {
            price = vo.getPriceId();
        }
        if (p != null) {
            page = Integer.parseInt(p);
        }
        String filterCol = CommonConstant.FOOD_TYPE;
        foods = FoodBLO.getFoodListCategory(col, numberPageList, order, record, page, filterCol, vo.getTypeProduct(),
                attr, price,providerId);
        // save in Session
        se.setAttribute(CommonConstant.FOOD_CATEGORY_F, foods);
        vo.setLimit(record);
        vo.setCol(col);
        vo.setPage(page);
        vo.setPagingList(numberPageList);
        vo.setOrder(order);
        vo.setAttr(attr);
        vo.setPriceId(price);
        return mapping.findForward(SUCCESS);

    }

}
