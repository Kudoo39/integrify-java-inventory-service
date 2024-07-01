package com.example.domain.supplier;

import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;

import java.util.List;
import java.util.UUID;

public interface ISupplierRepo {
    public List<SupplierReadDto> getAllSuppliers();
    public SupplierCreateDto createSupplier(SupplierCreateDto supplier);
    public Supplier getSupplierById(UUID id);
    public Supplier updateSupplier(UUID id, Supplier supplier);
    public void deleteSupplier(UUID id);


}
