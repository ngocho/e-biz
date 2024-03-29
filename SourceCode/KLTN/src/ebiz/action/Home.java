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
package ebiz.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.blo.food.FoodBLO;
import ebiz.blo.provider.ProviderBLO;
import ebiz.form.FoodForm;
import ebiz.form.ProviderForm;
import ebiz.util.CommonConstant;
/**
 * @author ThuyNT
 */
public class Home extends BaseAction {
    /**
     * [Home action].
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
        String lang = (String) se.getAttribute("language");
        if (lang == null) {
            Locale locale = new Locale("vi");
            se.setAttribute("language", "vi");
            se.setAttribute("org.apache.struts.action.LOCALE", locale);
        }
        List<FoodForm> formList = new ArrayList<FoodForm>();
        formList = FoodBLO.getFoodListPromotionBest(CommonConstant.HOME_RECORD);
        List<ProviderForm> providerSearchParam = ProviderBLO.getProviderFormAll();
        se.setAttribute("providerSearchParam", providerSearchParam);
        if (!formList.isEmpty()) {
            se.setAttribute("promotionFood", formList);
            se.removeAttribute("ProviderFood");
        }
        return mapping.findForward(SUCCESS);
    }

}
