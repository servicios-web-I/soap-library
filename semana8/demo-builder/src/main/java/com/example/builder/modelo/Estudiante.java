package com.example.builder.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private String universidad;
}
