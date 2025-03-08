package com.example.redissessiondemo.service;

import com.example.redissessiondemo.model.UserSession;
import com.example.redissessiondemo.repository.UserSessionRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserSessionService {
    private final UserSessionRepository userSessionRepository;

    public UserSessionService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    public UserSession createSession(String username) {
        String token = UUID.randomUUID().toString();
        UserSession session = new UserSession(username, username, token, 20L); // Expira en 20 segundos
        userSessionRepository.save(session);
        return session;
    }

    public Optional<UserSession> getSession(String username) {
        return userSessionRepository.findById(username);
    }

    public void deleteSession(String username) {
        userSessionRepository.deleteById(username);
    }
}
