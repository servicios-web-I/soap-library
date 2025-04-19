package com.example.excelreportdemo.controller;

import com.example.excelreportdemo.service.ProductoService;
import com.example.excelreportdemo.service.ReporteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;
    private final ProductoService productoService;

    public ReporteController(ReporteService reporteService, ProductoService productoService) {
        this.reporteService = reporteService;
        this.productoService = productoService;
    }

    @GetMapping("/excel")
    public ResponseEntity<byte[]> generarReporte() throws IOException {
        byte[] excel = reporteService.generarExcel(productoService.obtenerTodosLosProductos());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=productos.xlsx")
                .body(excel);
    }
}
