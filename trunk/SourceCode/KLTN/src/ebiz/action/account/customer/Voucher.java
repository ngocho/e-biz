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
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.form.LoginForm;
import ebiz.form.OrderBillForm;

/**
 * @author ThuyNT
 */
public class Voucher extends BaseAction {

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
        String value = request.getParameter("numVoucher");
        HttpSession se = request.getSession();
        LoginForm login = (LoginForm) se.getAttribute("user");
        if (value != null && !(value.equals(""))) {
            // test 'value'
            String id = (String) se.getAttribute("idFood");
            Long key;
            if (id != null) {
                int number = Integer.parseInt(value);
                key = Long.parseLong(id);
                // test number in database
                boolean flag = FoodBLO.getVoucherFood(key, number);
                if (flag) {
                    OrderBillForm voucherForm = new OrderBillForm();
                    // get info of Customer
                    // put value into Voucher Form

                    // set number of voucher
                    voucherForm.setNumberVoucher(number);
                    voucherForm.setIdFood(key);
                    voucherForm.sumVoucherMoney();
                    // save in session
                    se.setAttribute("voucherForm", voucherForm);
                    if (login != null) {
                        // get info of Customer
                        CustomerBLO.getLoginVoucher(login);
                        voucherForm.editFormLogin(login);
                        return mapping.findForward(SUCCESS);
                    } else {
                        se.setAttribute("screen", "voucher_optional");
                        // required Login
                        return mapping.findForward(LOGIN);
                    }
                }
            }
        }
        return mapping.findForward(FAILURE);
    }

}
