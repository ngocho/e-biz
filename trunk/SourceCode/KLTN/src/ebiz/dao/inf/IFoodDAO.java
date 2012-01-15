package ebiz.dao.inf;

import java.util.HashMap;
import java.util.List;

import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;

public interface IFoodDAO {
	
	public Food getFoodById(String key);
	
	public Food getFoodById(Long key);
	public String getStatusNameByID(String id);
	public List<Food> getListFoodByValue(String col, String id);

	public List<Food> getFoodListAll();
	
	public List<Food> getFoodListByProviderStatus(String idProvider, String statusFood);
	
	public List<String> getAttributeList(String col);

	public List<FoodPriceLevel> getPriceList();

	public boolean insertFoodAttribute(FoodAttribute food);

	public boolean insertFoodStatus(FoodStatus food);

	public boolean insertFoodType(FoodType food);

	public boolean insertFoodPriceLevel(FoodPriceLevel food);

	public boolean saveFood(Food food);   //save = update
	
	public boolean deleteFood(Food food);
	
	public boolean isFood(Long id);
	
	public List<Food> diplayPageFood(String col,
			HashMap<Integer, String> paging, String order, int record,
			int page, String filterCol, String typeProduct);

	

}
