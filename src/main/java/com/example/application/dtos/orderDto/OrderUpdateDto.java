package com.example.application.dtos.orderDto;

import com.example.application.dtos.orderItemDto.OrderItemCreateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderUpdateDto {
    private Date orderDate;
    private String status;
    private UUID supplierId;
    private List<OrderItemCreateDto> orderItems;
}
