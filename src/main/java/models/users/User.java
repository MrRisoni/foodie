package models.users;

import lombok.Getter;
import lombok.Setter;
import models.shop.Restaurant;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_favorite_restaurants",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name="restaurant_id"))
    private List<Restaurant> favoriteRestaurants = new ArrayList<>();

    public User() {
    }

    public List<Restaurant> getFavoriteRestaurants() {
        return favoriteRestaurants;
    }

    public void setFavoriteRestaurants(List<Restaurant> favoriteRestaurants) {
        this.favoriteRestaurants = favoriteRestaurants;
    }
}
