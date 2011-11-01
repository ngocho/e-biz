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
package dto;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Thuy
 *
 */
@PersistenceCapable
public class CategoryProduct implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long categoryProductId;
    
    @Persistent
    private String  categoryProductName;
    
    /**
     * Get value of categoryProductId.
     * @return the categoryProductId
     */
    public Long getCategoryProductId() {
        return categoryProductId;
    }
    /**
     * Set the value for categoryProductId.
     * @param categoryProductId the categoryProductId to set
     */
    public void setCategoryProductId(Long categoryProductId) {
        this.categoryProductId = categoryProductId;
    }
    /**
     * Get value of categoryProductName.
     * @return the categoryProductName
     */
    public String getCategoryProductName() {
        return categoryProductName;
    }
    /**
     * Set the value for categoryProductName.
     * @param categoryProductName the categoryProductName to set
     */
    public void setCategoryProductName(String categoryProductName) {
        this.categoryProductName = categoryProductName;
    }
    

}
