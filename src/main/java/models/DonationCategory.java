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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ekatania
 */
@Entity
@Table(name = "donation_categories")
@NamedQueries({
    @NamedQuery(name = "DonationCategories.findAll", query = "SELECT d FROM DonationCategories d")})
public class DonationCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private Set<Donations> donationsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private Set<OrderDonations> orderDonationsSet;

    public DonationCategories() {
    }

    public DonationCategories(Short id) {
        this.id = id;
    }

    public DonationCategories(Short id, String title) {
        this.id = id;
        this.title = title;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Donations> getDonationsSet() {
        return donationsSet;
    }

    public void setDonationsSet(Set<Donations> donationsSet) {
        this.donationsSet = donationsSet;
    }

    public Set<OrderDonations> getOrderDonationsSet() {
        return orderDonationsSet;
    }

    public void setOrderDonationsSet(Set<OrderDonations> orderDonationsSet) {
        this.orderDonationsSet = orderDonationsSet;
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
        if (!(object instanceof DonationCategories)) {
            return false;
        }
        DonationCategories other = (DonationCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DonationCategories[ id=" + id + " ]";
    }
    
}
