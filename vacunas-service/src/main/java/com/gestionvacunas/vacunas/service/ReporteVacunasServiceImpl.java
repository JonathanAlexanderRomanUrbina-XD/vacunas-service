package com.gestionvacunas.vacunas.service;

import com.gestionvacunas.vacunas.dto.ReporteVacunasDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteVacunasServiceImpl implements ReporteVacunasService {
    @Override
    public List<ReporteVacunasDTO> generarReporte(LocalDate start, LocalDate end) {
        // Lógica real pendiente, aquí datos de ejemplo
        return List.of(
                new ReporteVacunasDTO("Rabia", 50L, 40L),
                new ReporteVacunasDTO("Parvovirus", 30L, 25L)
        );
    }
}
