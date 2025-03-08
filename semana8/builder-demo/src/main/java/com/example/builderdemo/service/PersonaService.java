package com.example.builderdemo.service;

import com.example.builderdemo.model.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    public Persona crearPersona(String nombre, int edad, String direccion, String telefono) {
        return new Persona.PersonaBuilder()
                .setNombre(nombre)
                .setEdad(edad)
                .setDireccion(direccion)
                .setTelefono(telefono)
                .build();
    }
}
