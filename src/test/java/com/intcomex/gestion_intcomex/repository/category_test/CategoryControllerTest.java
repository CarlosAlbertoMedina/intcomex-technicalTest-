package com.intcomex.gestion_intcomex.repository.category_test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.intcomex.gestion_intcomex.category.application.DTOs.CategoryDTO;
import com.intcomex.gestion_intcomex.category.application.service.CategoryService;
import com.intcomex.gestion_intcomex.category.infrastructure.controller.CategoryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateServersCategory() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName("SERVIDORES");

        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(categoryDTO);

        mockMvc.perform(post("/api/category")
                        .contentType("application/json")
                        .content("{\"categoryName\":\"SERVIDORES\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.categoryName").value(categoryDTO.getCategoryName()));
    }

    @Test
    public void testCreateCloudCategory() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName("CLOUD");

        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(categoryDTO);

        mockMvc.perform(post("/api/category")
                        .contentType("application/json")
                        .content("{\"categoryName\":\"CLOUD\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.categoryName").value(categoryDTO.getCategoryName()));
    }

    @Test
    public void testGetAllCategories() throws Exception {
        this.testCreateServersCategory();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName("CLOUD");

        Pageable pageable = PageRequest.of(0, 10);
        Page<CategoryDTO> categoryPage = new PageImpl<>(Collections.singletonList(categoryDTO), pageable, 1);

        when(categoryService.getAllCategories(pageable)).thenReturn(categoryPage);

        mockMvc.perform(get("/api/category?page=0&size=10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].categoryName").value(categoryDTO.getCategoryName()));
    }


}

