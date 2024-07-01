package com.example.application.dtos;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.domain.orderItem.OrderItem;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface OrderItemMapper {
    OrderItem toOrderItem(OrderItemCreateDto incomingOrderItem);
    OrderItemReadDto toOrderItemRead(OrderItem orderItem);
}
