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

import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.form.ShoppingCart;

/**
 * @author ThuyNT
 */

public class UpdateShoppingCart extends BaseAction {
    /*
     * update product in shopping
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                HttpServletResponse response) throws Exception {
            
        System.out.println("action");
            response.setCharacterEncoding("utf-8");
            PrintWriter out=response.getWriter();
           String idProduct = request.getParameter("id");
           String numberUpdate = request.getParameter("numberUpdate");
           Integer number = 0;
           JSONObject json = new JSONObject();
           if(numberUpdate!=null){
            number = Integer.parseInt(numberUpdate);
           }
           
           HttpSession se = request.getSession();
           ShoppingCart shopCart =(ShoppingCart) se.getAttribute("shop");
           number = FoodBLO.isProNumberShop(shopCart, idProduct, number);
           try{
           if(number == 0){  //success
               System.out.println("success");
               Long result = FoodBLO.updateSubPriceShop(shopCart, idProduct, number);
               json.put("id","0");
               json.put("value",String.valueOf(result));
               System.out.println("success" + json);
               out.println(json);
           }
           else{
               
               json.put("id", "1");
               json.put("value",String.valueOf(number));
               System.out.println(json.toString());
               out.println(json);
           }
           } 
           finally{
               out.flush();
               out.close();
           }
           
           return null;
       }
           


}
