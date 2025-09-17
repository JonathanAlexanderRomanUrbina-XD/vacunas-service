package com.gestionvacunas.vacunas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_dueno")
    private Usuario dueno;  // relación con Usuario
}
