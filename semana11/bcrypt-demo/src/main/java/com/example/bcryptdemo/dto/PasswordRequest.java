package com.example.bcryptdemo.dto;

public class PasswordRequest {
    private String password;
    private String hash; // solo se usará en verificación

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
