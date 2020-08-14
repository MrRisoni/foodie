
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "perfectures")
public class Perfectures  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "perfecturesId", fetch = FetchType.LAZY)
    private Set<Cities> citiesSet;

    public Perfectures() {
    }

    public Perfectures(Long id) {
        this.id = id;
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

    public Set<Cities> getCitiesSet() {
        return citiesSet;
    }

    public void setCitiesSet(Set<Cities> citiesSet) {
        this.citiesSet = citiesSet;
    }

  
    
}
