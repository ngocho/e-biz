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
import ebiz.util.BillType;

/**
 * @author ThuyNT
 */
public class OrderDAO implements IOrderDAO {

    /**
     * [save an obj OrderBill into database].
     * @param order
     * @return OrderBill
     * @see ebiz.dao.inf.IOrderDAO#save(ebiz.dto.checkout.OrderBill)
     */
    @Override
    public OrderBill save(OrderBill order) {

        return (OrderBill) PMF.save(order);

    }

    /**
     * [save an obj VoucherBill into database].
     * @param voucher
     * @return VoucherBill 
     * @see ebiz.dao.inf.IOrderDAO#saveVoucherBill(ebiz.dto.checkout.VoucherBill)
     */
    @Override
    public VoucherBill saveVoucherBill(VoucherBill voucher) {

        return (VoucherBill) PMF.save(voucher);

    }
    /**
     * [get a obj VoucherBill by ID].
     * @param idVoucher
     * @return VoucherBill
     * @see ebiz.dao.inf.IOrderDAO#getVoucherByID(java.lang.Long)
     */
    @Override
    public VoucherBill getVoucherByID(Long idVoucher) {

        return (VoucherBill) PMF.getObjectById(VoucherBill.class, idVoucher);

    }
    
    /**
     * [insert an obj DetailOrder into database].
     * @param order
     * @return boolean
     * @see ebiz.dao.inf.IOrderDAO#insertDetailOrder(ebiz.dto.checkout.DetailOrder)
     */
    @Override
    public boolean insertDetailOrder(DetailOrder order) {

        return PMF.insertObject(order);

    }
    
    /**
     * [get an obj DetailOrder by ID].
     * @param id
     * @return OrderBill
     * @see ebiz.dao.inf.IOrderDAO#getOrderBillById(java.lang.Long)
     */
    @Override
    public OrderBill getOrderBillById(Long id) {
        return (OrderBill) PMF.getObjectById(OrderBill.class, id);

    }

    /**
     * [delete All Detail Order of a Order].
     * @param list
     * @return boolean
     * @see ebiz.dao.inf.IOrderDAO#deleteDetailOrderList(java.util.List)
     */
    @Override
    public boolean deleteDetailOrderList(List<DetailOrder> list) {
        return PMF.deleteAll(list);

    }
    
//    @Override
//    public boolean deleteDetailOrder(DetailOrder item) {
//        return PMF.delete(item);
//    }
    
    /**
     * [get list order by ID Customer].
     * @param idCustomer
     * @return List<OrderBill>
     * @see ebiz.dao.inf.IOrderDAO#getOrListByIDCustomer(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrListByIDCustomer(String idCustomer) {

        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByValue(OrderBill.class, "idCustomer", idCustomer);
        return orderList;

    }
    
    /**
     * [get List detail order by ID Order].
     * @param id
     * @return List<DetailOrder>
     * @see ebiz.dao.inf.IOrderDAO#getDetailByIDOrBill(java.lang.Long)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<DetailOrder> getDetailByIDOrBill(Long id) {
        List<DetailOrder> orderList = new ArrayList<DetailOrder>();
        orderList = (List<DetailOrder>) PMF.getObjectListByValue(DetailOrder.class, "orderId", id);
        return orderList;
    }
    
    /**
     * [get list order by ID Employee].
     * @param idEmployee
     * @return List<OrderBill>
     * @see ebiz.dao.inf.IOrderDAO#getOrListByIDEmployee(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrListByIDEmployee(String idEmployee) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByValue(OrderBill.class, "idEmployee", idEmployee);
        return orderList;
    }
    
    /**
     * [get list order filter:customerID, status].
     * @param userID
     * @param status
     * @return List<OrderBill>
     * @see ebiz.dao.inf.IOrderDAO#getOrListByStatus(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrListByStatus(String userID, String status) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByTwoValues(OrderBill.class, "idCustomer", userID, "status",
                status);
        return orderList;
    }
    
    /**
     * [get All Order].
     * @return List<OrderBill>
     * @see ebiz.dao.inf.IOrderDAO#getOrderList()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrderList() {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectList(OrderBill.class);
        return orderList;
    }
    
    /**
     * [get nameStatus of a order By idStatus].
     * @param id
     * @return nameStatus
     * @see ebiz.dao.inf.IOrderDAO#getOrderStatusById(java.lang.String)
     */
    @Override
    public String getOrderStatusById(String idStatus) {
        OrderStatus orderStatus;
        orderStatus = (OrderStatus) PMF.getObjectById(OrderStatus.class, idStatus);
        if (orderStatus != null) {
            return orderStatus.getName();
        }
        return null;
    }

    @Deprecated
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrderListByStatus(String status) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByValue(OrderBill.class, "status", status);
        return orderList;
    }
    /**
     * [get list order by status].
     * @param status
     * @return List<OrderBill>
     * @see ebiz.dao.inf.IOrderDAO#getOrderListByStatus(ebiz.util.BillType)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrderListByStatus(BillType status) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByValue(OrderBill.class, "status", status.toString());
        return orderList;
    }

    /**
     * [get list order by date].
     * @param date
     * @return List<OrderBill>
     * @see ebiz.dao.inf.IOrderDAO#getOrderListByDate(java.util.Date)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBill> getOrderListByDate(Date date) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByValueOrder(OrderBill.class, "dateShip", date, "status", "asc");
        return orderList;
    }

    /**
     * [delete an obj order By ID].
     * @param id
     * @return
     * @see ebiz.dao.inf.IOrderDAO#deleteOrderBill(java.lang.Long)
     */
    @Override
    public boolean deleteOrderBill(Long id) {
        return PMF.delete(OrderBill.class, id);
    }

}
