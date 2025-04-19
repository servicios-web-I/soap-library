package com.example.excelreportdemo.service;

import com.example.excelreportdemo.model.Producto;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    public byte[] generarExcel(List<Producto> productos) throws IOException {
        // Cargar la plantilla desde src/main/resources/template.xlsx
        InputStream templateStream = new ClassPathResource("template.xlsx").getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Crear contexto de JXLS con los datos
        Map<String, Object> data = new HashMap<>();
        data.put("equipos", productos);

        // Procesar plantilla con JXLS
        Context context = new Context(data);
        JxlsHelper.getInstance().processTemplate(templateStream, outputStream, context);

        return outputStream.toByteArray();
    }
}
