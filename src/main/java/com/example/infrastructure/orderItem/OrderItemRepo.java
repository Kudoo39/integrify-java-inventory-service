package com.example.infrastructure.orderItem;

import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.orderItem.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderItemRepo implements IOrderItemRepo {
    @Autowired
    private IOrderItemJpaRepo orderItemRepo;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    @Override
    public OrderItem getOrderItemById(UUID id) {
        return orderItemRepo.findById(id).orElse(null);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepo.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(UUID id, OrderItem orderItem) {
        if (orderItemRepo.existsById(id)) {
            orderItem.setId(id);
            return orderItemRepo.save(orderItem);
        }
        return null;
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemRepo.deleteById(id);
    }
}
