package com.example.gestionestudiantes.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inscripcion> inscripciones;

    @ElementCollection
    @CollectionTable(name = "calificaciones", joinColumns = @JoinColumn(name = "curso_id"))
    @AttributeOverrides({
        @AttributeOverride(name = "cursoId", column = @Column(name = "curso_id", insertable = false, updatable = false)),
        @AttributeOverride(name = "calificacion", column = @Column(name = "calificacion"))
    })
    private List<Calificacion> calificaciones;

    public Curso() {}

    public Curso(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter para id
    public Long getId() {
        return id;
    }

    // Setter para id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para inscripciones
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    // Setter para inscripciones
    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}