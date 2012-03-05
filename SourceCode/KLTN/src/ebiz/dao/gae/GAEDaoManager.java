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

import ebiz.dao.DaoManager;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dao.inf.IProviderDAO;

/**
 * @author Thach.Le
 */
public class GAEDaoManager extends DaoManager {

    @Override
    public IAdminDAO getAdminDao() {
        return new AdminDAO();
    }

    @Override
    public ICustomerDAO getCustomerDao() {
        return new CustomerDAO();
    }

    @Override
    public IFoodDAO getFoodDao() {
        return new FoodDAO();
    }

    @Override
    public IProviderDAO getProviderDao() {
        return new ProviderDAO();
    }

    @Override
    public IOrderDAO getOrderDao() {
        return new OrderDAO();
    }

}
