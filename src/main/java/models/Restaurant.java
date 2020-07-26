package models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonView(View.IFavoriteRestau.class)
    private Long id;

    @NotNull
    @Column
    @JsonView(View.IFavoriteRestau.class)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurants_id")
    private List<Menu> menu = new ArrayList<>();



    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
