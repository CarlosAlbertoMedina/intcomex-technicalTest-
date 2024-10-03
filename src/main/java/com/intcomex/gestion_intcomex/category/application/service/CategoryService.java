package com.intcomex.gestion_intcomex.category.application.service;

import com.intcomex.gestion_intcomex.category.application.DTOs.CategoryDTO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    Page<CategoryDTO> getAllCategories(Pageable pageable) ;

    Optional<CategoryDTO> getCategory(Long id);

    void deleteCategory(Long id);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

}
