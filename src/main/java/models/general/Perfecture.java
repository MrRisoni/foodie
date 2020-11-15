package models.general;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "perfectures")
public class Perfecture  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String name;

    @OneToMany(mappedBy = "perfecturesId", fetch = FetchType.LAZY)
    private Set<City> citiesSet;

    public Perfecture() {
    }

    public Set<City> getCitiesSet() {
        return citiesSet;
    }

    public void setCitiesSet(Set<City> citiesSet) {
        this.citiesSet = citiesSet;
    }
}
