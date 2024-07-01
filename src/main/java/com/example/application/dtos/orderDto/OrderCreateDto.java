package com.example.application.dtos.orderDto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderCreateDto {
    @NotNull
    private Date orderDate;

    @NotNull
    private String status;

    @NotNull
    private UUID supplierId;

    @NotNull
    private List<UUID> orderItemIds;
}
