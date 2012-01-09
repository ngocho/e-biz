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

import org.apache.struts.validator.ValidatorForm;

import ebiz.blo.food.FoodBLO;
import ebiz.blo.provider.ProviderBLO;
import ebiz.dto.food.Food;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 *
 */
public class FoodForm extends ValidatorForm implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String productTypeId;
    private Long price;
    private Long promoPrice;
    private Integer reviewer;
    private String status;   // san pham da het, khuyen mai(id)
    private String statusName;  // hien thi name
    private Integer number;
    private String calo;
    private String idAttr;
    private String url;
    private String detail;
    private String cooking;
    private Long subTotal;
    private String nameProvider;
    private String idProvider;
    private String urlKey;
    public Food getFood(){
        Food food = new Food();
        food.setFoodName(this.name);
        food.setPrice(this.price);
        food.setUrl(this.url);
        food.setUrlKey(this.urlKey);
        food.setPricePromotion(this.promoPrice);
        food.setNumber(this.number);
        food.setDetail(this.detail);
        food.setCooking(this.cooking);
        food.setFoodTypeId(this.productTypeId);
        food.setProviderID(this.idProvider);
        food.setFoodStatusId(this.status);
        return food;
    }
    public void clear(){
        this.name ="";
        this.calo ="";
        this.cooking ="";
        this.detail ="";
        this.price = new Long(0);
        this.number =0;
        this.detail ="";
    
    }
    /**
     * 
     * @param food
     * @return
     */
    public FoodForm editForm(Food food){
        this.id = food.getFoodId();
        this.name = food.getFoodName();
        this.reviewer = food.getReviewer();
        this.url = food.getUrl();
        this.urlKey = food.getUrlKey();
        this.number = food.getNumber();
        this.productTypeId = food.getFoodTypeId();
        this.idProvider = food.getProviderID();
        this.nameProvider = ProviderBLO.getNameProviderByID(this.idProvider);
        this.status = food.getFoodStatusId();
        //het san pham
        if(food.getNumber()== 0){
            this.statusName = CommonConstant.STATUS_MESSAGE_0;
        }
        else
        {
            this.statusName = FoodBLO.getNameStatusById(this.status);
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
        this.idProvider = food.getProviderID();
        this.nameProvider = ProviderBLO.getNameProviderByID(this.idProvider);
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
    /**
     * Get value of nameProvider.
     * @return the nameProvider
     */
    public String getNameProvider() {
        return nameProvider;
    }
    /**
     * Set the value for nameProvider.
     * @param nameProvider the nameProvider to set
     */
    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }
    /**
     * Get value of idProvider.
     * @return the idProvider
     */
    public String getIdProvider() {
        return idProvider;
    }
    /**
     * Set the value for idProvider.
     * @param idProvider the idProvider to set
     */
    public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
    }
    /**
     * Get value of statusName.
     * @return the statusName
     */
    public String getStatusName() {
        return statusName;
    }
    /**
     * Set the value for statusName.
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    /**
     * Get value of idAttr.
     * @return the idAttr
     */
    public String getIdAttr() {
        return idAttr;
    }
    /**
     * Set the value for idAttr.
     * @param idAttr the idAttr to set
     */
    public void setIdAttr(String idAttr) {
        this.idAttr = idAttr;
    }
    /**
     * Get value of urlKey.
     * @return the urlKey
     */
    public String getUrlKey() {
        return urlKey;
    }
    /**
     * Set the value for urlKey.
     * @param urlKey the urlKey to set
     */
    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }
    
    
    

}
