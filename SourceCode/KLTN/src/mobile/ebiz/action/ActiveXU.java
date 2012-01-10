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
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mobile.ebiz.blo.product.Product;
import mobile.ebiz.xu.IDXU;
import mobile.ebiz.xu.IDXUBLO;
import mobile.ebiz.xu.PhoneXU;
import mobile.ebiz.xu.PhoneXUBLO;


import com.google.appengine.api.search.ExpressionParser.num_return;
import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import ebiz.action.BaseAction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dao.gae.CustomerDAO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.gae.PMF;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.food.Food;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class ActiveXU extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;

        JSONObject json = new JSONObject();
        boolean flag = true;
        //flag active xu
        String flagxu=request.getParameter("flag");
        String content=request.getParameter("content");
        try {
            if(flagxu.equals("stp"))
            	flag=activexu_stp(content);
            else if(flagxu.equals("sca"))
            	flag=activexu_sca(content);
            else if(flagxu.equals("scb"))
            	flag=buy_scb(content);
            else if(flagxu.equals("stb"))
            	flag=buy_stb(content);
            else if(flagxu.equals("scn"))
            	flag=activexu_scn(content);
            json.put("flag", flag);
//            json.put("content", arg1)
            out = response.getWriter();
            out.println("123");
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
    
    //nap tien vao user theo cu phap
    //cu phap <stp username productkey >
    //cu phap server nhan content=username@productkey
    private boolean activexu_stp(String content){
    	String[] listitem=content.split("@");
    	boolean result=false;
    	try {
//    		Customer tem=new Customer();
//    		tem.setCustomerId("wind");
//    		tem.setXuOnline((long) 0);
//    		CustomerBLO.registerCustomer(tem);
    		IDXU tem=new IDXU();
    		tem.setId("1234567890");
    		tem.setMoney((long)50000);
    		PMF.save(tem);
    		
			Customer customer=CustomerBLO.getCustomerByID(listitem[0]);
			if(customer!=null){
				System.out.println("truoc : "+customer.getXuOnline());
				customer.setXuOnline(customer.getXuOnline()+50);
				CustomerBLO.updatecustomer(customer);
				System.out.println("sau : "+customer.getXuOnline());
				result=true;
			}
			IDXU xu=IDXUBLO.getXuById("1234567890");
			if(xu!=null)
				System.out.println(xu.getId()+xu.getMoney());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	return result;
    }
    
    //nap tien theo cu phap 
    //cu phap <sca username menhgia>(menhgia 10,20,50)
    //cu phap server nhan content=username@menhgia
    private boolean activexu_sca(String content){
    	String[] listitem=content.split("@");
    	long tempmoney=Long.parseLong(listitem[1]+"000");
    	boolean result=false;
    	try {
			Customer customer=CustomerBLO.getCustomerByID(listitem[0]);
			if(customer!=null){
				System.out.println("truoc khi nap : "+customer.getXuOnline());
				customer.setXuOnline(customer.getXuOnline()+tempmoney);
				CustomerBLO.updatecustomer(customer);
				System.out.println("sau khi nap : "+customer.getXuOnline());
				result=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return result;
    }
    //mua hang theo ma so hang hoa, theo so dien thoai nguoi mua
    //cu phap <scb mahang>
    //cu phap server nhan content=phone@mahang
    private boolean buy_scb(String content){
    	boolean result=false;
    	String[] listitem=content.split("@");
    	try {
			
		} catch (Exception e) {
			System.out.println(e);
		}
    	return result;
    }
    //mua hang theo ma so hang hoa, theo username nguoi dung
    //cu phap <stb mahang username password>
    //cu phap server nhan content=mahang@username@password
    private boolean buy_stb(String content){
    	boolean result=false;
    	String[] listitem=content.split("@");
    	try {
//    		Customer tem=new Customer();
//    		tem.setCustomerId("wind");
//    		tem.setCustomerPassword("wind");
//    		CustomerBLO.updatecustomer(tem);
			Customer customer=CustomerBLO.getCustomerByID(listitem[1]);
			if(customer.getCustomerPassword().equals(listitem[2])){
				result=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return result;
    }
    //nap tien vao tai khoan dien thoai
    //cu phap <scn menhgia>
    //cu phap server nhan content=phone@menhgia
    private boolean activexu_scn(String content){
    	String[] listitem=content.split("@");
    	long tempmoney=Long.parseLong(listitem[1]+"000");
    	boolean result=false;
    	try {
			PhoneXU phonexu=PhoneXUBLO.getPhoneXUById(listitem[0]);
			if(phonexu!=null){
				phonexu.setMoney(phonexu.getMoney()+tempmoney);
				PhoneXUBLO.updatePhoneXU(phonexu);
				System.out.println("sau khi nap : "+phonexu.getPhone()+" "+phonexu.getMoney());
			}
			else{
				PhoneXU node =new PhoneXU();
				node.setPhone(listitem[0]);
				node.setMoney(tempmoney);
				PhoneXUBLO.registerXu(node);
				System.out.println("nap moi : "+node.getPhone()+" "+node.getMoney());
			}
			result=true;
		} catch (Exception e) {
			System.out.println(e);
		}
    	return result;
    }
}
