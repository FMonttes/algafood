package com.algafood.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Objects;
@Data
@Entity
@Table
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
