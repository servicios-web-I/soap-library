package com.example.singletonpersona.service;

public class PersonaSingleton {
    private static PersonaSingleton instance;
    private String nombre;

    private PersonaSingleton() {
        this.nombre = "Sin nombre"; // Valor inicial
    }

    public static PersonaSingleton getInstance() {
        if (instance == null) {
            instance = new PersonaSingleton();
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}
