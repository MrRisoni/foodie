package models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonView(View.IOrder.class)
    private Long id;

    @Column
    @JsonView(View.IOrder.class)
    private BigDecimal base_price;

    @Column
    @JsonView(View.IOrder.class)
    private BigDecimal final_price;

    @OneToOne
    @JoinColumn(name="food_id")
    @JsonView(View.IOrder.class)
    private Food foodObj;
    
    @Column 
    private String comment;
        
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="order_items_id")
    @JsonView(View.IOrder.class)
    private List<OrderItemIngredient> ingredients = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="shop_id")
    @JsonView(View.IOrder.class)
    private Shop shopObj;

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBase_price() {
        return base_price;
    }

    public void setBase_price(BigDecimal base_price) {
        this.base_price = base_price;
    }

    public BigDecimal getFinal_price() {
        return final_price;
    }

    public void setFinal_price(BigDecimal final_price) {
        this.final_price = final_price;
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
}
