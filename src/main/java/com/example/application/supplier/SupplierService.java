package com.example.application.supplier;

import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    private ISupplierRepo supplierRepo;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.getAllSuppliers();
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepo.createSupplier(supplier);
    }

    @Override
    public Supplier getSupplierById(UUID id) {
        return supplierRepo.getSupplierById(id);
    }

    @Override
    public Supplier updateSupplier(UUID id, Supplier supplier) {
        return supplierRepo.updateSupplier(id, supplier);
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierRepo.deleteSupplier(id);
    }
}
