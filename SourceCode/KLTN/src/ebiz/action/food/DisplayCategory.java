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
import ebiz.blo.provider.ProviderBLO;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.form.FoodForm;
import ebiz.form.FoodPriceForm;
import ebiz.form.ProductVO;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class DisplayCategory extends BaseAction {
    /**
     * [DisplayCategory].
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
        List<FoodAttribute> attrs = new ArrayList<FoodAttribute>();
        List<FoodPriceForm> prices = new ArrayList<FoodPriceForm>();
        List<FoodForm> foods = new ArrayList<FoodForm>();
        List<String> numberPageList = new ArrayList<String>();
        ProductVO vo = new ProductVO();
        String providerId = request.getParameter("providerId");
        if(providerId == null){
        	providerId = (String)se.getAttribute("ProviderFood");
        }
        System.out.println("providerId" + providerId );
        String typeProduct = request.getParameter("typeProduct");
        if (typeProduct == null) {
            vo = (ProductVO) se.getAttribute(CommonConstant.PRODUCTVO);
            typeProduct = vo.getTypeProduct();
        } else {
            vo.setTypeProduct(typeProduct);
        }
        // get attribute --> save in session
        attrs = FoodBLO.getAttributeFoodList();
        se.setAttribute(CommonConstant.FOOD_CATEGORY_A, attrs);
        // get type of price from session
        prices = (List<FoodPriceForm>) se.getAttribute(CommonConstant.FOOD_CATEGORY_P);
        if (prices == null) {
            List<FoodPriceLevel> listLevel = FoodBLO.getPriceFoodList();
            prices = FoodBLO.format(listLevel);
            se.setAttribute(CommonConstant.FOOD_CATEGORY_P, prices);
        }
        // get product --> save in session
        String filterCol = CommonConstant.FOOD_TYPE;
        foods = FoodBLO.initFoodCategory(numberPageList, CommonConstant.DEFAULT_RECORD, filterCol, typeProduct, null,
                null,providerId);
        if(providerId != null){
        	String name = ProviderBLO.getNameProviderByID(providerId);
        	se.setAttribute("ProviderFood", providerId);
        	se.setAttribute("ProviderFoodName", name);
        }
        // paging
        vo.setPagingList(numberPageList);
        // se.setAttribute(CommonConstant.PAGING, pageList);
        // number display in 1 page
        vo.setLimit(CommonConstant.DEFAULT_RECORD);
        vo.setCol(CommonConstant.DEFAULT_COL);
        vo.setPage(CommonConstant.DEFAULT_PAGE);
        vo.setOrder(CommonConstant.DEFAULT_ORDER);
        vo.setAttr("0");
        vo.setPriceId("0");
        se.setAttribute(CommonConstant.PRODUCTVO, vo);
        // System.out.println("SIZE OF FOOD" + foods.size());
        // list food
        se.setAttribute(CommonConstant.FOOD_CATEGORY_F, foods);
        // return display category
        return mapping.findForward(SUCCESS);

    }

}
