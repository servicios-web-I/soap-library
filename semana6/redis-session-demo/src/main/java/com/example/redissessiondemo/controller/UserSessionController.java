package com.example.redissessiondemo.controller;

import com.example.redissessiondemo.model.UserSession;
import com.example.redissessiondemo.service.UserSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/session")
public class UserSessionController {
    private final UserSessionService userSessionService;

    public UserSessionController(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<UserSession> createSession(@PathVariable String username) {
        return ResponseEntity.ok(userSessionService.createSession(username));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<UserSession>> getSession(@PathVariable String username) {
        return ResponseEntity.ok(userSessionService.getSession(username));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteSession(@PathVariable String username) {
        userSessionService.deleteSession(username);
        return ResponseEntity.noContent().build();
    }
}
