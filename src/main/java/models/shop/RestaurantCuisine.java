package models.shop;


import com.fasterxml.jackson.annotation.JsonView;
import models.View;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants_cuisines")
public class RestaurantCuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cuisines_id", insertable = false,updatable = false)
    private Cuisine cuisineObj;

    @Column(name="cuisines_id")
    private Long cuisineFKey;

    public RestaurantCuisine() {
    }

    public RestaurantCuisine(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuisine getCuisineObj() {
        return cuisineObj;
    }

    public void setCuisineObj(Cuisine cuisineObj) {
        this.cuisineObj = cuisineObj;
    }


    public Long getCuisineFKey() {
        return cuisineFKey;
    }

    public void setCuisineFKey(Long cuisineFKey) {
        this.cuisineFKey = cuisineFKey;
    }
}
