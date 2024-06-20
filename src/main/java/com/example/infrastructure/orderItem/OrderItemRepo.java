package com.example.infrastructure.orderItem;

import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.orderItem.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class OrderItemRepo implements IOrderItemRepo {
    @Autowired
    private IOrderItemJpaRepo orderItemRepo;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    public OrderItem getOrderItemById(UUID id) {
        return orderItemRepo.findById(id).orElse(null);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepo.save(orderItem);
    }

    public OrderItem updateOrderItem(UUID id, OrderItem orderItem) {
        if (orderItemRepo.existsById(id)) {
            orderItem.setId(id);
            return orderItemRepo.save(orderItem);
        }
        return null;
    }

    public void deleteOrderItem(UUID id) {
        orderItemRepo.deleteById(id);
    }
}
