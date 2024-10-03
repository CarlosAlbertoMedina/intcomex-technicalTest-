package com.intcomex.gestion_intcomex.category.application.impl;

import com.intcomex.gestion_intcomex.category.application.DTOs.CategoryDTO;
import com.intcomex.gestion_intcomex.category.application.mapper.CategoryMapper;
import com.intcomex.gestion_intcomex.category.application.service.CategoryService;
import com.intcomex.gestion_intcomex.category.domain.model.Category;
import com.intcomex.gestion_intcomex.category.domain.port.CategoryRepository;
import com.intcomex.gestion_intcomex.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.convertToEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.convertToDTO(savedCategory);
    }

    @Override
    @Transactional
    public Page<CategoryDTO> getAllCategories(Pageable pageable) {
        Page<Category> categoriesPage = categoryRepository.findAll(pageable);
        return categoriesPage.map(categoryMapper::convertToDTO);
    }

    @Override
    @Transactional
    public Optional<CategoryDTO> getCategory(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::convertToDTO);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with ID: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        category.setCategoryName(categoryDTO.getCategoryName());
        category.setDescription(categoryDTO.getDescription());
        category.setPicture(categoryDTO.getPicture());

        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.convertToDTO(updatedCategory);
    }
}
