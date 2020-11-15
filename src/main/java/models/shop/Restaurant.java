package models.shop;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.shop.Menu;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurants_id")
    private List<Menu> menu = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurants_id")
    private List<RestaurantCuisine> cuisines = new ArrayList<>();


    public Restaurant() {
    }

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<RestaurantCuisine> getCusines() {
        return cuisines;
    }

    public void setCusines(List<RestaurantCuisine> cusines) {
        this.cuisines = cusines;
    }
}
