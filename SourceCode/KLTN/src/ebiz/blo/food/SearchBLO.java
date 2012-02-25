package ebiz.blo.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;

import com.google.appengine.api.memcache.jsr107cache.GCacheFactory;

import ebiz.blo.provider.ProviderBLO;
import ebiz.dao.gae.FoodDAO;
import ebiz.dao.inf.IFoodDAO;
import ebiz.dto.food.Food;
import ebiz.form.FoodForm;
import ebiz.form.SearchForm;

public class SearchBLO {

    /** FoodDAO . */
    private static IFoodDAO foodDao = new FoodDAO();

    public static List<FoodForm> searchFullText(SearchForm searchForm) {

        List<FoodForm> formList = new ArrayList<FoodForm>();
        List<Food> foodList = new ArrayList<Food>();
        // String idProvider ;
        boolean flag = true;
        if (!"0".equals(searchForm.getDistrictNameS())) {
            // near best
            // if(dis != null){
            // searchForm.setDistrictNameS(dis);
            // }
            // get list idProvider
            List<String> list = ProviderBLO.searchProviderByDis(searchForm.getDistrictNameS());
            if (!list.isEmpty()) {
                // select provider
                if (!"0".equals(searchForm.getProvider())) {
                    // no have value
                    if (!ProviderBLO.testProviderByDis(list, searchForm.getProvider())) {
                        searchForm.setDistrictNameS("0");
                        searchForm.setProvider("0");
                    }
                    // have value
                    else {
                        searchForm.setDistrictNameS("0");
                    }
                }
                // all
                else {
                    // loop
                    for (String id : list) {
                        searchForm.setProvider(id);
                        foodList.addAll(searchFood(searchForm));
                    }
                    flag = false;
                }

            }
        }
        if (flag) {
            foodList.addAll(searchFood(searchForm));
        }
        formList = distinct(foodList);
        return formList;
    }
    public static List<Food> searchFood(SearchForm searchForm) {
        List<FoodForm> formList = new ArrayList<FoodForm>();
        List<Food> foodList = new ArrayList<Food>();
        String textSeach = searchForm.getSearchText();
        if (textSeach != null) {
            List<Food> list = foodDao.searchFoodByName(textSeach, searchForm.getType(), searchForm.getAttr(),
                    searchForm.getPrice(), searchForm.getStatus(), searchForm.getProvider());
            foodList.addAll(list);
        }
        String text[] = searchForm.getSearchText().split(" ");
        if (text.length > 0) {
            for (String s : text) {
                List<Food> list = foodDao.searchFoodByName(s, searchForm.getType(), searchForm.getAttr(),
                        searchForm.getPrice(), searchForm.getStatus(), searchForm.getProvider());
                foodList.addAll(list);
            }
        }

        // //save in memcache
        // Cache cache = SearchBLO.getMemcache();
        // cache.put("searchData", formList);
        //
        // System.out.println("RESULT" + formList.size());
        return foodList;
    }

    // remove duplicated result and range
    public static List<FoodForm> distinct(List<Food> foodList) {
        /*
         * for(FoodForm form : formList){ if(form.) }
         */
        List<FoodForm> formList = new ArrayList<FoodForm>();
        HashMap<Long, Food> hashList = new HashMap<Long, Food>();
        for (Food food : foodList) {
            hashList.put(food.getFoodId(), food);
        }
        foodList = new ArrayList<Food>();
        Collection s = hashList.values();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            foodList.add((Food) i.next());
        }
        formList = FoodBLO.transferBeanForm(foodList);
        return formList;
    }

    public static Cache getMemcache() {
        Cache cache = null;
        Map props = new HashMap();
        props.put(GCacheFactory.EXPIRATION_DELTA, 180);
        try {
            CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
            cache = cacheFactory.createCache(Collections.emptyMap());
        } catch (CacheException e) {
            // ...
        }
        return cache;
    }

    // count number of page
    public static List<String> paging(int size) {
        List<String> list = new ArrayList<String>();
        int div = 1;
        div = size / 10;
        if (size % 10 > 0) {
            div = div + 1;
        }
        for (int i = 1; i <= div; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    public static List<?> getPage(List<?> foodList, int pageIndex) {
        List<Object> resultList = new ArrayList<Object>();
        int temp = pageIndex - 1;
        int size = pageIndex * 10;
        if (size > foodList.size()) {
            size = foodList.size();
        }
        for (int i = temp * 10; i < size; i++) {
            resultList.add(foodList.get(i));
        }
        return resultList;
    }
}
