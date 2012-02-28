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
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
/**
 * @author ThuyNT
 */
public class ProductCompare extends BaseAction {

    /**
     * [Logout(Customer)].
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
        String id = request.getParameter("id");
        String screen = request.getParameter("screen");
        if (id != null) {
            Food food = FoodBLO.getFoodById(Long.parseLong(id));
            List<FoodForm> formList = FoodBLO.getFoodListByNameDistinctProvider(food.getFoodName(),
                    food.getProviderID());
            if (!formList.isEmpty()) {
                FoodForm formFood = new FoodForm();
                se.setAttribute("valueCompare", formList);
                se.setAttribute("orginalCompare", formFood.editForm(food));

                return mapping.findForward(SUCCESS);
            }
        }
        se.setAttribute("flagCompare", screen);
        ActionForward forward = mapping.getInputForward();
        forward.setPath(screen);
        return forward;
    }
}
