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

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ebiz.action.BaseAction;
import ebiz.blo.common.SendMail;
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.checkout.NL_Checkout;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonConstant;

/**
 * @author Administrator
 */
public class CheckoutType extends BaseAction {
    private static final Logger log = Logger.getLogger(CheckoutType.class.getName());
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ActionMessages messages = new ActionMessages();
        boolean result = true;
        HttpSession se = request.getSession();
        OrderBillForm orderForm = (OrderBillForm) se.getAttribute("bill");
        String typeCheckout = request.getParameter("checkoutOption");
        LoginForm login = (LoginForm)se.getAttribute(CommonConstant.USER);
        if ("home".equals(typeCheckout)) {
           FoodBLO.updateStatusOrderBill(orderForm.getId(), CommonConstant.BILLSTATUS_1);
        } else if ("xu".equals(typeCheckout)) {
            LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
            String uid = user.getLoginId();
            boolean flag = CustomerBLO.checkoutXuOnline(uid, orderForm.getSumPrice());
            if (!flag) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("xu.notEnough"));
                result = false;

            }
            else{
                login.setXuOnline(CustomerBLO.getXuOnline(login.getLoginId()));
            // paid money
            FoodBLO.updateStatusOrderBill(orderForm.getId(), CommonConstant.BILLSTATUS_2);
            }
        } else if ("nganluong".equals(typeCheckout)) {
            NL_Checkout nl_checkout = new NL_Checkout();
            String transaction_info = request.getParameter("transaction_info");
            String order_code = request.getParameter("order_code");
            String price = request.getParameter("price");
            String payment_id = request.getParameter("payment_id");
            String payment_type = request.getParameter("payment_type");
            String error_text = request.getParameter("error_text");
            String secure_code = request.getParameter("secure_code");
            boolean flag = nl_checkout.verifyPaymentUrl(transaction_info, order_code, price, payment_id, payment_type,
                    error_text, secure_code);
            if (flag) {
                log.info("Gia tien thanh toan tu Ngan luong" + price);
                if (price.equals(String.valueOf(orderForm.getSumPrice()))) {
                    FoodBLO.updateStatusOrderBill(orderForm.getId(), CommonConstant.BILLSTATUS_3);
                } else {
                    result = false;
                }
            } else {
                result = false;
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("nganluong.false"));

            }
        }
        if (result) {
            SendMail.sendOrderBillMail(orderForm.getId());
            se.removeAttribute("shop");
            return mapping.findForward(SUCCESS);
        }
        saveMessages(request, messages);
        return mapping.findForward(FAILURE);
    }
}
