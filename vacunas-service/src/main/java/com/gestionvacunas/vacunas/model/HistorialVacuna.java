package com.gestionvacunas.vacunas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class HistorialVacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vacuna vacuna;

    private Long mascotaId;
    private Long veterinarioId;
    private LocalDate fechaAplicacion;
    private String observaciones; // opcional
}