package models.users;

import lombok.Getter;
import lombok.Setter;
import models.shop.Shop;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Getter
    @Setter
    @Column
    private String comment;

    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Shop shopId;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewId", fetch = FetchType.LAZY)
    private Set<ReviewRating> reviewsRatingSet;

    public Review() {
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Set<ReviewRating> getReviewsRatingSet() {
        return reviewsRatingSet;
    }

    public void setReviewsRatingSet(Set<ReviewRating> reviewsRatingSet) {
        this.reviewsRatingSet = reviewsRatingSet;
    }
}
