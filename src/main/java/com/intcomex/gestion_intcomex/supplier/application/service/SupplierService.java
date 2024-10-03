package com.intcomex.gestion_intcomex.supplier.application.service;

import com.intcomex.gestion_intcomex.supplier.application.DTOs.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SupplierService {

    SupplierDTO createSupplier(SupplierDTO supplierDTO);

    Page<SupplierDTO> getAllSuppliers(Pageable pageable) ;

    Optional<SupplierDTO> getSupplierById(Long id);

    void deleteSupplier(Long id);

    SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO);

}
