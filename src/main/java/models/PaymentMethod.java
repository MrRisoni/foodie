
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "payment_methods")
public class PaymentMethods  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payMethodId", fetch = FetchType.LAZY)
    private Set<Orxders> orxdersSet;

    public PaymentMethods() {
    }

    public PaymentMethods(Short id) {
        this.id = id;
    }

    public PaymentMethods(Short id, String title) {
        this.id = id;
        this.title = title;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Orxders> getOrxdersSet() {
        return orxdersSet;
    }

    public void setOrxdersSet(Set<Orxders> orxdersSet) {
        this.orxdersSet = orxdersSet;
    }

   
}
