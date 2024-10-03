package com.intcomex.gestion_intcomex.supplier.application.impl;

import com.intcomex.gestion_intcomex.supplier.application.DTOs.SupplierDTO;
import com.intcomex.gestion_intcomex.supplier.application.mappers.SupplierMapper;
import com.intcomex.gestion_intcomex.supplier.application.service.SupplierService;
import com.intcomex.gestion_intcomex.supplier.domain.model.Supplier;
import com.intcomex.gestion_intcomex.supplier.domain.port.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    public Page<SupplierDTO> getAllSuppliers(Pageable pageable) {
        Page<Supplier> suppliersPage = supplierRepository.findAll(pageable);
        return suppliersPage.map(supplierMapper::toDTO);
    }

    public Optional<SupplierDTO> getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .map(supplierMapper::toDTO);
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return supplierMapper.toDTO(savedSupplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        supplier.setSupplierId(id);
        Supplier updatedSupplier = supplierRepository.save(supplier);
        return supplierMapper.toDTO(updatedSupplier);
    }
}
