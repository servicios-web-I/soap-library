package com.example.rediswaitlistdemo.service;

import com.example.rediswaitlistdemo.model.Usuario;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitlistService {
    private final RedisTemplate<String, String> redisTemplate;

    public WaitlistService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void agregarUsuarioALista(String eventoId, Usuario usuario) {
        String key = "evento:" + eventoId + ":espera";
        redisTemplate.opsForList().leftPush(key, usuario.getId() + ":" + usuario.getNombre());
    }

    public String obtenerSiguienteUsuario(String eventoId) {
        String key = "evento:" + eventoId + ":espera";
        return redisTemplate.opsForList().rightPop(key);
    }

    public List<String> obtenerListaEspera(String eventoId) {
        String key = "evento:" + eventoId + ":espera";
        return redisTemplate.opsForList().range(key, 0, -1);
    }
}
