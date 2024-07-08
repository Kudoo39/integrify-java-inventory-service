package com.example.domain.order;

import com.example.application.dtos.orderDto.OrderCreateDto;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.application.dtos.orderDto.OrderUpdateDto;

import java.util.List;
import java.util.UUID;

public interface IOrderRepo {
    public List<OrderReadDto> getAllOrders();
    public OrderCreateDto createOrder(OrderCreateDto order);
    public Order getOrderById(UUID id);
    public OrderReadDto updateOrder(UUID id, OrderUpdateDto order);
    public void deleteOrder(UUID id);
}
