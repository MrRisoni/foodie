
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "users_addresses")
public class UserAddress  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "add_id")
    private Long addId;
    
    @Basic(optional = false)
    @Column(name = "add_street")
    
    private String addStreet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId", fetch = FetchType.LAZY)
    
    private Set<Order> orxdersSet;
    @JoinColumn(name = "add_suburb_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Suburb addSuburbId;
    
    @JoinColumn(name = "add_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User addUserId;

    public UserAddress() {
    }

 

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public Set<Order> getOrxdersSet() {
        return orxdersSet;
    }

    public void setOrxdersSet(Set<Order> orxdersSet) {
        this.orxdersSet = orxdersSet;
    }

    public Suburb getAddSuburbId() {
        return addSuburbId;
    }

    public void setAddSuburbId(Suburb addSuburbId) {
        this.addSuburbId = addSuburbId;
    }

    public User getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(User addUserId) {
        this.addUserId = addUserId;
    }


}
