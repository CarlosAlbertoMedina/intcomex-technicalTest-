package com.intcomex.gestion_intcomex.supplier.domain.model;

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
@Table(name = "suppliers")
@ApiModel(description = "Detalles del proveedor")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    @ApiModelProperty(value = "Identificador único del proveedor", example = "1")
    private Long supplierId;

    @Column(name = "company_name", length = 100, nullable = false)
    @ApiModelProperty(value = "Nombre de la empresa", example = "Example Inc.")
    private String companyName;

    @Column(name = "contact_name", length = 100)
    @ApiModelProperty(value = "Nombre del contacto", example = "John Doe")
    private String contactName;

    @Column(name = "contact_title", length = 50)
    @ApiModelProperty(value = "Título del contacto", example = "Gerente de Ventas")
    private String contactTitle;

    @Column(name = "address", length = 200)
    @ApiModelProperty(value = "Dirección del proveedor", example = "123 Main St")
    private String address;

    @Column(name = "city", length = 50)
    @ApiModelProperty(value = "Ciudad del proveedor", example = "New York")
    private String city;

    @Column(name = "region", length = 50)
    @ApiModelProperty(value = "Región del proveedor", example = "NY")
    private String region;

    @Column(name = "postal_code", length = 20)
    @ApiModelProperty(value = "Código postal del proveedor", example = "10001")
    private String postalCode;

    @Column(name = "country", length = 50)
    @ApiModelProperty(value = "País del proveedor", example = "USA")
    private String country;

    @Column(name = "phone", length = 15)
    @ApiModelProperty(value = "Teléfono del proveedor", example = "(123) 456-7890")
    private String phone;

    @Column(name = "fax", length = 15)
    @ApiModelProperty(value = "Fax del proveedor", example = "(123) 456-7891")
    private String fax;

    @ApiModelProperty(value = "Página de inicio del proveedor")
    private String homePage;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products; // Relación con Product
}