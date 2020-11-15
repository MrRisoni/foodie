package models.order;

import lombok.Getter;
import lombok.Setter;
import models.shop.Shop;
import models.shop.Food;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private BigDecimal base_price;

    @Getter
    @Setter
    @Column
    private BigDecimal final_price;

    @OneToOne
    @JoinColumn(name="food_id")
    private Food foodObj;

    @Getter
    @Setter
    @Column
    private int quantity;

    @Getter
    @Setter
    @Column 
    private String comment;

    @Transient
    @OneToMany(mappedBy="orderItemObj", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<OrderItemIngredient> ingredients = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="shop_id")
    private Shop shopObj;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order orderObj;

    public OrderItem() {
    }

    public Food getFoodObj() {
        return foodObj;
    }

    public void setFoodObj(Food foodObj) {
        this.foodObj = foodObj;
    }

    public List<OrderItemIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<OrderItemIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Shop getShopObj() {
        return shopObj;
    }

    public void setShopObj(Shop shopObj) {
        this.shopObj = shopObj;
    }

    public Order getOrderObj() {
        return orderObj;
    }

    public void setOrderObj(Order orderObj) {
        this.orderObj = orderObj;
    }
}
