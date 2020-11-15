package models.users;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users_addresses")
public class UserAddress  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Long addId;

    @Getter
    @Setter
    @Column(name = "add_street")
    private String addStreet;

    public UserAddress() {
    }
}