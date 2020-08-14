
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
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment")
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

    public Shops getShopId() {
        return shopId;
    }

    public void setShopId(Shops shopId) {
        this.shopId = shopId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Set<ReviewsRating> getReviewsRatingSet() {
        return reviewsRatingSet;
    }

    public void setReviewsRatingSet(Set<ReviewsRating> reviewsRatingSet) {
        this.reviewsRatingSet = reviewsRatingSet;
    }

    
}
