package com.gestionvacunas.vacunas.controller;

import com.gestionvacunas.vacunas.dto.ReporteVacunasDTO;
import com.gestionvacunas.vacunas.service.ReporteVacunasService;
import com.gestionvacunas.vacunas.util.ExcelExporter;
import com.gestionvacunas.vacunas.util.PdfExporter;
import com.itextpdf.text.DocumentException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteVacunasController {

    private final ReporteVacunasService service;

    public ReporteVacunasController(ReporteVacunasService service) {
        this.service = service;
    }

    @GetMapping("/vacunas")
    public List<ReporteVacunasDTO> generarReporte(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        // TODO: Validar acceso solo para Administrador (Spring Security)
        return service.generarReporte(start, end);
    }

    @GetMapping("/vacunas/excel")
    public void exportarExcel(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            HttpServletResponse response) throws IOException {
        List<ReporteVacunasDTO> datos = service.generarReporte(start, end);
        ExcelExporter exporter = new ExcelExporter(datos);
        exporter.export(response);
    }

    @GetMapping("/vacunas/pdf")
    public void exportarPdf(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            HttpServletResponse response) throws IOException, DocumentException {
        List<ReporteVacunasDTO> datos = service.generarReporte(start, end);
        PdfExporter exporter = new PdfExporter(datos);
        exporter.export(response);
    }
}

