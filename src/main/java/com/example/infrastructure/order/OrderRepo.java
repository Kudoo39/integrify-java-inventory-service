package com.example.infrastructure.order;

import com.example.application.dtos.OrderMapper;
import com.example.application.dtos.orderDto.OrderCreateDto;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.application.dtos.orderDto.OrderUpdateDto;
import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
import com.example.presentation.customException.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepo implements IOrderRepo {
    @Autowired
    private IOrderJpaRepo orderJpaRepo;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderReadDto> getAllOrders() {
        List<Order> orders = orderJpaRepo.findAll();
        List<OrderReadDto> orderDtos = new ArrayList<>();

        for (Order order : orders) {
            OrderReadDto orderDto = orderMapper.toOrderRead(order);
            orderDtos.add(orderDto);
        }

        return orderDtos;
    }

    @Override
    public Order getOrderById(UUID id) {
        return orderJpaRepo.findById(id).orElse(null);
    }

    @Override
    public OrderCreateDto createOrder(OrderCreateDto incomingOrder) {
        Order order = orderMapper.toOrder(incomingOrder);
        Order savedOrder = orderJpaRepo.save(order);
        return orderMapper.toOrderCreate(savedOrder);
    }

    @Override
    public OrderReadDto updateOrder(UUID id, OrderUpdateDto incomingOrder) {
        Order existingOrder = orderJpaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found with id: " + id));

        orderMapper.updateOrderFromDto(incomingOrder, existingOrder);

        Order savedOrder = orderJpaRepo.save(existingOrder);

        return orderMapper.toOrderRead(savedOrder);
    }

    @Override
    public void deleteOrder(UUID id) {
        orderJpaRepo.deleteById(id);
    }
}
