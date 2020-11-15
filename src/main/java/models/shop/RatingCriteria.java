package models.shop;

import lombok.Getter;
import lombok.Setter;
import models.users.ReviewRating;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "rating_criteria")
public class RatingCriteria  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Short id;

    @Getter
    @Setter
    @Column(name = "crit_title")
    private String critTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriaId", fetch = FetchType.LAZY)
    private Set<ReviewRating> reviewsRatingSet;

    public RatingCriteria() {
    }

    public RatingCriteria(Short id) {
        this.id = id;
    }

    public RatingCriteria(Short id, String critTitle) {
        this.id = id;
        this.critTitle = critTitle;
    }

    public Set<ReviewRating> getReviewsRatingSet() {
        return reviewsRatingSet;
    }

    public void setReviewsRatingSet(Set<ReviewRating> reviewsRatingSet) {
        this.reviewsRatingSet = reviewsRatingSet;
    }
}
