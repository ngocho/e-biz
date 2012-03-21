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
 */
public class AddShoppingCart extends BaseAction {

    /**
     * [AddShoppingCart(ajax)].
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

        PrintWriter out = response.getWriter();
        boolean flag;
        int count;
        // set attr for reponse
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType(CommonConstant.CONTENTTYPE);
        response.setCharacterEncoding(CommonConstant.CHARACTERENCODING);
        // get param from request
        String id = request.getParameter("id");
        String number = request.getParameter("number");
        // check numeric
        if (!CommonUtil.checkNumeric(number)) {
            out.println("0" + "0");
            return null;
        }
        // get attr from session
        HttpSession se = request.getSession();
        ShoppingCart shopCart = (ShoppingCart) se.getAttribute("shop");
        if (shopCart == null) {
            shopCart = new ShoppingCart();
        }

        try {
            if (number != null) {
                count = Integer.parseInt(number);
                // add shopping
                flag = FoodBLO.addShoppingCart(shopCart, id, count);
                if (!flag) { // failed
                    out.println("0" + " ");
                    return null;
                }
                // success
                // count size of Shopping Cart
                shopCart.size();
                // count money
                shopCart.sumMoney();
                // set info of product into session
                se.setAttribute(CommonConstant.SHOPPING, shopCart);
                int num = shopCart.remainNumber(Long.parseLong(id));
                se.setAttribute("numberDisplay", num);
                // retured data
                out.println(shopCart.getCount() + " " + num);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            out.flush();
            out.close();
        }

        return null;
    }

}
