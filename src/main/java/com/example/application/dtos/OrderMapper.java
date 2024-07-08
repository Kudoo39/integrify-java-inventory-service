package com.example.application.dtos;

import com.example.application.dtos.orderDto.OrderCreateDto;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.application.dtos.orderDto.OrderUpdateDto;
import com.example.domain.order.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface OrderMapper {
    Order toOrder(OrderCreateDto incomingOrder);
    void updateOrderFromDto(OrderUpdateDto updateDto, @MappingTarget Order order);
    OrderReadDto toOrderRead(Order order);
    OrderCreateDto toOrderCreate(Order order);
}
