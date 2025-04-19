package com.example.bcryptdemo.controller;

import com.example.bcryptdemo.dto.PasswordRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bcrypt")
public class BcryptController {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody PasswordRequest request) {
        return passwordEncoder.encode(request.getPassword());
    }

    @PostMapping("/verify")
    public String verify(@RequestBody PasswordRequest request) {
        boolean match = passwordEncoder.matches(request.getPassword(), request.getHash());
        return match ? "Contraseña válida" : "Contraseña inválida";
    }
}
