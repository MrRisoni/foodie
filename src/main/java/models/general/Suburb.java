
package models.general;


import models.general.City;

import javax.persistence.*;


@Entity
@Table(name = "suburbs")
public class Suburb  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    @JoinColumn(name = "cities_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private City citiesId;
    


    public Suburb() {
    }

      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(City citiesId) {
        this.citiesId = citiesId;
    }


    
    
}
