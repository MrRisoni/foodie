
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "rating_criteria")
public class RatingCriteria  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Short id;

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

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCritTitle() {
        return critTitle;
    }

    public void setCritTitle(String critTitle) {
        this.critTitle = critTitle;
    }

    public Set<ReviewRating> getReviewsRatingSet() {
        return reviewsRatingSet;
    }

    public void setReviewsRatingSet(Set<ReviewRating> reviewsRatingSet) {
        this.reviewsRatingSet = reviewsRatingSet;
    }

   
    
}
