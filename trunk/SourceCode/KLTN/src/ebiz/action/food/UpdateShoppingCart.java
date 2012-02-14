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
import ebiz.form.FoodForm;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */

public class UpdateShoppingCart extends BaseAction {
    /*
     * update product in shopping
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/xml; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String num = request.getParameter("number");
        boolean flag = true;
        long key = Long.parseLong(id);
        int number = Integer.parseInt(num);
        HttpSession se = request.getSession();
        ShoppingCart shop = (ShoppingCart) se.getAttribute("shop");
        FoodForm food = shop.getFood(key);
        // delete
        if (number == 0) {
            shop.removeFood(food);
        }
        if (number > 0) {
            if (food.getNumber() == number) {
                out.println("0");
                return null;
            }
            // required food < number of food in Shop
            if (food.getNumber() > number) {
                // updated
                food.setNumber(number);
                food.setSubTotal(number * food.getPrice());
            } else {
                flag = FoodBLO.addShoppingCart(shop, id, number - food.getNumber());
            }
        }
        try {
            // if have error
            if (!flag) {
                System.out.println("error");
                out.println("0" + " " + food.getNumber());
                return null;
            }

            shop.sumMoney();
            shop.size();
            // set info of product into session
            se.setAttribute(CommonConstant.SHOPPING, shop);
            // retured data
            out.println("1" + " " + number + " " + shop.subMoney(id) + " " + shop.getTotal());
            System.out.println("getCount" + shop.getCount());
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            out.flush();
            out.close();
        }

        return null;
    }

}
