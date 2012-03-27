package ebiz.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ebiz.dao.gae.PMF;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.OrderStatus;
import ebiz.dto.checkout.VoucherBill;
import ebiz.util.BillType;

/**
 * Order dao implement in hibernate.
 * @author DuyLT60571
 *
 */
public class OrderDAO implements IOrderDAO {

    @Override
    public OrderBill save(OrderBill order) {
        return HibernateHelper.saveOrder(order);
    }

    @Override
    public boolean insertDetailOrder(DetailOrder order) {
        // TODO Auto-generated method stub
        return HibernateHelper.saveObject(order);
    }

    @Override
    public OrderBill getOrderBillById(Long id) {
        return (OrderBill) HibernateHelper.getObjectById(OrderBill.class, id);
    }

    @Override
    public String getOrderStatusById(String id) {
        return ((OrderStatus) HibernateHelper.getObjectById(OrderStatus.class, id)).getName();
    }

    @Override
    public boolean deleteDetailOrderList(List<DetailOrder> list) {
        return HibernateHelper.deleteListObject(list);
    }

    @Override
    public List<OrderBill> getOrListByIDCustomer(String idCustomer) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) HibernateHelper.getObjectListByValue(OrderBill.class, "idCustomer", idCustomer);
        return orderList;
    }

    @Override
    public List<OrderBill> getOrListByIDEmployee(String idEmployee) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) HibernateHelper.getObjectListByValue(OrderBill.class, "idEmployee", idEmployee);
        return orderList;
    }

    @Override
    public List<DetailOrder> getDetailByIDOrBill(Long id) {
        List<DetailOrder> orderList = new ArrayList<DetailOrder>();
        orderList = (List<DetailOrder>) HibernateHelper.getObjectListByValue(DetailOrder.class, "orderId", id);
        return orderList;
    }

    @Override
    public List<OrderBill> getOrListByStatus(String userID, String status) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) HibernateHelper.getObjectListByTwoValues(OrderBill.class, "idCustomer", userID, "status",
                status);
        return orderList;
    }

    @Override
    public List<OrderBill> getOrderList() {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectList(OrderBill.class);
        return orderList;
    }

    @Override
    public List<OrderBill> getOrderListByStatus(BillType status) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) HibernateHelper.getObjectListByValue(OrderBill.class, "status", status.toString());
        return orderList;
    }

    @Override
    public List<OrderBill> getOrderListByStatus(String status) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) HibernateHelper.getObjectListByValue(OrderBill.class, "status", status);
        return orderList;
    }

    @Override
    public List<OrderBill> getOrderListByDate(Date date) {
        List<OrderBill> orderList = new ArrayList<OrderBill>();
        orderList = (List<OrderBill>) PMF.getObjectListByValueOrder(OrderBill.class, "dateShip", date, "status", "asc");
        return orderList;
    }

    @Override
    public VoucherBill saveVoucherBill(VoucherBill voucher) {
        return HibernateHelper.saveVoucherBill(voucher);
    }

    @Override
    public VoucherBill getVoucherByID(Long idVoucher) {
        return (VoucherBill) HibernateHelper.getObjectById(VoucherBill.class, idVoucher);
    }

    @Override
    public boolean deleteOrderBill(Long id) {
        return HibernateHelper.deleteObject(HibernateHelper.getObjectById(OrderBill.class, id));
    }

}
