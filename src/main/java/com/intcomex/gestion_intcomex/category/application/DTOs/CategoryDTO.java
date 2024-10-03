package com.intcomex.gestion_intcomex.category.application.DTOs;

import com.intcomex.gestion_intcomex.product.application.DTOs.ProductDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para la categoría")
public class CategoryDTO {

    @Schema(description = "Identificador único de la categoría", example = "1")
    private Long categoryId;

    @Schema(description = "Nombre de la categoría", example = "Electrónica", required = true)
    private String categoryName;

    @Schema(description = "Descripción de la categoría", example = "Categoría para productos electrónicos")
    private String description;

    @Schema(description = "URL o ruta de la imagen de la categoría", example = "http://example.com/image.jpg")
    private String picture;

    @Schema(description = "Lista de productos asociados a esta categoría")
    private List<ProductDTO> products;

}
