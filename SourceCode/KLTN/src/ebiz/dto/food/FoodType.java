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
 */

/**
 * xac dinh loai thuc pham: rau xanh, sơ chế, nấu sẵn,..
 * 1 : prepared food
 * 2 : cooked food
 * 3 : vegetable
 */
@PersistenceCapable
public class FoodType implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String productTypeId;
   
    @Persistent
    private String productTypeName;
   
    /**
     * Get value of productTypeId.
     * 
     * @return the productTypeId
     */
    public String getProductTypeId() {
        return productTypeId;
    }
    /**
     * Set the value for productTypeId.
     * 
     * @param productTypeId the productTypeId to set
     */
    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }
    /**
     * Get value of productTypeName.
     * 
     * @return the productTypeName
     */
    public String getProductTypeName() {
        return productTypeName;
    }
    /**
     * Set the value for productTypeName.
     * 
     * @param productTypeName the productTypeName to set
     */
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

}
