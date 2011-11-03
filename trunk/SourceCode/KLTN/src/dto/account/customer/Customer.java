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
package ebiz.dto.account.customer;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Extension;   

/**
 * @author ThuyNT
 *
 */
@PersistenceCapable
public class Customer implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    
    //ten dang nhap
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String customerId;
    private String customerPassword;
    private String customerName;
    private String customerGender;
    private Integer customerAge; 
    private String customerEmail;           //bat buoc
    private String customerPhone;
    private String customerAddress;
    private String customerType;            // khach hang binh thuong, thanh vien, vip
    private String customerService;
    private Long customerSumMoney;
    private Integer customerMark;           //tich luy diem

}
