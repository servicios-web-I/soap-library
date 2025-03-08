package com.example.singletonpersona.controller;

import com.example.singletonpersona.service.PersonaSingleton;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @GetMapping
    public String getNombre() {
        return "Nombre actual: " + PersonaSingleton.getInstance().getNombre();
    }

    @PostMapping("/{nuevoNombre}")
    public String setNombre(@PathVariable String nuevoNombre) {
        PersonaSingleton.getInstance().setNombre(nuevoNombre);
        return "Nuevo nombre asignado: " + nuevoNombre;
    }
}
