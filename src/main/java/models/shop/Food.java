package models.shop;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "foods_id")
    private List<FoodPart> foodparts = new ArrayList<>();

    public Food() {
    }

    public Food(Long pKey) {
        this.id = pKey;
    }

    public List<FoodPart> getFoodparts() {
        return foodparts;
    }

    public void setFoodparts(List<FoodPart> foodparts) {
        this.foodparts = foodparts;
    }
}
