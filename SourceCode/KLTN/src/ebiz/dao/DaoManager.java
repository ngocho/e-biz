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
package ebiz.dao;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import rocky.common.PropertiesManager;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dao.inf.IProviderDAO;

/**
 * @author thachln
 */
public abstract class DaoManager {
    /** Logger. */
    private static Logger log = Logger.getLogger("DaoManager");

    /** Singleton Dao Manager. */
    private static DaoManager daoInstance = null;

    /**
     * Get the instance of DaoManager from the configuration.
     * @return instance of DaoManager
     */
    public static DaoManager getInstance() {
        if (daoInstance == null) {
            try {
                Properties props = PropertiesManager.newInstanceFromProps("/app.properties");
                // get class of DaoManager implementation.
                String daoManagerImplClassName = props.getProperty("DaoManagerImpl",
                        "ebiz.dao.gae.GAEDAOManager");
                Class daoManagerClass = Class.forName(daoManagerImplClassName);
                daoInstance = (DaoManager) daoManagerClass.newInstance();
            } catch (IOException ex) {
                log.log(Level.CONFIG, "Load configuration resource file /app.properties", ex);
            } catch (ClassNotFoundException ex) {
                log.log(Level.CONFIG, "Create class for DaoManagerImpl in /app.properties", ex);
            } catch (InstantiationException ex) {
                log.log(Level.CONFIG, "Create instance for DaoManagerImpl in /app.properties", ex);
            } catch (IllegalAccessException ex) {
                log.log(Level.CONFIG, "Create instance for DaoManagerImpl in /app.properties", ex);
            }
        }

        return daoInstance;
    }

    /**
     * Get implementer of Admin Dao.
     * @return implementor of IAdminDAO
     */
    public abstract IAdminDAO getAdminDao();

    /**
     * [Give the description for method].
     * @return implementor of CustomerDAO
     */
    public abstract ICustomerDAO getCustomerDao();

    /**
     * [Give the description for method].
     * @return implementor of IFoodDAO
     */
    public abstract IFoodDAO getFoodDao();

    /**
     * [Give the description for method].
     * @return implementor of IProviderDAO
     */
    public abstract IProviderDAO getProviderDao();

    /**
     * [Give the description for method].
     * @return implementor of IOrderDAO
     */
    public abstract IOrderDAO getOrderDao();
}
