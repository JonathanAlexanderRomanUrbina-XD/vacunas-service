package com.gestionvacunas.vacunas.util;

import com.gestionvacunas.vacunas.dto.ReporteVacunasDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PdfExporter {

    private final List<ReporteVacunasDTO> lista;

    public PdfExporter(List<ReporteVacunasDTO> lista) {
        this.lista = lista;
    }

    public void export(HttpServletResponse response) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_vacunas.pdf");

        document.open();

        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph titulo = new Paragraph("Reporte de Vacunas", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);
        document.add(new Paragraph("\n"));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{4f, 3f, 3f});

        Font fontCabecera = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(5);

        String[] columnas = {"Vacuna", "Cantidad Aplicada", "Mascotas Atendidas"};
        for (String col : columnas) {
            cell.setPhrase(new Phrase(col, fontCabecera));
            table.addCell(cell);
        }

        for (ReporteVacunasDTO dto : lista) {
            table.addCell(dto.getVacunaNombre());
            table.addCell(String.valueOf(dto.getCantidadAplicada()));
            table.addCell(String.valueOf(dto.getMascotasAtendidas()));
        }

        document.add(table);
        document.close();
    }
}
