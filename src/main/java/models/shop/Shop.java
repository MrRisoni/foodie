package models.shop;

import com.fasterxml.jackson.annotation.JsonView;
import models.View;
import models.shop.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonView(View.IOrder.class)
    private Long id;

    @Column
    @JsonView(View.IOrder.class)
    private String address;

    @OneToOne
    @JoinColumn(name="restaurants_id")
    @JsonView(View.IOrder.class)
    private Restaurant restoObj;

    public Shop() {
    }

    public Shop(Long pKey) {
        this.id = pKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Restaurant getRestoObj() {
        return restoObj;
    }

    public void setRestoObj(Restaurant restoObj) {
        this.restoObj = restoObj;
    }
}
