package com.example.application.order;

import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
import com.example.exception.customException.ResourceNotFound;
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
        Order order = orderRepo.getOrderById(id);
        if (order == null) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        return order;
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        Order existingOrder = orderRepo.getOrderById(id);
        if (existingOrder == null) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        return orderRepo.updateOrder(id, order);
    }

    @Override
    public void deleteOrder(UUID id) {
        Order order = orderRepo.getOrderById(id);
        if (order == null) {
            throw new ResourceNotFound("Order not found with id: " + id);
        }
        orderRepo.deleteOrder(id);
    }
}
