
package models;


import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "order_donations")
public class OrderDonations  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DonationCategories categoryId;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orxders orderId;

    public OrderDonations() {
    }

    public OrderDonations(Long id) {
        this.id = id;
    }

    public OrderDonations(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DonationCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(DonationCategories categoryId) {
        this.categoryId = categoryId;
    }

    public Orxders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orxders orderId) {
        this.orderId = orderId;
    }

   
    
}
