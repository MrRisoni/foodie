package dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderItemDto {
    private Long id;
    private BigDecimal base_price;
    private BigDecimal final_price;
    private FoodDto foodObj;
    private List<OrderItemIngredientDto> ingredients;
    private ShopDto shopObj;

}
