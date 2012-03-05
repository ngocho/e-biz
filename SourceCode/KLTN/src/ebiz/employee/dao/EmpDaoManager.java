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
package ebiz.employee.dao;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import ebiz.employee.dao.inf.IEmployeeDAO;
import ebiz.employee.dao.inf.IEmployeeTaskDAO;

import rocky.common.PropertiesManager;

/**
 * @author Thach.Le
 */
public abstract class EmpDaoManager {
    /** Logger. */
    private static Logger log = Logger.getLogger("EmpDaoManager");

    /** Singleton Dao Manager. */
    private static EmpDaoManager daoInstance = null;

    /**
     * Get the instance of DaoManager from the configuration.
     * @return instance of DaoManager
     */
    public static EmpDaoManager getInstance() {
        if (daoInstance == null) {
            try {
                Properties props = PropertiesManager.newInstanceFromProps("/app.properties");
                // get class of DaoManager implementation.
                String daoManagerImplClassName = props
                        .getProperty("EmpDaoManagerImpl", "ebiz.dao.gae.GAEEmpDaoManager");
                Class daoManagerClass = Class.forName(daoManagerImplClassName);
                daoInstance = (EmpDaoManager) daoManagerClass.newInstance();
            } catch (IOException ex) {
                log.log(Level.CONFIG, "Load configuration resource file /app.properties", ex);
            } catch (ClassNotFoundException ex) {
                log.log(Level.CONFIG, "Create class for EmpDaoManagerImpl in /app.properties", ex);
            } catch (InstantiationException ex) {
                log.log(Level.CONFIG, "Create instance for EmpDaoManagerImpl in /app.properties", ex);
            } catch (IllegalAccessException ex) {
                log.log(Level.CONFIG, "Create instance for EmpDaoManagerImpl in /app.properties", ex);
            }
        }

        return daoInstance;
    }

    /**
     * [Give the description for method].
     * @return
     */
    abstract public IEmployeeDAO getEmployeeDao();
    
    /**
     * [Give the description for method].
     * @return
     */
    abstract public IEmployeeTaskDAO getEmployeeTaskDao();
}
