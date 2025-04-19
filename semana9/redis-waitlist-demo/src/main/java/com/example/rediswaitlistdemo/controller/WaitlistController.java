package com.example.rediswaitlistdemo.controller;

import com.example.rediswaitlistdemo.model.Usuario;
import com.example.rediswaitlistdemo.service.WaitlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class WaitlistController {
    private final WaitlistService waitlistService;

    public WaitlistController(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    @PostMapping("/{eventoId}/unirse")
    public String agregarUsuario(@PathVariable String eventoId, @RequestBody Usuario usuario) {
        waitlistService.agregarUsuarioALista(eventoId, usuario);
        return usuario.getNombre() + " se ha unido a la lista de espera del evento " + eventoId;
    }

    @GetMapping("/{eventoId}/siguiente")
    public String obtenerSiguienteUsuario(@PathVariable String eventoId) {
        String usuario = waitlistService.obtenerSiguienteUsuario(eventoId);
        return (usuario != null) ? "Siguiente en la lista: " + usuario : "No hay usuarios en la lista de espera.";
    }

    @GetMapping("/{eventoId}/espera")
    public List<String> obtenerListaEspera(@PathVariable String eventoId) {
        return waitlistService.obtenerListaEspera(eventoId);
    }
}
