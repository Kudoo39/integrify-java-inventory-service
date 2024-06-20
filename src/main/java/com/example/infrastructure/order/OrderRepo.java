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
    private IOrderJpaRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(UUID id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        if (orderRepo.existsById(id)) {
            order.setId(id);
            return orderRepo.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepo.deleteById(id);
    }
}
