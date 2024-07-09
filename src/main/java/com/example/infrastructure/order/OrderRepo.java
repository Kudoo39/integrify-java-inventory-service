package com.example.infrastructure.order;

import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepo implements IOrderRepo {
    @Autowired
    private IOrderJpaRepo orderJpaRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderJpaRepo.findAll();
    }

    @Override
    public Order getOrderById(UUID id) {
        return orderJpaRepo.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderJpaRepo.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderJpaRepo.save(order);
    }

    @Override
    public void deleteOrder(UUID id) {
        orderJpaRepo.deleteById(id);
    }
}
