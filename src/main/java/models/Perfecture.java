
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "perfectures")
public class Perfecture  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @OneToMany(mappedBy = "perfecturesId", fetch = FetchType.LAZY)
    private Set<City> citiesSet;

    public Perfecture() {
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

    public Set<City> getCitiesSet() {
        return citiesSet;
    }

    public void setCitiesSet(Set<City> citiesSet) {
        this.citiesSet = citiesSet;
    }

  
    
}
