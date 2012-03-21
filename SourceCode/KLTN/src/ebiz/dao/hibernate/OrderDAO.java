package ebiz.dao.hibernate;

import java.util.Date;
import java.util.List;

import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.checkout.DetailOrder;
import ebiz.dto.checkout.OrderBill;
import ebiz.dto.checkout.VoucherBill;
import ebiz.util.BillType;

public class OrderDAO implements IOrderDAO {

    @Override
    public OrderBill save(OrderBill order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insertDetailOrder(DetailOrder order) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public OrderBill getOrderBillById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getOrderStatusById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteDetailOrderList(List<DetailOrder> list) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteDetailOrder(DetailOrder item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<OrderBill> getOrListByIDCustomer(String idCustomer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBill> getOrListByIDEmployee(String idEmployee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DetailOrder> getDetailByIDOrBill(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBill> getOrListByStatus(String userID, String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBill> getOrderList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBill> getOrderListByStatus(BillType status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBill> getOrderListByStatus(String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBill> getOrderListByDate(Date date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VoucherBill saveVoucherBill(VoucherBill voucher) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VoucherBill getVoucherByID(Long idVoucher) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteOrderBill(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
