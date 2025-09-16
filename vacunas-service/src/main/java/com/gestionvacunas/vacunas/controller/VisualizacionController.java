package com.gestionvacunas.vacunas.controller;

import com.gestionvacunas.vacunas.dto.HistorialVacunaDTO;
import com.gestionvacunas.vacunas.service.VisualizacionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historial-vacunas")
public class VisualizacionController {

    private final VisualizacionService service;

    public VisualizacionController(VisualizacionService service) {
        this.service = service;
    }

    @GetMapping("/usuario/{id}")
    public List<HistorialVacunaDTO> obtenerHistorial(@PathVariable Long id) {
        // Validar acceso solo a sus mascotas (pendiente implementar con JWT)
        return service.obtenerHistorialPorUsuario(id);
    }
}
