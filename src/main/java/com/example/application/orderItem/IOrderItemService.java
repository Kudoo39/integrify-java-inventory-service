package com.example.application.orderItem;

import com.example.domain.orderItem.OrderItem;

import java.util.List;
import java.util.UUID;

public interface IOrderItemService {
    public List<com.example.domain.orderItem.OrderItem> getAllOrderItems();
    public com.example.domain.orderItem.OrderItem createOrderItem(com.example.domain.orderItem.OrderItem orderItem);
    public com.example.domain.orderItem.OrderItem getOrderItemById(UUID id);
    public com.example.domain.orderItem.OrderItem updateOrderItem(UUID id, OrderItem orderItem);
    public void deleteOrderItem(UUID id);
}
