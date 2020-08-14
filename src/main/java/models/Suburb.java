/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author ekatania
 */
@Entity
@Table(name = "suburbs")
@NamedQueries({
    @NamedQuery(name = "Suburbs.findAll", query = "SELECT s FROM Suburbs s")})
public class Suburbs implements Serializable {

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

    public Suburbs(Long id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suburbs)) {
            return false;
        }
        Suburbs other = (Suburbs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Suburbs[ id=" + id + " ]";
    }
    
}
