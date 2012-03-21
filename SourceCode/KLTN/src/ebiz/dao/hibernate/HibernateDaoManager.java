package ebiz.dao.hibernate;

import ebiz.dao.DaoManager;
import ebiz.dao.inf.IAdminDAO;
import ebiz.dao.inf.ICustomerDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dao.inf.IProviderDAO;

/**
 * Use to manage all dao implement in hibernate.
 * @author DuyLT60571
 *
 */
public class HibernateDaoManager extends DaoManager {
    @Override
    public IAdminDAO getAdminDao() {
        return new AdminDAO();
    }

    @Override
    public ICustomerDAO getCustomerDao() {
        return new CustomerDAO();
    }

    @Override
    public IFoodDAO getFoodDao() {
        return new FoodDAO();
    }

    @Override
    public IProviderDAO getProviderDao() {
        return new ProviderDAO();
    }

    @Override
    public IOrderDAO getOrderDao() {
        return new OrderDAO();
    }

}
