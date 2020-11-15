package models.order;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.users.User;
import models.users.UserAddress;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = " orxders")
public class Order {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private BigDecimal final_price;

    @Getter
    @Setter
    @Column
    private boolean success;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_at;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated_at;

    @OneToMany(mappedBy="orderObj", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
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

    public Order(Long id) {
        this.id = id;
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
}
