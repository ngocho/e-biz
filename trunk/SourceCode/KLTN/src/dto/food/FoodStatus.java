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
package dto.food;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Thuy
 *
 */
/**
 * xac dinh status cua thuc pham : dang ban , khuyen mai,  het hsd, het hang,..
 */
@PersistenceCapable
public class FoodStatus implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long  foodStatusId;
    
    @Persistent
    private String foodStatusName;
    /**
     * Get value of foodStatusId.
     * @return the foodStatusId
     */
    public Long getFoodStatusId() {
        return foodStatusId;
    }
    /**
     * Set the value for foodStatusId.
     * @param foodStatusId the foodStatusId to set
     */
    public void setFoodStatusId(Long foodStatusId) {
        this.foodStatusId = foodStatusId;
    }
    /**
     * Get value of foodStatusName.
     * @return the foodStatusName
     */
    public String getFoodStatusName() {
        return foodStatusName;
    }
    /**
     * Set the value for foodStatusName.
     * @param foodStatusName the foodStatusName to set
     */
    public void setFoodStatusName(String foodStatusName) {
        this.foodStatusName = foodStatusName;
    }
    

}
