package com.example.infrastructure.supplier;

import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SupplierRepo implements ISupplierRepo {
    @Autowired
    private ISupplierJpaRepo supplierRepo;


    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public Supplier getSupplierById(UUID id) {
        return supplierRepo.findById(id).orElse(null);
    }

    @Override
    public Supplier updateSupplier(UUID id, Supplier supplier) {
        if (supplierRepo.existsById(id)) {
            supplier.setId(id);
            return supplierRepo.save(supplier);
        }
        return null;
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierRepo.deleteById(id);
    }
}
