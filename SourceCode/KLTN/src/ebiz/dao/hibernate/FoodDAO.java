package ebiz.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ebiz.dao.gae.PMF;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.account.customer.Assessment;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;

/**
 * Implement dao of food in hibernate.
 * @author DuyLT60571
 *
 */
public class FoodDAO implements IFoodDAO {

    //@Override
    //public Food getFoodById(String key) {
    //    // TODO Auto-generated method stub
    //    return null;
    //}

    @Override
    public Food getFoodById(Long key) {
        return (Food) HibernateHelper.getObjectById(Food.class, key);
    }

    @Override
    public String getStatusNameByID(String id) {
        return ((FoodStatus) HibernateHelper.getObjectById(FoodStatus.class, id)).getFoodStatusName();
    }

    @Override
    public String getNameTypeById(String id) {
        return ((FoodType) HibernateHelper.getObjectById(FoodType.class, id)).getProductTypeName();
    }

    @Override
    public String getNameAttrById(String id) {
        return ((FoodAttribute)HibernateHelper.getObjectById(FoodAttribute.class, id)).getProductAttributeName();
    }

    /**
     * Get list of food by column name in database and it's value.
     * @param col column name in database
     * @param value value of above column
     * @return list of food dto
     * @see ebiz.dao.inf.IFoodDAO#getListFoodByValue(java.lang.String, java.lang.String)
     */
    @Override
    public List<Food> getListFoodByValue(String col, String value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Food> listFood = null;
        try {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Food where " + col + "= :col");
        query.setString("col", value);
        listFood = (List<Food>) query.list();
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listFood;
    }

    /**
     * Get all food.
     * @return list of food dto
     * @see ebiz.dao.inf.IFoodDAO#getFoodListAll()
     */
    @Override
    public List<Food> getFoodListAll() {
        return (List<Food>) HibernateHelper.getObjectList(Food.class);
    }

    /**
     * get list of food by status and provider.
     * @param idProvider id of provider
     * @param statusFood status of food
     * @return list of food dto
     * @see ebiz.dao.inf.IFoodDAO#getFoodListByProviderStatus(java.lang.String, java.lang.String)
     */
    @Override
    public List<Food> getFoodListByProviderStatus(String idProvider, String statusFood) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Food> listFood = null;
        try {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Food where providerID = :providerID and foodStatusId = :foodStatusId");
        query.setString("providerID", idProvider);
        query.setString("foodStatusId", statusFood);
        listFood = (List<Food>) query.list();
        } catch (Exception e) {
            System.out.print(e);
        transaction.rollback();
        e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listFood;
    }

    @Override
    public List<FoodAttribute> getAttributeList() {
        return (List<FoodAttribute>) HibernateHelper.getObjectList(FoodAttribute.class);
    }

    @Override
    public List<FoodPriceLevel> getPriceList() {
        return (List<FoodPriceLevel>) HibernateHelper.getObjectList(FoodPriceLevel.class);
    }

    @Override
    public boolean insertFoodAttribute(FoodAttribute food) {
        return HibernateHelper.saveObject(food);
    }

    @Override
    public boolean insertFoodStatus(FoodStatus food) {
        return HibernateHelper.saveObject(food);
    }

    @Override
    public boolean insertFoodType(FoodType food) {
        return HibernateHelper.saveObject(food);
    }

    @Override
    public boolean insertFoodPriceLevel(FoodPriceLevel food) {
        return HibernateHelper.saveObject(food);
    }

    @Override
    public boolean saveFood(Food food) {
        return HibernateHelper.saveObject(food);
    }

    @Override
    public boolean deleteFood(Food food) {
        return HibernateHelper.deleteObject(food);
    }

    @Override
    public boolean isFood(Long id) {
        return HibernateHelper.isObject(Food.class, id);
    }

    @Override
    public List<Food> diplayPageFood(String col, List<String> numberPageList, String order, int record, int page,
            String sql) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) HibernateHelper.displayPageFood(Food.class, col, numberPageList, order, record, page, sql);
        return foodList;
    }

    @Override
    public List<Food> diplayFoodCategoryAll(String col, List<String> numberPageList, String order, int record,
            int page, String sql) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) HibernateHelper.displayPageFoodAll(Food.class, col, numberPageList, order, record, page, sql);
        return foodList;
    }

    @Override
    public List<Food> searchFoodByName(String searchText, String type, String attr, String price, String status,
            String provider) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>) HibernateHelper.searchListFoodByName(Food.class, searchText, type, attr, price, status, provider);
        return foodList;
    }
}