package com.example.restbasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restbasics.model.Message;

@RestController
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/message")
	public Message message() {
	    return new Message("Hello, this is a JSON response!");
	}

}
