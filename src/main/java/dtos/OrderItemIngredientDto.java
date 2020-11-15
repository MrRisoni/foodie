package dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemIngredientDto {
    private BigDecimal price;
    private IngredientDto ingredientObj;

}
