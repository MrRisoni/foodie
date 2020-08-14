
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "donation_categories")
public class DonationCategories  {

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

    
}
