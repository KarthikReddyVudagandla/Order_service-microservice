package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PAYMENTS",schema = "public")
public class Payment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="PAYMENT_ID", updatable = false, nullable = false)
    private String payment_id;

//    @Column(name = "ORDER_ID")
//    private  String order_id;

    private String payment_method;

//    private Date payment_date;

    private int payment_confirmation_number;

    private String billing_addressline1;

    private String billing_addressline2;

    private String billing_city;

    private String billing_state;

    private int billing_zip;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID",insertable = false,updatable = false)
    private Order order;

    public Payment(String payment_id, String payment_method, int payment_confirmation_number, String billing_addressline1, String billing_addressline2, String billing_city, String billing_state, int billing_zip, Order order) {
        this.payment_id = payment_id;
        this.payment_method = payment_method;
        this.payment_confirmation_number = payment_confirmation_number;
        this.billing_addressline1 = billing_addressline1;
        this.billing_addressline2 = billing_addressline2;
        this.billing_city = billing_city;
        this.billing_state = billing_state;
        this.billing_zip = billing_zip;
        this.order = order;
    }

    public Payment() {
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

//    public String getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(String order_id) {
//        this.order_id = order_id;
//    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public int getPayment_confirmation_number() {
        return payment_confirmation_number;
    }

    public void setPayment_confirmation_number(int payment_confirmation_number) {
        this.payment_confirmation_number = payment_confirmation_number;
    }

    public String getBilling_addressline1() {
        return billing_addressline1;
    }

    public void setBilling_addressline1(String billing_addressline1) {
        this.billing_addressline1 = billing_addressline1;
    }

    public String getBilling_addressline2() {
        return billing_addressline2;
    }

    public void setBilling_addressline2(String billing_addressline2) {
        this.billing_addressline2 = billing_addressline2;
    }

    public String getBilling_city() {
        return billing_city;
    }

    public void setBilling_city(String billing_city) {
        this.billing_city = billing_city;
    }

    public String getBilling_state() {
        return billing_state;
    }

    public void setBilling_state(String billing_state) {
        this.billing_state = billing_state;
    }

    public int getBilling_zip() {
        return billing_zip;
    }

    public void setBilling_zip(int billing_zip) {
        this.billing_zip = billing_zip;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id='" + payment_id + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", payment_confirmation_number=" + payment_confirmation_number +
                ", billing_addressline1='" + billing_addressline1 + '\'' +
                ", billing_addressline2='" + billing_addressline2 + '\'' +
                ", billing_city='" + billing_city + '\'' +
                ", billing_state='" + billing_state + '\'' +
                ", billing_zip=" + billing_zip +
                '}';
    }
}
