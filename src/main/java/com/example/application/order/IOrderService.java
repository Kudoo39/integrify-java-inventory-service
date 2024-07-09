package com.example.application.order;

import com.example.application.dtos.orderDto.OrderCreateDto;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.application.dtos.orderDto.OrderUpdateDto;
import com.example.domain.order.Order;
import com.example.domain.orderItem.OrderItem;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    public List<OrderReadDto> getAllOrders();
    public OrderCreateDto createOrder(OrderCreateDto order);
    public OrderReadDto getOrderById(UUID id);
    public OrderReadDto updateOrder(UUID id, OrderUpdateDto order);
    public void deleteOrder(UUID id);
}
