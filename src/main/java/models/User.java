package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_favorite_restaurants",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name="restaurant_id"))
    private Set<Restaurant> restaurantSet = new HashSet<>();


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Restaurant> getRestaurantSet() {
        return restaurantSet;
    }

    public void setRestaurantSet(Set<Restaurant> restaurantSet) {
        this.restaurantSet = restaurantSet;
    }
}
