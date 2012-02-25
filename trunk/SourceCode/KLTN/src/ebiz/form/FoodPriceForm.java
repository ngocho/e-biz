package ebiz.form;

import java.io.Serializable;

import ebiz.blo.food.FoodBLO;
import ebiz.dto.food.FoodPriceLevel;

public class FoodPriceForm implements Serializable {

    /** . */
    private static final long serialVersionUID = 1L;
    private String id;
    private String startPrice;
    private String endPrice;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStartPrice() {
        return startPrice;
    }
    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }
    public String getEndPrice() {
        return endPrice;
    }
    public void setEndPrice(String endPrice) {
        this.endPrice = endPrice;
    }

    public FoodPriceLevel getFoodPrice() {
        FoodPriceLevel food = new FoodPriceLevel();
        food.setFoodPriceLevelId(id);
        if (startPrice != null) {
            food.setStartPrice(Long.parseLong(startPrice));
        }
        if (endPrice != null) {
            food.setEndPrice(Long.parseLong(endPrice));
        }
        return food;
    }

    public void editForm(FoodPriceLevel food) {
        this.id = food.getFoodPriceLevelId();
        if (food.getStartPrice() >= 200000) {
            this.startPrice = " Trên";
            this.endPrice = FoodBLO.format(String.valueOf(food.getStartPrice()), 3);
        } else {
            this.startPrice = FoodBLO.format(String.valueOf(food.getStartPrice()), 3);
            this.endPrice = FoodBLO.format(String.valueOf(food.getEndPrice()), 3);
        }
    }
}
