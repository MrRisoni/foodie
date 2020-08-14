
package models;


import java.util.Date;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "reviews")

public class Review {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Lob
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
