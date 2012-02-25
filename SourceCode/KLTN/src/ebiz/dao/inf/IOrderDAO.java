package ebiz.dao.inf;

import java.util.Date;
import java.util.List;

import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.VoucherBill;
 /**
 * @author ThuyNT
 *
 */
public interface IOrderDAO {
     OrderBill save(OrderBill order);

	 boolean insertDetailOrder(DetailOrder order);

	 OrderBill getOrderBillById(Long id);
	 String getOrderStatusById(String id);
//	 List<DetailOrder> getDetailOrderList(Long id);

	 boolean deleteDetailOrderList(List<DetailOrder> list);

	 boolean deleteDetailOrder(DetailOrder item);
	 List<OrderBill> getOrListByIDCustomer(String idCustomer);
	 List<OrderBill> getOrListByIDEmployee(String idEmployee);
	 List<DetailOrder> getDetailByIDOrBill(Long id);
	 List<OrderBill> getOrListByStatus(String userID, String status);

    /**
     * [Give the description for method].
     * @return
     */
	 List<OrderBill> getOrderList();
	 List<OrderBill> getOrderListByStatus(String idStatus);
	 List<OrderBill> getOrderListByDate(Date date);
	 VoucherBill saveVoucherBill(VoucherBill voucher);
	 VoucherBill getVoucherByID(Long idVoucher);
	

}
