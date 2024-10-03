package com.intcomex.gestion_intcomex.supplier.application.DTOs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Datos del proveedor")
public class SupplierDTO {

    @ApiModelProperty(value = "Identificador único del proveedor", example = "1")
    private Long supplierId;

    @ApiModelProperty(value = "Nombre de la empresa", example = "Example Inc.", required = true)
    private String companyName;

    @ApiModelProperty(value = "Nombre del contacto", example = "John Doe")
    private String contactName;

    @ApiModelProperty(value = "Título del contacto", example = "Gerente de Ventas")
    private String contactTitle;

    @ApiModelProperty(value = "Dirección del proveedor", example = "123 Main St")
    private String address;

    @ApiModelProperty(value = "Ciudad del proveedor", example = "New York")
    private String city;

    @ApiModelProperty(value = "Región del proveedor", example = "NY")
    private String region;

    @ApiModelProperty(value = "Código postal del proveedor", example = "10001")
    private String postalCode;

    @ApiModelProperty(value = "País del proveedor", example = "USA")
    private String country;

    @ApiModelProperty(value = "Teléfono del proveedor", example = "(123) 456-7890")
    private String phone;

    @ApiModelProperty(value = "Fax del proveedor", example = "(123) 456-7891")
    private String fax;

    @ApiModelProperty(value = "Página de inicio del proveedor", example = "http://example.com")
    private String homePage;
}

