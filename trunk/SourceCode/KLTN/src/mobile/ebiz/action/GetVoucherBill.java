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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.dao.gae.PMF;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.account.provider.Provider;
import ebiz.dto.checkout.VoucherBill;
import ebiz.util.CommonUtil;

/**
 * @author nthanhphong
 *
 */
public class GetVoucherBill {
    /**
     * [Give the description for method].
     * @return
     * @throws JSONException
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