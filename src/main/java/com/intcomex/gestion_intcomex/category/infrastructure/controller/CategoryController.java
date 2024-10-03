package com.intcomex.gestion_intcomex.category.infrastructure.controller;

import com.intcomex.gestion_intcomex.category.application.DTOs.CategoryDTO;
import com.intcomex.gestion_intcomex.category.application.service.CategoryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
@Api(value = "Category Management", tags = "Categorías")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener una categoría por ID", response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categoría encontrada"),
            @ApiResponse(code = 404, message = "Categoría no encontrada")
    })
    public ResponseEntity<CategoryDTO> getCategory(
            @ApiParam(value = "ID de la categoría a obtener", required = true) @PathVariable Long id) {
        return categoryService.getCategory(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ApiOperation(value = "Obtener todas las categorías", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Éxito al obtener las categorías"),
            @ApiResponse(code = 500, message = "Error en el servidor")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "Número de la página", required = false, dataType = "integer", paramType = "query", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "Tamaño de la página", required = false, dataType = "integer", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", value = "Campo(s) por los que ordenar (ej: name,asc)", required = false, dataType = "string", paramType = "query", defaultValue = "name,desc")
    })
    public Page<CategoryDTO> getAllCategories(@PageableDefault(size = 10) Pageable pageable) {
        return categoryService.getAllCategories(pageable);
    }

    @PostMapping
    @ApiOperation(value = "Crear una nueva categoría", response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Categoría creada exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud inválida")
    })
    public ResponseEntity<CategoryDTO> createCategory(
            @ApiParam(value = "Detalles de la categoría a crear", required = true) @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO responseDTO = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar una categoría por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categoría eliminada exitosamente"),
            @ApiResponse(code = 404, message = "Categoría no encontrada")
    })
    public ResponseEntity<String> deleteCategory(@ApiParam(value = "ID de la categoría a eliminar", required = true) @PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Categoría eliminada");
    }

}