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
package mobile.ebiz.blo.user;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.dao.gae.CustomerDAO;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Address;
import ebiz.dto.account.customer.Customer;
import ebiz.form.LoginForm;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 *
 */
public class CustomerBLO {
    
    private static ICustomerDAO custDao = new CustomerDAO();
    
    public static JSONObject getCustomerPhone() throws JSONException {
        JSONObject json = new JSONObject();
        List<String> phones = new ArrayList<String>();
        // JSONArray phoneList = new JSONArray();
        CustomerDAO dao = new CustomerDAO();
        phones = dao.getPhoneList();

//        json.put("info", CommonConstant.CODECUSTOMER_0);

        json.put("data", phones);

        return json;
    }
    public static JSONObject createCustomerPhone() throws JSONException {
        JSONObject json = new JSONObject();
        List<String> phones = new ArrayList<String>();
        //add data
        phones.add("0978354952");
        phones.add("0978354950");
        phones.add("0978354951");
        json.put("data", phones);

        return json;
    }
    public static JSONObject createName() throws JSONException {
        JSONObject json = new JSONObject();
        List<String> names = new ArrayList<String>();
        //add data
        names.add("Mr A");
        names.add("Mrs B ");
        names.add("Mss C");
        json.put("name", names);

        return json;
    }
    public static List<JSONObject> createHappyBirth() throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();
        JSONObject json = new JSONObject();
        JSONObject json1 = new JSONObject();
        //add data
        json.put("phone", "0978349998");
        json.put("name", " Chúc mừng sinh nhật Mr A! Thật nhiều may mắn và thành công");
        objList.add(json);
        json1.put("phone", "0978349999");
        json1.put("name", "Chúc mừng sinh nhật Mrs B!  Thật nhiều may mắn và thành công");
        objList.add(json1);
        return objList;
    }
    public static List<JSONObject> createEmployeeInfo() throws JSONException {
        List<JSONObject> objList = new ArrayList<JSONObject>();
        
        JSONObject json = new JSONObject();
        JSONObject json1 = new JSONObject();
        //add data
        json.put("id", "123");
        json.put("name", "Mr A");
        json.put("x", "1");
        json.put("y", "2");
        objList.add(json);
        json1.put("id", "123");
        json1.put("name", "Mr B");
        json1.put("x", "1");
        json1.put("y", "2");
        objList.add(json1);
        return objList;
    }
    
    /**
     * get Customer by ID
     */
    
    public static Customer getCustomerByID(String id){
        return custDao.getCustomerById(id);
        
    }
    /**
     * get Customer by ID
     */
    
    public static Customer getObject(LoginForm user){
      Customer customer = new Customer();
      customer.setCustomerId(user.getLoginId());
      customer.setCustomerName(user.getLoginName());
      customer.setCustomerGender(user.getGender());
      customer.setCustomerPhone(user.getPhone());
      customer.setCustomerEmail(user.getEmail());
      Address add = new Address();
      add.setBuildingName(user.getBuildingName());
      add.setDistrictName(user.getDistrictName());
      add.setHomeNumber(user.getHomeNumber());
      add.setStreetName(user.getStreetName());
      add.setWardName(user.getWardName());
      customer.setCustomerAddress(add);
      return customer;
        
    }
    
    

}
