package com.example.application.supplier;

import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import com.example.exception.customException.ResourceNotFound;
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
    public Supplier getSupplierById(UUID id) {
        Supplier supplier = supplierRepo.getSupplierById(id);
        if (supplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + id);
        }
        return supplier;
    }

    @Override
    public Supplier updateSupplier(UUID id, Supplier supplier) {
        Supplier existingSupplier = supplierRepo.getSupplierById(id);
        if (existingSupplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + id);
        }
        return supplierRepo.updateSupplier(id, supplier);
    }

    @Override
    public void deleteSupplier(UUID id) {
        Supplier supplier = supplierRepo.getSupplierById(id);
        if (supplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + id);
        }
        supplierRepo.deleteSupplier(id);
    }
}
