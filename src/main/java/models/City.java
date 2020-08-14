
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
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "citiesId", fetch = FetchType.LAZY)
    private Set<Suburbs> suburbsSet;
    @JoinColumn(name = "perfectures_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfectures perfecturesId;

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

    public Set<Suburbs> getSuburbsSet() {
        return suburbsSet;
    }

    public void setSuburbsSet(Set<Suburbs> suburbsSet) {
        this.suburbsSet = suburbsSet;
    }

    public Perfectures getPerfecturesId() {
        return perfecturesId;
    }

    public void setPerfecturesId(Perfectures perfecturesId) {
        this.perfecturesId = perfecturesId;
    }

   
    
}
