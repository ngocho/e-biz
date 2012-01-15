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
import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class AuthenticationUser extends BaseAction {

    /**
     * [AuthenticationUser].
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
        HttpSession se = request.getSession();
        ShoppingCart shop = (ShoppingCart) se.getAttribute(CommonConstant.SHOPPING);
        LoginForm user = (LoginForm) se.getAttribute("user");
        if (shop == null) {
            return mapping.findForward(FAILURE);
        }
        if (shop.size() == 0) {
            return mapping.findForward(FAILURE);
        }
        if (user != null) {
            // put attributes into OrderBillForm
            Customer customer = CustomerBLO.getCustomerByID(user.getLoginId());
            OrderBillForm orderForm = shop.getOrder();
            if (orderForm == null) {
                orderForm = new OrderBillForm();
            }
            // get attr from Customer
            orderForm.editCustomer(customer);
            // set Shopping Cart
            shop.setOrder(orderForm);
            // set into Session to display = name of bean in strust.config
            se.setAttribute("order", orderForm);
            // transfer action : creatRe Bill
            return mapping.findForward(SUCCESS);
        } else {
            // user didn't log-in
            System.out.println("REQUIRE LOGIN");
            // request.setAttribute("type", 1);
            return mapping.findForward(INPUT);
        }
    }

}
