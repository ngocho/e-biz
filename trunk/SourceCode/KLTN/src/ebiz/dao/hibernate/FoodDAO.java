package ebiz.dao.hibernate;

import java.util.List;

import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;

public class FoodDAO implements IFoodDAO {

    @Override
    public Food getFoodById(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Food getFoodById(Long key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getStatusNameByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNameTypeById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNameAttrById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Food> getListFoodByValue(String col, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Food> getFoodListAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Food> getFoodListByProviderStatus(String idProvider, String statusFood) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getAttributeList(String col) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodAttribute> getAttributeList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodPriceLevel> getPriceList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insertFoodAttribute(FoodAttribute food) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertFoodStatus(FoodStatus food) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertFoodType(FoodType food) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertFoodPriceLevel(FoodPriceLevel food) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean saveFood(Food food) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteFood(Food food) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteFoodAll(Class<?> className) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFood(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Food> diplayPageFood(String col, List<String> numberPageList, String order, int record, int page,
            String sql) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Food> diplayFoodCategoryAll(String col, List<String> numberPageList, String order, int record,
            int page, String sql) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Food> searchFoodByName(String searchText, String type, String attr, String price, String status,
            String provider) {
        // TODO Auto-generated method stub
        return null;
    }

}
