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

import java.util.ArrayList;
import java.util.List;



/**
 * @author Administrator
 *
 */
public class ShoppingCart implements java.io.Serializable{
    /**  . */
    private static final long serialVersionUID = 1L;
   
    private LoginForm user;
    private List<FoodForm> products;
    private Integer count;   // number of bought product
    private Long total;      // paid money
    
    public ShoppingCart(LoginForm user){
        this.user = user;
    }
    public ShoppingCart(){
        products = new ArrayList<FoodForm>();
        user = new LoginForm();
        count = 0;
       
    }
    
    public boolean isEmpty(){
        if(products.isEmpty()){
            return true;
        }
        return false;
    }
    
    public int size(){
        int sum =0;
        for(FoodForm food :products ){
                sum  = sum + food.getNumber();
            }
        count = sum;
        return count;
    }
    /**
     * add food into shop
     * @param food
     * @param number
     */
    public void addFood(FoodForm food, Integer number){
        food.setSubTotal(food.getPrice()* number);
        food.setNumber(number);
        products.add(food);
    }
    /**
     * 
     * remove food in shop
     * @param id
     */
    public void removeFood(Long id){
       for(FoodForm food :products ){
           if(id == food.getId()){
               products.remove(food);
           }
       }
        count = products.size();
    }
    /**
     * increase number of product if exist in shop
     * @param id
     * @param number
     */
    public void updateNumberFood(Long  id, Integer number){
        for(FoodForm food :products ){
            if(id == food.getId()){
               food.setNumber(number);
               food.setSubTotal(number*food.getPrice());
            }
        }
    }
    public Integer getNumberFood(Long id){
        for(FoodForm food :products ){
            if(id == food.getId()){
              return food.getNumber();
            }
        }
        return 0;
    }
    /**
     * Get value of user.
     * @return the user
     */
    public LoginForm getUser() {
        return user;
    }
    /**
     * Set the value for user.
     * @param user the user to set
     */
    public void setUser(LoginForm user) {
        this.user = user;
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
    public Integer getCount() {
        return count;
    }
    /**
     * Set the value for count.
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }
    /**
     * Get value of total.
     * @return the total
     */
    public Long getTotal() {
        return total;
    }
    /**
     * Set the value for total.
     * @param total the total to set
     */
    public void setTotal(Long total) {
        this.total = total;
    }
    /**
     * Get value of bill.
     * @return the bill
     */

}
