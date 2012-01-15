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
package ebiz.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * @author Administrator
 *
 */
public class ShoppingCart implements Serializable {
    /**  . */
    private static final long serialVersionUID = 1L;
    /** List<FoodForm> . */
    private List<FoodForm> products;
    /** count int . */
    private int count;   // number of bought product
    /**totalMoney long . */
    private long total;      // paid money
    /**  . */
    private OrderBillForm order;
    /**
     */
    public ShoppingCart() {
        products = new ArrayList<FoodForm>();
        order = new OrderBillForm();
        count = 0;
        total = 0;
    }
    /**
     * [get Food By ID in shopping cart].
     * @param id        id of Food
     * @return          FoodForm
     */
    public FoodForm getFood(Long id) {
        for (FoodForm food : products) {
            if (food.getId().equals(id)) {
                return food;
            }
        }
        return null;
    }
    /**
     * [isEmpty].
     * @return          boolean
     */
    public boolean isEmpty() {
        if (products.isEmpty()) {
            return true;
        }
        return false;
    }
    /**
     * [size of Product List in Shopping].
     * @return  int
     */
    public int size() {
        int sum = 0;
        for (FoodForm food : products) {
                sum  = sum + food.getNumber();
            }
        count = sum;
        return count;
    }
    /**
     * [count sum of money].
     */
    public void sumMoney() {
        long sumMoney = 0;
        for (FoodForm food : products) {
            sumMoney  = sumMoney + food.getPrice() * food.getNumber();
        }
        this.total = sumMoney;
    }
    /**
     * [add Food into Shopping Cart].
     * @param food      FoodForm
     * @param number    int
     */
    public void addFood(FoodForm food, int number) {
        food.setSubTotal(food.getPrice() * number);
        food.setNumber(number);
        products.add(food);
    }
    /**
     * [remove Food into Shopping Cart].
     * @param id        Long
     */
    public void removeFood(Long id) {
       for (FoodForm food : products) {
           if (id == food.getId()) {
               //remove
               products.remove(food);
               //recount money
               sumMoney();
               break;
           }
       }
        if (!products.isEmpty()) {
            count = products.size();
        } else {
            count = 0;
        }
    }
    /**
     * [remove Food into Shopping Cart].
     * @param food          FoodForm
     * @return              boolean
     */
    public boolean removeFood(FoodForm food) {
       return products.remove(food);
     }
    /**
     * [updateNumberFood].
     * @param id        Long
     * @param number    int
     */
    public void updateNumberFood(Long  id, int number) {
        for (FoodForm food : products) {
            if (id == food.getId()) {
               food.setNumber(number);
               food.setSubTotal(number * food.getPrice());
            }
        }
    }
    /**
     * [getNumberFood].
     * @param id   Long
     * @return      int
     */
    public int getNumberFood(Long id) {
        for (FoodForm food : products) {
            if (id == food.getId()) {
              return food.getNumber();
            }
        }
        return 0;
    }
    /**
     * Get value of products.
     * @return the products
     */
    public List<FoodForm> getProducts() {
        return products;
    }
    /**
     * Set the value for products.
     * @param products the products to set
     */
    public void setProducts(List<FoodForm> products) {
        this.products = products;
    }
    /**
     * Get value of count.
     * @return the count
     */
    public int getCount() {
        return count;
    }
    /**
     * Set the value for count.
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    /**
     * Get value of total.
     * @return the total
     */
    public long getTotal() {
        return total;
    }
    /**
     * Set the value for total.
     * @param total the total to set
     */
    public void setTotal(long total) {
        this.total = total;
    }
    /**
     * Get value of bill.
     * @return the bill
     */
    /**
     * Get value of order.
     * @return the order
     */
    public OrderBillForm getOrder() {
        return order;
    }
    /**
     * Set the value for order.
     * @param order the order to set
     */
    public void setOrder(OrderBillForm order) {
        this.order = order;
    }

}
