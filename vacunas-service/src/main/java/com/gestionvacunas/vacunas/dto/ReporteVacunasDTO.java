package com.gestionvacunas.vacunas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteVacunasDTO {
    private String vacunaNombre;
    private Long cantidadAplicada;
    private Long mascotasAtendidas;
}
