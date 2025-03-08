package com.example.factorymethoddemo.controller;

import com.example.factorymethoddemo.factory.VehiculoFactory;
import com.example.factorymethoddemo.model.Vehiculo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @GetMapping("/{tipo}")
    public String obtenerVehiculo(@PathVariable String tipo) {
        Vehiculo vehiculo = VehiculoFactory.crearVehiculo(tipo);
        return vehiculo.conducir();
    }
}
