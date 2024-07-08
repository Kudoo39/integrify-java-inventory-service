package com.example.application.dtos.supplierDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierCreateDto {
    @Size(min = 2, max = 20, message = "should be between 2 and 20")
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