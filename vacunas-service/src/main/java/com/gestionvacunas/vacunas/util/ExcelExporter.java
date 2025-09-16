package com.gestionvacunas.vacunas.util;

import com.gestionvacunas.vacunas.dto.ReporteVacunasDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    private final List<ReporteVacunasDTO> lista;

    public ExcelExporter(List<ReporteVacunasDTO> lista) {
        this.lista = lista;
    }

    public void export(HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte de Vacunas");

        Row headerRow = sheet.createRow(0);
        String[] columnas = {"Vacuna", "Cantidad Aplicada", "Mascotas Atendidas"};

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        for (int i = 0; i < columnas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnas[i]);
            cell.setCellStyle(headerStyle);
        }

        int rowIdx = 1;
        for (ReporteVacunasDTO dto : lista) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(dto.getVacunaNombre());
            row.createCell(1).setCellValue(dto.getCantidadAplicada());
            row.createCell(2).setCellValue(dto.getMascotasAtendidas());
        }

        for (int i = 0; i < columnas.length; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_vacunas.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
