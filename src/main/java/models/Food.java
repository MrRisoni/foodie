package models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Column
    @JsonView(View.IOrder.class)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="foods_id")
    private List<FoodPart> foodparts = new ArrayList<>();


    public Food() {
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

    public List<FoodPart> getFoodparts() {
        return foodparts;
    }

    public void setFoodparts(List<FoodPart> foodparts) {
        this.foodparts = foodparts;
    }
}
