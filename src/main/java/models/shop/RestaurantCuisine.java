package models.shop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants_cuisines")
public class RestaurantCuisine {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cuisines_id", insertable = false,updatable = false)
    private Cuisine cuisineObj;

    @Getter
    @Setter
    @Column(name="cuisines_id")
    private Long cuisineFKey;

    public RestaurantCuisine() {
    }

    public RestaurantCuisine(Long id) {
        this.id = id;
    }

    public Cuisine getCuisineObj() {
        return cuisineObj;
    }

    public void setCuisineObj(Cuisine cuisineObj) {
        this.cuisineObj = cuisineObj;
    }
}
