package org.example.controller;

import org.example.entity.Order;
import org.example.exception.ResourceNotFoundException;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "{order_id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order get_order(@PathVariable("order_id") String order_id) throws ResourceNotFoundException {
        return orderService.findByOrder_id( order_id );
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create_order(@RequestBody Order order){
        orderService.insert(order);
    }

    @RequestMapping(value = "{order_id}",method = RequestMethod.DELETE)
    public void cancel_order(@PathVariable("order_id") String order_id) {
        orderService.deleteByOrder_id( order_id );
    }

    @RequestMapping(value="batch",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void batch_create_orders(@RequestBody List<Order> orders){
        orderService.insertOrUpdateBatch(orders);
    }

    @RequestMapping(value="batch",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void batch_update_orders(@RequestBody List<Order> orders){
        orderService.insertOrUpdateBatch(orders);
    }

}
