package com.example.pdfdemo.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class ReportePDFService {

    public byte[] generarPDF() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Reporte PDF generado con iText")
                .setBold()
                .setFontSize(16)
                .setTextAlignment(TextAlignment.CENTER));

        document.add(new Paragraph("Este es un reporte generado en tiempo real desde una API REST.")
                .setFontSize(12));

        document.add(new Paragraph("Fecha: " + java.time.LocalDate.now()));

        document.close();
        return outputStream.toByteArray();
    }
}
