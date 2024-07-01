package com.example.application.dtos;

import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.domain.supplier.Supplier;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface SupplierMapper {
    Supplier toSupplier(SupplierCreateDto incomingSupplier);
    SupplierReadDto toSupplierRead(Supplier supplier);
    SupplierCreateDto toSupplierCreate(Supplier supplier);
}
