package models.shop;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.shop.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String address;

    @OneToOne
    @JoinColumn(name="restaurants_id")
    private Restaurant restoObj;

    public Shop() {
    }

    public Shop(Long pKey) {
        this.id = pKey;
    }

    public Restaurant getRestoObj() {
        return restoObj;
    }

    public void setRestoObj(Restaurant restoObj) {
        this.restoObj = restoObj;
    }
}
