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
package ebiz.form;

import java.io.Serializable;
import java.util.List;

/**
 * @author ThuyNT
 */
public class ProductVO implements Serializable {
    /** . */
    private static final long serialVersionUID = 1L;

    /** number of record/page. */
    private int limit;
    /** name of col to set order by. */
    private String col;
    /** number of page. */
    private int page;
    /** . */
    private String order;
    /** . */
    private List<String> pagingList;
    /** . */
    private String typeProduct;
    /** . */
    private String numberFoodView;
    /** . */
    private String status;
    /** . */
    private String priceId;
    /** . */
    private String attr;

    /**
     * Get value of limit.
     * 
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Set the value for limit.
     * 
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Get value of col.
     * 
     * @return the col
     */
    public String getCol() {
        return col;
    }

    /**
     * Set the value for col.
     * 
     * @param col the col to set
     */
    public void setCol(String col) {
        this.col = col;
    }

    /**
     * Get value of page.
     * 
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Set the value for page.
     * 
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Get value of pagingList.
     * 
     * @return the pagingList
     */
    public List<String> getPagingList() {
        return pagingList;
    }

    /**
     * Set the value for pagingList.
     * 
     * @param pagingList the pagingList to set
     */
    public void setPagingList(List<String> pagingList) {
        this.pagingList = pagingList;
    }

    /**
     * Get value of typeProduct.
     * 
     * @return the typeProduct
     */
    public String getTypeProduct() {
        return typeProduct;
    }

    /**
     * Set the value for typeProduct.
     * 
     * @param typeProduct the typeProduct to set
     */
    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    /**
     * Get value of numberFoodView.
     * 
     * @return the numberFoodView
     */
    public String getNumberFoodView() {
        return numberFoodView;
    }

    /**
     * Set the value for numberFoodView.
     * 
     * @param numberFoodView the numberFoodView to set
     */
    public void setNumberFoodView(String numberFoodView) {
        this.numberFoodView = numberFoodView;
    }

    /**
     * Get value of order.
     * 
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * Set the value for order.
     * 
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * Get value of status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value for status.
     * 
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get value of priceId.
     * 
     * @return the priceId
     */
    public String getPriceId() {
        return priceId;
    }

    /**
     * Set the value for priceId.
     * 
     * @param priceId the priceId to set
     */
    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    /**
     * Get value of attr.
     * 
     * @return the attr
     */
    public String getAttr() {
        return attr;
    }

    /**
     * Set the value for attr.
     * 
     * @param attr the attr to set
     */
    public void setAttr(String attr) {
        this.attr = attr;
    }

}
