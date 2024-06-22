package com.example.application.order;

import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.getAllOrders();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepo.createOrder(order);
    }

    @Override
    public Order getOrderById(UUID id) {
        return orderRepo.getOrderById(id);
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        return orderRepo.updateOrder(id, order);
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepo.deleteOrder(id);
    }
}
