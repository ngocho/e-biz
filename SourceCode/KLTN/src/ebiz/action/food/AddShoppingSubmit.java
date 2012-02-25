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

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class AddShoppingSubmit extends BaseAction {

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

        boolean flag;
        int count = 1;
        String number = request.getParameter("number");
        String type = request.getParameter("type");
        HttpSession se = request.getSession();
        ShoppingCart shopCart = (ShoppingCart) se.getAttribute("shop");
        String id = request.getParameter("id");
        if (number != null) {
            count = Integer.parseInt(number);
        }
        if (shopCart == null) {
            shopCart = new ShoppingCart();
        }
        if (id != null) {
            // if required product > product in shop
            // if (count > numberInShop) {
            // // test in database, then add shopping
            flag = FoodBLO.addShoppingCart(shopCart, id, count);
            if (flag) {
                shopCart.size();
            }
            // }

            // if required product < product in shop
            // else {
            // shopCart.updateNumberFood(key, numberInShop);
            // shopCart.size();
            // }
            // set info of product into session
            se.setAttribute(CommonConstant.SHOPPING, shopCart);
        }
        if (type.equals("1")) {
            return mapping.findForward(SUCCESS);
        }
        return mapping.findForward(SUCCESS);
    }
}
