package models.order;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String type;

    @Getter
    @Setter
    @Column
    private String bin;

    @Getter
    @Setter
    @Column
    private String lastfour;

    @Getter
    @Setter
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Getter
    @Setter
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public CreditCard() {
    }
}
