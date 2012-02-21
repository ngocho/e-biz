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
import java.util.Date;
import java.util.List;

import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.OrderStatus;
import ebiz.dto.checkout.VoucherBill;

/**
 * @author ThuyNT
 *
 */
public class OrderDAO implements IOrderDAO {
    
    public OrderBill save(OrderBill order ){
        
        return (OrderBill)PMF.save(order);
        
    }
    
    @Override
    public VoucherBill saveVoucherBill(VoucherBill voucher) {

        return (VoucherBill)PMF.save(voucher);

    }
    @Override
    public  VoucherBill getVoucherByID(Long idVoucher) {

        return (VoucherBill)PMF.getObjectById(VoucherBill.class, idVoucher);

    }
        public boolean insertDetailOrder(DetailOrder order){
        
        return PMF.insertObject(order);
        
    }
        public OrderBill getOrderBillById(Long id){
            return (OrderBill)PMF.getObjectById(OrderBill.class, id);
            
        }
//        @SuppressWarnings("unchecked")
//        public List<DetailOrder> getDetailOrderList(Long  id){
//            String key = String.valueOf(id);
//            return (List<DetailOrder>)PMF.getObjectListByValue(DetailOrder.class, "orderId", key);
//        }
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
        /**
         * get list order bill by id customer
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<OrderBill> getOrListByIDCustomer(String idCustomer){
        	
        	List<OrderBill> orderList = new ArrayList<OrderBill>();
        	orderList = (List<OrderBill>)PMF.getObjectListByValue(OrderBill.class, "idCustomer", idCustomer);
        	return orderList;
        	
        }
        /**
         * get List order detail by Id order
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<DetailOrder> getDetailByIDOrBill(Long id){
        	List<DetailOrder> orderList = new ArrayList<DetailOrder>();
        	orderList = (List<DetailOrder>)PMF.getObjectListByValue(DetailOrder.class, "orderId", id);
        	return orderList;
        }
        /**
         * get List order bill by Id employee
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<OrderBill> getOrListByIDEmployee(String idEmployee){
        	List<OrderBill> orderList = new ArrayList<OrderBill>();
        	orderList = (List<OrderBill>)PMF.getObjectListByValue(OrderBill.class, "idEmployee", idEmployee);
        	return orderList;
        }
        /**
         * get List order bill by Id employee
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<OrderBill> getOrListByStatus(String userID, String status){
            List<OrderBill> orderList = new ArrayList<OrderBill>();
            orderList = (List<OrderBill>)PMF.getObjectListByTwoValues(OrderBill.class,"idCustomer",userID, "status", status);
            return orderList;
        }
        /**
         * get List order bill by Id employee
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<OrderBill> getOrderList(){
            List<OrderBill> orderList = new ArrayList<OrderBill>();
            orderList = (List<OrderBill>)PMF.getObjectList(OrderBill.class);
            return orderList;
        }
        /**
         * [Explain the description for this method here].
         * @param id
         * @return
         * @see ebiz.dao.inf.IOrderDAO#getOrderStatusById(java.lang.String)
         */
        @Override
        public String getOrderStatusById(String id) {
            OrderStatus orderStatus ;
            orderStatus = (OrderStatus)PMF.getObjectById(OrderStatus.class, id);
            if(orderStatus != null){
                return orderStatus.getName();
            }
            return null;
        }
        @SuppressWarnings("unchecked")
        @Override
        public List<OrderBill> getOrderListByStatus(String idStatus) {
            List<OrderBill> orderList = new ArrayList<OrderBill>();
            orderList = (List<OrderBill>)PMF.getObjectListByValue(OrderBill.class, "status", idStatus);
            return orderList;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public List<OrderBill> getOrderListByDate(Date date){
            List<OrderBill> orderList = new ArrayList<OrderBill>();
            orderList = (List<OrderBill>)PMF.getObjectListByValueOrder(OrderBill.class, "dateShip", date,"status","asc");
            return orderList;
        }
        
}
