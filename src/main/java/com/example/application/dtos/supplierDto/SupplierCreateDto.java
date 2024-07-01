package com.example.application.dtos.supplierDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierCreateDto {
    @NotNull
    private String name;

    @NotNull
    private String contactDetails;

    @NotNull
    private String address;

    @NotNull
    @Email
    private String email;
}
