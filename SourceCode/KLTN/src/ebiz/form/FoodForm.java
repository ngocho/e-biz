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

import ebiz.dto.food.Food;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 *
 */
public class FoodForm {
    
    private Long id;
    private String name;
    private String productTypeId;
    private Long price;
    private Long promoPrice;
    private Integer reviewer;
    private String status;   // san pham da het, khuyen mai
    private Integer number;
    private String calo;
    private String url;
    private String detail;
    private String cooking;
    private Long subTotal;
    
    /**
     * 
     * san pham dang ban
     * @param food
     * @return
     */
    public FoodForm editForm(Food food){
        this.id = food.getFoodId();
        this.name = food.getFoodName();
        this.reviewer = food.getReviewer();
        this.url = food.getUrl();
        this.number = food.getNumber();
        this.productTypeId = food.getFoodTypeId();
        //het san pham
        if(food.getNumber()== 0){
            this.status = CommonConstant.STATUS_MESSAGE_0;
        }
        else
        {
            this.price = food.getPrice();
            this.promoPrice = food.getPricePromotion();
        }
        
        return this;
        
    }
//    /**
//     * 
//     * san pham dang khuyen mai
//     * @param food
//     * @return
//     */
//    public FoodForm editForm(FoodPromotion food){
//        if(food!=null){
//        this.id = food.getProductId();
//        this.name = food.getProductName();
//        this.reviewer = food.getReviewer();
//        this.price = food.getPrice();
//        this.promoPrice = food.getPricePromo();
//        this.url = food.getUrl();
//        this.number = food.getNumber();
//        }
//        return this;
//    }
//    /**
//     * 
//     * san pham dang khuyen mai (detail)
//     * @param food
//     * @return
//     */
//    public FoodForm editFormDetail(FoodPromotion food){
//        if(food!=null){
//        this.id = food.getProductId();
//        this.name = food.getProductName();
//        this.reviewer = food.getReviewer();
//        this.price = food.getPrice();
//        this.promoPrice = food.getPricePromo();
//        this.calo = food.getCalo();
//        this.url = food.getUrl();
//        this.detail = food.getDetail();
//        this.cooking = food.getCooking();
//        }
//        return this;
//    }
    /**
     * 
     * san pham dang khuyen mai (detail)
     * @param food
     * @return
     */
    public FoodForm editFormDetail(Food food){
        this.id = food.getFoodId();
        this.name = food.getFoodName();
        this.reviewer = food.getReviewer();
        this.url = food.getUrl();
        this.number = food.getNumber();
        this.calo = food.getCalo();
        this.detail = food.getDetail();
        this.cooking = food.getCooking();
        this.productTypeId = food.getFoodTypeId();
        //het san pham
        if(food.getNumber()== 0){
            this.status = CommonConstant.STATUS_MESSAGE_0;
        }
        else
        {
            this.price = food.getPrice();
            this.promoPrice = food.getPricePromotion();
        }
        
        return this;
        
    }
    
    
    public boolean isEmpty() {
        if(id == null){
            return true;
        }
        else{
            return false;
        }
    }
   
    /**
     * Get value of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get value of name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Set the value for name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get value of reviewer.
     * @return the reviewer
     */
    public Integer getReviewer() {
        return reviewer;
    }
    /**
     * Set the value for reviewer.
     * @param reviewer the reviewer to set
     */
    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }
    /**
     * Get value of price.
     * @return the price
     */
    public Long getPrice() {
        return price;
    }
    /**
     * Set the value for price.
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }
    /**
     * Get value of promoPrice.
     * @return the promoPrice
     */
    public Long getPromoPrice() {
        return promoPrice;
    }
    /**
     * Set the value for promoPrice.
     * @param promoPrice the promoPrice to set
     */
    public void setPromoPrice(Long promoPrice) {
        this.promoPrice = promoPrice;
    }
    /**
     * Get value of status.
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Get value of number.
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }
    /**
     * Set the value for number.
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
        
    }
    /**
     * Get value of calo.
     * @return the calo
     */
    public String getCalo() {
        return calo;
    }
    /**
     * Set the value for calo.
     * @param calo the calo to set
     */
    public void setCalo(String calo) {
        this.calo = calo;
    }
    /**
     * Get value of url.
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * Set the value for url.
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Get value of detail.
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }
    /**
     * Set the value for detail.
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
    /**
     * Get value of cooking.
     * @return the cooking
     */
    public String getCooking() {
        return cooking;
    }
    /**
     * Set the value for cooking.
     * @param cooking the cooking to set
     */
    public void setCooking(String cooking) {
        this.cooking = cooking;
    }
    /**
     * Get value of subTotal.
     * @return the subTotal
     */
    public Long getSubTotal() {
        subTotal =price * number;
        return subTotal;
    }
    /**
     * Set the value for subTotal.
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }
    /**
     * Get value of productTypeId.
     * @return the productTypeId
     */
    public String getProductTypeId() {
        return productTypeId;
    }
    /**
     * Set the value for productTypeId.
     * @param productTypeId the productTypeId to set
     */
    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }
    
    
    

}
