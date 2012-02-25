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

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;
import ebiz.util.CommonUtil;

/**
 * @author Administrator
 */
public class XuTransfer extends BaseAction {
    /**
     * [XuTransfer].
     * 
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        // set attr for reponse
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/xml; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String moneyStr = request.getParameter("money");
        if (!CommonUtil.isBlankOrNull(name)) {
            if (moneyStr != null && !(moneyStr.equals("0"))) {
                HttpSession se = request.getSession();
                LoginForm user = (LoginForm) se.getAttribute(CommonConstant.USER);
                if (user != null) {
                    String uid = user.getLoginId();
                    long money = Long.parseLong(moneyStr);
                    // test xu account is enough to transter
                    boolean flag = CustomerBLO.isXuOnline(uid, money);
                    if (flag) {
                        // test isExsist
                        flag = CustomerBLO.isUID(name);
                        if (flag) {
                            // transfer
                            flag = CustomerBLO.transferXuOnline(uid, name, money);
                            // success
                            if (flag) {
                                // get money
                                long result = CustomerBLO.getXuOnline(uid);
                                user.setXuOnline(result);
                                // success
                                out.println("1" + " " + String.valueOf(result));
                            } else {
                                out.println("0" + " ");
                            }
                        } else {
                            // uid don't exist
                            out.println("2" + " ");
                        }

                    } else {
                        // not enough money
                        out.println("3" + " ");
                    }
                } else {
                    // required login
                    out.println("4" + " ");
                }
            }
        }
        // required madatory
        out.println("5" + " ");
        return null;
    }

}
