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

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;   // 👈 en lugar de solo Long mascotaId

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Usuario veterinario;

    private LocalDate fechaAplicacion;
    private String observaciones;
}
