package com.intcomex.gestion_intcomex.order_detail.infraestructure.entity;

import com.intcomex.gestion_intcomex.order.infraestructure.entity.OrderEntity;
import com.intcomex.gestion_intcomex.product.domain.model.Product;
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
@Table(name = "order_details")
@ApiModel(description = "Detalles del pedido")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "Identificador único del detalle del pedido", example = "1")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @ApiModelProperty(value = "Pedido asociado al detalle")
    private OrderEntity order; // Relación con Order

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @ApiModelProperty(value = "Producto asociado al detalle")
    private Product product; // Relación con Product

    @Column(name = "quantity")
    @ApiModelProperty(value = "Cantidad del producto", example = "5")
    private Integer quantity;

    @Column(name = "unit_price")
    @ApiModelProperty(value = "Precio unitario del producto", example = "15.99")
    private Double unitPrice;

    @Column(name = "discount")
    @ApiModelProperty(value = "Descuento aplicado", example = "0.10")
    private Double discount; // Descuento aplicado

}