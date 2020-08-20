package models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item_ingredients")
public class OrderItemIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @JsonView(View.IOrder.class)
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name="ingredients_id")
    @JsonView(View.IOrder.class)
    private Ingredient ingredientObj;

    public OrderItemIngredient() {
    }

    public OrderItemIngredient(Ingredient ingredientObj) {
        this.ingredientObj = ingredientObj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Ingredient getIngredientObj() {
        return ingredientObj;
    }

    public void setIngredientObj(Ingredient ingredientObj) {
        this.ingredientObj = ingredientObj;
    }
}
