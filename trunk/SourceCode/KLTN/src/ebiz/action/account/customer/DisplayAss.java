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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Assessment;

/**
 * @author ThuyNT
 */
public class DisplayAss extends BaseAction {

    /**
     * [DisplayAss].
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
        String idValue = request.getParameter("vote");
        // CustomerBLO.createAss();
        if (idValue != null) {
            // get Ass
            Assessment as = CustomerBLO.getAss(idValue);
            if (as != null) {
                as.setNumber(as.getNumber() + 1);
                boolean flag = CustomerBLO.saveAss(as);
                if (flag) {
                    // get list
                    List<Assessment> assList = CustomerBLO.getAssList();
                    // HttpSession se = request.getSession();
                    request.setAttribute("assList", assList);
                    return mapping.findForward(SUCCESS);
                }
            }

        }
        return mapping.findForward(FAILURE);

    }

}
