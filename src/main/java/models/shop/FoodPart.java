package models.shop;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_parts")
public class FoodPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Column
    private String name;

    @Column
    private Boolean allow_many;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinTable(
            name = "food_part_ingredients",
            joinColumns = @JoinColumn(name = "food_part_id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredientsList = new ArrayList<>();

    public FoodPart() {
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

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public Boolean getAllow_many() {
        return allow_many;
    }

    public void setAllow_many(Boolean allow_many) {
        this.allow_many = allow_many;
    }
}
