package com.example.infrastructure.order;

import com.example.application.dtos.OrderMapper;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.domain.order.IOrderRepo;
import com.example.domain.order.Order;
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
    public Order createOrder(Order order) {
        return orderJpaRepo.save(order);
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        if (orderJpaRepo.existsById(id)) {
            order.setId(id);
            return orderJpaRepo.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(UUID id) {
        orderJpaRepo.deleteById(id);
    }
}
