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

import ebiz.blo.customer.CustomerBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 *
 */
    public class AuthenticationUser extends BaseAction {
       
        public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                HttpServletResponse response) throws Exception {
            String type = request.getParameter("type");
            if(type == "0"){ //checkout
                HttpSession se = request.getSession();
                ShoppingCart shop  = (ShoppingCart)se.getAttribute(CommonConstant.SHOPPING);
                LoginForm user = shop.getUser();
                if(shop.size() == 0){
                    return mapping.findForward(FAILURE); 
                }
                if(!user.isEmpty()){
                    //put attributes into LoginForm
                    Customer customer = CustomerBLO.getCustomerByID(user.getLoginId());
                    user.editForm(customer);
                    return mapping.findForward(SUCCESS); // transfer action : create Bill
                }
                else{
                    // user didn't log-in
                    return mapping.findForward(INPUT);
                }
            }
            return mapping.findForward(SUCCESS);
        }
        

}
