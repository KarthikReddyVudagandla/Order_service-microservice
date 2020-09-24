package org.example.service;

import org.example.entity.Order;
import org.example.entity.Payment;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Order findByOrder_id(String order_id) throws ResourceNotFoundException {
        Optional<Order> order= orderRepository.findByOrderId(order_id);
        if(!order.isPresent()){
            throw new ResourceNotFoundException("Error Occured!!");
        }
        System.out.println(order.get());
        return order.get();
    }

    @Override
    @Transactional
    public void deleteByOrder_id(String order_id) {
        orderRepository.deleteByOrderId(order_id);
    }

    @Override
    @Transactional
    public void insertOrUpdateBatch(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

}
