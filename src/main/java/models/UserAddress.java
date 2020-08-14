
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "users_addresses")
public class UserAddress  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "add_id")
    private Long addId;
    

    @Column(name = "add_street")
    
    private String addStreet;


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



}
