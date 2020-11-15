package dtos;

import lombok.Data;
import models.shop.Restaurant;

@Data
public class ShopDto {
    private String address;
    private RestaurantDto restoObj;

}
