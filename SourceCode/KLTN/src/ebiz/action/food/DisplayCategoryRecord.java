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
public class DisplayCategoryRecord extends BaseAction {
    
 
    /* get tên : save all in session
     * attribute của product 
     * type of giá
     * list product (form)
     * phân trang ( lưu trang đầu tiên vào session)
     * 
     */
    @SuppressWarnings("unchecked")
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        HttpSession se = request.getSession();
        List<FoodForm> foods = new ArrayList<FoodForm>();
        List<Paging> pageList = new ArrayList<Paging>();
        HashMap<Integer, String> paging = new HashMap<Integer, String>();
        ProductVO vo = new ProductVO();
        int record = CommonConstant.DEFAULT_RECORD;
        String limit;
        String col;
        String order = "asc";
        int  page = 1;
       
        vo = (ProductVO)se.getAttribute(CommonConstant.PRODUCTVO);
        //get info from request
        limit = (String)request.getParameter("limit"); 
        col   = (String)request.getParameter("col"); 
        String p = (String)request.getParameter("page"); 
        if(limit ==null){
            record = vo.getLimit();
        }
        else{
            record = Integer.parseInt(limit);
        }
        
         if(col ==null){
             col = vo.getCol();
         }
         if(p!=null){
             page = Integer.parseInt(p);
         }
         if(page >1){ //get old 
             pageList = (List<Paging>) vo.getPagingList();
             paging = FoodBLO.toHashMap(pageList);
         }
        foods = FoodBLO.getFoodFormList(col,paging,order,record,page,vo.getTypeProduct());
        pageList = FoodBLO.updateStatusPaging(paging);
//        se.setAttribute(CommonConstant.PAGING, paging);
        se.setAttribute(CommonConstant.FOOD_CATEGORY_F, foods);
        
        //save in session
        vo.setLimit(record);
        vo.setCol(col);
        vo.setPage(page);
        vo.setPagingList(pageList);
        
//        se.setAttribute("limit", record);
//        se.setAttribute("col", col);
//        se.setAttribute("page", page);
//        se.setAttribute(CommonConstant.PAGING, pageList);
        //return display category
        
        return mapping.findForward(SUCCESS);

    }

}
