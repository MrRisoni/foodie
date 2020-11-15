package models.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "order_donations")
public class OrderDonation  {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Getter
    @Setter
    @Column(name = "amount")
    private BigDecimal amount;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DonationCategory categoryId;

    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order orderId;

    public OrderDonation() {
    }

    public DonationCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(DonationCategory categoryId) {
        this.categoryId = categoryId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }
}
