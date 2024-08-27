package com.algafood.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Table
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private BigDecimal deliveryTax;
    @ManyToOne
//    @JoinColumn(name = "kitchen_id")
    private Kitchen kitchen;
}
