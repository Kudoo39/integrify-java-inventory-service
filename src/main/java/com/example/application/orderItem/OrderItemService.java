package com.example.application.orderItem;

import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.orderItem.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemRepo orderItemRepo;


    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.getAllOrderItems();
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepo.createOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(UUID id) {
        return orderItemRepo.getOrderItemById(id);
    }

    @Override
    public OrderItem updateOrderItem(UUID id, OrderItem orderItem) {
        return orderItemRepo.updateOrderItem(id, orderItem);
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemRepo.deleteOrderItem(id);
    }
}
