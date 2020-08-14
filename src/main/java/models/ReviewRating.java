
package models;


import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "reviews_rating")
public class ReviewRating  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    private BigDecimal stars;
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RatingCriteria criteriaId;
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Review reviewId;

    public ReviewRating() {
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

    public Review getReviewId() {
        return reviewId;
    }

    public void setReviewId(Review reviewId) {
        this.reviewId = reviewId;
    }

   
    
}
