package com.example.application.order;

import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.domain.order.Order;
import com.example.domain.orderItem.OrderItem;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    public List<OrderReadDto> getAllOrders();
    public Order createOrder(Order order);
    public Order getOrderById(UUID id);
    public Order updateOrder(UUID id, Order order);
    public void deleteOrder(UUID id);
}
