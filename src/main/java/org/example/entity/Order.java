package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="ORDERS",schema = "public")
public class Order implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ORDER_ID",updatable = false,nullable = false)
    private  String orderId;

    @Column(name = "CUSTOMER_ID")
    private int customer_id;

    @Column(name = "SHIPPING_METHOD")
    private String shipping_method;

    private Boolean shippingAddress_sameAs_BillingAddress;

//    private Date createdDate;
//
//    private Date modifiedDate;

    private Double order_subtotal;

    private Double order_tax;

    private Double order_shipping_charges;

    private Double order_total;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="ORDER_ID")
    private List<Item> itemList;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="ORDER_ID")
    private List<Payment> paymentList;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SHIPPING_ID",referencedColumnName = "SHIPPING_ID")
    private Shipping shipping;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getShipping_method() {
        return shipping_method;
    }

    public void setShipping_method(String shipping_method) {
        this.shipping_method = shipping_method;
    }

    public Boolean getShippingAddress_sameAs_BillingAddress() {
        return shippingAddress_sameAs_BillingAddress;
    }

    public void setShippingAddress_sameAs_BillingAddress(Boolean shippingAddress_sameAs_BillingAddress) {
        this.shippingAddress_sameAs_BillingAddress = shippingAddress_sameAs_BillingAddress;
    }

    public Double getOrder_subtotal() {
        return order_subtotal;
    }

    public void setOrder_subtotal(Double order_subtotal) {
        this.order_subtotal = order_subtotal;
    }

    public Double getOrder_tax() {
        return order_tax;
    }

    public void setOrder_tax(Double order_tax) {
        this.order_tax = order_tax;
    }

    public Double getOrder_shipping_charges() {
        return order_shipping_charges;
    }

    public void setOrder_shipping_charges(Double order_shipping_charges) {
        this.order_shipping_charges = order_shipping_charges;
    }

    public Double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Double order_total) {
        this.order_total = order_total;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Order(String orderId, int customer_id, String shipping_method, Boolean shippingAddress_sameAs_BillingAddress, Double order_subtotal, Double order_tax, Double order_shipping_charges, Double order_total, List<Item> itemList, List<Payment> paymentList, Shipping shipping) {
        this.orderId = orderId;
        this.customer_id = customer_id;
        this.shipping_method = shipping_method;
        this.shippingAddress_sameAs_BillingAddress = shippingAddress_sameAs_BillingAddress;
        this.order_subtotal = order_subtotal;
        this.order_tax = order_tax;
        this.order_shipping_charges = order_shipping_charges;
        this.order_total = order_total;
        this.itemList = itemList;
        this.paymentList = paymentList;
        this.shipping = shipping;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer_id=" + customer_id +
                ", shipping_method='" + shipping_method + '\'' +
                ", shippingAddress_sameAs_BillingAddress=" + shippingAddress_sameAs_BillingAddress +
                ", order_subtotal=" + order_subtotal +
                ", order_tax=" + order_tax +
                ", order_shipping_charges=" + order_shipping_charges +
                ", order_total=" + order_total +
                ", itemList=" + itemList +
                ", paymentList=" + paymentList +
                ", shipping=" + shipping +
                '}';
    }
}
