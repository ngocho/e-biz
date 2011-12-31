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
 * phan loai mon an : xao, chien, canh,kho...
 */

@PersistenceCapable
public class FoodAttribute implements Serializable{


    private static final long serialVersionUID = 1L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String productAttributeId;
    
    @Persistent
    private String productAttributeName;
    
    /**
     * Get value of productAttributeId.
     * 
     * @return the productAttributeId
     */
    public String getProductAttributeId() {
        return productAttributeId;
    }
    /**
     * Set the value for productAttributeId.
     * 
     * @param productAttributeId the productAttributeId to set
     */
    public void setProductAttributeId(String productAttributeId) {
        this.productAttributeId = productAttributeId;
    }
    /**
     * Get value of productAttributeName.
     * 
     * @return the productAttributeName
     */
    public String getProductAttributeName() {
        return productAttributeName;
    }
    /**
     * Set the value for productAttributeName.
     * 
     * @param productAttributeName the productAttributeName to set
     */
    public void setProductAttributeName(String productAttributeName) {
        this.productAttributeName = productAttributeName;
    }

}
