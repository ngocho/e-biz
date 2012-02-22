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

import java.util.List;

import ebiz.dao.inf.IProviderDAO;
import ebiz.dto.account.provider.Provider;

/**
 * @author Administrator
 *
 */
public class ProviderDAO implements IProviderDAO{

    /**
     * [Explain the description for this method here].
     * @param provider
     * @return
     * @see ebiz.dao.inf.IProviderDAO#saveProvider(ebiz.dto.account.provider.Provider)
     */
    @Override
    public boolean saveProvider(Provider provider) {
        // TODO Auto-generated method stub
        return PMF.insertObject(provider);
    }

    /**
     * [Explain the description for this method here].
     * @param id
     * @return
     * @see ebiz.dao.inf.IProviderDAO#isProvider(java.lang.String)
     */
    @Override
    public boolean isProvider(String id) {
        return PMF.isObject(Provider.class, id);
    }

    /**
     * [Explain the description for this method here].
     * @param id
     * @return
     * @see ebiz.dao.inf.IProviderDAO#getProviderById(java.lang.String)
     */
    @Override
    public Provider getProviderById(String id) {
        Provider provider = null;
        provider = (Provider)PMF.getObjectById(Provider.class, id);
        return provider;
    }

    /**
     * [Explain the description for this method here].
     * @return
     * @see ebiz.dao.inf.IProviderDAO#getProviderAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Provider> getProviderAll() {
        return (List<Provider>)PMF.getObjectList(Provider.class);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Provider> getProviderByName(String value) {
        return  (List<Provider>)PMF.searchListProviderByName(Provider.class, value);
        
    }
}
