package dtos;

import lombok.Data;

@Data
public class RestaurantDto {
    private Long id;
    private String name;

    // custom fetch id and name only???
}
