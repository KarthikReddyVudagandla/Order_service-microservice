package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ITEMS",schema = "public")
public class Item {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="ITEM_ID", updatable = false, nullable = false)
    private String item_id;

//    @Column(name = "ORDER_ID")
//    private  String order_id;

    private String item_name;

    private int item_qty;

    private Double item_cost;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID",insertable = false,updatable = false)
    private Order order;

    public Item(String item_id, String item_name, int item_qty, Double item_cost, Order order) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_qty = item_qty;
        this.item_cost = item_cost;
        this.order = order;
    }

    public Item() {
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

//    public String getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(String order_id) {
//        this.order_id = order_id;
//    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }

    public Double getItem_cost() {
        return item_cost;
    }

    public void setItem_cost(Double item_cost) {
        this.item_cost = item_cost;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id='" + item_id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_qty=" + item_qty +
                ", item_cost=" + item_cost +
                '}';
    }
}
