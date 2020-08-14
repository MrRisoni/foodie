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
@Table(name = "users_addresses")
@NamedQueries({
    @NamedQuery(name = "UsersAddresses.findAll", query = "SELECT u FROM UsersAddresses u")})
public class UsersAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "add_id")
    private Long addId;
    @Basic(optional = false)
    @Column(name = "add_street")
    private String addStreet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId", fetch = FetchType.LAZY)
    private Set<Orxders> orxdersSet;
    @JoinColumn(name = "add_suburb_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Suburbs addSuburbId;
    @JoinColumn(name = "add_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users addUserId;

    public UsersAddresses() {
    }

    public UsersAddresses(Long addId) {
        this.addId = addId;
    }

    public UsersAddresses(Long addId, String addStreet) {
        this.addId = addId;
        this.addStreet = addStreet;
    }

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public Set<Orxders> getOrxdersSet() {
        return orxdersSet;
    }

    public void setOrxdersSet(Set<Orxders> orxdersSet) {
        this.orxdersSet = orxdersSet;
    }

    public Suburbs getAddSuburbId() {
        return addSuburbId;
    }

    public void setAddSuburbId(Suburbs addSuburbId) {
        this.addSuburbId = addSuburbId;
    }

    public Users getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Users addUserId) {
        this.addUserId = addUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addId != null ? addId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersAddresses)) {
            return false;
        }
        UsersAddresses other = (UsersAddresses) object;
        if ((this.addId == null && other.addId != null) || (this.addId != null && !this.addId.equals(other.addId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UsersAddresses[ addId=" + addId + " ]";
    }
    
}
