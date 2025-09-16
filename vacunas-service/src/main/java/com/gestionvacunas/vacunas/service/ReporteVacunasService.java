package com.gestionvacunas.vacunas.service;

import com.gestionvacunas.vacunas.dto.ReporteVacunasDTO;
import java.time.LocalDate;
import java.util.List;

public interface ReporteVacunasService {
    List<ReporteVacunasDTO> generarReporte(LocalDate start, LocalDate end);
}
