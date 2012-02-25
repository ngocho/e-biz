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
package ebiz.dto.checkout;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Administrator 1 : Hóa đơn chưa thanh toán 2 : Hóa đơn chưa nhận hàng 3 : Hóa đơn đã thanh toán 4 : Hóa đơn đã
 *         nhận hàng
 */
@PersistenceCapable
public class DetailOrder implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    @Persistent
    private Long idProduct;
    @Persistent
    private String name;
    @Persistent
    private Integer number;
    @Persistent
    private Long subPrice;
    @Persistent
    private Long orderId;
    /**
     * Get value of id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the value for id.
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get value of idProduct.
     * 
     * @return the idProduct
     */
    public Long getIdProduct() {
        return idProduct;
    }
    /**
     * Set the value for idProduct.
     * 
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
    /**
     * Get value of name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Set the value for name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get value of number.
     * 
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }
    /**
     * Set the value for number.
     * 
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
     * Get value of subPrice.
     * 
     * @return the subPrice
     */
    public Long getSubPrice() {
        return subPrice;
    }
    /**
     * Set the value for subPrice.
     * 
     * @param subPrice the subPrice to set
     */
    public void setSubPrice(Long subPrice) {
        this.subPrice = subPrice;
    }
    /**
     * Get value of orderId.
     * 
     * @return the orderId
     */
    public Long getOrderId() {
        return orderId;
    }
    /**
     * Set the value for orderId.
     * 
     * @param orderId the orderId to set
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
