package com.example.factorymethoddemo.factory;

import com.example.factorymethoddemo.model.Coche;
import com.example.factorymethoddemo.model.Moto;
import com.example.factorymethoddemo.model.Vehiculo;

public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo) {
        if (tipo.equalsIgnoreCase("coche")) {
            return new Coche();
        } else if (tipo.equalsIgnoreCase("moto")) {
            return new Moto();
        } else {
            throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        }
    }
}
