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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.dao.gae.PMF;
import ebiz.dto.account.customer.Customer;
import ebiz.util.CommonUtil;

/**
 * @author nthanhphong
 */
public class HappyBirthday extends BaseAction {

    /**
     * [Explain the description for this method here].
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        List<JSONObject> objList = new ArrayList<JSONObject>();
        try {

            objList = createListHappyBirth();
            out = response.getWriter();
            out.println(objList);
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
    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException JSONException
     */
    @SuppressWarnings("unchecked")
    public List<JSONObject> createListHappyBirth() throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<Customer> listcustomer = new ArrayList<Customer>();
        listcustomer = (List<Customer>) PMF.getObjectList(Customer.class);
        for (int i = 0; i < listcustomer.size(); i++) {
            String today = CommonUtil.convertDateToString(Calendar.getInstance().getTime()).substring(0, 5);
            Customer item = listcustomer.get(i);
            try {
                if (item.getCustomerPhone() != null && item.getCustomerBirth() != null
                        && CommonUtil.convertDateToString(item.getCustomerBirth()).substring(0, 5).equals(today)) {
                    JSONObject json = new JSONObject();
                    json.put("phone", listcustomer.get(i).getCustomerPhone());
                    json.put("name", listcustomer.get(i).getCustomerName());
                    objList.add(json);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return objList;
    }
}
