package com.example.application.supplier;

import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.application.dtos.supplierDto.SupplierUpdateDto;
import com.example.domain.supplier.ISupplierRepo;
import com.example.presentation.customException.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    private ISupplierRepo supplierRepo;

    @Override
    public List<SupplierReadDto> getAllSuppliers() {
        return supplierRepo.getAllSuppliers();
    }

    @Override
    public SupplierCreateDto createSupplier(SupplierCreateDto supplier) {
        return supplierRepo.createSupplier(supplier);
    }

    @Override
    public SupplierReadDto getSupplierById(UUID id) {
        SupplierReadDto supplier = supplierRepo.getSupplierById(id);
        if (supplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + id);
        }
        return supplier;
    }

    @Override
    public SupplierReadDto updateSupplier(UUID id, SupplierUpdateDto supplier) {
        SupplierReadDto existingSupplier = supplierRepo.getSupplierById(id);
        if (existingSupplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + id);
        }
        return supplierRepo.updateSupplier(id, supplier);
    }

    @Override
    public void deleteSupplier(UUID id) {
        SupplierReadDto supplier = supplierRepo.getSupplierById(id);
        if (supplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + id);
        }
        supplierRepo.deleteSupplier(id);
    }
}
