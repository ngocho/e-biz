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

import mobile.ebiz.blo.IDXUBLO;
import mobile.ebiz.blo.PhoneXUBLO;
import mobile.ebiz.dto.IDXU;
import mobile.ebiz.dto.PhoneXU;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.blo.food.FoodBLO;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.food.Food;

/**
 * @author NThanhPhong
 */
public class ActiveXU extends BaseAction {
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

        JSONObject json = new JSONObject();
        String flag = "false";
        // flag active xu
        String flagxu = request.getParameter("flag");
        String content = request.getParameter("content");
        try {
            if (flagxu.equals("stp")) {
                flag = activexuStp(content);
            } else if (flagxu.equals("sca")) {
                flag = activexuSca(content);
            } else if (flagxu.equals("scb")) {
                flag = buyScb(content);
            } else if (flagxu.equals("stb")) {
                flag = buyStb(content);
            } else if (flagxu.equals("scn")) {
                flag = activexuScn(content);
            } else if (flagxu.equals("adm")) {
                flag = activexuAdmin(content);
            }
            json.put("flag", flag);
            // json.put("content", arg1)
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
    /**
     * [Give the description for method].
     * @param content String
     * @return String
     */
    private String activexuAdmin(String content) {
        String[] listitem = content.split("@");
        String result = "false";
        try {
            IDXUBLO.CreateListXu();
            Customer customer = CustomerBLO.getCustomerByID(listitem[0]);
            if (customer != null) {
                System.out.println("truoc : " + customer.getXuOnline());
                IDXU xu = IDXUBLO.getXuById(listitem[1]);
                if (xu != null && xu.getFlag().equals("true")) {
                    customer.setXuOnline(customer.getXuOnline() + xu.getMoney());
                    CustomerBLO.updateCustomer(customer);
                    System.out.println("sau : " + customer.getXuOnline());
                    xu.setFlag("false");
                    IDXUBLO.updateXu(xu);
                    System.out.println(xu.getId() + " - " + xu.getMoney() + " - " + xu.getFlag());
                    result = String.valueOf(customer.getXuOnline());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    // nap tien vao user theo cu phap
    // cu phap <stp username productkey >
    // cu phap server nhan content=username@productkey
    /**
     * [Give the description for method].
     * @param content String
     * @return String
     */
    private String activexuStp(String content) {
        String[] listitem = content.split("@");
        String result = "false";
        try {
            // Customer tem=new Customer();
            // tem.setCustomerId(listitem[0]);
            // tem.setXuOnline((long) 10);
            // CustomerBLO.updatecustomer(tem);
            // IDXU tem=new IDXU();
            // tem.setId("1234567890");
            // tem.setMoney((long)50000);
            // PMF.save(tem);
            IDXUBLO.CreateListXu();
            Customer customer = CustomerBLO.getCustomerByID(listitem[0]);
            if (customer != null) {
                System.out.println("truoc : " + customer.getXuOnline());
                IDXU xu = IDXUBLO.getXuById(listitem[1]);
                if (xu != null && xu.getFlag().equals("true")) {
                    customer.setXuOnline(customer.getXuOnline() + xu.getMoney());
                    CustomerBLO.updateCustomer(customer);
                    System.out.println("sau : " + customer.getXuOnline());
                    xu.setFlag("false");
                    IDXUBLO.updateXu(xu);
                    System.out.println(xu.getId() + " - " + xu.getMoney() + " - " + xu.getFlag());
                    result = "true";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    // nap tien theo cu phap
    // cu phap <sca username menhgia>(menhgia 10,20,50)
    // cu phap server nhan content=username@menhgia
    /**
     * [Give the description for method].
     * @param content String
     * @return String
     */
    private String activexuSca(String content) {
        String[] listitem = content.split("@");
        long tempmoney = Long.parseLong(listitem[1] + "000");
        String result = "false";
        try {
            Customer customer = CustomerBLO.getCustomerByID(listitem[0]);
            if (customer != null) {
                System.out.println("truoc khi nap : " + customer.getXuOnline());
                customer.setXuOnline(customer.getXuOnline() + tempmoney);
                CustomerBLO.updateCustomer(customer);
                System.out.println("sau khi nap : " + customer.getXuOnline());
                result = "true";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    // mua hang theo ma so hang hoa, theo so dien thoai nguoi mua
    // cu phap <scb mahang>
    // cu phap server nhan content=phone@mahang
    /**
     * [Give the description for method].
     * @param content String
     * @return String
     */
    private String buyScb(String content) {
        String result = "false";
        String[] listitem = content.split("@");
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    // mua hang theo ma so hang hoa, theo username nguoi dung
    // cu phap <stb mahang username password>
    // cu phap server nhan content=mahang@username@password
    /**
     * [Give the description for method].
     * @param content String
     * @return String
     */
    private String buyStb(String content) {
        String result = "false";
        String[] listitem = content.split("@");
        try {
            // Customer tem=new Customer();
            // tem.setCustomerId("wind");
            // tem.setCustomerPassword("wind");
            // CustomerBLO.updatecustomer(tem);
            Customer customer = CustomerBLO.getCustomerByID(listitem[1]);
            if (customer.getCustomerPassword().equals(listitem[2])) {
                Food food = FoodBLO.getFoodById(Long.parseLong(listitem[0]));
                if (food != null) {
                    if (customer.getXuOnline() >= food.getPrice()) {
                        result = "true";
                        customer.setXuOnline(customer.getXuOnline() - food.getPrice());
                        CustomerBLO.updateCustomer(customer);
                    } else {
                        result = "Ban khong du tien thanh toan. Xin nap them tien!";
                    }
                } else {
                    result = "Mon an nay khong ton tai. Ban co the nhap ma so mon an khac!";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    // nap tien vao tai khoan dien thoai
    // cu phap <scn menhgia>
    // cu phap server nhan content=phone@menhgia
    /**
     * [Give the description for method].
     * @param content String
     * @return String
     */
    private String activexuScn(String content) {
        String[] listitem = content.split("@");
        long tempmoney = Long.parseLong(listitem[1] + "000");
        String result = "false";
        try {
            PhoneXU phonexu = PhoneXUBLO.getPhoneXUById(listitem[0]);
            if (phonexu != null) {
                phonexu.setMoney(phonexu.getMoney() + tempmoney);
                PhoneXUBLO.updatePhoneXU(phonexu);
                System.out.println("sau khi nap : " + phonexu.getPhone() + " " + phonexu.getMoney());
            } else {
                PhoneXU node = new PhoneXU();
                node.setPhone(listitem[0]);
                node.setMoney(tempmoney);
                PhoneXUBLO.registerXu(node);
                System.out.println("nap moi : " + node.getPhone() + " " + node.getMoney());
            }
            result = "true";
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
