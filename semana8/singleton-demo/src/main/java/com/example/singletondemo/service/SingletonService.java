package com.example.singletondemo.service;

public class SingletonService {
    // Instancia única de la clase
    private static SingletonService instance;

    // Constructor privado para evitar instanciación externa
    private SingletonService() {
    	System.out.println("Nueva instancia creada!");
    }

    // Método estático para obtener la única instancia
    public static SingletonService getInstance() {
        if (instance == null) {
            instance = new SingletonService();
        }
        return instance;
    }

    public String getMessage() {
        return "Hola, soy un Singleton!";
    }
}
