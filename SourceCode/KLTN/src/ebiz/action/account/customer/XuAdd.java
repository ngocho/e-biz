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

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mobile.ebiz.blo.IDXUBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;
/**
 * @author Administrator
 */
public class XuAdd extends BaseAction {
    /**
     * [Add Xu].
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
        PrintWriter out = response.getWriter();
        // set attr for reponse
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/xml; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String value = request.getParameter("value");
        if (value != null || !("".equals(value))) {
            value = value.trim();
            long money = IDXUBLO.getMoneyByID(value);
            // long money = Long.parseLong(value);
            HttpSession se = request.getSession();
            LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
            if (user != null) {
                String uid = user.getLoginId();
                long result = CustomerBLO.addXuOnline(uid, money);
                if (result > 0) {
                    user.setXuOnline(result);
                    out.println("1" + " " + String.valueOf(result));
                } else {
                    // fail
                    out.println("0" + " " + String.valueOf(result));
                }
            } else { // required login
                out.println("2" + " " + "2");
            }
        } else {
            // required mandatory
            out.println("3" + " " + "3");
        }
        return null;
    }

}
