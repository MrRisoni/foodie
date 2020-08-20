package models;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paraggelies")
public class Order {
    @JsonView(View.IOrder.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonView(View.IOrder.class)
    @Column
    private BigDecimal final_price;

    @Column
    private boolean success;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonView(View.IOrder.class)
    private Date created_at;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated_at;

    @OneToMany(mappedBy="orderObj", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
  //  @JoinColumn(name=" order_id")
    @JsonView(View.IOrder.class)
    private List<OrderItem> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="pay_method_id")
    private PaymentMethod payObj;

    @OneToOne
    @JoinColumn(name="users_id")
    private User userObj;


    @OneToOne
    @JoinColumn(name="address_id")
    private UserAddress addrObj;



    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFinal_price() {
        return final_price;
    }

    public void setFinal_price(BigDecimal final_price) {
        this.final_price = final_price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public PaymentMethod getPayObj() {
        return payObj;
    }

    public void setPayObj(PaymentMethod payObj) {
        this.payObj = payObj;
    }


    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }

    public UserAddress getAddrObj() {
        return addrObj;
    }

    public void setAddrObj(UserAddress addrObj) {
        this.addrObj = addrObj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
