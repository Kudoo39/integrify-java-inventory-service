package com.example.infrastructure.supplier;

import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class SupplierRepo implements ISupplierRepo {
    @Autowired
    private ISupplierJpaRepo supplierRepo;

    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Supplier getSupplierById(UUID id) {
        return supplierRepo.findById(id).orElse(null);
    }

    public Supplier updateSupplier(UUID id, Supplier supplier) {
        if (supplierRepo.existsById(id)) {
            supplier.setId(id);
            return supplierRepo.save(supplier);
        }
        return null;
    }

    public void deleteSupplier(UUID id) {
        supplierRepo.deleteById(id);
    }
}
