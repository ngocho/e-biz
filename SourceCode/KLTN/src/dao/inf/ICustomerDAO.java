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
package ebiz.dao.inf;

import java.util.List;

import ebiz.dto.account.customer.Customer;

/**
 * @author ThuyNT
 *
 */
public interface ICustomerDAO {
    /**
     * 
     * kiem tra su ton tai cua Customer , neu chua co thi insert
     * @param customer
     * @return 
     */
    public boolean insertCustomer(Customer customer );
    
    public boolean isCustomer(String id );
        
    /**
     * dua vao thong tin dang nhap : username, pass lay thong tin cua customer
     * @param loginId
     * @param loginPassword
     * @return
     */
    public Customer getCustomerById(String id);
    public int isCustomerID(String id, String pass);
    public int isCustomerMail(String email, String pass);
//    public Customer getCustomerList(String customerService);
    public List<String> getPhoneList();
    

}
