
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "suburbs")
public class Suburbs  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "cities_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cities citiesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sssbSuburbId", fetch = FetchType.LAZY)
    private Set<ShopsServingSuburbs> shopsServingSuburbsSet;
    @OneToMany(mappedBy = "suburbsId", fetch = FetchType.LAZY)
    private Set<Shops> shopsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addSuburbId", fetch = FetchType.LAZY)
    private Set<UsersAddresses> usersAddressesSet;

    public Suburbs() {
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

    public Cities getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(Cities citiesId) {
        this.citiesId = citiesId;
    }

    public Set<ShopsServingSuburbs> getShopsServingSuburbsSet() {
        return shopsServingSuburbsSet;
    }

    public void setShopsServingSuburbsSet(Set<ShopsServingSuburbs> shopsServingSuburbsSet) {
        this.shopsServingSuburbsSet = shopsServingSuburbsSet;
    }

    public Set<Shops> getShopsSet() {
        return shopsSet;
    }

    public void setShopsSet(Set<Shops> shopsSet) {
        this.shopsSet = shopsSet;
    }

    public Set<UsersAddresses> getUsersAddressesSet() {
        return usersAddressesSet;
    }

    public void setUsersAddressesSet(Set<UsersAddresses> usersAddressesSet) {
        this.usersAddressesSet = usersAddressesSet;
    }

  
    
}
