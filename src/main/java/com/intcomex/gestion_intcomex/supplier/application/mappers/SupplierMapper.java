package com.intcomex.gestion_intcomex.supplier.application.mappers;

import com.intcomex.gestion_intcomex.supplier.application.DTOs.SupplierDTO;
import com.intcomex.gestion_intcomex.supplier.domain.model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public SupplierDTO toDTO(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO dto = new SupplierDTO();
        dto.setSupplierId(supplier.getSupplierId());
        dto.setCompanyName(supplier.getCompanyName());
        dto.setContactName(supplier.getContactName());
        dto.setContactTitle(supplier.getContactTitle());
        dto.setAddress(supplier.getAddress());
        dto.setCity(supplier.getCity());
        dto.setRegion(supplier.getRegion());
        dto.setPostalCode(supplier.getPostalCode());
        dto.setCountry(supplier.getCountry());
        dto.setPhone(supplier.getPhone());
        dto.setFax(supplier.getFax());
        dto.setHomePage(supplier.getHomePage());
        return dto;
    }

    public Supplier toEntity(SupplierDTO dto) {
        if (dto == null) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setSupplierId(dto.getSupplierId());
        supplier.setCompanyName(dto.getCompanyName());
        supplier.setContactName(dto.getContactName());
        supplier.setContactTitle(dto.getContactTitle());
        supplier.setAddress(dto.getAddress());
        supplier.setCity(dto.getCity());
        supplier.setRegion(dto.getRegion());
        supplier.setPostalCode(dto.getPostalCode());
        supplier.setCountry(dto.getCountry());
        supplier.setPhone(dto.getPhone());
        supplier.setFax(dto.getFax());
        supplier.setHomePage(dto.getHomePage());
        return supplier;
    }
}

