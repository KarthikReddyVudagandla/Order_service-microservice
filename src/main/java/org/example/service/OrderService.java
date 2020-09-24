package org.example.service;

import org.example.entity.Order;
import org.example.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void insert(Order order);

    Order findByOrder_id(String order_id) throws ResourceNotFoundException;

    void deleteByOrder_id(String order_id);

    void insertOrUpdateBatch(List<Order> orders);

}
