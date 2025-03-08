package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.exception.FileNotFoundException;
import com.example.exceptiondemo.service.FileService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    // Endpoint que maneja una Checked Exception
    @GetMapping("/{filename}")
    public ResponseEntity<String> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(fileService.readFile(filename));
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // Endpoint que lanza una Unchecked Exception
    @PostMapping("/process")
    public ResponseEntity<String> processFile(@RequestBody Map<String, Object> data) {
        return ResponseEntity.ok(fileService.processData(data));
    }
}
