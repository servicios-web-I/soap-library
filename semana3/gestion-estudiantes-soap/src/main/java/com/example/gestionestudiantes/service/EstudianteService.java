package com.example.gestionestudiantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionestudiantes.model.Calificacion;
import com.example.gestionestudiantes.model.ConsultarCalificacionesRequest;
import com.example.gestionestudiantes.model.ConsultarCalificacionesResponse;
import com.example.gestionestudiantes.model.CrearCursoRequest;
import com.example.gestionestudiantes.model.CrearCursoResponse;
import com.example.gestionestudiantes.model.Curso;
import com.example.gestionestudiantes.model.Estudiante;
import com.example.gestionestudiantes.model.InscribirCursoRequest;
import com.example.gestionestudiantes.model.InscribirCursoResponse;
import com.example.gestionestudiantes.model.Inscripcion;
import com.example.gestionestudiantes.model.RegistrarEstudianteRequest;
import com.example.gestionestudiantes.model.RegistrarEstudianteResponse;
import com.example.gestionestudiantes.model.SubirCalificacionRequest;
import com.example.gestionestudiantes.model.SubirCalificacionResponse;
import com.example.gestionestudiantes.repository.CursoRepository;
import com.example.gestionestudiantes.repository.EstudianteRepository;
import com.example.gestionestudiantes.repository.InscripcionRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    // Registrar un estudiante
    public RegistrarEstudianteResponse registrarEstudiante(RegistrarEstudianteRequest request) {
        // Crear un nuevo estudiante
        Estudiante estudiante = new Estudiante(request.getNombre(), request.getEmail());
        estudiante = estudianteRepository.save(estudiante);

        // Crear la respuesta
        RegistrarEstudianteResponse response = new RegistrarEstudianteResponse();
        response.setEstudianteId(estudiante.getId().intValue()); // Convertir Long a int
        response.setMensaje("Estudiante registrado con éxito: " + request.getNombre());
        return response;
    }
    
    // Método para crear un curso
    public CrearCursoResponse crearCurso(CrearCursoRequest request) {
        // Crear un nuevo curso
        Curso curso = new Curso();
        curso.setNombre(request.getNombre());
        curso = cursoRepository.save(curso);

        // Crear la respuesta
        CrearCursoResponse response = new CrearCursoResponse();
        response.setCursoId(curso.getId().intValue()); // Convertir Long a int
        response.setMensaje("Curso creado con éxito: " + curso.getNombre());
        return response;
    }

    // Inscribir un estudiante en un curso
    public InscribirCursoResponse inscribirCurso(InscribirCursoRequest request) {
        Estudiante estudiante = buscarEstudiantePorId((long) request.getEstudianteId());
        Curso curso = buscarCursoPorId((long) request.getCursoId());

        Inscripcion inscripcion = new Inscripcion(estudiante, curso);
        inscripcionRepository.save(inscripcion);

        // Crear la respuesta
        InscribirCursoResponse response = new InscribirCursoResponse();
        response.setMensaje("Estudiante " + request.getEstudianteId() + " inscrito en el curso " + request.getCursoId());
        return response;
    }

    // Subir una calificación para un estudiante en un curso
    public SubirCalificacionResponse subirCalificacion(SubirCalificacionRequest request) {
        Estudiante estudiante = buscarEstudiantePorId((long) request.getEstudianteId());
        Calificacion calificacion = new Calificacion();
        calificacion.setCursoId(request.getCursoId());
        calificacion.setCalificacion(request.getCalificacion());

        estudiante.getCalificaciones().add(calificacion);
        estudianteRepository.save(estudiante); // Persistir las calificaciones

        // Crear la respuesta
        SubirCalificacionResponse response = new SubirCalificacionResponse();
        response.setMensaje("Calificación " + request.getCalificacion() + " registrada para el estudiante " + request.getEstudianteId() + " en el curso " + request.getCursoId());
        return response;
    }

    // Consultar calificaciones de un estudiante
    public ConsultarCalificacionesResponse consultarCalificaciones(ConsultarCalificacionesRequest request) {
        Estudiante estudiante = buscarEstudiantePorId((long) request.getEstudianteId());

        // Crear la respuesta
        ConsultarCalificacionesResponse response = new ConsultarCalificacionesResponse();
        response.getCalificacion().addAll(estudiante.getCalificaciones());
        return response;
    }

    // Métodos auxiliares para buscar estudiantes y cursos
    private Estudiante buscarEstudiantePorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    private Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}