package com.example.pdfdemo.controller;

import com.example.pdfdemo.service.ReportePDFService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdf")
public class ReporteController {

    private final ReportePDFService reportePDFService;

    public ReporteController(ReportePDFService reportePDFService) {
        this.reportePDFService = reportePDFService;
    }

    @GetMapping("/generar")
    public ResponseEntity<byte[]> generarReportePDF() {
        byte[] pdfBytes = reportePDFService.generarPDF();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
