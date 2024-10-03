package com.intcomex.gestion_intcomex.order.infraestructure.entity;

import com.intcomex.gestion_intcomex.customer.infrastructure.entity.Customer;
import com.intcomex.gestion_intcomex.employee.infrastructure.entity.Employee;
import com.intcomex.gestion_intcomex.order_detail.infraestructure.entity.OrderDetailEntity;
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
@Table(name = "orders")
@ApiModel(description = "Detalles del pedido")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @ApiModelProperty(value = "Identificador único del pedido", example = "1")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @ApiModelProperty(value = "Cliente asociado al pedido")
    private Customer customer; // Relación con Customer

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(value = "Empleado asociado al pedido")
    private Employee employee; // Relación con Employee

    @Column(name = "order_date", nullable = false)
    @ApiModelProperty(value = "Fecha del pedido", example = "2024-10-01")
    private String orderDate;

    @Column(name = "required_date")
    @ApiModelProperty(value = "Fecha requerida para envío", example = "2024-10-05")
    private String requiredDate;

    @Column(name = "shipped_date")
    @ApiModelProperty(value = "Fecha de envío", example = "2024-10-02")
    private String shippedDate;

    @Column(name = "ship_via")
    @ApiModelProperty(value = "Método de envío", example = "DHL")
    private String shipVia;

    @Column(name = "freight")
    @ApiModelProperty(value = "Costo del envío", example = "29.99")
    private Double freight;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetailEntity> orderDetails; // Relación con OrderDetails
}