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

import ebiz.dto.account.customer.Assessment;
import ebiz.dto.account.customer.Comment;
import ebiz.dto.account.customer.Customer;

/**
 * Interface for CRUD of Customer entity.
 *
 * @author ThuyNT17, thachln
 */
public interface ICustomerDAO {

    /**
     * Store the customer into the persistence layer.
     *
     * @param customer Customer entity
     * @return true if success. Otherwise, return false and details of exception (if occur) is in logging file.
     */
    boolean saveCustomer(Customer customer);

    /**
     * [saveComment].
     * @param comment Comment
     * @return boolean
     */
    boolean saveComment(Comment comment);

    /**
     * [saveAss].
     * @param content Assessment
     * @return boolean
     */
    boolean saveAss(Assessment content);
    /**
     * [getAssByID].
     * @param id String
     * @return Assessment
     */
    Assessment getAssByID(String id);
    /**
     * [isCustomer].
     * @param id String
     * @return boolean
     */
    boolean isCustomer(String id);

    /**
     * [getCustomerById].
     * @param id String
     * @return Customer
     */
    Customer getCustomerById(String id);

    /**
     * [getPhoneList].
     * @return List<String>
     */
    List<String> getPhoneList();

    /**
     * [getCustomerList].
     * @return List<Customer>
     */
    List<Customer> getCustomerList();
    /**
     * [getAssList].
     * @return List<Assessment>
     */
    List<Assessment> getAssList();

}
