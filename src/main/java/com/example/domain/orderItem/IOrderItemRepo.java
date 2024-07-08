package com.example.domain.orderItem;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.application.dtos.orderItemDto.OrderItemUpdateDto;

import java.util.List;
import java.util.UUID;

public interface IOrderItemRepo {
    public List<OrderItemReadDto> getAllOrderItems();
    public OrderItemCreateDto createOrderItem(OrderItemCreateDto orderItem);
    public OrderItem getOrderItemById(UUID id);
    public OrderItemReadDto updateOrderItem(UUID id, OrderItemUpdateDto orderItem);
    public void deleteOrderItem(UUID id);
}
