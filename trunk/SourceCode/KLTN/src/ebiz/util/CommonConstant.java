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
package ebiz.util;

/**
 * @author ThuyNT
 */
public class CommonConstant {
    public final static String SUCCESS = "success";
    public final static String SUCCESS1 = "success1";
    public final static String SUCCESS2 = "success2";
    public final static String FAILURE = "failure";
    public final static String LOGIN = "login";
    public final static String URL= "http://12.test-kltn1.appspot.com";
    // save in session
    public final static String USER = "user";
    public final static String ADMIN = "admin";
    public final static String PROVIDER = "provider";
    public final static String SHOPPING = "shop";
    public final static String WELCOME = "Chào mừng  ";
    public final static String WELCOMEP = "Chào ";
    public final static String BILL = "bill";
    public final static String ADMIN_BILL = "billAdmin";
    public final static String ADMIN_CUSTOMER = "customerAdmin";
    public final static int SHORTDISPLAY = 5;
    // CUSTOMER for sending message prmotion
    public final static String CODECUSTOMER_0 = "0";
    public final static String PHONECUSTOMER = "phone";

    public final static String CUSTOMER_SERVICE0 = "0"; // normal
    public final static String CUSTOMER_SERVICE1 = "1"; // isAdMail
    public final static String CUSTOMER_SERVICE2 = "2"; // isAdPhone
    public final static String NAME_SERVICE1 = "1";

    // FOOD
    public final static String CODEFOOD_0 = "0";
    public final static String FOODPROMOTION = "2";
    // FOOD PROMOTION
    public final static String CODEFOOD_1 = "1";
    public final static String NAMEFOOD_PRO = "promotion";

    // FOOD STATUS
    public final static String STATUS_0 = "0"; // het hang
    public final static String STATUS_1 = "1"; // dang ban
    public final static String STATUS_2 = "2"; // khuyen mai
    public final static String STATUS_3 = "3"; // het hsd
    public final static String STATUS_4 = "4";
    public final static String STATUS_MESSAGE_0 = "Hết hàng";

    // FOOD TYPE
    public final static String TYPE_1 = "1"; // prepared cook
    public final static String TYPE_2 = "2"; // cooked food
    public final static String TYPE_3 = "3"; // vegatable
    // BILL STATUS
    public final static String BILLSTATUS_5 = "5"; // assign for employee
    public final static String BILLSTATUS_0 = "0"; // create bill not payment
    public final static String BILLSTATUS_1 = "1"; // not paid money(order) or reOrder (paid money in home)
    public final static String BILLSTATUS_2 = "2"; // not rececive (paid money xu)
    public final static String BILLSTATUS_3 = "3"; // paid money ngan luong
    public final static String BILLSTATUS_4 = "4"; // rececive : finish
    // public final static String BILLSTATUS_5 ="5"; //cancel
    // public final static String BILLSTATUS_6 ="6";
    // DISPLAY CATEGORY
    public final static String FOOD_TYPE = "foodTypeId";
    public final static String FOOD_STATUS = "foodStatusId";
    public final static String FOOD_CATEGORY_A = "Attribute";
    public final static String FOOD_CATEGORY_P = "Price";
    public final static String FOOD_CATEGORY_F = "Food";
    public final static String PAGING = "Paging";
    public final static Integer DEFAULT_RECORD = 8;
    public final static Integer HOME_RECORD = 6;
    public final static Integer LIMIT_NUMBER_XU = 500;
    public final static String DEFAULT_COL = "foodName";
    public final static Integer DEFAULT_PAGE = 1;
    public final static String DEFAULT_ORDER = "asc";
    public final static String PRODUCTVO = "productVo";
    public final static String PROVIDER_CATEGORY_F = "providerFood";
    public final static String ADMIN_CATEGORY_F = "adminFood";
    public final static String ADMINRVO = "adminVo";
    public final static String PROVIDERVO = "providerVo";
    // Home Action
    public final static int HOME_NUMBER_DEFAUL = 8;
    // DISPLAY PRODUCT DETAIL
    public final static String FOOD_DETAIL_PRODUCT = "DetailProduct";
    // screen
    public final static String SCREEN_CHECKOUT = "scheckout";
    public final static int HASHCODENUMBER = 15;
    public final static int HASHCODENUMBERROVIDER = 8;
}
