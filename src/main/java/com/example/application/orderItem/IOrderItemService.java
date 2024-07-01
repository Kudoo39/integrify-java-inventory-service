package com.example.application.orderItem;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.domain.orderItem.OrderItem;

import java.util.List;
import java.util.UUID;

public interface IOrderItemService {
    public List<OrderItemReadDto> getAllOrderItems();
    public OrderItem createOrderItem(OrderItem orderItem);
    public OrderItem getOrderItemById(UUID id);
    public OrderItem updateOrderItem(UUID id, OrderItem orderItem);
    public void deleteOrderItem(UUID id);
}
