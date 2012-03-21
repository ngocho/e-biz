package ebiz.dao.inf;

import java.util.List;

import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;

/**
 * @author ThuyNT
 *
 */
public interface IFoodDAO {

    Food getFoodById(String key);

    Food getFoodById(Long key);
    String getStatusNameByID(String id);
    String getNameTypeById(String id);
    String getNameAttrById(String id);
    List<Food> getListFoodByValue(String col, String id);

    List<Food> getFoodListAll();

    List<Food> getFoodListByProviderStatus(String idProvider, String statusFood);

    List<FoodAttribute> getAttributeList();

    List<FoodPriceLevel> getPriceList();

    boolean insertFoodAttribute(FoodAttribute food);

    boolean insertFoodStatus(FoodStatus food);

    boolean insertFoodType(FoodType food);

    boolean insertFoodPriceLevel(FoodPriceLevel food);

    boolean saveFood(Food food); // save = update

    boolean deleteFood(Food food);

    boolean isFood(Long id);

    List<Food> diplayPageFood(String col, List<String> numberPageList, String order, int record, int page, String sql);
    List<Food> diplayFoodCategoryAll(String col, List<String> numberPageList, String order, int record, int page,
            String sql);

    List<Food> searchFoodByName(String searchText, String type, String attr, String price, String status,
            String provider);

}
