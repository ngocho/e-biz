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
package ebiz.dto.food;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author ThuyNT
 *
 */

@PersistenceCapable
public class Food  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long foodId;
    @Persistent
    private String foodName;
    @Persistent
    private String foodPriceLevelId;
    @Persistent
    private String productAttributeId;
    @Persistent
    private String foodStatusId;
    @Persistent
    private String foodTypeId;
    @Persistent
    private Date startDate;
    @Persistent
    private Date expDate;
    @Persistent
    private Integer number;
    @Persistent
    private Integer numberOrder;
    @Persistent
    private String detail;
    @Persistent
    private String cooking;
    @Persistent
    private String calo;
    @Persistent
    private Long price;
    @Persistent
    private Long pricePromotion;
    @Persistent
    private String providerID;  //nha cung cap
    @Persistent
    private String url;   //luu duong dan hinh anh
    @Persistent
    private String urlKey;   //luu duong dan hinh anh
    @Persistent
    private Integer reviewer;
    @Persistent
    private Integer uploadDate;
    @Persistent
    private Integer isDisplay;
    /**
     * Get value of foodId.
     * @return the foodId
     */
    public Long getFoodId() {
        return foodId;
    }
    /**
     * Set the value for foodId.
     * @param foodId the foodId to set
     */
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
    /**
     * Get value of foodName.
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }
    /**
     * Set the value for foodName.
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    /**
     * Get value of foodPriceLevelId.
     * @return the foodPriceLevelId
     */
    public String getFoodPriceLevelId() {
        return foodPriceLevelId;
    }
    /**
     * Set the value for foodPriceLevelId.
     * @param foodPriceLevelId the foodPriceLevelId to set
     */
    public void setFoodPriceLevelId(String foodPriceLevelId) {
        this.foodPriceLevelId = foodPriceLevelId;
    }
    /**
     * Get value of productAttributeId.
     * @return the productAttributeId
     */
    public String getProductAttributeId() {
        return productAttributeId;
    }
    /**
     * Set the value for productAttributeId.
     * @param productAttributeId the productAttributeId to set
     */
    public void setProductAttributeId(String productAttributeId) {
        this.productAttributeId = productAttributeId;
    }
    /**
     * Get value of foodStatusId.
     * @return the foodStatusId
     */
    public String getFoodStatusId() {
        return foodStatusId;
    }
    /**
     * Set the value for foodStatusId.
     * @param foodStatusId the foodStatusId to set
     */
    public void setFoodStatusId(String foodStatusId) {
        this.foodStatusId = foodStatusId;
    }
    /**
     * Get value of productTypeId.
     * @return the productTypeId
     */
    public String getFoodTypeId() {
        return foodTypeId;
    }
    /**
     * Set the value for productTypeId.
     * @param productTypeId the productTypeId to set
     */
    public void setFoodTypeId(String foodTypeId) {
        this.foodTypeId = foodTypeId;
    }
    /**
     * Get value of startDate.
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * Set the value for startDate.
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * Get value of expDate.
     * @return the expDate
     */
    public Date getExpDate() {
        return expDate;
    }
    /**
     * Set the value for expDate.
     * @param expDate the expDate to set
     */
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
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
     * Get value of providerID.
     * @return the providerID
     */
    public String getProviderID() {
        return providerID;
    }
    /**
     * Set the value for providerID.
     * @param providerID the providerID to set
     */
    public void setProviderID(String providerID) {
        this.providerID = providerID;
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
     * Get value of numberOrder.
     * @return the numberOrder
     */
    public Integer getNumberOrder() {
        return numberOrder;
    }
    /**
     * Set the value for numberOrder.
     * @param numberOrder the numberOrder to set
     */
    public void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }
    /**
     * Get value of pricePromotion.
     * @return the pricePromotion
     */
    public Long getPricePromotion() {
        return pricePromotion;
    }
    /**
     * Set the value for pricePromotion.
     * @param pricePromotion the pricePromotion to set
     */
    public void setPricePromotion(Long pricePromotion) {
        this.pricePromotion = pricePromotion;
    }
    /**
     * Get value of uploadDate.
     * @return the uploadDate
     */
    public Integer getUploadDate() {
        return uploadDate;
    }
    /**
     * Set the value for uploadDate.
     * @param uploadDate the uploadDate to set
     */
    public void setUploadDate(Integer uploadDate) {
        this.uploadDate = uploadDate;
    }
    /**
     * Get value of isDisplay.
     * @return the isDisplay
     */
    public Integer getIsDisplay() {
        return isDisplay;
    }
    /**
     * Set the value for isDisplay.
     * @param isDisplay the isDisplay to set
     */
    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
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
