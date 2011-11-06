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

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.google.appengine.api.taskqueue.Queue;

import ebiz.action.BaseAction;
import ebiz.dao.gae.CustomerDAO;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Customer;
import ebiz.form.Login;
import ebiz.util.CommonConstant;


/**
 * @author ThuyNT
 *
 */
public class Register extends BaseAction{
   
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        
        //after checked validation using xml file
        Customer register =(Customer)form;
        boolean f;
        //su dung interface de goi  ???? || goi truc tiep DAO hay thong qua BLO
        CustomerDAO custDao = new CustomerDAO();
        f = custDao.insertCustomer(register);
        if(f){
            HttpSession se=request.getSession();
            se.setMaxInactiveInterval(300);
            Login user = new Login();
            user = register.editForm();
            
            //luu cac gia tri vao session
            se.setAttribute(CommonConstant.USER, user);
            
            
            //thuc hien goi mail thong bao thanh cong --> use task queue
            
            return mapping.findForward(SUCCESS);
        }
        return mapping.findForward(FAILURE);
    }


}
