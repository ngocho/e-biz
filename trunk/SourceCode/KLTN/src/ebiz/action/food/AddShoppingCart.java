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

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;
import ebiz.util.CommonUtil;

/**
 * @author ThuyNT
 *
 */
public class AddShoppingCart extends BaseAction {
    
    /*
     * using ajax to call this action
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        response.setContentType("text/xml; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        boolean flag;
       HttpSession se = request.getSession();
       ShoppingCart shopCart =(ShoppingCart) se.getAttribute("shop");
       String id = request.getParameter("id");
       Long key = new Long(0);
       String number = request.getParameter("number");
       Integer count = Integer.parseInt(number);
       System.out.println("ID"+id);
       System.out.println("Number"+number);
       if(!CommonUtil.isBlankOrNull(id)){
           key = Long.parseLong(id);
       }
       if(shopCart == null){
            shopCart = new ShoppingCart();
        }
       Integer numberInShop = shopCart.getNumberFood(key);
      
       try{
        if(number!=null){
            //if required product > product in shop
            if(count >numberInShop){ 
           //test in database, then add shopping
            flag = FoodBLO.addShoppingCart( shopCart,id, count );
            if(!flag){
                
                out.println("0");
                return null;
            }
            shopCart.size();
        }
       
        //if required product < product in shop
        else{
            shopCart.updateNumberFood(key, numberInShop + count);
            shopCart.size();
        }
            
            //set info of product into session
            se.setAttribute(CommonConstant.SHOPPING, shopCart);
            System.out.println(se.getAttribute(CommonConstant.FOOD_DETAIL_PRODUCT));
            System.out.println("detail" + shopCart.getCount());
            out.println(shopCart.getCount());
            return null;
        }
       }
        catch(Exception e)
        {
            
        }
        finally{
            out.flush();
            out.close();
        }
        
        return null;
    }

}
