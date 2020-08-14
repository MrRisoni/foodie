package pojos;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Donation> donations;
    private PaymentMethod fop;
    private CreditCard cc;
    private List<OrderItem> orderItems;


    public Basket() {
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
