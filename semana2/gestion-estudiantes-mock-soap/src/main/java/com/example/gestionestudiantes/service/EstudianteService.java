package com.example.gestionestudiantes.service;

import com.example.gestionestudiantes.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {

    public RegistrarEstudianteResponse registrarEstudiante(RegistrarEstudianteRequest request) {
        RegistrarEstudianteResponse response = new RegistrarEstudianteResponse();
        response.setEstudianteId(1); // Simulación de ID generado
        response.setMensaje("Estudiante registrado con éxito: " + request.getNombre());
        return response;
    }

    public InscribirCursoResponse inscribirCurso(InscribirCursoRequest request) {
        InscribirCursoResponse response = new InscribirCursoResponse();
        response.setMensaje("Estudiante " + request.getEstudianteId() + " inscrito en el curso " + request.getCursoId());
        return response;
    }

    public SubirCalificacionResponse subirCalificacion(SubirCalificacionRequest request) {
        SubirCalificacionResponse response = new SubirCalificacionResponse();
        response.setMensaje("Calificación " + request.getCalificacion() + " registrada para el estudiante " + request.getEstudianteId() + " en el curso " + request.getCursoId());
        return response;
    }

    public ConsultarCalificacionesResponse consultarCalificaciones(ConsultarCalificacionesRequest request) {
        ConsultarCalificacionesResponse response = new ConsultarCalificacionesResponse();
        List<Calificacion> calificaciones = new ArrayList<>();

        // Simulación de datos
        Calificacion calificacion1 = new Calificacion();
        calificacion1.setCursoId(1);
        calificacion1.setCalificacion(8.5f);
        calificaciones.add(calificacion1);

        response.getCalificacion().addAll(calificaciones);
        return response;
    }
}