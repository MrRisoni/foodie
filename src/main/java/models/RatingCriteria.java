/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ekatania
 */
@Entity
@Table(name = "rating_criteria")
@NamedQueries({
    @NamedQuery(name = "RatingCriteria.findAll", query = "SELECT r FROM RatingCriteria r")})
public class RatingCriteria implements Serializable {

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingCriteria)) {
            return false;
        }
        RatingCriteria other = (RatingCriteria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RatingCriteria[ id=" + id + " ]";
    }
    
}
