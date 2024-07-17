package com.example.application.dtos;

import com.example.application.dtos.orderDto.OrderCreateDto;
import com.example.application.dtos.orderDto.OrderReadDto;
import com.example.application.dtos.orderDto.OrderUpdateDto;
import com.example.domain.order.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(source = "orderItems", target = "orderItems")
    Order toOrder(OrderCreateDto incomingOrder);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(source = "orderItems", target = "orderItems")
    void updateOrderFromDto(OrderUpdateDto updateDto, @MappingTarget Order order);

    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "orderItems", target = "orderItems")
    OrderReadDto toOrderRead(Order order);
}
