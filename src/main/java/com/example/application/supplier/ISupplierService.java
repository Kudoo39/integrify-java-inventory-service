package com.example.application.supplier;

import com.example.domain.supplier.Supplier;

import java.util.List;
import java.util.UUID;

public interface ISupplierService {
    public List<Supplier> getAllSuppliers();
    public Supplier createSupplier(Supplier supplier);
    public Supplier getSupplierById(UUID id);
    public Supplier updateSupplier(UUID id, Supplier supplier);
    public void deleteSupplier(UUID id);
}
