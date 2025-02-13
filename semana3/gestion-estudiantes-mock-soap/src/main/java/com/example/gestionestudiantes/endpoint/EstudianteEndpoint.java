package com.example.gestionestudiantes.endpoint;

import com.example.gestionestudiantes.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.gestionestudiantes.service.EstudianteService;

@Endpoint
public class EstudianteEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/gestionestudiantes";

    @Autowired
    private EstudianteService estudianteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegistrarEstudianteRequest")
    @ResponsePayload
    public RegistrarEstudianteResponse registrarEstudiante(@RequestPayload RegistrarEstudianteRequest request) {
        return estudianteService.registrarEstudiante(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "InscribirCursoRequest")
    @ResponsePayload
    public InscribirCursoResponse inscribirCurso(@RequestPayload InscribirCursoRequest request) {
        return estudianteService.inscribirCurso(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubirCalificacionRequest")
    @ResponsePayload
    public SubirCalificacionResponse subirCalificacion(@RequestPayload SubirCalificacionRequest request) {
        return estudianteService.subirCalificacion(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ConsultarCalificacionesRequest")
    @ResponsePayload
    public ConsultarCalificacionesResponse consultarCalificaciones(@RequestPayload ConsultarCalificacionesRequest request) {
        return estudianteService.consultarCalificaciones(request);
    }
}