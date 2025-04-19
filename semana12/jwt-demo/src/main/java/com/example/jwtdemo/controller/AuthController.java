package com.example.jwtdemo.controller;

import com.example.jwtdemo.dto.AuthRequest;
import com.example.jwtdemo.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        // Autenticación básica simulada (usuario: user, pass: 1234)
        if ("user".equals(request.getUsername()) && "1234".equals(request.getPassword())) {
            return jwtUtil.generateToken(request.getUsername());
        } else {
            return "Credenciales inválidas";
        }
    }

    @GetMapping("/hello")
    public String hello(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        if (jwtUtil.validateToken(token)) {
            String user = jwtUtil.extractUsername(token);
            return "Hola, " + user + "! Acceso autorizado.";
        }
        return "Token inválido o expirado.";
    }
}
