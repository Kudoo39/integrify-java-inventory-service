package com.example.infrastructure.order;

import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class OrderRepo implements IOrderRepo {
    @Autowired
    private IOrderJpaRepo orderRepo;
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(UUID id) {
        return orderRepo.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order updateOrder(UUID id, Order order) {
        if (orderRepo.existsById(id)) {
            order.setId(id);
            return orderRepo.save(order);
        }
        return null;
    }

    public void deleteOrder(UUID id) {
        orderRepo.deleteById(id);
    }
}
