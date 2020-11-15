package models.general;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "suburbs")
public class Suburb  {

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

    @JoinColumn(name = "cities_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private City citiesId;
    
    public Suburb() {
    }
    public City getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(City citiesId) {
        this.citiesId = citiesId;
    }
}
