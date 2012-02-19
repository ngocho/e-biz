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
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.checkout.OrderBill;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author Administrator
 */
public class CreateOrderBill extends BaseAction {
    /**
     * [AuthenticationUser].
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
        OrderBill order = new OrderBill();
        HttpSession se = request.getSession();
        ShoppingCart shopCart = (ShoppingCart) se.getAttribute(CommonConstant.SHOPPING);
        OrderBillForm orderForm = (OrderBillForm) form;
        // checkout is Pay money
        boolean flag = true;
        String typePayment = "0";
        LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
        if (orderForm.getIsPayment() == 0) {
            // user Xu account
            String uid = user.getLoginId();
            flag = CustomerBLO.checkoutXuOnline(uid, shopCart.getTotal());
            // not enough money
            if (!flag) {
                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("xu.notEnough"));
                saveMessages(request, messages);
                return mapping.findForward(FAILURE);
            }
            // paid money
            typePayment = CommonConstant.BILLSTATUS_2;
        } else if (orderForm.getIsPayment() == 1) {
            // will pay in home
            typePayment = CommonConstant.BILLSTATUS_1;

        } else {
            typePayment = CommonConstant.BILLSTATUS_2;
        }
        if (flag) {
            // save in session
            user.setXuOnline(CustomerBLO.getXuOnline(user.getLoginId()));
            // billing
            order = FoodBLO.billing(shopCart, typePayment);
            // update Customer
            // transfer OrderBill-> form to display
            // success
            if (order != null) {

                // send mail

                orderForm.editForm(order);
                System.out.println("DATE BILL" + orderForm.getDateShip());
                // update atrributes
                orderForm.setNumberProduct(shopCart.size());
                // set orderForm into session
                se.setAttribute("bill", orderForm);
                se.removeAttribute("shop");
                // call method to pay xu

                return mapping.findForward(SUCCESS);
            }
        }
        return mapping.findForward(FAILURE);
    }
}
