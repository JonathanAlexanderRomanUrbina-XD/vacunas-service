package com.gestionvacunas.vacunas.service;

import com.gestionvacunas.vacunas.dto.HistorialVacunaDTO;
import com.gestionvacunas.vacunas.repository.HistorialVacunaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisualizacionServiceImpl implements VisualizacionService {

    private final HistorialVacunaRepository repository;

    public VisualizacionServiceImpl(HistorialVacunaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HistorialVacunaDTO> obtenerHistorialPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId)
                .stream()
                .map(h -> new HistorialVacunaDTO(
                        h.getVacuna().getNombre(),
                        h.getFechaAplicacion(),
                        h.getObservaciones()
                ))
                .collect(Collectors.toList());
    }
}