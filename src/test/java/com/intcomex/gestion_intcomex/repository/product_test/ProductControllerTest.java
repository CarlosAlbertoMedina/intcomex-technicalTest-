package com.intcomex.gestion_intcomex.repository.product_test;

import com.intcomex.gestion_intcomex.product.application.DTOs.ProductDTO;
import com.intcomex.gestion_intcomex.product.application.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProducts() throws Exception {
        mockMvc.perform(get("/api/products?page=0&size=10"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Widget A");
        productDTO.setCategoryId(1L);
        productDTO.setSupplierId(1L);


        Mockito.when(productService.createProduct(any(ProductDTO.class))).thenReturn(productDTO);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productName\": \"Widget A\", \"supplierId\": 1, \"categoryId\": 1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.productName").value("Widget A"));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setProductName("Updated Widget");
        productDTO.setCategoryId(1L);
        productDTO.setSupplierId(1L);
        Mockito.when(productService.updateProduct(any(Long.class), any(ProductDTO.class))).thenReturn(productDTO);

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productName\": \"Updated Widget\", \"supplierId\": 1, \"categoryId\": 1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("Updated Widget"));
    }

    @Test
    public void testGetProductById() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setProductName("Widget A");

        Mockito.when(productService.getProduct(1L)).thenReturn(Optional.of(productDTO));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("Updated Widget"));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Mockito.doNothing().when(productService).deleteProduct(1L);
        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }
}
