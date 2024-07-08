package com.example.application.dtos;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import com.example.application.dtos.orderItemDto.OrderItemUpdateDto;
import com.example.domain.orderItem.OrderItem;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface OrderItemMapper {
    OrderItem toOrderItem(OrderItemCreateDto incomingOrderItem);
    void updateOrderItemFromDto(OrderItemUpdateDto updateDto, @MappingTarget OrderItem orderItem);
    OrderItemReadDto toOrderItemRead(OrderItem orderItem);
    OrderItemCreateDto toOrderItemCreate(OrderItem orderItem);
}
