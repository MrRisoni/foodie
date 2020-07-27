package pojos;

public class BasketIngredient {
    private Long foodPartId;
    private Long ingredientId;

    public BasketIngredient() {
    }

    public Long getFoodPartId() {
        return foodPartId;
    }

    public void setFoodPartId(Long foodPartId) {
        this.foodPartId = foodPartId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }
}
