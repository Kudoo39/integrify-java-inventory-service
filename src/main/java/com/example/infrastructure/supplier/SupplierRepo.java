package com.example.infrastructure.supplier;

import com.example.application.dtos.SupplierMapper;
import com.example.application.dtos.supplierDto.SupplierCreateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.application.dtos.supplierDto.SupplierUpdateDto;
import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import com.example.exception.customException.ResourceNotFound;
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
    public SupplierReadDto getSupplierById(UUID id) {
        Supplier supplier = supplierJpaRepo.findById(id).orElse(null);
        SupplierReadDto supplierDto = supplierMapper.toSupplierRead(supplier);
        return supplierDto;
    }

    @Override
    public SupplierReadDto updateSupplier(UUID id, SupplierUpdateDto supplierDto) {
        Supplier existingSupplier = supplierJpaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Supplier not found with id: " + id));

        supplierMapper.updateSupplierFromDto(supplierDto, existingSupplier);

        Supplier savedSupplier = supplierJpaRepo.save(existingSupplier);

        return supplierMapper.toSupplierRead(savedSupplier);
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierJpaRepo.deleteById(id);
    }
}
