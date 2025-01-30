package com.example.gestionestudiantes.repository;

import com.example.gestionestudiantes.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}