package com.intcomex.gestion_intcomex.product.application.mappers;

import com.intcomex.gestion_intcomex.category.domain.model.Category;
import com.intcomex.gestion_intcomex.product.application.DTOs.ProductDTO;
import com.intcomex.gestion_intcomex.product.domain.model.Product;
import com.intcomex.gestion_intcomex.supplier.domain.model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public ProductDTO convertToDTO(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setQuantityPerUnit(product.getQuantityPerUnit());
        dto.setUnitPrice(product.getUnitPrice());
        dto.setStock(product.getStock());
        dto.setUnitsOnOrder(product.getUnitsOnOrder());
        dto.setReorderLevel(product.getReorderLevel());
        dto.setDiscontinued(product.getDiscontinued());

        if (product.getSupplier() != null) {
            dto.setSupplierId(product.getSupplier().getSupplierId());
        }
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getCategoryId());
        }

        return dto;
    }

    public Product convertToEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setQuantityPerUnit(dto.getQuantityPerUnit());
        product.setUnitPrice(dto.getUnitPrice());
        product.setStock(dto.getStock());
        product.setUnitsOnOrder(dto.getUnitsOnOrder());
        product.setReorderLevel(dto.getReorderLevel());
        product.setDiscontinued(dto.getDiscontinued());

        if (dto.getSupplierId() != null) {
            Supplier supplier = new Supplier();
            supplier.setSupplierId(dto.getSupplierId());
            product.setSupplier(supplier);
        }
        if (dto.getCategoryId() != null) {
            Category category = new Category();
            category.setCategoryId(dto.getCategoryId());
            product.setCategory(category);
        }

        return product;
    }
}
