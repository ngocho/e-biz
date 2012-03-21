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
package ebiz.dao.gae;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import ebiz.dao.inf.ICustomerDAO;
import ebiz.dto.account.customer.Assessment;
import ebiz.dto.account.customer.Comment;
import ebiz.dto.account.customer.Customer;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class CustomerDAO implements ICustomerDAO {

    @Override
    public boolean saveCustomer(Customer customer) {

        return PMF.insertObject(customer);
    }
    @Override
    public boolean saveComment(Comment comment) {

        return PMF.insertObject(comment);
    }
    @Override
    public boolean saveAss(Assessment content) {

        return PMF.insertObject(content);
    }

    @Override
    public Assessment getAssByID(String id) {

        Assessment ass = (Assessment) PMF.getObjectById(Assessment.class, id);
        return ass;

    }

    @Override
    public boolean isCustomer(String id) {

        return PMF.isObject(Customer.class, id);

    }

    @Override
    public Customer getCustomerById(String id) {

        Customer customer = null;
        customer = (Customer) PMF.getObjectById(Customer.class, id);
        return customer;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getCustomerList() {

        List<Customer> customerList = new ArrayList<Customer>();
        customerList = (List<Customer>) PMF.getObjectList(Customer.class);
        return customerList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Assessment> getAssList() {

        List<Assessment> assList = new ArrayList<Assessment>();
        assList = (List<Assessment>) PMF.getObjectList(Assessment.class);
        return assList;
    }
}
