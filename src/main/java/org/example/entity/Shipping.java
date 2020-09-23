package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="SHIPPINGS",schema = "public")
public class Shipping {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="SHIPPING_ID", updatable = false, nullable = false)
    private String shipping_id;

    private String shipping_addressline1;

    private String shipping_addressline2;

    private String shipping_city;

    private String shipping_state;

    private int shipping_zip;

    @JsonBackReference
    @OneToOne(mappedBy = "shipping")
    private Order order;

    public Shipping(String shipping_id, String shipping_addressline1, String shipping_addressline2, String shipping_city, String shipping_state, int shipping_zip, Order order) {
        this.shipping_id = shipping_id;
        this.shipping_addressline1 = shipping_addressline1;
        this.shipping_addressline2 = shipping_addressline2;
        this.shipping_city = shipping_city;
        this.shipping_state = shipping_state;
        this.shipping_zip = shipping_zip;
        this.order = order;
    }

    public Shipping() {
    }

    public String getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(String shipping_id) {
        this.shipping_id = shipping_id;
    }

    public String getShipping_addressline1() {
        return shipping_addressline1;
    }

    public void setShipping_addressline1(String shipping_addressline1) {
        this.shipping_addressline1 = shipping_addressline1;
    }

    public String getShipping_addressline2() {
        return shipping_addressline2;
    }

    public void setShipping_addressline2(String shipping_addressline2) {
        this.shipping_addressline2 = shipping_addressline2;
    }

    public String getShipping_city() {
        return shipping_city;
    }

    public void setShipping_city(String shipping_city) {
        this.shipping_city = shipping_city;
    }

    public String getShipping_state() {
        return shipping_state;
    }

    public void setShipping_state(String shipping_state) {
        this.shipping_state = shipping_state;
    }

    public int getShipping_zip() {
        return shipping_zip;
    }

    public void setShipping_zip(int shipping_zip) {
        this.shipping_zip = shipping_zip;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "shipping_id='" + shipping_id + '\'' +
                ", shipping_addressline1='" + shipping_addressline1 + '\'' +
                ", shipping_addressline2='" + shipping_addressline2 + '\'' +
                ", shipping_city='" + shipping_city + '\'' +
                ", shipping_state='" + shipping_state + '\'' +
                ", shipping_zip=" + shipping_zip +
                '}';
    }
}
