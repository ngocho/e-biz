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
package ebiz.mobile.xu;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Administrator
 */
@PersistenceCapable
public class IDXU implements Serializable {
    /**  . */
    private static final long serialVersionUID = 1L;
    /**  . */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String id;
    /**  . */
    @Persistent
    private Long money;
    /**  . */
    @Persistent
    private String flag;

    /**
     * [Give the description for method].
     * @param flag String
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getFlag() {
        return flag;
    }
    /**
     * [Give the description for method].
     * @return String
     */
    public String getId() {
        return id;
    }
    /**
     * [Give the description for method].
     * @return Long
     */
    public Long getMoney() {
        return money;
    }
    /**
     * [Give the description for method].
     * @param mid String
     */
    public void setId(String mid) {
        this.id = mid;
    }
    /**
     * [Give the description for method].
     * @param mmoney Long
     */
    public void setMoney(Long mmoney) {
        this.money = mmoney;
    }
}
