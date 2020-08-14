
package models;


import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "citiesId", fetch = FetchType.LAZY)
    private Set<Suburb> suburbsSet;
    @JoinColumn(name = "perfectures_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfecture perfecturesId;

    public City() {
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

    public Set<Suburb> getSuburbsSet() {
        return suburbsSet;
    }

    public void setSuburbsSet(Set<Suburb> suburbsSet) {
        this.suburbsSet = suburbsSet;
    }

    public Perfecture getPerfecturesId() {
        return perfecturesId;
    }

    public void setPerfecturesId(Perfecture perfecturesId) {
        this.perfecturesId = perfecturesId;
    }

   
    
}
