
package models.general;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "cities")
public class City {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String name;
    
    @OneToMany(mappedBy = "citiesId", fetch = FetchType.LAZY)
    private Set<Suburb> suburbsSet;
    @JoinColumn(name = "perfectures_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfecture perfecturesId;

    public City() {
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
