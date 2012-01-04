package ebiz.dao.inf;

import java.util.List;

import ebiz.dto.checkout.*;

public interface IOrderDAO {
    public OrderBill save(OrderBill order);

	public boolean insertDetailOrder(DetailOrder order);

	public OrderBill getOrderBillById(Long id);

//	public List<DetailOrder> getDetailOrderList(Long id);

	public boolean deleteDetailOrderList(List<DetailOrder> list);

	public boolean deleteDetailOrder(DetailOrder item);
	public List<OrderBill> getOrListByIDCustomer(String idCustomer);
	public List<OrderBill> getOrListByIDEmployee(String idEmployee);
	public List<DetailOrder> getDetailByIDOrBill(Long id);
		
	

}
