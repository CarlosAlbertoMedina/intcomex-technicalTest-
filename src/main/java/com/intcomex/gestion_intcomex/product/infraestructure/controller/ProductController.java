package com.intcomex.gestion_intcomex.product.infraestructure.controller;

import com.intcomex.gestion_intcomex.product.application.DTOs.ProductDTO;
import com.intcomex.gestion_intcomex.product.application.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Api(tags = "Productos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ApiOperation(value = "Obtener lista de productos")
    public Page<ProductDTO> getProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un producto por ID")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Optional<ProductDTO> productDTO = productService.getProduct(id);
        return productDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo producto")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar un producto existente")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un producto por ID")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}