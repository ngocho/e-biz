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
package mobile.ebiz.dto;
import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * @author Administrator
 */
@PersistenceCapable
public class USERXUHISTORY implements Serializable {
    /**  . */
    private static final long serialVersionUID = 1L;
    /**  . */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    /**  . */
    @Persistent
    private String idXu;
    /**  . */
    @Persistent
    private String idCustomer;
    /**  . */
    @Persistent
    private Long money;
    /**  . */
    @Persistent
    private Date addXu;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the idXu
     */
    public String getIdXu() {
        return idXu;
    }
    /**
     * @param idXu the idXu to set
     */
    public void setIdXu(String idXu) {
        this.idXu = idXu;
    }
    /**
     * @return the money
     */
    public Long getMoney() {
        return money;
    }
    /**
     * @param money the money to set
     */
    public void setMoney(Long money) {
        this.money = money;
    }
    /**
     * @return the addXu
     */
    public Date getAddXu() {
        return addXu;
    }
    /**
     * @param addXu the addXu to set
     */
    public void setAddXu(Date addXu) {
        this.addXu = addXu;
    }
    /**
     * @return the idCustomer
     */
    public String getIdCustomer() {
        return idCustomer;
    }
    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

}
