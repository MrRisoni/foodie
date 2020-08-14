
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "reviews_rating")
public class ReviewsRating  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "stars")
    private BigDecimal stars;
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RatingCriteria criteriaId;
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reviews reviewId;

    public ReviewsRating() {
    }

 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getStars() {
        return stars;
    }

    public void setStars(BigDecimal stars) {
        this.stars = stars;
    }

    public RatingCriteria getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(RatingCriteria criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Reviews getReviewId() {
        return reviewId;
    }

    public void setReviewId(Reviews reviewId) {
        this.reviewId = reviewId;
    }

   
    
}
