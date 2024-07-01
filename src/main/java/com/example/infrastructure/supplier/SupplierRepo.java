package com.example.infrastructure.supplier;

import com.example.application.dtos.SupplierMapper;
import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class SupplierRepo implements ISupplierRepo {
    @Autowired
    private ISupplierJpaRepo supplierJpaRepo;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<SupplierReadDto> getAllSuppliers() {
        List<Supplier> suppliers = supplierJpaRepo.findAll();
        List<SupplierReadDto> supplierDtos = new ArrayList<>();

        for (Supplier supplier : suppliers) {
            SupplierReadDto supplierDto = supplierMapper.toSupplierRead(supplier);
            supplierDtos.add(supplierDto);
        }

        return supplierDtos;
    }

    @Override
    public SupplierCreateDto createSupplier(SupplierCreateDto incomingSupplier) {
        Supplier supplier = supplierMapper.toSupplier(incomingSupplier);
        Supplier savedSupplier = supplierJpaRepo.save(supplier);
        return supplierMapper.toSupplierCreate(savedSupplier);
    }

    @Override
    public Supplier getSupplierById(UUID id) {
        return supplierJpaRepo.findById(id).orElse(null);
    }

    @Override
    public Supplier updateSupplier(UUID id, Supplier supplier) {
        if (supplierJpaRepo.existsById(id)) {
            supplier.setId(id);
            return supplierJpaRepo.save(supplier);
        }
        return null;
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierJpaRepo.deleteById(id);
    }
}
