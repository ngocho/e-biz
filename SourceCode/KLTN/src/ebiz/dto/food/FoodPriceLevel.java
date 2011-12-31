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

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author ThuyNT
 *
 */

/**
 * chia thanh nhieu muc tien khac nhau
 */
@PersistenceCapable
public class FoodPriceLevel  implements Serializable{

    /**  . */
    private static final long serialVersionUID = 1L;
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String  foodPriceLevelId;
    @Persistent
    private Long startPrice;
    @Persistent
    private Long endPrice;
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
     * Get value of startPrice.
     * @return the startPrice
     */
    public Long getStartPrice() {
        return startPrice;
    }
    /**
     * Set the value for startPrice.
     * @param startPrice the startPrice to set
     */
    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }
    /**
     * Get value of endPrice.
     * @return the endPrice
     */
    public Long getEndPrice() {
        return endPrice;
    }
    /**
     * Set the value for endPrice.
     * @param endPrice the endPrice to set
     */
    public void setEndPrice(Long endPrice) {
        this.endPrice = endPrice;
    }
    
    

}
