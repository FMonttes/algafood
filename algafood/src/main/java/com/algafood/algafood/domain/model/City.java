package com.algafood.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private State state;

}
