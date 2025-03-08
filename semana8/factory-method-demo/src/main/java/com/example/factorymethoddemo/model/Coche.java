package com.example.factorymethoddemo.model;

public class Coche implements Vehiculo {
    @Override
    public String conducir() {
        return "Conduciendo un coche";
    }
}
