package com.algafood.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
