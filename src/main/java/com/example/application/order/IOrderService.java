package com.example.application.order;

import com.example.domain.order.Order;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    public List<Order> getAllOrders();
    public Order createOrder(Order order);
    public Order getOrderById(UUID id);
    public Order updateOrder(UUID id, Order order);
    public void deleteOrder(UUID id);
}
