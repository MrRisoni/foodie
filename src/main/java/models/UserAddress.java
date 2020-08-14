
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "users_addresses")
public class UsersAddresses  {

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
    private Set<Orxders> orxdersSet;
    @JoinColumn(name = "add_suburb_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Suburbs addSuburbId;
    @JoinColumn(name = "add_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users addUserId;

    public UsersAddresses() {
    }

    public UsersAddresses(Long addId) {
        this.addId = addId;
    }

    public UsersAddresses(Long addId, String addStreet) {
        this.addId = addId;
        this.addStreet = addStreet;
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

    public Set<Orxders> getOrxdersSet() {
        return orxdersSet;
    }

    public void setOrxdersSet(Set<Orxders> orxdersSet) {
        this.orxdersSet = orxdersSet;
    }

    public Suburbs getAddSuburbId() {
        return addSuburbId;
    }

    public void setAddSuburbId(Suburbs addSuburbId) {
        this.addSuburbId = addSuburbId;
    }

    public Users getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Users addUserId) {
        this.addUserId = addUserId;
    }


}
