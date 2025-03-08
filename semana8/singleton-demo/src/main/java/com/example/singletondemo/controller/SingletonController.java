package com.example.singletondemo.controller;

import com.example.singletondemo.service.SingletonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class SingletonController {

    @GetMapping
    public String getSingletonMessage() {
        SingletonService singleton = SingletonService.getInstance();
        return singleton.getMessage();
    }
}
