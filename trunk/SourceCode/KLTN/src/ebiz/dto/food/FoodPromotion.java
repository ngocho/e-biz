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
public class FoodPromotion implements Serializable{
   
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long productId;
    @Persistent
    private String productPromotionTypeName;
    @Persistent
    private String productPromotionTypeId;
    @Persistent
    private String productName;
    @Persistent
    private Long pricePromo;
    @Persistent
    private Long price;
    @Persistent
    private Date expPromo;
    @Persistent
    private String calo;
    @Persistent
    private String detail;
    @Persistent
    private String cooking;
    @Persistent
    private String url;
    @Persistent
    private Integer number;
    @Persistent
    private Integer reviewer;
   
    /**
     * Get value of productId.
     * @return the productId
     */
    public Long getProductId() {
        return productId;
    }
    /**
     * Set the value for productId.
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    /**
     * Get value of productPromotionTypeName.
     * @return the productPromotionTypeName
     */
    public String getProductPromotionTypeName() {
        return productPromotionTypeName;
    }
    /**
     * Set the value for productPromotionTypeName.
     * @param productPromotionTypeName the productPromotionTypeName to set
     */
    public void setProductPromotionTypeName(String productPromotionTypeName) {
        this.productPromotionTypeName = productPromotionTypeName;
    }
    /**
     * Get value of productPromotionTypeId.
     * @return the productPromotionTypeId
     */
    public String getProductPromotionTypeId() {
        return productPromotionTypeId;
    }
    /**
     * Set the value for productPromotionTypeId.
     * @param productPromotionTypeId the productPromotionTypeId to set
     */
    public void setProductPromotionTypeId(String productPromotionTypeId) {
        this.productPromotionTypeId = productPromotionTypeId;
    }
    /**
     * Get value of productName.
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Set the value for productName.
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    /**
     * Get value of pricePromo.
     * @return the pricePromo
     */
    public Long getPricePromo() {
        return pricePromo;
    }
    /**
     * Set the value for pricePromo.
     * @param pricePromo the pricePromo to set
     */
    public void setPricePromo(Long pricePromo) {
        this.pricePromo = pricePromo;
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
     * Get value of expPromo.
     * @return the expPromo
     */
    public Date getExpPromo() {
        return expPromo;
    }
    /**
     * Set the value for expPromo.
     * @param expPromo the expPromo to set
     */
    public void setExpPromo(Date expPromo) {
        this.expPromo = expPromo;
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
    
}
