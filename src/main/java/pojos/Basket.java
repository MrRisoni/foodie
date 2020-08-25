package pojos;

import models.order.CreditCard;
import models.order.Donation;
import models.order.OrderItem;
import models.order.PaymentMethod;

import java.util.List;

public class Basket {
    private List<Donation> donations;
    private PaymentMethod fop;
    private CreditCard cc;
    private List<OrderItem> orderItems;
    private Long userId;
    private Long addressId;

    public Basket() {
    }

    public Long getUserId()
    {
        return this.userId;
    }


    public Long getAddressId()
    {
        return this.userId;
    }


    public void setUserId(Long userId)
    {
        this.userId  =userId;
    }


    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public PaymentMethod getFop() {
        return fop;
    }

    public void setFop(PaymentMethod fop) {
        this.fop = fop;
    }

    public CreditCard getCc() {
        return cc;
    }

    public void setCc(CreditCard cc) {
        this.cc = cc;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
