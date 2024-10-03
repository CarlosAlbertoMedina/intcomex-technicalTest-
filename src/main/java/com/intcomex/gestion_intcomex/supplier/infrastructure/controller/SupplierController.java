package com.intcomex.gestion_intcomex.supplier.infrastructure.controller;

import com.intcomex.gestion_intcomex.supplier.application.DTOs.SupplierDTO;
import com.intcomex.gestion_intcomex.supplier.application.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Api(tags = "Suppliers", description = "Operaciones relacionadas con proveedores")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    @ApiOperation(value = "Obtener todos los proveedores", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Éxito"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public Page<SupplierDTO> getAllSuppliers(@PageableDefault(size = 10) Pageable pageable) {
        return supplierService.getAllSuppliers(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un proveedor por ID", response = SupplierDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Éxito"),
            @ApiResponse(code = 404, message = "Proveedor no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo proveedor", response = SupplierDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Proveedor creado"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public SupplierDTO createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.createSupplier(supplierDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar un proveedor existente", response = SupplierDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Proveedor actualizado"),
            @ApiResponse(code = 404, message = "Proveedor no encontrado"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public SupplierDTO updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        return supplierService.updateSupplier(id, supplierDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un proveedor por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Proveedor eliminado"),
            @ApiResponse(code = 404, message = "Proveedor no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
