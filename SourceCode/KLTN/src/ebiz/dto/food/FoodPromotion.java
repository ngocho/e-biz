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

import com.google.appengine.repackaged.com.google.common.base.Flag.Date;

/**
 * @author ThuyNT
 *
 */
public class FoodPromotion {
    private String productPromotionTypeId;
    private String productPromotionTypeName;
    private String productId;
    private String productName;
    private Long pricePromo;
    private Long price;
    private Date expPromo;
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
     * Get value of productId.
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }
    /**
     * Set the value for productId.
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
    
}
