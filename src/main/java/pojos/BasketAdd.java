package pojos;

import java.util.ArrayList;
import java.util.List;

public class BasketAdd {
    private Long  foodId;
    private List<BasketIngredient> ingredients;

    public BasketAdd() {
        this.ingredients = new ArrayList<>();
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public List<BasketIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<BasketIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
