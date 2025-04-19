package com.example.junitdemo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void testSuma() {
        int resultado = calculadora.sumar(3, 2);
        assertEquals(5, resultado);
    }

    @Test
    void testResta() {
        int resultado = calculadora.restar(10, 4);
        assertEquals(6, resultado);
    }

    @Test
    void testMultiplicacion() {
        int resultado = calculadora.multiplicar(6, 3);
        assertEquals(18, resultado);
    }

    @Test
    void testDivision() {
        double resultado = calculadora.dividir(9, 3);
        assertEquals(3.0, resultado);
    }

    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(5, 0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
}
