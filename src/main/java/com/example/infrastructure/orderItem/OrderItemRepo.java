package com.example.infrastructure.orderItem;

import com.example.application.dtos.OrderItemMapper;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.orderItem.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderItemRepo implements IOrderItemRepo {
    @Autowired
    private IOrderItemJpaRepo orderItemJpaRepo;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItemReadDto> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemJpaRepo.findAll();
        List<OrderItemReadDto> orderItemDtos = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            OrderItemReadDto orderItemDto = orderItemMapper.toOrderItemRead(orderItem);
            orderItemDtos.add(orderItemDto);
        }

        return orderItemDtos;
    }

    @Override
    public OrderItem getOrderItemById(UUID id) {
        return orderItemJpaRepo.findById(id).orElse(null);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemJpaRepo.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(UUID id, OrderItem orderItem) {
        if (orderItemJpaRepo.existsById(id)) {
            orderItem.setId(id);
            return orderItemJpaRepo.save(orderItem);
        }
        return null;
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemJpaRepo.deleteById(id);
    }
}
