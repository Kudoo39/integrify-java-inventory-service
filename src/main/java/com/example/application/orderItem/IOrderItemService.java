package com.example.application.orderItem;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.application.dtos.orderItemDto.OrderItemUpdateDto;
import com.example.domain.orderItem.OrderItem;

import java.util.List;
import java.util.UUID;

public interface IOrderItemService {
    public List<OrderItemReadDto> getAllOrderItems();
    public OrderItemCreateDto createOrderItem(OrderItemCreateDto orderItem);
    public OrderItemReadDto getOrderItemById(UUID id);
    public OrderItemReadDto updateOrderItem(UUID id, OrderItemUpdateDto orderItem);
    public void deleteOrderItem(UUID id);
}
