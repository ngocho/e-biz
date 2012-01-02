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
package ebiz.blo.food;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Transaction;
import ebiz.blo.customer.CustomerBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.gae.OrderDAO;
import ebiz.dao.gae.PMF;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dao.inf.IOrderDAO;
import ebiz.dto.checkout.*;
import ebiz.dto.account.customer.Customer;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
import ebiz.form.Paging;
import ebiz.form.ShoppingCart;
import ebiz.util.CommonConstant;

/**
 * @author ThuyNT
 */
public class FoodBLO {
	private static IFoodDAO foodDao = new FoodDAO();
	private static IOrderDAO orderDao = new OrderDAO();

	// /**
	// * ! khuyến mãi get info của sản phẩm khuyến mãi
	// */
	// public static FoodPromotion isProductPromotion(Long id) {
	// // get info cua product
	// return foodDao.getFoodPromotionById(id);
	// }
	/**
	 * ! khuyến mãi get info của sản phẩm khuyến mãi
	 */
	public static Food getFoodById(Long id) {
		// get info cua product
		return foodDao.getFoodById(id);
	}

	/**
	 * get Food to display category
	 * 
	 * @return
	 */
	public static List<FoodForm> getFoodFormList(String col,
			HashMap<Integer, String> paging, String order, int record,
			int page, String typeProduct) {
		List<FoodForm> formList = new ArrayList<FoodForm>();
		List<Food> foodList = new ArrayList<Food>();
		String filterCol = CommonConstant.FOOD_TYPE;

		// call method to display product
		foodList = foodDao.diplayPageFood(col, paging, order, record, page,
				filterCol, typeProduct);

		// transfer dto-> form : display
		for (Food food : foodList) {
			FoodForm form = new FoodForm();
			form.editForm(food);
			if (!form.isEmpty()) {
				formList.add(form);
			}
		}
		return formList;
	}

	/**
	 * init display Food Category
	 * 
	 * @return
	 */
	public static List<FoodForm> initFoodCategory(
			HashMap<Integer, String> paging, int record, String typeProduct) {

		List<FoodForm> formList = new ArrayList<FoodForm>();
		formList = getFoodFormList("foodName", paging, "asc", record, 1,
				typeProduct);
		return formList;
	}

	/**
	 * get Food to display detail product using String key
	 * 
	 * @return
	 */
	public static FoodForm getFoodFormDetail(String key) {

		FoodForm form = new FoodForm();
		Long id;
		if (key != null) {
			id = Long.parseLong(key);
			form.editFormDetail(getFoodById(id));

		}
		if (form.isEmpty()) {
			return null;
		}
		return form;
	}

	/**
	 * update status of paging : cursor string
	 * 
	 * @param p
	 * @return
	 */
	public static List<Paging> updateStatusPaging(HashMap<Integer, String> p) {
		List<Paging> pageList = new ArrayList<Paging>();

		for (Integer key : p.keySet()) {
			Paging page = new Paging();
			page.setId(key);
			page.setCursorString(p.get(key));
			pageList.add(page);
		}
		return pageList;

	}

	/**
	 * transfer from List<Paging> -->HashMap<Integer, String>
	 * 
	 * @param p
	 * @return
	 */
	public static HashMap<Integer, String> toHashMap(List<Paging> pageList) {

		HashMap<Integer, String> paging = new HashMap<Integer, String>();
		for (Paging page : pageList) {
			paging.put(page.getId(), page.getCursorString());
		}
		return paging;

	}

	/**
	 * add product into shopping cart
	 * 
	 * @param p
	 * @return
	 */
	public static boolean addShoppingCart(ShoppingCart shopCart, String key,
			Integer number) {
		Long id;
		Integer numberDB;
		FoodForm food = null;
		if (key != null) {
			id = Long.parseLong(key);
			// test number of product in database
			Food foodDB = foodDao.getFoodById(id);
			numberDB = foodDB.getNumber();

			if (!shopCart.isEmpty()) {
				System.out.println("!isEmpty");
				List<FoodForm> foodList = shopCart.getProducts();
				// ? exist product in shopping cart
				for (FoodForm foodForm : foodList) {
					// exist product in shopping
					if (id == foodForm.getId()) {

						Integer numberProduct = foodForm.getNumber() + number;
						// number product required <= number in database
						if (numberProduct <= numberDB) {
							foodForm.setNumber(numberProduct);
							foodForm.setSubTotal(foodForm.getPrice()
									* numberProduct);
							return true;
						} else {
							return false;
						}
					}
				}
			}
			// shopcart is empty or don't exist required product in shop cart
			if (number <= numberDB) {
				food = new FoodForm();
				food.editForm(foodDB);
				food.setPrice(food.getPrice());
				// if product is a promotion products
				if ((CommonConstant.FOODPROMOTION).equals(food.getStatus())) {
					food.setPromoPrice(food.getPromoPrice());
				}
				shopCart.addFood(food, number);
				System.out.println("SIZE" + shopCart.getCount());
			} else {
				return false;
			}

		}

		return true;
	}

	/**
	 * remove product in shopping
	 * 
	 * @param shopCart
	 * @param idProduct
	 * @return
	 */
	public boolean removeProInShop(ShoppingCart shopCart, Long idProduct) {
		List<FoodForm> foodList = shopCart.getProducts();
		if (!foodList.isEmpty()) {
			for (int i = 0; i < foodList.size(); i++) {
				if (foodList.get(i).getId() == idProduct) {
					foodList.remove(i);
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * test number of product in database <= number request
	 * 
	 * @param shopCart
	 * @param key
	 * @return number in database (if not)
	 * @return 0 ( if OK)
	 */
	public static Integer isProNumberShop(ShoppingCart shopCart, String key,
			Integer number) {
		Long id;
		Integer numberDB;
		if (key != null) {
			id = Long.parseLong(key);
			Food foodDB = foodDao.getFoodById(id);
			numberDB = foodDB.getNumber();
			if (number > numberDB) {
				return numberDB;
			}
		}
		return 0; // success

	}

	/**
	 * update number and subPrice of product in shopping cart
	 * 
	 * @param shopCart
	 * @param key
	 * @return
	 */
	public static Long updateSubPriceShop(ShoppingCart shopCart, String key,
			Integer number) {
		Long id;
		Long subPrice = new Long(0);
		if (key != null) {
			id = Long.parseLong(key);
			List<FoodForm> foodList = shopCart.getProducts();
			for (FoodForm foodForm : foodList) {
				if (id == foodForm.getId()) {
					subPrice = number * foodForm.getPrice();
					foodForm.setNumber(number);
					foodForm.setSubTotal(subPrice);
				}
			}

		}
		return subPrice;

	}

	/**
	 * update number of product when status of Bill : finish shiiping
	 */
	public static boolean downNumberOfFood(Long id, Integer number) {

		Food food = foodDao.getFoodById(id);
		food.setNumber(food.getNumber() - number);
		food.setNumberOrder(food.getNumberOrder() - number);
		return foodDao.saveFood(food);

	}

	/**
	 * update number of product when status of Bill : order
	 * 
	 * @param id
	 * @param number
	 * @return
	 */
	public static boolean upNumberOfFood(Long id, Integer number) {

		Food food = foodDao.getFoodById(id);
		food.setNumberOrder(food.getNumber() - number);
		return foodDao.saveFood(food);

	}

	/**
	 * update number of product Order when status of Bill : order
	 */
	public static boolean upNumberFoodOrder(Long id, Integer number) {

		Food food = foodDao.getFoodById(id);
		food.setNumberOrder(food.getNumberOrder() + number);
		return foodDao.saveFood(food);

	}

	/**
	 * create bill
	 * 
	 * @param id
	 * @param number
	 * @return
	 */
	public static boolean billing(ShoppingCart shop) {

		if (shop.getUser().getLoginId() != null) {
			Customer customer = new Customer();
			Long moneyOrder = new Long(0);
			customer = CustomerBLO.getCustomerByID(shop.getUser().getLoginId());
			OrderBill order = new OrderBill();
			System.out.println("CUSTOMER" + customer.getCustomerId());
			// create OrderBill
			order.setNameCustomer(customer.getCustomerName());
			order.setAddress(customer.getCustomerAddress());
			order.setEmail(customer.getCustomerEmail());
			order.setPhone(customer.getCustomerPhone());
			order.setStatus(CommonConstant.BILLSTATUS_0); // chua giao
			order.setDateOrder(new Date());
			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			// Queue queue = QueueFactory.getDefaultQueue();
			// insert , update database using transaction
			Transaction txn = ds.beginTransaction();
			try {

				// save order
				order = orderDao.save(order);
				Long idOrder = order.getId();
				System.out.println(order.getId());

				// create detailOrder --> save in database

				for (FoodForm food : shop.getProducts()) {
					moneyOrder = moneyOrder + food.getNumber()
							* food.getPrice();
					DetailOrder detail = new DetailOrder();
					detail.setIdProduct(food.getId());
					detail.setName(food.getName());
					detail.setNumber(food.getNumber());
					detail.setSubPrice(moneyOrder);
					detail.setOrderId(idOrder);

					// save DetailOrder
					orderDao.insertDetailOrder(detail);

					// increase number of product Order
					upNumberFoodOrder(food.getId(), food.getNumber());
					// downNumberOfFood(food.getId(), food.getNumber());
				}

				// sum money for this bill
				order.setSumPrice(moneyOrder);

				// update sumMoney for order
				orderDao.save(order);
				txn.commit();
				return true;
			} catch (DatastoreFailureException e) {
				txn.rollback();
				return false;
			}
		}
		return false;// user chua dang nhap
	}

	/**
	 * cancel bill when status : order
	 * 
	 * @param id
	 * @param number
	 * @return
	 */

	public static boolean cancelOrderBill(Long id) {
		if (updateStatusOrderBill(id, CommonConstant.BILLSTATUS_4)) {
			List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();
			detailOrderList = orderDao.getDetailByIDOrBill(id);
			for (DetailOrder detail : detailOrderList) {
				upNumberOfFood(detail.getIdProduct(), detail.getNumber());
			}
			orderDao.deleteDetailOrderList(detailOrderList);
			return true;
		}

		return false;
	}

	/**
	 * set status of OrderBill:
	 * 
	 * @param id
	 * @param number
	 * @return
	 */

	public static boolean updateStatusOrderBill(Long id, Integer status) {
		OrderBill order = orderDao.getOrderBillById(id);
		order.setStatus(status);
		if (orderDao.save(order) != null) {
			return true;
		}
		return false;
	}

	/**
	 * delete product
	 */
	public static boolean deleteFood(Food food) {
		return PMF.delete(food);
	}

}

// /**
// *
// * get detail info of product
// * @return
// */
// public static List<FoodForm> getFoodForm(){
//
// List<FoodForm> formList = new ArrayList<FoodForm>();
// List<Food> foodList = new ArrayList<Food>();
// foodList = foodDao.getFoodList();
// for(Food food:foodList ){
// FoodForm form = new FoodForm();
//
// if(CommonConstant.STATUS_2 != food.getFoodStatusId() ){
// form.editForm(food);
// }
// else
// {
// //san pham khuyen mai
// form.editForm(isProductPromotion( food.getFoodId()));
// }
// if(!form.isEmpty()){
// formList.add(form);
// }
// }
// return formList;
// }
//

