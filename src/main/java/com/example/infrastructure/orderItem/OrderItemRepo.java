package com.example.infrastructure.orderItem;

import com.example.application.dtos.OrderItemMapper;
import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.application.dtos.orderItemDto.OrderItemUpdateDto;
import com.example.domain.orderItem.IOrderItemRepo;
import com.example.domain.orderItem.OrderItem;
import com.example.presentation.customException.ResourceNotFound;
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
    public OrderItemCreateDto createOrderItem(OrderItemCreateDto incomingOrderItem) {
        OrderItem orderItem = orderItemMapper.toOrderItem(incomingOrderItem);
        OrderItem savedOrderItem = orderItemJpaRepo.save(orderItem);
        return orderItemMapper.toOrderItemCreate(savedOrderItem);
    }

    @Override
    public OrderItemReadDto updateOrderItem(UUID id, OrderItemUpdateDto incomingOrderItem) {
        OrderItem existingOrderItem = orderItemJpaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("OrderItem not found with id: " + id));

        orderItemMapper.updateOrderItemFromDto(incomingOrderItem, existingOrderItem);

        OrderItem savedOrderItem = orderItemJpaRepo.save(existingOrderItem);

        return orderItemMapper.toOrderItemRead(savedOrderItem);
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemJpaRepo.deleteById(id);
    }
}
