package com.example.sha256demo.controller;

import com.example.sha256demo.dto.HashRequest;
import com.example.sha256demo.util.HashUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hash")
public class HashController {

    @PostMapping("/sha256")
    public String obtenerHashSHA256(@RequestBody HashRequest request) {
        return HashUtil.aplicarSHA256(request.getTexto());
    }
}
