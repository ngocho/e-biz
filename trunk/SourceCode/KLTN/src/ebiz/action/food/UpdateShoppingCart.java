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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.form.FoodForm;
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
            
        String id = request.getParameter("id");
        String num = request.getParameter("number");
        ActionMessages messages = new ActionMessages();
        boolean flag = false;
        long key = Long.parseLong(id);
        int number = Integer.parseInt(num);
        HttpSession se = request.getSession();
        ShoppingCart shop =(ShoppingCart)se.getAttribute("shop");
        FoodForm food = shop.getFood(key);
        //delete
        if(number == 0){
            shop.removeFood(food);
        }
        if(number > 0){
        if(food.getNumber() == number){
            return mapping.findForward(SUCCESS);
        }
        //required food < number of food in Shop
        if(food.getNumber() > number){
            //updated
            food.setNumber(number);
            food.setSubTotal(number *food.getPrice());
        }
        else { 
          flag =  FoodBLO.addShoppingCart(shop, id ,number - food.getNumber());
        }
        //if have error
          if(!flag){
             
              messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("shopping.update"));
              return mapping.findForward(FAILURE);
          }
          shop.sumMoney();
          return mapping.findForward(SUCCESS);
        }
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("shopping.invalidNumber"));
        return mapping.findForward(FAILURE);

    }
}
