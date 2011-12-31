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

import ebiz.dao.inf.ICommonDAO;
import ebiz.dto.DetailOrder;
import ebiz.dto.OrderBill;

/**
 * @author ThuyNT
 *
 */
public class CommonDAO implements ICommonDAO {
    
    public OrderBill save(OrderBill order ){
        
        return (OrderBill)PMF.save(order);
        
    }
        public boolean insertDetailOrder(DetailOrder order){
        
        return PMF.insertObject(order);
        
    }
        public OrderBill getOrderBillById(Long id){
            return (OrderBill)PMF.getObjectById(OrderBill.class, id);
            
        }
        @SuppressWarnings("unchecked")
        public List<DetailOrder> getDetailOrderList(Long  id){
            String key = String.valueOf(id);
            return (List<DetailOrder>)PMF.getObjectListByValue(DetailOrder.class, "orderId", key);
        }
        /**
         * [Explain the description for this method here].
         * @param id
         * @return
         */
        @Override
        public boolean deleteDetailOrderList(List<DetailOrder> list) {
           return PMF.deleteAll(list);
            
        }
        /**
         * [Explain the description for this method here].
         * @param id
         * @return
         */
        @Override
        public boolean deleteDetailOrder(DetailOrder  item) {
            return PMF.delete(item);
        }
        
}