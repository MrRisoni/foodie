
package models.order;


import models.order.Donation;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "donation_categories")
public class DonationCategory  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Short id;

    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private Set<Donation> donationsSet;

    public DonationCategory() {
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

    public Set<Donation> getDonationsSet() {
        return donationsSet;
    }

    public void setDonationsSet(Set<Donation> donationsSet) {
        this.donationsSet = donationsSet;
    }



    
}
