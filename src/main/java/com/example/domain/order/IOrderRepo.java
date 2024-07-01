package com.example.domain.order;

import com.example.application.dtos.orderDto.OrderReadDto;

import java.util.List;
import java.util.UUID;

public interface IOrderRepo {
    public List<OrderReadDto> getAllOrders();
    public Order createOrder(Order order);
    public Order getOrderById(UUID id);
    public Order updateOrder(UUID id, Order order);
    public void deleteOrder(UUID id);
}
