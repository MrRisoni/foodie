package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "cuisines")
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Column
    private String name;
    
     @OneToMany(mappedBy = "cuisinesId", fetch = FetchType.LAZY)
    private Set<Foods> foodsSet;
    @OneToMany(mappedBy = "cuisinesId", fetch = FetchType.LAZY)
    private Set<RestaurantsCuisines> restaurantsCuisinesSet;

    public Cuisine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
