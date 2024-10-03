package com.intcomex.gestion_intcomex.repository.supplier_test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.intcomex.gestion_intcomex.supplier.application.DTOs.SupplierDTO;
import com.intcomex.gestion_intcomex.supplier.application.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SupplierService supplierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSupplier() throws Exception {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId(1L);
        supplierDTO.setCompanyName("Example Inc.");
        when(supplierService.createSupplier(any(SupplierDTO.class))).thenReturn(supplierDTO);
        mockMvc.perform(post("/api/suppliers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"companyName\":\"Example Inc.\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").value("Example Inc."));
    }

    @Test
    @Order(2)
    void updateSupplier() throws Exception {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId(1L);
        supplierDTO.setCompanyName("Updated Inc.");
        when(supplierService.updateSupplier(eq(1L), any(SupplierDTO.class))).thenReturn(supplierDTO);
        mockMvc.perform(put("/api/suppliers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"supplierId\":1,\"companyName\":\"Updated Inc.\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").value("Updated Inc."));
    }

    @Test
    void getSupplierById_Exist() throws Exception {
        when(supplierService.getSupplierById(1L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/suppliers/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteSupplier() throws Exception {
        mockMvc.perform(delete("/api/suppliers/1"))
                .andExpect(status().isNoContent());
        verify(supplierService, times(1)).deleteSupplier(1L);
    }


}
