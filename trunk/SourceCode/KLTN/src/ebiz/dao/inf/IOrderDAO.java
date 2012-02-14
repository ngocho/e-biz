package ebiz.dao.inf;

import java.util.List;
import java.util.Date;
import ebiz.dto.checkout.*;
import ebiz.form.*;
public interface IOrderDAO {
    public OrderBill save(OrderBill order);

	public boolean insertDetailOrder(DetailOrder order);

	public OrderBill getOrderBillById(Long id);
	public String getOrderStatusById(String id);
//	public List<DetailOrder> getDetailOrderList(Long id);

	public boolean deleteDetailOrderList(List<DetailOrder> list);

	public boolean deleteDetailOrder(DetailOrder item);
	public List<OrderBill> getOrListByIDCustomer(String idCustomer);
	public List<OrderBill> getOrListByIDEmployee(String idEmployee);
	public List<DetailOrder> getDetailByIDOrBill(Long id);
	public List<OrderBill> getOrListByStatus(String userID, String status);

    /**
     * [Give the description for method].
     * @return
     */
	public List<OrderBill> getOrderList();
	public List<OrderBill> getOrderListByStatus(String idStatus);
	public List<OrderBill> getOrderListByDate(Date date);
	public VoucherBill saveVoucherBill(VoucherBill voucher);
	

}
