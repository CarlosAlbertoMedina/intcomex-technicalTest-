package com.intcomex.gestion_intcomex.product.application.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para el producto")
public class ProductDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Long productId;

    @Schema(description = "Nombre del producto", example = "Widget A")
    private String productName;

    @Schema(description = "ID del proveedor asociado al producto", example = "1")
    private Long supplierId; // Solo guardamos el ID del proveedor en el DTO

    @Schema(description = "ID de la categoría asociada al producto", example = "1")
    private Long categoryId; // Solo guardamos el ID de la categoría en el DTO

    @Schema(description = "Cantidad por unidad", example = "10 boxes")
    private String quantityPerUnit;

    @Schema(description = "Precio unitario del producto", example = "15.99")
    private Double unitPrice;

    @Schema(description = "Unidades en stock", example = "100")
    private Integer stock;

    @Schema(description = "Unidades en pedido", example = "20")
    private Integer unitsOnOrder;

    @Schema(description = "Nivel de reorden", example = "5")
    private Integer reorderLevel;

    @Schema(description = "¿Producto discontinuado?", example = "false")
    private Boolean discontinued;

}
