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

import mobile.ebiz.blo.MobileBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.dao.gae.PMF;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.account.provider.Provider;
import ebiz.dto.checkout.VoucherBill;
import ebiz.util.CommonUtil;

/**
 * @author nthanhphong
 */
public class GetVoucherBill {
    /**
     * [Give the description for method].
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        List<JSONObject> objList = new ArrayList<JSONObject>();

        try {

            objList = createListVoucher();
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
        return null;
    }
    /**
     * [Give the description for method].
     * @return List<JSONObject>
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    public List<JSONObject> createListVoucher() throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();
        List<VoucherBill> listvoucherbill = new ArrayList<VoucherBill>();
        listvoucherbill = (List<VoucherBill>) PMF.getObjectList(VoucherBill.class);
        for (int i = 0; i < listvoucherbill.size(); i++) {
            String today = CommonUtil.convertDateToString(Calendar.getInstance().getTime());
            VoucherBill item = listvoucherbill.get(i);
            try {
                if (item.getPhone() != null && item.getStartDate() != null
                        && CommonUtil.convertDateToString(item.getStartDate()).equals(today)) {
                    JSONObject json = new JSONObject();
                    json.put("id", item.getId());
                    json.put("idfood", item.getIdFood());
                    json.put("money", item.getSumMoney());
                    json.put("idcustomer", item.getIdCustomer());
                    json.put("key", item.getKeyVoucher());
                    json.put("phone", item.getPhone());
                    json.put("date", CommonUtil.convertDateToString(item.getStartDate()));
                    objList.add(json);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return objList;
    }
}
