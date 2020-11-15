package dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientDto {
    private String name;
    private BigDecimal price;
}
