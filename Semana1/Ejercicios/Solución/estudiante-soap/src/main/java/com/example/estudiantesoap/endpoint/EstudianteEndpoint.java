package com.example.estudiantesoap.endpoint;

import com.ejemplo.estudiante.GetEstudianteRequest;
import com.ejemplo.estudiante.GetEstudianteResponse;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class EstudianteEndpoint {

    private static final String NAMESPACE_URI = "http://ejemplo.com/estudiante";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstudianteRequest")
    @ResponsePayload
    public GetEstudianteResponse getEstudiante(@RequestPayload GetEstudianteRequest request) {
        GetEstudianteResponse response = new GetEstudianteResponse();

        if (request.getId() == 101) {
            response.setNombre("Ana Pérez");
            response.setCurso("Ingeniería de Sistemas");
        } else if (request.getId() == 102) {
            response.setNombre("Luis Torres");
            response.setCurso("Administración");
        } else {
            response.setNombre("Desconocido");
            response.setCurso("N/A");
        }

        return response;
    }
}