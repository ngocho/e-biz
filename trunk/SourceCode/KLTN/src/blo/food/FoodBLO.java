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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;

import mobile.ebiz.blo.user.CustomerBLO;
import ebiz.dao.gae.CommonDAO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.inf.ICommonDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.DetailOrder;
import ebiz.dto.OrderBill;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
import ebiz.form.Paging;
import ebiz.form.ShoppingCart;

/**
 * @author ThuyNT
 */
public class FoodBLO {
    private static IFoodDAO foodDao = new FoodDAO();
    private static ICommonDAO commonDao = new CommonDAO();
    // /**
    // * ! khuyến mãi get info của sản phẩm khuyến mãi
    // */
    // public static FoodPromotion isProductPromotion(Long id) {
    // // get info cua product
    // return foodDao.getFoodPromotionById(id);
    // }
    /**
     * ! khuyến mãi get info của sản phẩm khuyến mãi
     */
    public static Food getFoodById(Long id) {
        // get info cua product
        return foodDao.getFoodById(id);
    }
    /**
     * get Food to display category
     * 
     * @return
     */
    public static List<FoodForm> getFoodFormList(String col, HashMap<Integer, String> paging, String order, int record,
            int page) {
        List<FoodForm> formList = new ArrayList<FoodForm>();
        List<Food> foodList = new ArrayList<Food>();
        foodList = foodDao.diplayFirstPage(col, paging, order, record, page);
        for (Food food : foodList) {
            FoodForm form = new FoodForm();
            //
            // if (CommonConstant.STATUS_2 == food.getFoodStatusId()) {
            // // san pham khuyen mai
            // form.editForm(isProductPromotion(food.getFoodId()));
            // } else {
            form.editForm(food);
            // }
            if (!form.isEmpty()) {
                formList.add(form);
            }
        }
        return formList;
    }
    /**
     * init display Food Category
     * 
     * @return
     */
    public static List<FoodForm> initFoodCategory(HashMap<Integer, String> paging, int record) {

        List<FoodForm> formList = new ArrayList<FoodForm>();
        formList = getFoodFormList("foodName", paging, "asc", record, 1);
        return formList;
    }
    /**
     * get Food to display detail product
     * 
     * @return
     */
    public static FoodForm getFoodFormDetail(String key) {

        FoodForm form = new FoodForm();
        Long id;
        if (key != null) {
            id = Long.parseLong(key);
            // FoodPromotion foodPromotion = null;
            // foodPromotion = isProductPromotion(id);
            // if (foodPromotion != null) {
            // // promotion
            // form.editFormDetail(foodPromotion);
            // } else {
            form.editFormDetail(getFoodById(id));

        }
        if (form.isEmpty()) {
            return null;
        }
        return form;
    }
    /**
     * [Give the description for method].
     * 
     * @param p
     * @return
     */
    public static List<Paging> editPage(HashMap<Integer, String> p) {
        List<Paging> pageList = new ArrayList<Paging>();

        for (Integer key : p.keySet()) {
            Paging page = new Paging();
            page.setId(key);
            page.setCursorString(p.get(key));
            pageList.add(page);
        }
        return pageList;

    }
    /**
     * [Give the description for method].
     * 
     * @param p
     * @return
     */
    public static HashMap<Integer, String> toHashMap(List<Paging> pageList) {
        HashMap<Integer, String> paging = new HashMap<Integer, String>();
        for (Paging page : pageList) {
            paging.put(page.getId(), page.getCursorString());
        }
        return paging;

    }
    // /**
    // * change product -> product promotion
    // *
    // * @param p
    // * @return
    // */
    // public static FoodPromotion updateFoodPromotion(Food food) {
    // FoodPromotion result = new FoodPromotion();
    // result.setProductId(food.getFoodId());
    // result.setCalo(food.getCalo());
    // result.setDetail(food.getDetail());
    // result.setPrice(food.getPrice());
    // result.setNumber(food.getNumber());
    // result.setProductName(food.getFoodName());
    // result.setUrl(food.getUrl());
    // return result;
    // }
    /**
     * add product into shopping cart
     * 
     * @param p
     * @return
     */
    public static boolean addShoppingCart(ShoppingCart shopCart, String key, Integer number) {
        Long id;
        Integer numberDB;
        FoodForm food = null;
        if (key != null) {
            id = Long.parseLong(key);
            Food foodDB = foodDao.getFoodById(id);
            numberDB = foodDB.getNumber();

            if (!shopCart.isEmpty()) {
                System.out.println("!isEmpty");
                List<FoodForm> foodList = shopCart.getProducts();
                // ? exist product in shopping cart
                for (FoodForm foodFrom : foodList) {
                    if (id == foodFrom.getId()) { // exist product in shopping cart
                        Integer numberProduct = foodFrom.getNumber() + number;
                        if (numberProduct <= numberDB) { // number of product<= in database
                            foodFrom.setNumber(numberProduct);
                            foodFrom.setSubTotal(foodFrom.getPrice() * numberProduct);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            // shopcart is empty or don't exist product in shop cart
            if (number <= numberDB) {
                System.out.println("add new");
                food = new FoodForm();
                System.out.println("add new 1");
                food.editForm(foodDB);
                System.out.println("add new 2");
                if ("2".equals(food.getStatus())) {
                    food.setPrice(food.getPromoPrice());
                }
                shopCart.addFood(food, number);
                System.out.println("SIZE" + shopCart.getCount());
            } else {
                return false;
            }

        }

        return true;
    }

    public static Integer updateProductShop(ShoppingCart shopCart, String key, Integer number) {

        Long id;
        Integer numberDB;
        if (key != null) {
            id = Long.parseLong(key);
            Food foodDB = foodDao.getFoodById(id);
            numberDB = foodDB.getNumber();
            if (number > numberDB) {
                return numberDB;
            }

            List<FoodForm> foodList = shopCart.getProducts();
            for (FoodForm foodFrom : foodList) {
                if (id == foodFrom.getId()) {
                    foodFrom.setNumber(number);
                    break;
                }
            }

        }
        return 0;
    }
    public static Long updateSubPriceShop(ShoppingCart shopCart, String key) {

        Long id;
        if (key != null) {
            id = Long.parseLong(key);
            List<FoodForm> foodList = shopCart.getProducts();
            for (FoodForm foodFrom : foodList) {
                if (id == foodFrom.getId()) {
                    return foodFrom.getSubTotal();
                }
            }

        }
        return (long) 0;
    }

    // public static boolean upNumberFood(Long id, Integer number){
    // Food food = null;
    // food = getFoodById(id);
    // if(food !=null){
    // food.setNumber(food.getNumber()+number);
    // return true;
    // }
    // return false;
    // }
    // public static boolean downNumberFood(Long id, Integer number){
    // Food food = null;
    // food = getFoodById(id);
    // if(food !=null){
    // food.setNumber(food.getNumber() - number);
    // return true;
    // }
    // return false;
    // }
    /**
     * update number of product when checkout
     */
    public static boolean downNumberOfFood(Long id, Integer number) {

        Food food = foodDao.getFoodById(id);
        food.setNumber(food.getNumber() - number);
        food.setNumberOrder(food.getNumberOrder() + number);
        return foodDao.save(food);

    }
    /**
     * update number of product when checkout
     * 
     * @param id
     * @param number
     * @return
     */
    public static boolean upNumberOfFood(Long id, Integer number) {

        Food food = foodDao.getFoodById(id);
        food.setNumber(food.getNumber() + number);
        food.setNumberOrder(food.getNumberOrder() - number);
        return foodDao.save(food);

    }
    /**
     * create bill
     * 
     * @param id
     * @param number
     * @return
     */
    public static boolean billing(ShoppingCart shop) {

        if (shop.getUser().getLoginId() != null) {
            Customer customer = new Customer();
            Long moneyOrder = new Long(0);
            customer = CustomerBLO.getCustomerByID(shop.getUser().getLoginId());
            OrderBill order = new OrderBill();
            System.out.println("CUSTOMER" + customer.getCustomerId());
            // create OrderBill
            order.setNameCustomer(customer.getCustomerName());
            order.setAddress(customer.getCustomerAddress());
            order.setEmail(order.getEmail());
            order.setPhone(order.getPhone());
            order.setStatus(0); // chua giao
            order.setDateOrder(new Date());
            DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
//            Queue queue = QueueFactory.getDefaultQueue();
            Transaction txn = ds.beginTransaction();
            try {

            // save order
            order = commonDao.save(order);
            Long idOrder = order.getId();
            System.out.println(order.getId());

            // create detailOrder --> save in database

            for (FoodForm food : shop.getProducts()) {
                moneyOrder = moneyOrder + food.getNumber() * food.getPrice();
                DetailOrder detail = new DetailOrder();
                detail.setIdProduct(food.getId());
                detail.setName(food.getName());
                detail.setNumber(food.getNumber());
                detail.setSubPrice(moneyOrder);
                detail.setOrderId(idOrder);

                // save DetailOrder
                commonDao.insertDetailOrder(detail);

                // update number of product
//                downNumberOfFood(food.getId(), food.getNumber());
            }
            order.setSumPrice(moneyOrder);

            // update sumMoney for order
            commonDao.save(order);
            txn.commit();
            return true;
        } catch (DatastoreFailureException e) {
           txn.rollback(); 
        }
        
        return false;
    }
        return false;// user chua dang nhap
    }
    /**
     * when cancel bill
     * 
     * @param id
     * @param number
     * @return
     */

    public static boolean cancelOrderBill(Long id) {
        if (updateStatusOrderBill(id, -1)) {
            List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();
            detailOrderList = commonDao.getDetailOrderList(id);
            for (DetailOrder detail : detailOrderList) {
                upNumberOfFood(detail.getIdProduct(), detail.getNumber());
            }
            commonDao.deleteDetailOrderList(detailOrderList);
            return true;
        }

        return false;
    }
    /**
     * set status of OrderBill when finished shipping
     * 
     * @param id
     * @param number
     * @return
     */

    public static boolean updateStatusOrderBill(Long id, Integer status) {
        OrderBill order = commonDao.getOrderBillById(id);
        order.setStatus(status);
        if (commonDao.save(order) != null) {
            return true;
        }
        return false;
    }


}

// /**
// *
// * get detail info of product
// * @return
// */
// public static List<FoodForm> getFoodForm(){
//
// List<FoodForm> formList = new ArrayList<FoodForm>();
// List<Food> foodList = new ArrayList<Food>();
// foodList = foodDao.getFoodList();
// for(Food food:foodList ){
// FoodForm form = new FoodForm();
//
// if(CommonConstant.STATUS_2 != food.getFoodStatusId() ){
// form.editForm(food);
// }
// else
// {
// //san pham khuyen mai
// form.editForm(isProductPromotion( food.getFoodId()));
// }
// if(!form.isEmpty()){
// formList.add(form);
// }
// }
// return formList;
// }
//

