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
package ebiz.blo.food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ebiz.blo.customer.CustomerBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.gae.OrderDAO;
import ebiz.dao.gae.PMF;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.form.FoodForm;
import ebiz.form.FoodPriceForm;
import ebiz.form.OrderBillForm;
import ebiz.form.Paging;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;
import ebiz.util.CommonUtil;

/**
 * @author ThuyNT
 */
public class FoodBLO {
    /** FoodDAO . */
    private static IFoodDAO foodDao = new FoodDAO();
    /** OrderDAO. */
    private static IOrderDAO orderDao = new OrderDAO();
    /**
     * [get Food by ID(Long type)].
     * @param id Long
     * @return Food
     */
    public static Food getFoodById(Long id) {
        return foodDao.getFoodById(id);
    }
    /**
     * [Get all food List].
     * @return List<Food>
     */
    public static List<Food> getFoodListAll() {
        // get info cua product
        return foodDao.getFoodListAll();
    }

    /**
     * [get FoodFormList By Status with limit].
     * @param limit number of food to get
     * @param idStatus status of food
     * @return List<FoodForm> to display
     */
    public static List<FoodForm> getFoodListByStatus(int limit, String idStatus) {
        List<FoodForm> formList = new ArrayList<FoodForm>();
        List<Food> foodList = new ArrayList<Food>();
        // get Food List
        foodList = (List<Food>) foodDao.getListFoodByValue("foodStatusId", idStatus);
        // specify size list to get
        if (!foodList.isEmpty()) {
            if (foodList.size() < limit) {
                limit = foodList.size();
            }

            for (int i = 0; i < limit; i++) {
                FoodForm form = new FoodForm();
                form.editForm(foodList.get(i));
                if (form != null) {
                    formList.add(form);
                }
            }
        }
        // transfer FoodForm to display
        return formList;
    }

    /**
     * [get Name of Food by ID].
     * @param id Id of Food
     * @return String Name of Food
     */
    public static String getNameStatusById(String id) {
        return foodDao.getStatusNameByID(id);
    }
    /**
     * [get FoodForm(paging)].
     * @param col Name Column
     * @param paging content list Cursor String
     * @param order type Order
     * @param record number of record in 1 page
     * @param page number page
     * @param typeProduct type of Food
     * @return List<FoodForm> to display
     */
    public static List<FoodForm> getFoodFormList(String col, HashMap<Integer, String> paging, String order, int record,
            int page, String sql) {
        List<FoodForm> formList = new ArrayList<FoodForm>();
        List<Food> foodList = new ArrayList<Food>();
//        String filterCol = CommonConstant.FOOD_TYPE;

        // call method to get FoodList
        foodList = foodDao.diplayPageFood(col, paging, order, record, page,sql);
        // transfer dto-> form : display
        for (Food food : foodList) {
            FoodForm form = new FoodForm();
            // display
//            if (food.getIsDisplay() == 1) {
                form.editForm(food);
                if (!form.isEmpty()) {
//                   System.out.println("Attribute:"+ food.getProductAttributeId());
//                   food.setProductAttributeId("1");
//                   foodDao.saveFood(food);
                    formList.add(form);
                }
//           }
        }
        return formList;
    }
    //Customer
    public static List<FoodForm> getFoodListCategory(String col, HashMap<Integer, String> paging, String order, int record,
            int page, String colFilter, String typeProduct, String attr, String price) {
        StringBuffer sql = new StringBuffer();
            sql.append(" isDisplay == 1 ");
            sql.append(" &&  ");
            sql.append(colFilter + "== \'" + typeProduct + "\'");
        if (!attr.equals("0")) {
            sql.append(" &&  ");
            sql.append("productAttributeId == \'" + attr + "\'");
        }
        if (!price.equals("0")) {
            sql.append(" &&  ");
            sql.append("foodPriceLevelId == \'" + price + "\'");
        }
        return getFoodFormList(col, paging, order, record, page,sql.toString());
    }
    
    
    public static List<FoodForm> getFoodFormListAll(String col, HashMap<Integer, String> paging, String order, int record,
            int page, String idProvider) {
        List<FoodForm> formList = new ArrayList<FoodForm>();
        List<Food> foodList = new ArrayList<Food>();

        foodList = foodDao.diplayFoodProviderAll(col, paging, order, record, page, idProvider);
        for (Food food : foodList) {
            FoodForm form = new FoodForm();
//            if (food.getIsDisplay() == 1) {
            	System.out.println("getIsDisplay"+food.getFoodId());
                form.editForm(food);
                if (!form.isEmpty()) {
                    formList.add(form);
                }
//            }
        }
        return formList;
    }
    /**
     * [initialize Food Category ].
     * @param paging Cursor string
     * @param record record in 1 page
     * @param typeProduct type of Food
     * @return List<FoodForm> to display
     */
    public static List<FoodForm> initFoodCategory(HashMap<Integer, String> paging,int record, String colFilter, String typeProduct, String attr, String price) {

        List<FoodForm> formList = new ArrayList<FoodForm>();
        StringBuffer sql = new StringBuffer();
        sql.append(" isDisplay == 1 ");
        sql.append(" &&  ");
        sql.append(colFilter + "== \'" + typeProduct + "\'");
        if (attr != null) {
            sql.append(" &&  ");
            sql.append("productAttributeId == \'" + attr + "\'");
        }
        if (price != null) {
            sql.append(" &&  ");
            sql.append("foodPriceLevelId == \'" + price + "\'");
        }
        formList = getFoodFormList("foodName", paging, "asc", record, 1,sql.toString());
        return formList;
    }
    
    /**
     * [initialize Food Category Provider ].
     * @param paging Cursor string
     * @param record record in 1 page
     * @param typeProduct type of Food
     * @return List<FoodForm> to display
     */
    public static List<FoodForm> initFoodCategoryProvider(HashMap<Integer, String> paging,String idProvider) {

        List<FoodForm> formList = new ArrayList<FoodForm>();
        formList = getFoodFormListAll("foodName", paging, "asc", 8, 1, idProvider);
        System.out.println("SIZE OF FOOD"+formList.size());
        return formList;
    }
   
    /**
     * [displayFoodCategoryProvider].
     * @param col				String
     * @param paging			HashMap
     * @param order				String
     * @param record			int
     * @param page				int
     * @param colFilter			String
     * @param status			String
     * @return 					List<FoodForm>
     */
    public static List<FoodForm> displayFoodCategoryProvider(String col,HashMap<Integer, String> paging,String order, int record,int page, String colFilter, String status,String idProvider) {
        List<FoodForm> formList = new ArrayList<FoodForm>();
        StringBuffer sql = new StringBuffer();
        sql.append("providerID == \'" + idProvider +"\'");
        if(status.equals("0")){
        	// get all
        	formList = getFoodFormListAll(col,paging,order,record,page,idProvider);
        }
        else{
            if (("4".equals(status))){
                sql.append(" &&  ");
                sql.append(" isDisplay == 0 ");
            }
            else {
                sql.append(" &&  ");
                sql.append(" isDisplay == 1 ");
                sql.append(" &&  ");
                sql.append(colFilter + "== \'" + status + "\'");
            }
//            if (attr != null) {
//                sql.append(" &&  ");
//                sql.append("productAttributeId == \'" + attr + "\'");
//            }
//            if (price != null) {
//                sql.append(" &&  ");
//                sql.append("foodPriceLevelId == \'" + price + "\'");
//            }
        	 formList = getFoodFormList(col, paging, order, record, page,sql.toString());
        }
        return formList;
    }
    
//    public static List<FoodForm> initFoodProviderCategory(HashMap<Integer, String> paging, int record, String colFilter, String typeProduct) {
//        List<FoodForm> formList = new ArrayList<FoodForm>();
//        formList = getFoodFormList("foodName", paging, "asc", record, 1,colFilter, typeProduct);
//        return formList;
//    }

     /**
     * [Give the description for method].
     * @param key               String
     * @return                  FoodForm
     */
     public static FoodForm getFoodFormDetail(String key) {
     FoodForm form = new FoodForm();
     Long id;
     if (key != null) {
     id = Long.parseLong(key);
     form.editFormDetail(getFoodById(id));
     }
     if (form.isEmpty()) {
     return null;
     }
     return form;
     }

    /**
     * [update Status of paging].
     * @param p HashMap<Integer, String>
     * @return List<Paging> Class for cursor String
     */
    public static List<Paging> updateStatusPaging(HashMap<Integer, String> p) {
        List<Paging> pageList = new ArrayList<Paging>();

        for (int key : p.keySet()) {
            Paging page = new Paging();
            page.setId(key);
            page.setCursorString(p.get(key));
            pageList.add(page);
        }
        return pageList;

    }

    /**
     * [transfer HashMap<Integer, String> to List<Paging>].
     * @param pageList List<Paging>
     * @return HashMap<Integer, String>
     */
    public static HashMap<Integer, String> toHashMap(List<Paging> pageList) {

        HashMap<Integer, String> paging = new HashMap<Integer, String>();
        for (Paging page : pageList) {
            paging.put(page.getId(), page.getCursorString());
        }
        return paging;

    }
    /**
     * [add food into shopping cart].
     * @param shopCart ShoppingCart
     * @param key key of food
     * @param number amount of food
     * @return boolean
     */
    public static boolean addShoppingCart(ShoppingCart shopCart, String key, int number) {
        Long id;
        int numberDB;
        FoodForm food = null;
        if (key != null) {
            id = Long.parseLong(key);
            // test number of product in database
            Food foodDB = foodDao.getFoodById(id);
            numberDB = foodDB.getNumber();
            System.out.println("NUMBER DATEBASE"+numberDB+" "+number);
            if (!shopCart.isEmpty()) {
                List<FoodForm> foodList = shopCart.getProducts();
                // ? exist product in shopping cart
                for (FoodForm foodForm : foodList) {
                    // exist product in shopping
                    if (id.equals(foodForm.getId())) {

                        int numberProduct = foodForm.getNumber() + number;
                        // number product required <= number in database
                        if (numberProduct <= numberDB) {
                            foodForm.setNumber(numberProduct);
                            foodForm.setSubTotal(foodForm.getPrice() * numberProduct);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            // shopcart is empty or don't exist required product in shop cart
            if (number <= numberDB) {
                System.out.println("No Product");
                food = new FoodForm();
                food.editForm(foodDB);
                // if product is a promotion products -> put into price
                if ((CommonConstant.FOODPROMOTION).equals(food.getStatus())) {
                    food.setPrice(food.getPromoPrice());
                }
                // add shopping
                shopCart.addFood(food, number);
                // re-count size of productList in shopping
                shopCart.size();
            } else {
                return false;
            }

        }

        return true;
    }

//    /**
//     * [remove Product in Shopping Cart].
//     * @param shopCart ShoppingCart
//     * @param idProduct id of Food
//     * @return boolean
//     */
//    public boolean removeProInShop(ShoppingCart shopCart, Long idProduct) {
//        List<FoodForm> foodList = shopCart.getProducts();
//        if (!foodList.isEmpty()) {
//            for (int i = 0; i < foodList.size(); i++) {
//                if (foodList.get(i).getId() == idProduct) {
//                    foodList.remove(i);
//                    return true;
//                }
//
//            }
//        }
//        return false;
//    }
    /**
     * [test number of food in database with food which add into shop].
     * @param shopCart ShoppingCart
     * @param key id of Food
     * @param number amount of Food
     * @return if(fail) return number of food indatabse else return 0
     */
    public static int isProNumberShop(ShoppingCart shopCart, String key, int number) {
        Long id;
        int numberDB;
        if (key != null) {
            id = Long.parseLong(key);
            Food foodDB = foodDao.getFoodById(id);
            numberDB = foodDB.getNumber();
            if (number > numberDB) {
                return numberDB;
            }
        }
        return 0; // success

    }
//    /**
//     * [update SubPrice in shopping ].
//     * @param shopCart ShoppingCart
//     * @param key id of Food
//     * @param number amount of Food
//     * @return amount of SubPrice
//     */
//    public static Long updateSubPriceShop(ShoppingCart shopCart, String key, int number) {
//        Long id;
//        Long subPrice = new Long(0);
//        if (key != null) {
//            id = Long.parseLong(key);
//            List<FoodForm> foodList = shopCart.getProducts();
//            for (FoodForm foodForm : foodList) {
//                if (id == foodForm.getId()) {
//                    subPrice = number * foodForm.getPrice();
//                    // update amount of food
//                    foodForm.setNumber(number);
//                    // update subTotal
//                    foodForm.setSubTotal(subPrice);
//                }
//            }
//        }
//        return subPrice;
//
//    }

    /**
     * [decrease amount of FoodNumber, FoodOrder].
     * @param id id of Food
     * @param number amount of Food
     * @return boolean
     */
    public static boolean downNumberOfFood(Long id, int number) {

        Food food = foodDao.getFoodById(id);
        food.setNumber(food.getNumber() - number);
        food.setNumberOrder(food.getNumberOrder() - number);
        return foodDao.saveFood(food);

    }

    /**
     * [increase amount of Food].
     * @param id id of Food
     * @param number amount of Food
     * @return boolean
     */
    public static boolean upNumberOfFood(Long id, int number) {

        Food food = foodDao.getFoodById(id);
        food.setNumberOrder(food.getNumber() + number);
        return foodDao.saveFood(food);

    }

    /**
     * [increase amount of FoodOrder(Order column)].
     * @param id id of Food
     * @param number amount of Food
     * @return boolean
     */
    public static boolean upNumberFoodOrder(Long id, int number) {

        System.out.println("ID" + number);
        Food food = foodDao.getFoodById(id);
        if (food == null) {
            System.out.println("NULL");
        }
        System.out.println("Number" + food.getNumberOrder());
        food.setNumberOrder(food.getNumberOrder() + number);
        return foodDao.saveFood(food);

    }

    // /**
    // * [Give the description for method].
    // * @param shop
    // * @return OrderBill
    // */
    // public static OrderBill billing(ShoppingCart shop) {
    //
    // //infor shipping ( get from form , did'nt update in Customer)
    // LoginForm login = shop.getUser();
    // if (login.getLoginId() != null) {
    // Customer customer = login.getCustomer();
    // Long moneyOrder = new Long(0);
    // // customer = CustomerBLO.getCustomerByID(shop.getUser().getLoginId());
    //
    // OrderBill order = new OrderBill();
    // System.out.println("CUSTOMER" + customer.getCustomerId());
    // // create OrderBill
    // order.setIdCustomer(customer.getCustomerId());
    // order.setAddress(customer.getCustomerAddress());
    // order.setEmail(customer.getCustomerEmail());
    // order.setPhone(customer.getCustomerPhone());
    // order.setStatus(CommonConstant.BILLSTATUS_1); // chua giao
    // order.setDateOrder(new Date());
    // List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();
    // // save order
    // moneyOrder = sumMoneyOrder(shop);
    // order.setSumPrice(moneyOrder);
    // order = orderDao.save(order);
    // Long idOrder = order.getId();
    // // save in shopping
    // // create detailOrder --> save in database
    //
    // for (FoodForm food : shop.getProducts()) {
    // DetailOrder detail = new DetailOrder();
    // detail.setIdProduct(food.getId());
    // detail.setName(food.getName());
    // detail.setNumber(food.getNumber());
    // detail.setSubPrice(food.getNumber() * food.getPrice());
    // detail.setOrderId(idOrder);
    // detailOrderList.add(detail);
    // // save DetailOrder
    // orderDao.insertDetailOrder(detail);
    //
    // // increase number of product Order
    // upNumberFoodOrder(food.getId(), food.getNumber());
    //
    // }
    // return order;
    // }
    // return null;// user chua dang nhap
    // }

    /**
     * [billing for Order].
     * @param shop ShoppingCart
     * @return OrderBill
     */
    public static OrderBill billing(ShoppingCart shop) {

        OrderBillForm orderForm = shop.getOrder();
        if (orderForm != null) {
            long moneyOrder = 0;
            System.out.println("start"+orderForm.getIdCustomer());
            OrderBill order = orderForm.getOrder();
            System.out.println("end"+order.getIdCustomer());
            // List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();
            moneyOrder = sumMoneyOrder(shop);
            //checkout 
//            if(!CustomerBLO.checkoutXuOnline(orderForm.getIdCustomer(), moneyOrder)){
//            	return null;
//            }
            order.setSumPrice(moneyOrder);
            // save order
            order = orderDao.save(order);
            Long idOrder = order.getId();
            // create detailOrder --> save in database

            for (FoodForm food : shop.getProducts()) {
                DetailOrder detail = new DetailOrder();
                detail.setIdProduct(food.getId());
                detail.setName(food.getName());
                detail.setNumber(food.getNumber());
                detail.setSubPrice(food.getNumber() * food.getPrice());
                detail.setOrderId(idOrder);
                // detailOrderList.add(detail);
                // save DetailOrder
                orderDao.insertDetailOrder(detail);

                // increase number of product Order
                upNumberFoodOrder(food.getId(), food.getNumber());

            }
            System.out.println("ID Customer"+order.getIdCustomer());
            return order;
        }
        // user chua dang nhap
        return null;
    }

    /**
     * [getDetailOrderReset(function of Customer)].
     * @param orderID           Long
     * @return                  List<DetailOrder>
     */
    public static List<DetailOrder> getDetailOrderRe(Long orderID) {
        List<DetailOrder> detailList = new ArrayList<DetailOrder>();
        // get detail Order
        detailList = orderDao.getDetailByIDOrBill(orderID);
        // test product in order Detail with product current
        for (DetailOrder detail : detailList) {

            Food tempFood = foodDao.getFoodById(detail.getIdProduct());
            // co san pham nay
            if (!CommonUtil.isNull(tempFood)) {
                // not enough product for reOrder
                if (tempFood.getNumber() < detail.getNumber()) {
                    detail.setNumber(tempFood.getNumber());
                }
            } else {
             // didn't exist this product
                detailList.remove(detail);
            }
        }
        return detailList;
    }

    /**
     * [getDetailOrder by Order ID].
     * @param orderID       Long
     * @return              List<DetailOrder>
     */
    public static List<DetailOrder> getDetailOrder(Long orderID) {
        List<DetailOrder> detailList = new ArrayList<DetailOrder>();
        // get detail Order
        detailList = orderDao.getDetailByIDOrBill(orderID);
        return detailList;

    }
    /**
     * [isEqual].
     * @param list1         List<DetailOrder>
     * @param list2         List<DetailOrder>
     * @return              boolean
     */
    public static boolean isEqual(List<DetailOrder> list1, List<DetailOrder> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list2.get(i).getNumber() != list1.get(i).getNumber()) {
                return false;
            }
        }
        return true;
    }
    /**
     * [cancelOrderBill(set status of OrderBill)].
     * @param id            Long
     * @return              boolean
     */
    public static boolean cancelOrderBill(Long id) {
        if (updateStatusOrderBill(id, CommonConstant.BILLSTATUS_4)) {
            List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();
            detailOrderList = orderDao.getDetailByIDOrBill(id);
            for (DetailOrder detail : detailOrderList) {
                upNumberOfFood(detail.getIdProduct(), detail.getNumber());
            }
            orderDao.deleteDetailOrderList(detailOrderList);
            return true;
        }

        return false;
    }

    /**
     * [updateStatusOrderBill].
     * @param id                Long
     * @param status            int
     * @return                  boolean
     */
    public static boolean updateStatusOrderBill(Long id, String status) {
        OrderBill order = orderDao.getOrderBillById(id);
        order.setStatus(status);
        if (orderDao.save(order) != null) {
            return true;
        }
        return false;
    }

    /**
     * [deleteFood].
     * @param food          Food
     * @return              boolean
     */
    public static boolean deleteFood(Food food) {
        return PMF.delete(Food.class, food.getFoodId());
    }

    /**
     * [deleteFood].
     * @param food          Food
     * @return              boolean
     */
    public static boolean deleteFood(Long idFood) {
        if(idFood != null){
        	Food food = getFoodById(idFood);
        	if(food != null){
        	    System.out.println("DELETE");
        	return deleteFood(food);
        	}
        }
        return false;
    }
    /**
     * [sumMoneyOrder].
     * @param shop          ShoppingCart
     * @return long
     */
    public static long sumMoneyOrder(ShoppingCart shop) {
        long moneyOrder = 0;
        for (FoodForm food : shop.getProducts()) {
            moneyOrder = moneyOrder + food.getNumber() * food.getPrice();
        }
        return moneyOrder;
    }
    /**
     * [upload Food (provider)].
     * @param food          Food
     * @return              boolean
     */
    public static boolean uploadFood(Food food) {
        food.setIsDisplay(1); // display ( must edit : 0 - product doesn't sell)
        food.setFoodStatusId(food.getFoodStatusId()); // status of product
       
        food.setNumberOrder(0);
        food.setFoodPriceLevelId(FoodBLO.getFoodIdPrice(food.getPrice()));
        System.out.println("SETFOODPRICELEVELID" + food.getFoodPriceLevelId());
        return foodDao.saveFood(food);
    }
    
    /**
     * [upload Food (provider)].
     * @param food          Food
     * @return              boolean
     */
    public static boolean updateFood(Food food) {
        return foodDao.saveFood(food);
    }
    
    /**
     * [upload Food (provider)].
     * @param food          Food
     * @return              boolean
     */
    public static boolean updateFoodStatus(Food food) {
        Food foodTemp = getFoodById(food.getFoodId());
        if (foodTemp != null) {
        return foodDao.saveFood(food);
        }
        return false;
    }
    /**
     * [getAttributeFoodList].
     * @return      List<String>
     */
    public static List<FoodAttribute> getAttributeFoodList() {
        return foodDao.getAttributeList();
    }
    /**
     * [getPriceFoodList].
     * @return      List<FoodPriceLevel>
     */
    public static List<FoodPriceLevel> getPriceFoodList() {
        return foodDao.getPriceList();
    }
    public static String format(String s, int len){
    	String result = s;
    	
    	if(s.length() - len > 0){
    	result = s.substring(0, s.length() - len);
    	System.out.println("Subtring" + result);
    	result = result + "," + "000";
    	}
    	return result;
    }
    
    public static List<FoodPriceForm> format(List<FoodPriceLevel> listLevel){
    	List<FoodPriceForm> formList = new ArrayList<FoodPriceForm>();
    	for(FoodPriceLevel level: listLevel){
    		FoodPriceForm form = new FoodPriceForm();
    		form.editForm(level);
    		System.out.println("FOODFORM" + form.getId());
    		formList.add(form);
    	}
    	return formList;
    }
    
    /**
     * [getFoodIdPrice].
     * @param money         long
     * @return              String
     */
    public static String getFoodIdPrice(long money) {
        List<FoodPriceLevel> formList = new ArrayList<FoodPriceLevel>();
        // call to get list price
        formList = getPriceFoodList();
        for (FoodPriceLevel food : formList) {
            if ((money >= food.getStartPrice()) && (money <= food.getEndPrice())) {
                return food.getFoodPriceLevelId();
            }
        }
        return null;
    }
    /**
     * [shortDisplayText].
     * @param list          List<FoodForm>
     * @param len           int
     */
    public static void shortDisplay(List<FoodForm> list, int len) {
        for (FoodForm form : list) {
            form.setDetail(CommonUtil.shortString(form.getDetail(), len));
            form.setCooking(CommonUtil.shortString(form.getCooking(), len));
        }
    }
    
    public static List<FoodForm> transferBeanForm(List<Food> list){
    	List<FoodForm> formList = new ArrayList<FoodForm>();
    	for(Food food : list){
    		if (food != null) {
    			FoodForm form = new FoodForm();
    			form = form.editForm(food);
    			formList.add(form);
    		}
    	}
    	return formList;
    }

}

