package com.example.factorymethoddemo.model;

public class Moto implements Vehiculo {
    @Override
    public String conducir() {
        return "Conduciendo una moto";
    }
}
