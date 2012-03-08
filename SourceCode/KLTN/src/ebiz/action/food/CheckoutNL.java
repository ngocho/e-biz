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
import ebiz.dto.checkout.OrderBill;
import ebiz.util.BillType;

/**
 * @author Administrator
 */
public class CheckoutNL extends BaseAction {
    /**  Logger. */
    private static final Logger LOG = Logger.getLogger(CheckoutType.class.getName());
    /**
     * [CheckoutNL].
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
        ActionMessages messages = new ActionMessages();
        String typeCheckout = request.getParameter("checkout");
        if ("nganluong".equals(typeCheckout)) {
            NL_Checkout nlCheckout = new NL_Checkout();
            String transactionInfo = request.getParameter("transaction_info");
            String orderCode = request.getParameter("order_code");
            String price = request.getParameter("price");
            String paymentId = request.getParameter("payment_id");
            String paymentType = request.getParameter("payment_type");
            String errorText = request.getParameter("error_text");
            String secureCode = request.getParameter("secure_code");
            boolean flag = nlCheckout.verifyPaymentUrl(transactionInfo, orderCode, price, paymentId, paymentType,
                    errorText, secureCode);
            if (flag) {
                LOG.info("Gia tien thanh toan tu Ngan luong" + price);
                OrderBill bill = CustomerBLO.getBillById(Long.parseLong(orderCode));
                if (price.equals(String.valueOf(bill.getSumPrice()))) {
                    FoodBLO.updateStatusOrderBill(bill.getId(), BillType.PAID_THROUGH_NGANLUONG);
                    SendMail.sendOrderBillMail(bill.getId());
                    return mapping.findForward(SUCCESS);

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("nganluong.false"));

                }
            }
        }
        saveMessages(request, messages);
        return mapping.findForward(FAILURE);
    }
}
