package com.example.domain.supplier;

import java.util.List;
import java.util.UUID;

public interface ISupplierRepo {
    public List<Supplier> getAllSuppliers();
    public Supplier createSupplier(Supplier supplier);
    public Supplier getSupplierById(UUID id);
    public Supplier updateSupplier(Supplier supplier);
    public void deleteSupplier(UUID id);


}
