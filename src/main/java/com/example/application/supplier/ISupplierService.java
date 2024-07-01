package com.example.application.supplier;

import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.domain.supplier.Supplier;

import java.util.List;
import java.util.UUID;

public interface ISupplierService {
    public List<SupplierReadDto> getAllSuppliers();
    public SupplierCreateDto createSupplier(SupplierCreateDto supplier);
    public Supplier getSupplierById(UUID id);
    public Supplier updateSupplier(UUID id, Supplier supplier);
    public void deleteSupplier(UUID id);
}
