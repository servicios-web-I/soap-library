package com.example.bcryptdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactivar CSRF para pruebas POST con Postman
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permitir todos los endpoints
            )
            .httpBasic(Customizer.withDefaults()); // Desactiva login form

        return http.build();
    }
}
