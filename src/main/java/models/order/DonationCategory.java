package models.order;

import lombok.Getter;
import lombok.Setter;
import models.order.Donation;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "donation_categories")
public class DonationCategory  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private Set<Donation> donationsSet;

    public DonationCategory() {
    }

    public Set<Donation> getDonationsSet() {
        return donationsSet;
    }

    public void setDonationsSet(Set<Donation> donationsSet) {
        this.donationsSet = donationsSet;
    }
}
