package models.order;

import lombok.Getter;
import lombok.Setter;
import models.order.OrderItem;
import models.shop.Ingredient;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item_ingredients")
public class OrderItemIngredient {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name="ingredients_id")
    private Ingredient ingredientObj;

    @OneToOne
    @JoinColumn(name="order_items_id")
    private OrderItem orderItemObj;

    public OrderItemIngredient() {
    }

    public OrderItemIngredient(Ingredient ingredientObj,BigDecimal price) {
        this.ingredientObj = ingredientObj;
        this.price = price;
    }

    public Ingredient getIngredientObj() {
        return ingredientObj;
    }

    public void setIngredientObj(Ingredient ingredientObj) {
        this.ingredientObj = ingredientObj;
    }

    public OrderItem getOrderItemObj() {
        return orderItemObj;
    }

    public void setOrderItemObj(OrderItem orderItemObj) {
        this.orderItemObj = orderItemObj;
    }
}
