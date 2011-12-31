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

import java.util.List;

/**
 * @author ThuyNT
 *
 */
public class ProductVO {
    
    //number of record/page
    private Integer limit ;
    
    //name of col to set order by
    private String col;
    
    //number of page
    private Integer  page;
    
    //save pagin
    private List<Paging> pagingList;

    /**
     * Get value of limit.
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Set the value for limit.
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Get value of col.
     * @return the col
     */
    public String getCol() {
        return col;
    }

    /**
     * Set the value for col.
     * @param col the col to set
     */
    public void setCol(String col) {
        this.col = col;
    }

    /**
     * Get value of page.
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Set the value for page.
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Get value of pagingList.
     * @return the pagingList
     */
    public List<Paging> getPagingList() {
        return pagingList;
    }

    /**
     * Set the value for pagingList.
     * @param pagingList the pagingList to set
     */
    public void setPagingList(List<Paging> pagingList) {
        this.pagingList = pagingList;
    }

}
