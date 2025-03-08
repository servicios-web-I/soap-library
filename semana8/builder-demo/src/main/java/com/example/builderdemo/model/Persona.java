package com.example.builderdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Ignorar valores nulos en la respuesta
public class Persona {
    private String nombre;
    private int edad;
    private String direccion;
    private String telefono;

    private Persona(PersonaBuilder builder) {
        this.nombre = builder.nombre;
        this.edad = builder.edad;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
    }

    // Getters (necesarios para convertir JSON a objeto)
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }

    // Clase estática interna Builder
    public static class PersonaBuilder {
        private String nombre;
        private int edad;
        private String direccion;
        private String telefono;

        public PersonaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PersonaBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public PersonaBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public PersonaBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Persona build() {
            return new Persona(this);
        }
    }
}
