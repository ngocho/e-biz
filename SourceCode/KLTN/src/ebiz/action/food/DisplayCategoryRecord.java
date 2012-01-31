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
import ebiz.blo.food.FoodBLO;
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
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String attr = request.getParameter("attr");
        String price = request.getParameter("price");
        System.out.println("ATTR"+attr);
        System.out.println("PRICE"+price);
        String order = request.getParameter("order");
        System.out.println("ORDER"+order);
        HttpSession se = request.getSession();
        List<FoodForm> foods = new ArrayList<FoodForm>();
        List<Paging> pageList = new ArrayList<Paging>();
        HashMap<Integer, String> paging = new HashMap<Integer, String>();
        ProductVO vo =  (ProductVO)se.getAttribute(CommonConstant.PRODUCTVO);
        int record = CommonConstant.DEFAULT_RECORD;
        String limit;
        String col;
        if(order == null){
        order = vo.getOrder();
        System.out.println("ORDER"+order);
        }
        int  page = 1;
       
        //get info from request
        limit = (String)request.getParameter("limit"); 
        col   = (String)request.getParameter("col"); 
        String p = (String)request.getParameter("page"); 
        if(limit == null){
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
        String filterCol = CommonConstant.FOOD_TYPE;
        foods = FoodBLO.getFoodListCategory(col,paging,order,record,page,filterCol,vo.getTypeProduct(),attr,price);
        pageList = FoodBLO.updateStatusPaging(paging);
        //save in Session
        se.setAttribute(CommonConstant.FOOD_CATEGORY_F, foods);
        vo.setLimit(record);
        vo.setCol(col);
        vo.setPage(page);
        vo.setPagingList(pageList);
        vo.setOrder(order);

        return mapping.findForward(SUCCESS);

    }

}
