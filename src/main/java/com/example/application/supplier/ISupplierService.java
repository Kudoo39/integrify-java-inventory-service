package com.example.application.supplier;

import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.application.dtos.supplierDto.SupplierUpdateDto;
import com.example.domain.supplier.Supplier;

import java.util.List;
import java.util.UUID;

public interface ISupplierService {
    public List<SupplierReadDto> getAllSuppliers();
    public SupplierCreateDto createSupplier(SupplierCreateDto supplier);
    public SupplierReadDto getSupplierById(UUID id);
    public SupplierReadDto updateSupplier(UUID id, SupplierUpdateDto supplier);
    public void deleteSupplier(UUID id);
}
