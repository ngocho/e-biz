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
package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobile.ebiz.blo.MobileBLO;
import mobile.ebiz.blo.PromotionBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class Promotion extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;

        JSONObject json = new JSONObject();
        JSONObject jsonPhone = new JSONObject();
        JSONObject jsonFood = new JSONObject();

        // call function get thong tin khuyen mai

        try {
            
            jsonPhone = MobileBLO.createCustomerPhone();
            json.put(CommonConstant.PHONECUSTOMER, jsonPhone);
            jsonFood = PromotionBLO.createFoodPromotion();
            json.put(CommonConstant.NAMEFOOD_PRO, jsonFood);
            out = response.getWriter();
            out.println(json);
            out.flush();
        } catch (JSONException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        

        return mapping.findForward(null);

    }
}
