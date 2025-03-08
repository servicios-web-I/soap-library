package com.example.exceptiondemo.service;

import com.example.exceptiondemo.exception.FileNotFoundException;
import com.example.exceptiondemo.exception.InvalidDataException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {
    private final Map<String, String> files = new HashMap<>();

    public FileService() {
        files.put("document1.txt", "Contenido del documento 1");
        files.put("report.pdf", "Contenido del reporte PDF");
    }

    // Ejemplo de Checked Exception (Obliga a usar try-catch o throws)
    public String readFile(String filename) throws FileNotFoundException {
        if (!files.containsKey(filename)) {
            throw new FileNotFoundException("El archivo '" + filename + "' no fue encontrado.");
        }
        return files.get(filename);
    }

    // Ejemplo de Unchecked Exception (No obliga a usar try-catch)
    public String processData(Map<String, Object> data) {
        if (data.get("data") == null || ((String)data.get("data")).isEmpty()) {
            throw new InvalidDataException("Los datos proporcionados son inválidos.");
        }
        return "Datos procesados: " + data;
    }
}
