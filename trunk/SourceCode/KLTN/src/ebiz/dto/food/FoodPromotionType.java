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
 * kiểu khuyến mãi
 * @author ThuyNT
 *
 */
@PersistenceCapable
public class FoodPromotionType implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String promotionType;
    @Persistent
    private String promotionName;
    /**
     * Get value of promotionType.
     * @return the promotionType
     */
    public String getPromotionType() {
        return promotionType;
    }
    /**
     * Set the value for promotionType.
     * @param promotionType the promotionType to set
     */
    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }
    /**
     * Get value of promotionName.
     * @return the promotionName
     */
    public String getPromotionName() {
        return promotionName;
    }
    /**
     * Set the value for promotionName.
     * @param promotionName the promotionName to set
     */
    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }
    
    

}