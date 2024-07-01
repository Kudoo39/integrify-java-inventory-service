package com.example.domain.orderItem;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;

import java.util.List;
import java.util.UUID;

public interface IOrderItemRepo {
    public List<OrderItemReadDto> getAllOrderItems();
    public OrderItem createOrderItem(OrderItem orderItem);
    public OrderItem getOrderItemById(UUID id);
    public OrderItem updateOrderItem(UUID id, OrderItem orderItem);
    public void deleteOrderItem(UUID id);
}
