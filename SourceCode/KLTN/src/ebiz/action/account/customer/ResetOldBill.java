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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.checkout.DetailOrder;

/**
 * @author Administrator
 */
public class ResetOldBill extends BaseAction {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession se = request.getSession();
        String id = request.getParameter("id");
        System.out.println("ID" + id);
        if (id == null) {
            return mapping.findForward(FAILURE);

        }
        Long orderID = Long.parseLong(id);
        System.out.println("CREATE BILL");
        List<DetailOrder> detailList1 = new ArrayList<DetailOrder>();
        List<DetailOrder> detailList2 = new ArrayList<DetailOrder>();
        boolean flag;
        // get detailOrder of old Order(update DetailOrder)
        detailList2 = FoodBLO.getDetailOrderRe(orderID);
        // get detailOrder of old Order
        detailList1 = FoodBLO.getDetailOrder(orderID);
        // compare (for test number in db is enough)
        flag = FoodBLO.isEqual(detailList1, detailList2);
        se.setAttribute("idBill", id);
        if (flag) {
            se.setAttribute("detailBill", detailList1);
        } else {
            // let user compare to decide
            se.setAttribute("detailFlag", flag);
            se.setAttribute("detailBill", detailList1);
            se.setAttribute("detailBill2", detailList2);
        }
        return mapping.findForward(SUCCESS);
    }

}
