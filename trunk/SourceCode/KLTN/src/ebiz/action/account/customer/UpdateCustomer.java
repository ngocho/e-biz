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

import ebiz.blo.customer.CustomerBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 *
 */
public class UpdateCustomer extends BaseAction{

    /**
     * [Give the description for method].
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession se = request.getSession(); 
        boolean flag;
        ShoppingCart shop = (ShoppingCart)se.getAttribute(CommonConstant.SHOPPING);
//        LoginForm  user  = shop.getUser();
//        user =(LoginForm) form;
        LoginForm user = (LoginForm) form;
        System.out.println("NAME" + user.getLoginName());
        System.out.println("ID" + user.getLoginId());
        Customer customer = user.getCustomer();
        flag = CustomerBLO.updatecustomer(customer);
        if(flag){
//            shop.setUser(user);
            System.out.println("ID"+ user.getLoginId());
            return mapping.findForward(SUCCESS);
        }
       return mapping.findForward(FAILURE);
    }

}
