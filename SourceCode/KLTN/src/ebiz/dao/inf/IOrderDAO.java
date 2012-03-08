package ebiz.dao.inf;

import java.util.Date;
import java.util.List;

import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.VoucherBill;
import ebiz.util.BillType;

/**
 * @author ThuyNT
 */
public interface IOrderDAO {
    /**
     * Save bill.
     *
     * @param order bill.
     * @return bill
     */
    OrderBill save(OrderBill order);

    /**
     * Insert order detail.
     * @param order order detail
     * @return true if success
     */
    boolean insertDetailOrder(DetailOrder order);

    /**
     * 
     * Get bill by ID.
     * @param id order ID
     * @return bill
     */
    OrderBill getOrderBillById(Long id);

    /**
     * get status by order's ID.
     *
     * @param id order's ID
     * @return Status
     */
    String getOrderStatusById(String id);

    // List<DetailOrder> getDetailOrderList(Long id);
    /**
     * delete order's details.
     * @param list list to delete
     * @return true if success
     */
    boolean deleteDetailOrderList(List<DetailOrder> list);

    /**
     * delete order.
     * @param item order
     * @return true if success.
     */
    boolean deleteDetailOrder(DetailOrder item);

    /**
     * get order of a customer.
     * @param idCustomer customer's ID
     * @return list
     */
    List<OrderBill> getOrListByIDCustomer(String idCustomer);

    /**
     * Get order by Employee manage.
     * @param idEmployee employee's ID
     * @return list of order
     */
    List<OrderBill> getOrListByIDEmployee(String idEmployee);

    /**
     * Get list of Order Detail by order's ID.
     * [Give the description for method].
     * @param id order ID
     * @return list of order detail
     */
    List<DetailOrder> getDetailByIDOrBill(Long id);

    /**
     * Get order List by Status.
     * @param userID user's ID
     * @param status status
     * @return list of order.
     */
    List<OrderBill> getOrListByStatus(String userID, String status);

    /**
     * [Give the description for method].
     * 
     * @return List of Order
     */
    List<OrderBill> getOrderList();

    /**
     * Get order list by Status, type.
     *
     * @param status bill Type.
     * @return List.
     */
    List<OrderBill> getOrderListByStatus(BillType status);

    /**
     * Get order list by Status, type.
     *
     * @param status bill Type.
     * @return List.
     * @deprecated use <code>getOrderListByStatus(BillType)</code> instead.
     */
    @Deprecated
    List<OrderBill> getOrderListByStatus(String status);

    /**
     * Get order list by order date.
     *
     * @param date order Date.
     * @return List.
     */
    List<OrderBill> getOrderListByDate(Date date);

    /**
     * 
     * [Give the description for method].
     * @param voucher voucher
     * @return voucher
     */
    VoucherBill saveVoucherBill(VoucherBill voucher);

    /**
     * 
     * Get voucher by ID.
     * @param idVoucher voucher's ID
     * @return voucher.
     */
    VoucherBill getVoucherByID(Long idVoucher);

    /**
     * 
     * delete voucher by ID.
     * @param id voucher's ID
     * @return true if success.
     */
    boolean deleteOrderBill(Long id);
}
