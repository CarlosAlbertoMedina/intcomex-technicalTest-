package com.intcomex.gestion_intcomex.category.application.mapper;

import com.intcomex.gestion_intcomex.category.application.DTOs.CategoryDTO;
import com.intcomex.gestion_intcomex.category.domain.model.Category;
import com.intcomex.gestion_intcomex.product.application.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    private final ProductMapper productMapper;

    @Autowired
    public CategoryMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public CategoryDTO convertToDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        dto.setPicture(category.getPicture());
        dto.setProducts(category.getProducts() != null ?
                category.getProducts().stream()
                        .map(productMapper::convertToDTO)
                        .collect(Collectors.toList()) : null);

        return dto;
    }

    public Category convertToEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());
        category.setPicture(dto.getPicture());
        return category;
    }
}

