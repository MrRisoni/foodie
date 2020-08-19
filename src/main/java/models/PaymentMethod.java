
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "payment_methods")
public class PaymentMethod  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Short id;

    @Column(name = "title")
    private String title;


    public PaymentMethod() {
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


   
}
