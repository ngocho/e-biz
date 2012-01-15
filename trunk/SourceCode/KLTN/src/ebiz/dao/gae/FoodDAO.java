/**
 * Licensed to Open-Ones Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Open-Ones Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ebiz.dao.gae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.Food;
import ebiz.dto.food.FoodAttribute;
import ebiz.dto.food.FoodPriceLevel;
import ebiz.dto.food.FoodStatus;
import ebiz.dto.food.FoodType;

/**
 * @author ThuyNT
 */
public class FoodDAO implements IFoodDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getListFoodByValue(String col, String id) {
		List<Food> foodList = new ArrayList<Food>();
		foodList = (List<Food>) PMF.getObjectListByValue(Food.class, col, id);
		return foodList;
	}

	@Override
	public Food getFoodById(String key) {
		Food food = null;
		food = (Food) PMF.getObjectById(Food.class, key);
		return food;
	}

	@Override
	public Food getFoodById(Long key) {
		Food food = null;
		food = (Food) PMF.getObjectById(Food.class, key);
		return food;
	}

	public static boolean upNumberFood(Long id, Integer number) {
		Food food = null;
		food = (Food) PMF.getObjectById(Food.class, id);
		if (food != null) {
			food.setNumber(food.getNumber() + number);
			return true;
		}
		return false;
	}

	public static boolean downNumberFood(Long id, Integer number) {
		Food food = null;
		food = (Food) PMF.getObjectById(Food.class, id);
		if (food != null) {
			food.setNumber(food.getNumber() - number);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getFoodListAll() {
		List<Food> foodList = new ArrayList<Food>();
		foodList = (List<Food>) PMF.getObjectList(Food.class);
		return foodList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> diplayPageFood(String col,
			HashMap<Integer, String> paging, String order, int record,
			int page, String filterCol, String typeProduct) {
		List<Food> foodList = new ArrayList<Food>();
		foodList = (List<Food>) PMF.diplayPageFood(Food.class, col, paging,
				order, record, page, filterCol, typeProduct);
		return foodList;
	}

	@Override
	public boolean saveFood(Food food) {

		return PMF.insertObject(food);

	}

	@Override
	public boolean insertFoodAttribute(FoodAttribute food) {

		return PMF.insertObject(food);

	}

	@Override
	public boolean insertFoodStatus(FoodStatus food) {

		return PMF.insertObject(food);

	}

	@Override
	public boolean insertFoodType(FoodType food) {

		return PMF.insertObject(food);

	}

	@Override
	public boolean insertFoodPriceLevel(FoodPriceLevel food) {

		return PMF.insertObject(food);

	}

	@Override
	public boolean deleteFood(Food food) {
		return PMF.delete(food);

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAttributeList(String col) {
		List<String> foodProList = new ArrayList<String>();
		foodProList = (List<String>) PMF.getColList(FoodAttribute.class, col);
		return foodProList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodPriceLevel> getPriceList() {

		List<FoodPriceLevel> foodProList = new ArrayList<FoodPriceLevel>();
		foodProList = (List<FoodPriceLevel>) PMF
				.getObjectList(FoodPriceLevel.class);
		return foodProList;

	}

	@Override
	public boolean isFood(Long id) {
		if (id != null) {
			return PMF.isObject(Food.class, String.valueOf(id));
		}
		return false;
	}

    /**
     * [Explain the description for this method here].
     * @return
     * @see ebiz.dao.inf.IFoodDAO#getFoodListByProviderStatus()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Food> getFoodListByProviderStatus(String idProvider, String statusFood) {
        List<Food> foodList = new ArrayList<Food>();
        foodList = (List<Food>)PMF.getObjectListByTwoValues(Food.class, "providerID", idProvider, "foodStatusId", statusFood);
        return foodList;
    }

    /**
     * [Explain the description for this method here].
     * @param id
     * @return
     * @see ebiz.dao.inf.IFoodDAO#getStatusNameByID(java.lang.String)
     */
    @Override
    public String getStatusNameByID(String id) {
        FoodStatus status = (FoodStatus)PMF.getObjectById(FoodStatus.class, id);
        if(status !=null){
            return status.getFoodStatusName();
        }
        return null;
    }

	// /**
	// * create bill using transaction : put task into taks queue
	// * @param key
	// * @return
	// * @see ebiz.dao.inf.IFoodDAO#billing(ebiz.form.ShoppingCart)
	// */
	// @Override
	// public boolean billing(ShoppingCart key) {
	//
	// DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	// Queue queue = QueueFactory.getDefaultQueue();
	// Transaction txn = ds.beginTransaction();
	// try {
	//
	//
	// // ...
	//
	// queue.add(TaskOptions.Builder.withUrl("/path/to/my/worker"));
	//
	// // ...
	// txn.commit();
	// } catch (DatastoreFailureException e) {
	// txn.rollback();
	// }
	//
	// return false;
	// }


}
