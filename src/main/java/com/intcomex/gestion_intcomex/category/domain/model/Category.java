package com.intcomex.gestion_intcomex.category.domain.model;

import com.intcomex.gestion_intcomex.product.domain.model.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
@ApiModel(description = "Detalles de la categoría")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @ApiModelProperty(value = "Identificador único de la categoría", example = "1")
    private Long categoryId;

    @Column(name = "category_name", length = 100, nullable = false)
    @ApiModelProperty(value = "Nombre de la categoría", example = "Electrónica")
    private String categoryName;

    @Column(name = "description", length = 255)
    @ApiModelProperty(value = "Descripción de la categoría", example = "Productos electrónicos y gadgets")
    private String description;

    @Column(name = "picture")
    @ApiModelProperty(value = "Imagen de la categoría")
    private String picture;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products; // Relación con Product
}
