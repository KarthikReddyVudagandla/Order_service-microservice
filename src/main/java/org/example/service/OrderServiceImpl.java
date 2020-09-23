package org.example.service;

import org.example.entity.Order;
import org.example.entity.Payment;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements  OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void insert(Order order) {

        orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order findByOrder_id(String order_id) {
        Optional<Order> order= orderRepository.findByOrderId(order_id);
        if(!order.isPresent()){

        }
        System.out.println(order.get());
        return order.get();
    }

    @Override
    @Transactional
    public void deleteByOrder_id(String order_id) {
        orderRepository.deleteByOrderId(order_id);
    }
}
