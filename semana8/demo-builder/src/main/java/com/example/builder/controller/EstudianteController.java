package com.example.builder.controller;

import org.springframework.web.bind.annotation.*;

import com.example.builder.modelo.Estudiante;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @PostMapping
    public Estudiante registrarEstudiante(@RequestBody Estudiante estudianteRequest) {
        // Usamos el builder para construir el estudiante
        Estudiante estudiante = Estudiante.builder()
                .nombre(estudianteRequest.getNombre())
                .apellido(estudianteRequest.getApellido())
                .edad(estudianteRequest.getEdad())
                .carrera(estudianteRequest.getCarrera())
                .universidad(estudianteRequest.getUniversidad())
                .build();

        // Aquí podrías guardarlo en una base de datos (por ahora solo lo devolvemos)
        return estudiante;
    }
}