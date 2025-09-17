package com.gestionvacunas.vacunas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity   // 👈 ESTA ANOTACIÓN ES OBLIGATORIA
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String rol; // "Dueño", "Veterinario", "Administrador"

    // relaciones opcionales
}