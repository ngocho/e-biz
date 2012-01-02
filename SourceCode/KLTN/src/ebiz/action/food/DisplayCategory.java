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
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.common.Initialize;
import ebiz.blo.food.FoodBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.form.FoodForm;
import ebiz.form.Paging;
import ebiz.form.ProductVO;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class DisplayCategory extends BaseAction {
    
 
    /* get tên : save all in session
     * attribute của product 
     * type of giá
     * list product (form)
     * phân trang ( lưu trang đầu tiên vào session)
     * 
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
          HttpSession se = request.getSession();
          List<String> attrs = new ArrayList<String>();
          List<FoodPriceLevel> prices = new ArrayList<FoodPriceLevel>();
          List<Paging> pageList = new ArrayList<Paging>();
          List<FoodForm> foods = new ArrayList<FoodForm>();
          ProductVO vo = new ProductVO();
        String typeProduct = request.getParameter("typeProduct");
        if(typeProduct ==null){
            vo = (ProductVO)se.getAttribute(CommonConstant.PRODUCTVO);
            typeProduct = vo.getTypeProduct();
        }
        vo.setTypeProduct(typeProduct);
      
        IFoodDAO dao = new FoodDAO();
       Initialize.initializeFood();
        Initialize.initializeFoodAttribute();
        Initialize.initializeFoodStatus();
        Initialize.initializeFoodPriceLevel();
       // get attribute --> save in session
        attrs = dao.getAttributeList("productAttributeName");
        se.setAttribute(CommonConstant.FOOD_CATEGORY_A, attrs);
        
       //get type of price --> save in session
        prices = dao.getPriceList();
        se.setAttribute(CommonConstant.FOOD_CATEGORY_P, prices);
        
        //getproduct --> save in session
        HashMap<Integer, String> paging = new HashMap<Integer, String>();
        
        foods = FoodBLO.initFoodCategory(paging,CommonConstant.DEFAULT_RECORD,typeProduct);
        pageList = FoodBLO.updateStatusPaging(paging);
        //paging
        vo.setPagingList(pageList);
//        se.setAttribute(CommonConstant.PAGING, pageList);
        //number display in 1 page
        vo.setLimit(CommonConstant.DEFAULT_RECORD);
        vo.setCol(CommonConstant.DEFAULT_COL);
        vo.setPage(CommonConstant.DEFAULT_PAGE);

        se.setAttribute(CommonConstant.PRODUCTVO, vo);
        
        
      //list food
        se.setAttribute(CommonConstant.FOOD_CATEGORY_F, foods);
        
      //return display category
        return mapping.findForward(SUCCESS);

    }

}
