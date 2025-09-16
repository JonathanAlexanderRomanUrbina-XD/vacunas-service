package com.gestionvacunas.vacunas.service;

import com.gestionvacunas.vacunas.dto.HistorialVacunaDTO;
import java.util.List;

public interface VisualizacionService {
    List<HistorialVacunaDTO> obtenerHistorialPorUsuario(Long usuarioId);
}
