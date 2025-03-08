package com.example.builderdemo.controller;

import com.example.builderdemo.model.Persona;
import com.example.builderdemo.service.PersonaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.crearPersona(
            persona.getNombre(),
            persona.getEdad(),
            persona.getDireccion(),
            persona.getTelefono()
        );
    }
}
