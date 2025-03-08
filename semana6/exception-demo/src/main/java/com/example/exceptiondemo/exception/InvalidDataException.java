package com.example.exceptiondemo.exception;

// Unchecked Exception (no obliga a manejarse)
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
       super(message);
    }
}
