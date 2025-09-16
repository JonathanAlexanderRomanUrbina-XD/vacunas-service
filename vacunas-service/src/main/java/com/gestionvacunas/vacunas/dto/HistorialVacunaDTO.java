package com.gestionvacunas.vacunas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HistorialVacunaDTO {
    private String vacunaNombre;
    private LocalDate fechaAplicacion;
    private String observaciones;
}
