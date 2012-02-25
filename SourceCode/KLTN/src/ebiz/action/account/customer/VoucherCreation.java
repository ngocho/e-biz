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
package ebiz.action.account.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.common.SendMail;
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.checkout.VoucherBill;
import ebiz.form.OrderBillForm;
import ebiz.util.CommonConstant;
import ebiz.form.LoginForm;
import mobile.ebiz.dto.hashCode;
import java.util.Date;
/**
 * @author ThuyNT
 */
public class VoucherCreation extends BaseAction {

    /**
     * [Voucher(Customer)].
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
        HttpSession se = request.getSession();
        LoginForm login;
        OrderBillForm voucherForm = (OrderBillForm) form;
        VoucherBill voucherBill = voucherForm.getVoucher();
        // generate code voucher
        String code = hashCode.hashID(CommonConstant.HASHCODENUMBER);
        voucherBill.setKeyVoucher(code);
        voucherBill.setStartDate(new Date());
        // save voucherForm in database
        voucherBill = CustomerBLO.saveVoucher(voucherBill);
        if (voucherBill != null) {
            // checkout
            boolean flag = CustomerBLO.checkoutXuOnline(voucherForm.getIdCustomer(), voucherBill.getSumMoney());
            if (flag) {
                // send mail
                SendMail.sendVoucherlMail(voucherBill.getId());
                // decrease product = number of voucher
                FoodBLO.downNumberOfFood(voucherBill.getIdFood(), voucherBill.getNumber());
                // send mail
                login = (LoginForm) se.getAttribute(CommonConstant.USER);
                // update xu in LoginForm
                login.setXuOnline(CustomerBLO.getXuOnline(login.getLoginId()));
            }

        }
        return mapping.findForward(SUCCESS);

    }

}
