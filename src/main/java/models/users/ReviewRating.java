package models.users;

import lombok.Getter;
import lombok.Setter;
import models.shop.RatingCriteria;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "reviews_rating")
public class ReviewRating  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Getter
    @Setter
    @Column
    private BigDecimal stars;

    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RatingCriteria criteriaId;

    @JoinColumn(name = "review_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Review reviewId;

    public ReviewRating() {
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
