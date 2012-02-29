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
import ebiz.dto.checkout.NL_Checkout;
import ebiz.dto.checkout.OrderBill;
import ebiz.form.OrderBillForm;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author Administrator
 */
public class CreateOrderBill extends BaseAction {
    /**
     * [CreateOrderBill].
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
        // billing
        order = FoodBLO.billing(shopCart);
        if (order != null) {
            orderForm.editForm(order);
            // // update atrributes
            orderForm.setNumberProduct(shopCart.size());
            // // set orderForm into session
            se.setAttribute("bill", orderForm);
            /**
             * Create nganluong payment url)
             */
            NL_Checkout nl_checkout = new NL_Checkout();
            String return_url = CommonConstant.URL + "/checkoutnl.vn?checkout=nganluong";// Địa chỉ trả về
            String transaction_info = "Demo";// Thông tin giao dịch
            String order_code = String.valueOf(orderForm.getId());
            String receiver = "hailam349@gmail.com";// Tài khoản nhận tiền
            String price = String.valueOf(orderForm.getSumPrice());
            String url = nl_checkout.buildCheckoutUrl(return_url, receiver, order_code, price, transaction_info);
            se.setAttribute("nganluongurl", url);
            return mapping.findForward(SUCCESS);
        }
        return mapping.findForward(FAILURE);
    }
}
