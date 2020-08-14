
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "rating_criteria")
public class RatingCriteria  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @Column(name = "crit_title")
    private String critTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriaId", fetch = FetchType.LAZY)
    private Set<ReviewsRating> reviewsRatingSet;

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

    public Set<ReviewsRating> getReviewsRatingSet() {
        return reviewsRatingSet;
    }

    public void setReviewsRatingSet(Set<ReviewsRating> reviewsRatingSet) {
        this.reviewsRatingSet = reviewsRatingSet;
    }

   
    
}
