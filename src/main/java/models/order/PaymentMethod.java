package models.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod  {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    public PaymentMethod() {
    }
}
