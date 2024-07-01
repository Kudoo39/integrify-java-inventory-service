package com.example.application.orderItem;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.orderItem.OrderItem;
import com.example.exception.customException.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemRepo orderItemRepo;

    @Override
    public List<OrderItemReadDto> getAllOrderItems() {
        return orderItemRepo.getAllOrderItems();
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepo.createOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(UUID id) {
        OrderItem orderItem = orderItemRepo.getOrderItemById(id);
        if (orderItem == null) {
            throw new ResourceNotFound("OrderItem not found with id: " + id);
        }
        return orderItem;
    }

    @Override
    public OrderItem updateOrderItem(UUID id, OrderItem orderItem) {
        OrderItem existingOrderItem = orderItemRepo.getOrderItemById(id);
        if (existingOrderItem == null) {
            throw new ResourceNotFound("OrderItem not found with id: " + id);
        }
        return orderItemRepo.updateOrderItem(id, orderItem);
    }

    @Override
    public void deleteOrderItem(UUID id) {
        OrderItem orderItem = orderItemRepo.getOrderItemById(id);
        if (orderItem == null) {
            throw new ResourceNotFound("OrderItem not found with id: " + id);
        }
        orderItemRepo.deleteOrderItem(id);
    }
}
