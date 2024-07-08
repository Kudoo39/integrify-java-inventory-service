package com.example.application.dtos.orderDto;

import com.example.application.dtos.orderItemDto.OrderItemReadDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderReadDto {
    private UUID id;
    private Date orderDate;
    private String status;
    private UUID supplierId;
    private List<OrderItemReadDto> orderItems;
}