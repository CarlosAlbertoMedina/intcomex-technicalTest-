package com.intcomex.gestion_intcomex.product.domain.model;

import com.intcomex.gestion_intcomex.category.domain.model.Category;
import com.intcomex.gestion_intcomex.supplier.domain.model.Supplier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@ApiModel(description = "Detalles del producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @ApiModelProperty(value = "Identificador único del producto", example = "1")
    private Long productId;

    @Column(name = "product_name", length = 100, nullable = false)
    @ApiModelProperty(value = "Nombre del producto", example = "Widget A")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @ApiModelProperty(value = "Proveedor asociado al producto")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ApiModelProperty(value = "Categoría asociada al producto")
    private Category category;

    @Column(name = "quantity_per_unit", length = 50)
    @ApiModelProperty(value = "Cantidad por unidad", example = "10 boxes")
    private String quantityPerUnit;

    @Column(name = "unit_price")
    @ApiModelProperty(value = "Precio unitario del producto", example = "15.99")
    private Double unitPrice;

    @Column(name = "units_in_stock")
    @ApiModelProperty(value = "Unidades en stock", example = "100")
    private Integer stock;

    @Column(name = "units_on_order")
    @ApiModelProperty(value = "Unidades en pedido", example = "20")
    private Integer unitsOnOrder;

    @Column(name = "reorder_level")
    @ApiModelProperty(value = "Nivel de reorden", example = "5")
    private Integer reorderLevel;

    @Column(name = "discontinued")
    @ApiModelProperty(value = "¿Producto discontinuado?", example = "false")
    private Boolean discontinued;

}