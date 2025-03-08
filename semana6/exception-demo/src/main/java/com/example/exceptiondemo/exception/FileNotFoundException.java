package com.example.exceptiondemo.exception;

// Checked Exception (obliga a usar try-catch o throws)
public class FileNotFoundException extends Exception {
    public FileNotFoundException(String message) {
        super(message);
    }
}
