package com.intcomex.gestion_intcomex.employee.infrastructure.entity;

import com.intcomex.gestion_intcomex.order.infraestructure.entity.OrderEntity;
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
@Table(name = "employees")
@ApiModel(description = "Detalles del empleado")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    @ApiModelProperty(value = "Identificador único del empleado", example = "1")
    private Long employeeId;

    @Column(name = "first_name", length = 50, nullable = false)
    @ApiModelProperty(value = "Nombre del empleado", example = "John")
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @ApiModelProperty(value = "Apellido del empleado", example = "Smith")
    private String lastName;

    @Column(name = "title", length = 50)
    @ApiModelProperty(value = "Título del empleado", example = "Gerente de Ventas")
    private String title;

    @Column(name = "address", length = 200)
    @ApiModelProperty(value = "Dirección del empleado", example = "789 Oak St")
    private String address;

    @Column(name = "city", length = 50)
    @ApiModelProperty(value = "Ciudad del empleado", example = "San Francisco")
    private String city;

    @Column(name = "region", length = 50)
    @ApiModelProperty(value = "Región del empleado", example = "CA")
    private String region;

    @Column(name = "postal_code", length = 20)
    @ApiModelProperty(value = "Código postal del empleado", example = "94101")
    private String postalCode;

    @Column(name = "country", length = 50)
    @ApiModelProperty(value = "País del empleado", example = "USA")
    private String country;

    @Column(name = "home_phone", length = 15)
    @ApiModelProperty(value = "Teléfono del empleado", example = "(123) 456-7890")
    private String homePhone;

    @Column(name = "extension", length = 5)
    @ApiModelProperty(value = "Extensión telefónica del empleado", example = "123")
    private String extension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    @ApiModelProperty(value = "Empleado superior")
    private Employee manager; // Relación jerárquica con otro Employee

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderEntity> orders; // Relación con Order
}
