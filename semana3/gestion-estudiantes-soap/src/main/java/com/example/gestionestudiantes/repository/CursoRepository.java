package com.example.gestionestudiantes.repository;

import com.example.gestionestudiantes.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}